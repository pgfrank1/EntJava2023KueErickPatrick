package com.kueerickpatrick.plantinfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kueerickpatrick.plantinfo.entity.User;
import com.kueerickpatrick.plantinfo.entity.Userplant;
import com.kueerickpatrick.plantinfo.entity.plantObjects.PlantIndividualInfo;
import com.kueerickpatrick.plantinfo.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * User servlet
 * Used to get user data once authenticated
 * @author ereyes3
 */
@WebServlet(
        name = "userServlet",
        urlPatterns = { "/user" }
)
public class UserServlet extends HttpServlet {
    // instance variables

    // logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // generic dao
    GenericDao userDao;

    // user
    private User user;

    // map of UserPlant
    LinkedHashMap<Integer, PlantIndividualInfo> plantMap;

    /**
     * Responsible for getting a user's information
     * @param request   an {@link HttpServletRequest} object that
     *                  contains the request the client has made
     *                  of the servlet
     *
     * @param response  an {@link HttpServletResponse} object that
     *                  contains the response the servlet sends
     *                  to the client
     *
     * @throws ServletException if there is a servlet failure
     * @throws IOException if there is an I/O error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // TODO: Get user from authentication service rather than hard-coded

        // set url
        String url = "/WEB-INF/user-profile.jsp";

        // Instantiate GenericDao of User object.
        userDao = new GenericDao(User.class);

        // Get username from session
        HttpSession session = request.getSession(false);

        int sessionUser = (int)session.getAttribute("id");
        logger.info("The id in session is: " + sessionUser);

        // Get user by id
        user = (User)userDao.getById(sessionUser);

        logger.info("The retrieved user is: " + user.getFirstname());

        logger.info("The retrieved user's plants are: " + user.getUserplants());

        Set<Userplant> userplants = user.getUserplants();

        // parse user's plants
        try {
            parsePlantList(userplants);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        // set page title
//        request.setAttribute("pageTitle", user.getFirstname() + "'s profile");
//        // set user
        request.setAttribute("user", user);
//        // set user's plants
        request.setAttribute("plantList", plantMap);

        // get dispatcher
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        // forward
        dispatcher.forward(request, response);
    }

    /**
     * Parses plant list from db
     * @param userPlants the object that links users to their plants
     * @throws Exception if there is an issue calling the API
     */
    private void parsePlantList(Set<Userplant> userPlants) throws Exception {
        // instantiate map
        plantMap = new LinkedHashMap<>();

        logger.info("I am in the parsePlantList()");


        // for each UserPlant add id and plant to map
        for (Userplant userPlant : userPlants) {

            logger.info("I got into the for loop");
            logger.info(userPlant.getId());
            logger.info(callAPI(userPlant.getPlantid().getPerenualid()));

            plantMap.put(userPlant.getId(), callAPI(userPlant.getPlantid().getPerenualid()));
            logger.info("The plants in plantsMap are: " + plantMap);
        }

    }

    /**
     * Calls our API
     * @param queryId the id of the plant to query
     * @throws Exception if there is an error calling the API
     * @return mapResponse the mapped response from the API
     */
    public PlantIndividualInfo callAPI(Integer queryId) throws Exception {
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
     * @reutrn plantInfo the mapped information of the plant
     */
    public PlantIndividualInfo mapResponse(String response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // List of individual plant info
        PlantIndividualInfo plantInfo = mapper.readValue(response, PlantIndividualInfo.class);
        logger.debug("Parsed response from API ready for display: " + plantInfo.getCommonName());
        return plantInfo;
    }
}
