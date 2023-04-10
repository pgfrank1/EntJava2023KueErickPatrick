package com.kueerickpatrick.plantinfo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kueerickpatrick.plantinfo.entity.plantObjects.DataItem;
import com.kueerickpatrick.plantinfo.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This class utilizes a RESTful API service to get the user's search term and look through the data for any
 * term that matches the search
 *
 * @author pgfrank1
 * @version 1.0
 * @since 1.0
 */
@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class PlantDataRetrieval implements PropertiesLoader {
    /**
     * The Servlet Context of the web application.
     */
    @Context
    ServletContext context;
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static List<DataItem> foundPlants;


    /**
     * Gets plant filtered info from the user's search term.
     *
     * @param searchTerm the user search term
     * @return the plant filtered info
     * @throws IOException the io exception that may happen when converting the List to JSON data
     */
    @GET
    @Path("/{searchTerm}")
    public Response getPlantFilteredInfo(@PathParam("searchTerm") String searchTerm) throws IOException {
        List<DataItem> filteredPlants = new ArrayList<>();
        getPlantDetails(searchTerm);
        for (DataItem plantData:
             foundPlants) {
            if (plantData.getCommonName().toLowerCase().contains(searchTerm.toLowerCase())
                    || plantData.getOtherName().stream().anyMatch(x -> x.equalsIgnoreCase(searchTerm.toLowerCase()))
                    || plantData.getScientificName().stream().anyMatch(x -> x.equalsIgnoreCase(searchTerm.toLowerCase()))
                    || plantData.getSunlight().stream().anyMatch(x -> x.equals(searchTerm.toLowerCase()))
                    || plantData.getCycle().toLowerCase().contains(searchTerm.toLowerCase())) {
                filteredPlants.add(plantData);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String output = mapper.writeValueAsString(filteredPlants);
        return Response.status(200).entity(output).build();
    }

    /**
     * Gets plant details from the Perenual API and places those results within a list
     *
     * @throws JsonProcessingException the json processing exception
     */
    public void getPlantDetails(String searchTerm) throws JsonProcessingException {
        foundPlants = new ArrayList<>();
        Client client = ClientBuilder.newClient();
        String builtUrl = (String)context.getAttribute("plantDetailsUrl") + context.getAttribute("apiKey");

        List<String> userSearchParameters = Arrays.asList(searchTerm.split("\\s+"));
        Iterator<String> plantCycles = Arrays.stream(context.getAttribute("plantCycles").toString().split(",")).iterator();
        Iterator<String> plantWateringNeeds = Arrays.stream(context.getAttribute("plantWateringNeeds").toString().split(",")).iterator();
        Iterator<String> plantSunlightNeeds = Arrays.stream(context.getAttribute("plantSunlightNeeds").toString().split(",")).iterator();

        Boolean cycleParameterAlreadyExists = false;
        Boolean waterParameterAlreadyExists = false;

        while (plantCycles.hasNext() && plantWateringNeeds.hasNext()) {

            String plantCycle = plantCycles.next();
            String wateringNeed = plantWateringNeeds.next();

            if (userSearchParameters.contains(plantCycle) && !cycleParameterAlreadyExists) {

                cycleParameterAlreadyExists = true;
                builtUrl += "&cycle=" + plantCycle;
                userSearchParameters.remove(plantCycle);

            } else if (cycleParameterAlreadyExists) {
                userSearchParameters.remove(plantCycle);
            }

            if (userSearchParameters.contains(wateringNeed) && !waterParameterAlreadyExists) {
                waterParameterAlreadyExists = true;
                builtUrl += "&watering=" + wateringNeed;
                userSearchParameters.remove(wateringNeed);
            } else if (waterParameterAlreadyExists) {
                userSearchParameters.remove(wateringNeed);
            }
        }

/*        for (int i = 1; i <= 2 *//*(int) context.getAttribute("numberOfPages")*//*; i++) {
            String plantInfoApiUrl = (String) context.getAttribute("plantListMainPageUrl") + i + "&"
                    + context.getAttribute("apiKey");
            logger.info("Getting page number: " + i);
            logger.debug("Attempting to retrieve plant details pages");
            WebTarget targetPlantDetails = client.target(plantInfoApiUrl);
            String apiResponse = targetPlantDetails.request(MediaType.APPLICATION_JSON).get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            PlantDetailList plantDetailList = mapper.readValue(apiResponse, PlantDetailList.class);
            foundPlants.addAll(plantDetailList.getData());
            logger.debug("Current found plants in JSON data: " + foundPlants.size());
        }*/
    }
}
