package com.kueerickpatrick.plantinfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kueerickpatrick.plantinfo.entity.plantObjects.PlantIndividualInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * PlantPage Servlet
 * Handles requests from search results to get plant details.
 * @author ereyes3
 */

@WebServlet(
        name = "plantPage",
        urlPatterns = {"/plantPage"}
)
public class PlantPage extends HttpServlet {
    // logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Handles GET requests
     * @param request   an {@link HttpServletRequest} object that
     *                  contains the request the client has made
     *                  of the servlet
     *
     * @param response  an {@link HttpServletResponse} object that
     *                  contains the response the servlet sends
     *                  to the client
     *
     * @throws IOException if an I/O error occurs
     * @throws ServletException if there is a servlet failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        // log parameter to search
        logger.debug("Query string is: " + request.getParameter("idToSearch"));
        // get plant from API
        Integer selectedId = Integer.parseInt(request.getParameter("idToSearch"));
        Integer userPlantId;
        if (request.getParameter("userPlantId") != null) {
            userPlantId = Integer.parseInt(request.getParameter("userPlantId"));
            request.setAttribute("userPlantId", userPlantId);
        }
        // try to get plant
        try {
            PlantIndividualInfo selectedPlant = callAPI(selectedId);
            request.setAttribute("selectedPlant", selectedPlant);
        } catch (Exception e) {
            logger.error("Error getting plant: " + e);
        }
        // forward request
        String url = "/WEB-INF/plant.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    /**
     * Calls our API
     * @param queryId the id of the plant to query
     * @throws Exception if there is an error calling the API
     * @return mapResponse the mapped response from the API
     */
    public PlantIndividualInfo callAPI(Integer queryId) throws Exception {
        // log random number
        logger.debug("Random number generated: " + queryId);
        // create client
        Client client = ClientBuilder.newClient();
        // set url to API endpoint with query
        WebTarget target = client.target("http://plantinfo-env.eba-hff4mr2x.us-east-2.elasticbeanstalk.com/rest/search/id/" + queryId);
        // return response
        return mapResponse(target.request(MediaType.APPLICATION_JSON).get(String.class));
    }

    /**
     * Maps response to list of POJO objects ready to display
     * @param response the response of the API to parse
     * @throws IOException if there is an error parsing the response
     * @return plantInfo the mapped info of the plant
     */
    public PlantIndividualInfo mapResponse(String response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // List of individual plant info
        PlantIndividualInfo plantInfo = mapper.readValue(response, PlantIndividualInfo.class);
        logger.debug("Parsed response from API ready for display: " + plantInfo.getCommonName());
        return plantInfo;
    }
}
