package edu.uml.project90308.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class UserInfoTest {

    private String testUserName;
    private String testPassword;

    @Before
    public void setup() {
        testUserName = "pgmartin11";
        testPassword = "Fsaj2011";
    }

    @Test
    public void testStockConstruction() {
        UserInfo pgm = new UserInfo("pgmartin11", "Fsaj2011");
        assertEquals("User Name", pgm.getUserName(), testUserName);
        assertEquals("Password", pgm.getPassword(), testPassword );
    }

    @Test
    public void testSetUserName() {
        UserInfo pgm = new UserInfo("pgmartin11", "Fsaj2011");
        String newName = "peterg";
        pgm.setUserName(newName);
        assertEquals("User Name", pgm.getUserName(), newName);
    }

    @Test
    public void testSetPassword() {
        UserInfo pgm = new UserInfo("pgmartin11", "Fsaj2011");
        String newPasswd = "Tco2012";
        pgm.setPassword(newPasswd);
        assertEquals("Password", pgm.getPassword(), newPasswd);
    }


}
