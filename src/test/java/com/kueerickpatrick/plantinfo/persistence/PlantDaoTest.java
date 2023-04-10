package com.kueerickpatrick.plantinfo.persistence;

import com.kueerickpatrick.plantinfo.entity.Plant;
import com.kueerickpatrick.plantinfo.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Plant dao test
 */
public class PlantDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao plantDao;

    /**
     * Creates the GenericDao and resets user, plant,
     * and userplant table with original content.
     */
    @BeforeEach
    void setUp() {

        plantDao = new GenericDao(Plant.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all plants success.
     */
    @Test
    void getAllPlantsSuccess() {
        List<Plant> plants = plantDao.getAll();
        assertEquals(2,plants.size());
    }

    @Test
    void getByIdSuccess(){
        Plant retreivedPlant = (Plant)plantDao.getById(2);
        assertNotNull(retreivedPlant);
        int expected = 6;
        int actual = retreivedPlant.getPerenualid();
        assertEquals(expected, actual);
    }

}
