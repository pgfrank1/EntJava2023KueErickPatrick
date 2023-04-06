package com.kueerickpatrick.plantinfo.persistence;

import com.kueerickpatrick.plantinfo.entity.Plant;
import com.kueerickpatrick.plantinfo.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Plant dao test
 */
public class PlantDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao genericDao;

    /**
     * Creates the GenericDao and resets user, plant,
     * and userplant table with original content.
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(Plant.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all plants success.
     */
    @Test
    void getAllPlantsSuccess() {
        List<Plant> plants = genericDao.getAll();
        assertEquals(2,plants.size());
    }
}
