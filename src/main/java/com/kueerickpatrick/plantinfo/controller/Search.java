package com.kueerickpatrick.plantinfo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kueerickpatrick.plantinfo.entity.plantObjects.DataItem;

/**
 * Search
 * This Servlet will be used get form data.
 * Calls our API and forwards results.
 * @author ereyes3
 */
@WebServlet(
        name = "search",
        urlPatterns = { "/search" }
)
public class Search extends HttpServlet {
    // instance variables
    private static List<DataItem> foundPlants;

    // logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet
     * Called when user requests search.
     * Forwards to search page.
     * @exception ServletException if there is a servlet failure
     * @exception IOException if there is an IO error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException {
        // set url
        String url = "/WEB-INF/search.jsp";
        // set page title
        request.setAttribute("pageTitle", "Detailed plant search");
        // get dispatcher
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        // forward
        dispatcher.forward(request, response);
    }
    /**
     * doPost
     * Called when user submits search request.
     * Calls our API
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            // instance variables
            List<DataItem> results = null;
            // get query from form submission
            String query = request.getParameter("query");
            request.setAttribute("userQuery", query);
            logger.debug("User query: " + query);
            // call API
            try {
                callAPI(query);
            } catch (Exception e) {
                logger.error("Error calling API: " + e);
            }
            // set request attribute
            request.setAttribute("results", foundPlants);
            logger.debug("Current request attribute value for result: " + request.getAttribute("results"));
            // forward results back to search for display
            String url = "/WEB-INF/search.jsp";
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
    }

    /**
     * Calls our API
     * @param query the user's query string
     * @throws Exception if there is an error calling the API
     */
    public void callAPI(String query) throws Exception {
        // create client
        Client client = ClientBuilder.newClient();
        // set url to API endpoint with query
        WebTarget target = client.target("http://localhost:8080/EntJava2023KueErickPatrick_war/rest/search/" + query);
        // return response
        mapResponse(target.request(MediaType.APPLICATION_JSON).get(String.class));
    }

    /**
     * Maps response to list of POJO objects ready to display
     * @param response the response of the API to parse
     * @throws IOException if there is an error parsing the response
     */
    public void mapResponse(String response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        foundPlants = new ArrayList<>();
        foundPlants = Arrays.asList(mapper.readValue(response, DataItem[].class));
        logger.debug("Parsed response from API ready for display: " + foundPlants.get(0).getCommonName());
    }
}
