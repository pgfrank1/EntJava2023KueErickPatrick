package com.kueerickpatrick.plantinfo.persistence;

import com.kueerickpatrick.plantinfo.entity.Plant;
import com.kueerickpatrick.plantinfo.entity.User;
import com.kueerickpatrick.plantinfo.entity.Userplant;
import com.kueerickpatrick.plantinfo.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    /**
     * Verifies add plant to user success
     */
    @Test
    void addPlantToUserSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User retrievedUser = (User)userDao.getById(2);

        Plant firstNewPlant = new Plant(4);
        Plant secondNewPlant = new Plant(5);

        Set<Plant>

        retrievedUser.setUserplants();

        }

        assertEquals(1,retrievedUser.getUserplants().size());
    }

}
