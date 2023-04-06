package com.kueerickpatrick.plantinfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kueerickpatrick.plantinfo.entity.plantObjects.PlantDetailList;
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
}
