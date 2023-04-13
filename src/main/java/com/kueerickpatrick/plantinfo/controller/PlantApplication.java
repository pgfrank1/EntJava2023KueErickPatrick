/**
 * PlantApplication
 * Sets an application path for the REST service.
 * @author ereyes3
 */
package com.kueerickpatrick.plantinfo.controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest/")
public class PlantApplication extends Application {
    /**
     * Gets classes needed for REST service.
     * @return hashset of classes needed for REST.
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet restClasses = new HashSet<Class<?>>();
        restClasses.add(PlantDataRetrieval.class);
        restClasses.add(UserPlantREST.class);
        return restClasses;
    }
}
