package com.kueerickpatrick.plantinfo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kueerickpatrick.plantinfo.entity.SingletonAttributes;
import com.kueerickpatrick.plantinfo.entity.plantObjects.DataItem;
import com.kueerickpatrick.plantinfo.entity.plantObjects.PlantDetailList;
import com.kueerickpatrick.plantinfo.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/search")
@Produces(MediaType.TEXT_HTML)
@WebServlet(
        name = "PlantDataRetrieval",
        value = "/PlantDataRetrieval"
)
public class PlantDataRetrieval implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static List<DataItem> foundPlants;
    private SingletonAttributes attributes = SingletonAttributes.SingletonAttributes();
    @GET
    @Path("/{searchTerm}/get")
    public List<DataItem> getPlantFilteredInfo(@PathParam("searchTerm") String searchTerm) throws JsonProcessingException {
        return getPlantDetails();
    }

    public List<DataItem> getPlantDetails() throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        foundPlants = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String plantInfoApiUrl = attributes.plantListMainPage + i + "&"
                    + attributes.apiKey;
            logger.info("Getting page number: " + i);
            logger.debug("Attempting to retrieve plant details pages");
            WebTarget targetPlantDetails = client.target(plantInfoApiUrl);
            String apiResponse = targetPlantDetails.request(MediaType.APPLICATION_JSON).get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            PlantDetailList plantDetailList = mapper.readValue(apiResponse, PlantDetailList.class);
            foundPlants.addAll(plantDetailList.getData());
            logger.debug("Current found plants in JSON data: " + foundPlants.size());
        }
        return foundPlants;
    }
}
