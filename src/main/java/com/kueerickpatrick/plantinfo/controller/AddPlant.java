package com.kueerickpatrick.plantinfo.controller;

import com.kueerickpatrick.plantinfo.entity.Plant;
import com.kueerickpatrick.plantinfo.entity.User;
import com.kueerickpatrick.plantinfo.entity.Userplant;
import com.kueerickpatrick.plantinfo.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * AddPlant Servlet
 * Handles requests from Plant page to add plant to user's collection
 * @author Kue Xiong
 */

@WebServlet(
        name = "addPlant",
        urlPatterns = {"/addPlant"}
)
public class AddPlant extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Handles Post requests
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        GenericDao plantDao = new GenericDao(Plant.class);
        GenericDao userDao = new GenericDao(User.class);
        GenericDao userplantDao = new GenericDao(Userplant.class);

        // log parameter to search
        logger.debug("Query string is: " + request.getParameter("plantId"));
        // get plant from API
        Integer selectedId = Integer.parseInt(request.getParameter("plantId"));

        Plant newPlant = new Plant(selectedId);
        int newPlantId = plantDao.insert(newPlant);
        Plant addedPlant = (Plant) plantDao.getById(newPlantId);

        // Get user id from session
        HttpSession session = request.getSession(false);
        int sessionUserID = (int)session.getAttribute("id");

        logger.info("The id in session is: " + sessionUserID);

        User retrievedUser = (User) userDao.getById(sessionUserID);
        Userplant addToUserPlant = new Userplant(retrievedUser, addedPlant);
        userplantDao.insert(addToUserPlant);

        // forward request
        String url = "/user";
        response.sendRedirect(request.getContextPath() + url);

    }
}
