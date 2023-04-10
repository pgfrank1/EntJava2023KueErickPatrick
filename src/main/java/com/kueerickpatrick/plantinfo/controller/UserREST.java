package com.kueerickpatrick.plantinfo.controller;

import com.kueerickpatrick.plantinfo.entity.*;
import com.kueerickpatrick.plantinfo.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static java.lang.Integer.parseInt;

@Path("/user")
public class UserREST {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao userDao;
    private GenericDao plantDao;
    private GenericDao userplant;

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/html")
    @Path("/{id}")
    public Response getUserById(@PathParam("id") String id) {

        userDao = new GenericDao(User.class);

        String displayID = "The ID passed in is: " + id;

        int userId = Integer.parseInt(id);
        logger.info("The id passed in is: " + userId);
        User user = (User)userDao.getById(userId);
        logger.info("The user is: " + user.toString());
        String output = "User ID: " + userId + "\nUser information: " + user;

        return Response.status(200).entity(output).build();

    }
}
