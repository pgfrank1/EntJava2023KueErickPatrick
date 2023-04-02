package com.kueerickpatrick.plantinfo.persistence;


import com.kueerickpatrick.plantinfo.entity.User;
import com.kueerickpatrick.plantinfo.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test
 */
public class UserDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao genericDao;

    /**
     * Creates the GenericDao and resets user and plant tables
     * with original content.
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all users success.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = genericDao.getAll();
        assertEquals(2,users.size());
    }

    /**
     * Verifies gets by id success.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Kue", retrievedUser.getFirstName());
    }

    /**
     * Verifies save or update success.
     */
    @Test
    void saveOrUpdate() {
        String newLastName = "Pikachu";
        User user = (User)genericDao.getById(1);
        user.setLastName(newLastName);
        genericDao.saveOrUpdate(user);
        User retrievedUser = (User)genericDao.getById(1);
        assertEquals(user,retrievedUser);
    }

    /**
     * Verifies insert new user success.
     */
    @Test
    void insertSuccess() {
        User user = new User("Patrick", "Starfish","pstarfish");
        int id = genericDao.insert(user);
        assertNotEquals(0,id);
        User expectedUser = (User)genericDao.getById(id);
        assertEquals(user,expectedUser);
    }

    /**
     * Verifies delete a user success.
     */
    @Test
    void deleteSuccess() {
        User userToBeDeleted = (User)genericDao.getById(1);
        genericDao.delete(userToBeDeleted);
        assertNull(genericDao.getById(1));
    }

    /**
     * Verifies get by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> retrievedUsers = genericDao.getByPropertyLike("lastName","Sq");
        assertEquals(1, retrievedUsers.size());
    }
}
