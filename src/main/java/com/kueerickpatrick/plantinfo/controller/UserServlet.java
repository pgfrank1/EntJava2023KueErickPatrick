package com.kueerickpatrick.plantinfo.controller;

import com.kueerickpatrick.plantinfo.entity.Plant;
import com.kueerickpatrick.plantinfo.entity.User;
import com.kueerickpatrick.plantinfo.entity.Userplant;
import com.kueerickpatrick.plantinfo.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    LinkedHashMap<Integer, Plant> plantMap;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // TODO: Get user from authentication service rather than hard-coded
        // getUser(request.getAttribute("userFromAuthenticationService"));
        // for now uses Kue as a placeholder
        getUser(1);
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

    private void getUser(int userId) {
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

    private void parsePlantList(Set<Userplant> userPlants) {
        // instantiate map
        plantMap = new LinkedHashMap<>();
        // for each UserPlant add id and plant to map
        for (Userplant userPlant : userPlants) {
            plantMap.put(userPlant.getId(), userPlant.getPlantid());
        }
    }
}
