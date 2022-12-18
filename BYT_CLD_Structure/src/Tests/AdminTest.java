package Tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Models.Admin;

class AdminTest {
    //TODO: Fill those test cases
   static Admin admin;


    //Create necessary object here but, don't initialize them here!
    @BeforeAll
    static void setUp() {
        admin = new Admin("Gokce","Gokce123","gke","gokcealtunkanat@hotmail.com");
    }

    @Test
    void getId() {
        int id=1;
        assertEquals(id,admin.getId());
    }

    @Test
    void getLogin() {
     admin.setLogin("Gokce");
     assertEquals("Gokce",admin.getLogin());
    }

    @Test
    void setLogin() {
     assertEquals("Gokce",admin.getLogin());
     admin.setLogin("Altunkanat");
     assertEquals("Altunkanat",admin.getLogin());
    }

    @Test
    void getPassword() {
     admin.setPassword("Gokce123");
     assertEquals("Gokce123",admin.getPassword());

    }

    @Test
    void setPassword() {
     assertEquals("Gokce123",admin.getPassword());
     admin.setPassword("gke123");
     assertEquals("gke123",admin.getPassword());

    }

    @Test
    void getNickname() {
     assertEquals("gke",admin.getNickname());
    }

    @Test
    void setNickname() {
     assertEquals("gke",admin.getNickname());
     admin.setNickname("G123");
     assertEquals("G123",admin.getNickname());
    }

    @Test
    void getEmailAddress() {
     assertEquals("gokcealtunkanat@hotmail.com",admin.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
     assertEquals("gokcealtunkanat@hotmail.com",admin.getEmailAddress());
     admin.setEmailAddress("gke@hotmail.com");
     assertEquals("gke@hotmail.com",admin.getEmailAddress());
    }

    @Test
        //exception is expected
    void getProfilePicture() {
     Assertions.assertThrows(UnsupportedOperationException.class, () -> admin.getProfilePicture(), "Exception is expected!");
    }

    @Test
        //exception is expected
    void setProfilePicture() {
     Assertions.assertThrows(UnsupportedOperationException.class, () -> admin.setProfilePicture(null), "Exception is expected!");
    }
}