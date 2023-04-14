package com.kueerickpatrick.plantinfo.controller;

import com.kueerickpatrick.plantinfo.entity.Plant;
import com.kueerickpatrick.plantinfo.entity.User;
import com.kueerickpatrick.plantinfo.entity.Userplant;
import com.kueerickpatrick.plantinfo.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "deletePlant",
        urlPatterns = {"/deletePlant"}
)
public class DeletePlant extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        GenericDao plantDao = new GenericDao(Plant.class);
        GenericDao userDao = new GenericDao(User.class);
        GenericDao userplantDao = new GenericDao(Userplant.class);

        logger.debug("Delete string is: " + req.getParameter("plantId"));

        Plant plantToRemove = new Plant(Integer.parseInt(req.getParameter("plantId")));
        User currentUser = (User) userDao.getById((Integer) session.getAttribute("id"));
        userplantDao.delete(plantToRemove);
        String url = "/user";
        resp.sendRedirect(req.getContextPath() + url);
    }
}
