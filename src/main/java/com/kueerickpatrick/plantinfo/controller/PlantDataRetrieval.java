package com.kueerickpatrick.plantinfo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kueerickpatrick.plantinfo.entity.plantObjects.DataItem;
import com.kueerickpatrick.plantinfo.entity.plantObjects.PlantDetailList;
import com.kueerickpatrick.plantinfo.entity.plantObjects.PlantIndividualInfo;
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
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This class utilizes a RESTful API service to get the user's search terms and look through the data for any
 * term that matches the search
 *
 * @author pgfrank1
 * @version 1.1
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
    private List<DataItem> foundPlants = new ArrayList<>();


    /**
     * Gets plant filtered info from the user's search terms.
     *
     * @param searchTerm the user search term
     * @return the plant filtered info
     * @throws IOException the io exception that may happen when converting the List to JSON data
     */
    @GET
    @Path("/{searchTerm}")
    public Response getPlantFilteredInfo(@PathParam("searchTerm") String searchTerm) throws IOException {
        getPlantDetails(searchTerm.toLowerCase());
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String output = mapper.writeValueAsString(foundPlants);
        return Response.status(200).entity(output).build();
    }

    /**
     * Gets plant info by id.
     *
     * @param enteredId the entered id
     * @return the plant info in JSON format
     * @throws JsonProcessingException the json processing exception
     */
    @GET
    @Path("/id/{enteredId}")
    public Response getPlantInfoById(@PathParam("enteredId") String enteredId) throws JsonProcessingException {
        String plantIndividualInfo = getPlantDetailsById(Integer.parseInt(enteredId));
        ObjectMapper mapper = new ObjectMapper();
        PlantIndividualInfo mappedPlantIndividualInfo = mapper.readValue(plantIndividualInfo, PlantIndividualInfo.class);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String output = mapper.writeValueAsString(mappedPlantIndividualInfo);
        return Response.status(200).entity(output).build();
    }

    /**
     * Creates the URL with the entered ID, and retrieves the data from the Perenual API
     *
     * @param enteredId the entered id to search for
     * @return Json data in String format
     */
    private String getPlantDetailsById(int enteredId) {
        Client client = ClientBuilder.newClient();
        String completedIdUrl = (String) context.getAttribute("plantDetailsUrl") + enteredId + "?" + context.getAttribute("apiKey");
        WebTarget targetPlantDetails = client.target(completedIdUrl);
        return targetPlantDetails.request(MediaType.APPLICATION_JSON).get(String.class);
    }

    /**
     * Gets plant details from the Perenual API and places those results within a list
     *
     * @param searchTerm the search term
     * @throws JsonProcessingException the json processing exception
     */
    public void getPlantDetails(String searchTerm) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        //Split user search parameters into an ArrayList
        ArrayList<String> userSearchParameters = new ArrayList<>(Arrays.asList(searchTerm.split("\\s+")));
        //Creates the completed url to query the Perenual API
        StringBuilder completedUrl = buildPerenualUrl(userSearchParameters);
        ArrayList<String> allQueriesUrl = buildRemainingSearchTerms(completedUrl, userSearchParameters);

        for (String individualQueries : allQueriesUrl) {
            WebTarget targetPlantDetails = client.target(individualQueries);
            String apiResponse = targetPlantDetails.request(MediaType.APPLICATION_JSON).get(String.class);
            //Gets the API response and places it in a String
            ObjectMapper mapper = new ObjectMapper();
            PlantDetailList plantDetailList = mapper.readValue(apiResponse, PlantDetailList.class);
            // add new results
            foundPlants.addAll(plantDetailList.getData());
        }
        logger.debug("Current found plants in JSON data: " + foundPlants.size());
    }

    /**
     * This class takes in the user's search parameters, checks to see it matches the 3 queries that are static values
     * in the Perenual API, removes any matching parameter from the user's search term, then attempts to search for
     * the plant name that the user has entered.
     *
     * @param userSearchParameters the user search parameters
     * @return the string builder of the url API query
     */
    public StringBuilder buildPerenualUrl(ArrayList<String> userSearchParameters) {
        // Prepares the beginning of the URL
        StringBuilder builtUrl = new StringBuilder((String) context.getAttribute("plantListSearchUrl") + context.getAttribute("apiKey"));
        // As there are only 3 Lists within the properties, the queryLists variable gets reassigned 3 times.
        for (int i = 0; i < 3; i++) {
            Iterator<String> queryLists = null;
            Boolean parameterExists = false;
            // Selects the different lists available
            switch (i){
                case 0:
                    queryLists = Arrays.stream(context.getAttribute("plantCycles").toString().split(",")).iterator();
                    logger.debug("plantCycles array has been selected.");
                    break;
                case 1:
                    queryLists = Arrays.stream(context.getAttribute("plantWateringNeeds").toString().split(",")).iterator();
                    logger.debug("plantWateringNeeds array has been selected.");
                    break;
                case 2:
                    queryLists = Arrays.stream(context.getAttribute("plantSunlightNeeds").toString().split(",")).iterator();
                    logger.debug("plantSunlightNeeds array has been selected.");
                    break;
            }
            // Loops through the current query list and checks to make sure that a parameter does not already exist.
            while (queryLists.hasNext() && !parameterExists) {
                String parameterToAdd = queryLists.next();
                if (userSearchParameters.contains(parameterToAdd)) {
                    parameterExists = true;
                    // Uses the correct parameter depending on the queryList the iterator is on
                    if (i == 0) {
                        builtUrl.append("&cycle=").append(parameterToAdd);
                        logger.debug("Cycle parameter found: Current URL is:" + builtUrl);
                    } else if (i == 1) {
                        builtUrl.append("&watering=").append(parameterToAdd);
                        logger.debug("Watering parameter found: Current URL is:" + builtUrl);
                    } else {
                        builtUrl.append("&sunlight=").append(parameterToAdd);
                        logger.debug("Sunlight parameter found: Current URL is:" + builtUrl);
                    }
                }
                userSearchParameters.remove(parameterToAdd);
            }
        }
        return builtUrl;
    }

    /**
     * Build remaining search terms array list.
     *
     * @param completedUrl         the completed url
     * @param userSearchParameters the user search parameters
     * @return the array list
     */
    public ArrayList<String> buildRemainingSearchTerms(StringBuilder completedUrl, ArrayList<String> userSearchParameters) {
        ArrayList<String> allPossibleQueries = new ArrayList<>();
        for (String userSearchTerm : userSearchParameters) {
            String newUrl = completedUrl.toString();
            newUrl += "&q=" + userSearchTerm;
            allPossibleQueries.add(newUrl);
        }
        return allPossibleQueries;
    }
}
