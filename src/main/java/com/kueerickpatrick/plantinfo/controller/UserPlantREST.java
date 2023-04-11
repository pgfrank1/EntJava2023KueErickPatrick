package com.kueerickpatrick.plantinfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kueerickpatrick.plantinfo.entity.*;
import com.kueerickpatrick.plantinfo.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Path("/plantinfo")
public class UserPlantREST {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao userDao;
    private GenericDao plantDao;

    ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    // The Java method will process HTTP GET requests
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user/{id}")
    public Response getUserById(@PathParam("id") String id) throws IOException {

        userDao = new GenericDao(User.class);

        int userId = Integer.parseInt(id);
        logger.info("The id passed in is: " + userId);
        User user = (User)userDao.getById(userId);
        logger.info("The user is: " + user.toString());

        String output = mapper.writeValueAsString(user);

        return Response.status(200).entity(output).build();
    }

    /**
     * Gets plant by id.
     *
     * @param id the id
     * @return the plant by id
     * @throws IOException the io exception
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/plant/{id}")
    public Response getPlantById(@PathParam("id") String id) throws IOException {

        plantDao = new GenericDao(Plant.class);

        int plantId = Integer.parseInt(id);
        logger.info("The id passed in is: " + plantId);
        Plant plant = (Plant)plantDao.getById(plantId);
        logger.info("The user is: " + plant.toString());

        String output = mapper.writeValueAsString(plant);

        return Response.status(200).entity(output).build();
    }

    /**
     * Gets plants by user id.
     *
     * @param id the id
     * @return the plants by user id
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user/{id}/plants")
    public Response getPlantsByUserId(@PathParam("id") String id) throws IOException {

        userDao = new GenericDao(User.class);

        int userId = Integer.parseInt(id);
        logger.info("The id passed in is: " + userId);
        User user = (User)userDao.getById(userId);

        // Get all entries (primary keys) in Userplant for userID
        Set<Userplant> userplants = user.getUserplants();

        // Loop through each entry and add plantID to new list
        Set<Plant> plantIds = new HashSet<>();
        for (Userplant plant : userplants) {
            plantIds.add(plant.getPlantid());
        }

        String output = mapper.writeValueAsString(plantIds);

        return Response.status(200).entity(output).build();
    }

    /**
     * Gets users by plant id.
     *
     * @param id the id
     * @return the users by plant id
     * @throws IOException the io exception
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("plant/{id}/users")
    public Response getUsersByPlantID(@PathParam("id") String id) throws IOException {

        plantDao = new GenericDao(Plant.class);

        int plantId = Integer.parseInt(id);
        logger.info("The plant id passed in is: " + plantId);
        Plant plant = (Plant)plantDao.getById(plantId);
        logger.info("The plant object is: " + plant);

        // Get all entries (primary keys) in Userplant for plantID
        Set<Userplant> userplants = plant.getUserplants();

        // Loop through each entry and add userID to new list
        Set<User> userIds = new HashSet<>();
        for (Userplant user : userplants) {
            userIds.add(user.getUserid());
        }

        String output = mapper.writeValueAsString(userIds);

        return Response.status(200).entity(output).build();
    }

    @POST
    @Produces("Text/HTML")
    @Path("newuser/{firstName}/{lastName}/{userName}")
    public Response addNewUser(@PathParam("firstName") String firstName,
                               @PathParam("lastName") String lastName,
                               @PathParam("userName") String userName) {

        userDao = new GenericDao(User.class);
        logger.info("First name: " + firstName + ", Last Name: " + lastName +  ", Username: " + userName);
        User newUser = new User(firstName, lastName, userName);
        int id = userDao.insert(newUser);

        String output = null;
        User expectedUser = (User)userDao.getById(id);
        if (newUser.equals(expectedUser)) {
            output = "The user was successfully added.";
        } else {
            output = "There was an error in adding user.";
        }

        return Response.status(200).entity(output).build();
    }
}
