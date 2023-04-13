package com.kueerickpatrick.plantinfo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "RESTfulDocs",
        urlPatterns = {"/restfulDocs"}
)
public class RestfulDocsServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/WEB-INF/restfulDocs.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        logger.debug("Sending user to " + url);
        request.setAttribute("pageTitle", "API Documentation");
        dispatcher.forward(request, response);
    }
}
