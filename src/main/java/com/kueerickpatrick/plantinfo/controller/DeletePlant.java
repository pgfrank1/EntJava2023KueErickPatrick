package com.kueerickpatrick.plantinfo.controller;

import com.kueerickpatrick.plantinfo.entity.Userplant;
import com.kueerickpatrick.plantinfo.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Delete plant.
 */
@WebServlet(
        name = "deletePlant",
        urlPatterns = {"/deletePlant"}
)
public class DeletePlant extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        GenericDao userplantDao = new GenericDao(Userplant.class);

        logger.debug("Delete string is: " + req.getParameter("plantId"));

        Userplant plantToRemove = (Userplant) userplantDao.getById(Integer.parseInt(req.getParameter("plantId")));
        userplantDao.delete(plantToRemove);
        String url = "/user";
        resp.sendRedirect(req.getContextPath() + url);
    }
}
