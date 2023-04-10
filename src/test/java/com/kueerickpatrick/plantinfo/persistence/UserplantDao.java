package com.kueerickpatrick.plantinfo.persistence;

import com.kueerickpatrick.plantinfo.entity.Plant;
import com.kueerickpatrick.plantinfo.entity.User;
import com.kueerickpatrick.plantinfo.entity.Userplant;
import com.kueerickpatrick.plantinfo.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Userplant dao test
 */
public class UserplantDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao plantDao;
    GenericDao userDao;
    GenericDao userplantDao;

    /**
     * Creates the GenericDao and resets user and plant tables
     * with original content.
     */
    @BeforeEach
    void setUp() {

        userDao = new GenericDao(User.class);
        plantDao = new GenericDao(Plant.class);
        userplantDao = new GenericDao(Userplant.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }


    /**
     * Verifies get list of plants for user success
     */
    @Test
    void getPlantsByUserSuccess() {
        User retrievedUser = (User)userDao.getById(2);
        assertEquals(1,retrievedUser.getUserplants().size());
    }

    /**
     * Verifies get list of users by plants
     */
    @Test
    void getUsersByPlantSuccess() {
        Plant retrievedPlant = (Plant)plantDao.getById(1);
        assertEquals(2, retrievedPlant.getUserplants().size());
    }


    /**
     * Verifies add plant to user success
     */
    @Test
    @Transactional
    void addPlantToUserSuccess() {

        User retrievedUser = (User)userDao.getById(2);
        Plant newPlant = new Plant(4);
        int id = plantDao.insert(newPlant);

        Plant retrievedPlantID = (Plant)plantDao.getById(id);

        Userplant newUserplant = new Userplant(retrievedUser, retrievedPlantID);

        int i = userplantDao.insert(newUserplant);

        Userplant retrievedPlant = (Userplant)userplantDao.getById(i);
        assertEquals(i, retrievedPlant);
    }

}
