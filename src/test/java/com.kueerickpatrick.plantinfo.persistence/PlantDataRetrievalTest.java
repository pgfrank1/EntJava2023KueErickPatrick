package com.kueerickpatrick.plantinfo.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kueerickpatrick.plantinfo.entity.plantObjects.PlantDetailList;
import com.kueerickpatrick.plantinfo.util.PropertiesLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Plant data retrieval test.
 */
public class PlantDataRetrievalTest implements PropertiesLoader {
    /**
     * The Properties.
     */
    Properties properties;
    /**
     * The Mapper.
     */
    ObjectMapper mapper;

    /**
     * Initializes the required variables for testing
     *
     * @throws Exception the exception
     */
    @BeforeEach
    public void init() throws Exception {
        properties = loadProperties("/perenualAPI.properties");
        mapper = new ObjectMapper();
    }

    /**
     * Test json response.
     *
     * @throws Exception the exception
     */
    @Test
    public void testJSONResponse() throws Exception {
        Client client = ClientBuilder.newClient();
        String plantInfoApiUrl = (String) properties.getProperty("plant.list.main.page")
                + 1 + "&" + properties.getProperty("api.key");
        WebTarget target = client.target(plantInfoApiUrl);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        PlantDetailList plantDetailList = mapper.readValue(response, PlantDetailList.class);
        int resultSize = 30;
        assertEquals(resultSize, plantDetailList.getTo());
    }
}
