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
        // getUser(request.getAttribute("userFromAuthenticationService"));
        // for now uses Kue as a placeholder
        try {
            getUser(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // set url
        String url = "/WEB-INF/user-profile.jsp";
        // set page title
        request.setAttribute("pageTitle", user.getFirstname() + "'s profile");
        // set user
        request.setAttribute("user", user);
        // set user's plants
        request.setAttribute("plantList", plantMap);
        // get dispatcher
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        // forward
        dispatcher.forward(request, response);
    }

    /**
     * Gets user from db
     * @param userId the id of the user to get
     * @throws Exception if there is an error getting the user
     */
    private void getUser(int userId) throws Exception {
        // instantiate userDao
        userDao = new GenericDao(User.class);
        // get user from db
        User user = (User)userDao.getById(userId);
        // check if user is null
        if (user == null) {
            logger.error("User not found");
        } else {
            // parse user's plants
            parsePlantList(user.getUserplants());
            // set user
            this.user = user;
        }
    }

    /**
     * Parses plant list from db
     * @param userPlants the object that links users to their plants
     * @throws Exception if there is an issue calling the API
     */
    private void parsePlantList(Set<Userplant> userPlants) throws Exception {
        // instantiate map
        plantMap = new LinkedHashMap<>();
        // for each UserPlant add id and plant to map
        for (Userplant userPlant : userPlants) {
            plantMap.put(userPlant.getId(), callAPI(userPlant.getPlantid().getPerenualid()));
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
