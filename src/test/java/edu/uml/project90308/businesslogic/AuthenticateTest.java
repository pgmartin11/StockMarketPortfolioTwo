package edu.uml.project90308.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.uml.project90308.persistence.Person;

public class AuthenticateTest {

    private String tUserName;
    private String tPasswd;
    private UserInfo testUser;

    @Before
    public void setup() {
        tUserName = "pgmartin";
        tPasswd = "pg.martin@rcn.com";
        testUser = new UserInfo(tUserName, tPasswd);
    }

    @Test
    public void testAuthenticateConstruction() {
        return;
    }

    @Test
    public void testProcessLoginPositive() {
        Authenticate testAuthenticate = new Authenticate();
        UserInfo uInfo = testAuthenticate.processLogin(tUserName, tPasswd);
        assertEquals("Authentication successful: userName", testUser.getUserName(), uInfo.getUserName());
        assertEquals("Authentication successful: password", testUser.getPassword(), uInfo.getPassword());
    }

}
