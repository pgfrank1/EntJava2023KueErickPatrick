package com.kueerickpatrick.plantinfo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kueerickpatrick.plantinfo.entity.plantObjects.DataItem;
import com.kueerickpatrick.plantinfo.entity.plantObjects.PlantDetailList;
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
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class PlantDataRetrieval implements PropertiesLoader {
    @Context
    ServletContext context;
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static List<DataItem> foundPlants;
    @GET
    @Path("/{searchTerm}")
    public String getPlantFilteredInfo(@PathParam("searchTerm") String searchTerm) throws IOException {
        List<DataItem> filteredPlants = new ArrayList<>();
        getPlantDetails();

        for (DataItem plantData:
             foundPlants) {
            if (plantData.getCommonName().contains(searchTerm)
                    || plantData.getOtherName().stream().anyMatch(x -> x.equalsIgnoreCase(searchTerm))
                    || plantData.getScientificName().stream().anyMatch(x -> x.equalsIgnoreCase(searchTerm))
                    || plantData.getSunlight().stream().anyMatch(x -> x.equals(searchTerm))
                    || plantData.getCycle().toLowerCase().contains(searchTerm)) {
                filteredPlants.add(plantData);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        return mapper.writeValueAsString(filteredPlants);
    }

    public void getPlantDetails() throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        context.getAttribute("apiKey");
        foundPlants = new ArrayList<>();
        for (int i = 1; i <= 2 /*(int) context.getAttribute("numberOfPages")*/; i++) {
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
        }
    }
}
