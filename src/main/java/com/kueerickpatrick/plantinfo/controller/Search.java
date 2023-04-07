package com.kueerickpatrick.plantinfo.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Search
 * This Servlet will be used to forward to the search page.
 * @author ereyes3
 */
@WebServlet(
        name = "search",
        urlPatterns = { "/search" }
)
public class Search extends HttpServlet {
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
}
