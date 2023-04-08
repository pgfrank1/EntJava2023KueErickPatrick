package com.kueerickpatrick.plantinfo.controller;

import com.kueerickpatrick.plantinfo.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import java.util.Properties;

/**
 * This class places all the properties that are needed within the application scope. It reduces the need to have a
 * properties loader within each class.
 *
 * @author PGFrank1
 * @version 1.0
 * @since 1.0
 */
@WebListener
public class StartupServlet extends HttpServlet implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void init() {
        Properties properties;
        try {
            properties = loadProperties("/perenualAPI.properties");
            logger.info("The main page is: " + properties.getProperty("plant.details.link"));

            getServletContext().setAttribute("apiKey", properties.getProperty("api.key"));
            getServletContext().setAttribute("plantListMainPageUrl", properties.getProperty("plant.list.main.page"));
            getServletContext().setAttribute("plantDetailsUrl", properties.getProperty("plant.details.link"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}