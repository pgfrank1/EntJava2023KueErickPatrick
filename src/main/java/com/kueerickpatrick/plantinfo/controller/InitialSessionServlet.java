package com.kueerickpatrick.plantinfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kueerickpatrick.plantinfo.entity.plantObjects.PlantDetailList;
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
import java.util.Random;

/**
 * This servlet gets used when any user connects to the application
 * It gathers data needed to display on the index page.
 *
 * @author PGFrank1
 * @version 1.0
 */
@WebServlet (
        name = "InitialSessionServlet",
        urlPatterns = {"/index.jsp"}
)
public class InitialSessionServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *
     * Retrieves the plant detail list, maps the JSON response from Perenual, and places the data within the
     * plantDetailMap request attribute
     *
     * @param req   an {@link HttpServletRequest} object that
     *                  contains the request the client has made
     *                  of the servlet
     *
     * @param resp  an {@link HttpServletResponse} object that
     *                  contains the response the servlet sends
     *                  to the client
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // try to create random plant
        try {
            PlantIndividualInfo randomPlant = createPlant();
            req.setAttribute("randomPlant", randomPlant);
        } catch (Exception e) {
            logger.error("Unable to create random plant: " + e);
        }
        // create client
        Client client = ClientBuilder.newClient();
        String plantInfoApiUrl = (String) getServletContext().getAttribute("plantListMainPageUrl") + 1
                + "&" + getServletContext().getAttribute("apiKey");
        logger.info("url is: " + plantInfoApiUrl);
        logger.debug("Attempting to retrieve plant details pages");

        WebTarget targetPlantDetails = client.target(plantInfoApiUrl);
        String apiResponse = targetPlantDetails.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        PlantDetailList plantDetailList = mapper.readValue(apiResponse, PlantDetailList.class);

        req.setAttribute("plantDetailMap", plantDetailList);

        String url = "/WEB-INF/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /**
     * Creates random number
     * @return a random number between 1 and 10000 (inclusive)
     */
    private int createRandomNumber() {
        // local variables
        // minimum
        int min = 1;
        // maximum
        int max = 10000;
        // instantiate randomNumberGenerator
        Random randomNumberGenerator = new Random();
        // generate number
        return randomNumberGenerator.nextInt((max - min) + 1) + min;
    }

    /**
     * Creates a random plant
     * @return randomly fetched plant from API
     * @throws Exception if there is an API error
     */
    private PlantIndividualInfo createPlant() throws Exception {
        return callAPI(createRandomNumber());
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
