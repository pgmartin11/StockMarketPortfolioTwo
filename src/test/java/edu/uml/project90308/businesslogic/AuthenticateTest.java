package edu.uml.project90308.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.uml.project90308.persistence.*;

public class AuthenticateTest {

    private String tUserName;
    private String tPasswd;
    private UserInfo testUser;

    @Before
    public void setup() {
        tUserName = "pgmartin";
        tPasswd = "Biking2009";
        testUser = new UserInfo(tUserName, tPasswd);
    }

    @Test
    public void testProcessLoginPositive() throws UserNotFoundException, MoreThanOneUserFoundException {
        UserInfo user = Authenticate.processLogin(tUserName, tPasswd);
        assertEquals("Authentication successful: userName", testUser.getUserName(), user.getUserName());
        assertEquals("Authentication successful: password", testUser.getPassword(), user.getPassword());
    }
    @Test
    public void testProcessLoginNegative() throws UserNotFoundException, MoreThanOneUserFoundException {
    //     UserInfo user = Authenticate.processLogin(tUserName, "foo");
    //     assertEquals("Authentication successful: userName", testUser.getUserName(), user.getUserName());
    //     assertEquals("Authentication successful: password", "foo", user.getPassword());
    }
    @Test
    public void testProcessLogout() {
        //
    }

}
