package com.kueerickpatrick.plantinfo.controller;

import com.kueerickpatrick.plantinfo.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

/**
 * This class places all the properties that are needed within the application scope. It reduces the need to have a
 * properties loader within each class.
 * @author PGFrank1
 * @version 1.0
 */
@WebListener
public class StartupServlet extends HttpServlet implements PropertiesLoader, ServletContextListener {
    /**
     * Logs the errors that occur within the StartupServlet class.
     */
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * Holds the properties that needs to be loaded for the application.
     */
    Properties properties;

    /**
     * This method obtains the initial servlet context and assigns the needed properties for the
     * application to servlet attributes.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     * that is being initialized
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
//
            properties = loadProperties("/perenualAPI.properties");
            logger.info("The main page is: " + properties.getProperty("plant.details.link"));

            sce.getServletContext().setAttribute("apiKey", properties.getProperty("api.key"));
            sce.getServletContext().setAttribute("plantListMainPageUrl", properties.getProperty("plant.list.main.page"));
            sce.getServletContext().setAttribute("plantDetailsUrl", properties.getProperty("plant.details.link"));

        } catch (IOException e) {
            logger.error("There was an error attempting to open a properties file: ", e);
        } catch (Exception e) {
            logger.error("There was a general error that occurred when attempting to use the properties file: ", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) { }
}
