package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Models.User;

class UserTest {
    //TODO: Fill those test cases
    static User user;
    //Create necessary object here but, don't initialize them here!
    @BeforeAll
    static void setUp() {
        user=new User("gokce","hektor","hek459","gokce@outlook.com",0);
        //Initialize those objects here.
    }

    @Test
    void getId() {
        int id=1;
        assertEquals(id,user.getId());
    }

    @Test
    void getLogin() {
        user.setLogin("gokce");
        assertEquals("gokce",user.getLogin());
    }

    @Test
    void setLogin() {
        user.setLogin("gokce1");
        assertEquals("gokce1",user.getLogin());
    }

    @Test
    void getPassword() {
        user.setPassword("hektor");
        assertEquals("hektor",user.getPassword());
    }

    @Test
    void setPassword() {
        user.setPassword("gok");
        assertEquals("gok",user.getPassword());
    }

    @Test
    void getNickname() {
        assertEquals("hek459",user.getNickname());
    }

    @Test
    void setNickname() {
        user.setNickname("gok459");
        assertEquals("gok459",user.getNickname());
    }

    @Test
    void getEmailAddress() {
        assertEquals("gokce@outlook.com",user.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        user.setEmailAddress("g@outlook.com");
        assertEquals("g@outlook.com",user.getEmailAddress());
    }

    @Test
    void getProfilePicture() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> user.getProfilePicture(), "Exception is expected!");

    }

    @Test
    void setProfilePicture() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> user.setProfilePicture(null), "Exception is expected!");

    }

    @Test
    void getAccountStatus() {
        assertEquals("active",user.getAccountStatus());
    }

    @Test
    void setAccountStatus() {
        user.setAccountStatus(1);
        assertEquals("suspended",user.getAccountStatus());
    }

    @Test
    void getStatusType() {
        assertEquals("active",user.getStatusType(0));
    }
}