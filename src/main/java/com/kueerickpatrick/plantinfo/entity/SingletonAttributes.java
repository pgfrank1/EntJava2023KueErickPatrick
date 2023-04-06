package com.kueerickpatrick.plantinfo.entity;

import com.kueerickpatrick.plantinfo.util.PropertiesLoader;

import java.util.Properties;

public class SingletonAttributes implements PropertiesLoader {
    private static SingletonAttributes singleInstance = null;
    private Properties properties;

    public String apiKey;
    public String plantListMainPage;
    public String plantDetailsLink;

    private SingletonAttributes() {
        try {
            properties = loadProperties("/perenualAPI.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        apiKey = properties.getProperty("api.key");
        plantListMainPage = properties.getProperty("plant.list.main.page");
        plantDetailsLink = properties.getProperty("plant.details.link");
    }
    public static SingletonAttributes SingletonAttributes() {
        if (singleInstance == null) {
            singleInstance = new SingletonAttributes();
        }
        return singleInstance;
    }
}
