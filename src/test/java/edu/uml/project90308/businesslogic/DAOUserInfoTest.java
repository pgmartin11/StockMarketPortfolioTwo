package edu.uml.project90308.businesslogic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import edu.uml.project90308.businesslogic.*;
import edu.uml.project90308.persistence.*;

public class DAOUserInfoTest {

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
    public void testGetUserAccountPositive() throws CouldNotReadDataException {
        List<UserInfo> userInfoList = DAOUserInfo.getUserAccount(tUserName, tPasswd);
        UserInfo user = userInfoList.get(0);
        assertEquals("Username", testUser.getUserName(), user.getUserName());
        assertEquals("Password", testUser.getPassword(), user.getPassword());
    }

    @Test
    public void testGetUserAccountNegative() throws CouldNotReadDataException {
        List<UserInfo> userInfoList = DAOUserInfo.getUserAccount("foo", "bar");
        assertTrue(userInfoList.isEmpty());
    }

    @Test
    public void testGetAllUserAccounts() throws CouldNotReadDataException {
        List<UserInfo> testAccounts = new ArrayList<UserInfo>();
        List<Stock> testStocks = new ArrayList<Stock>();
        testStocks.add(new Stock("GOOG", "", ""));
        testAccounts.add(new UserInfo("pgmartin", "Biking2009",testStocks));
        testStocks = new ArrayList<Stock>();
        testStocks.add(new Stock("APPL", "", ""));
        testStocks.add(new Stock("EMC", "", ""));
        testAccounts.add(new UserInfo("jharvard", "Brewhouse2012",testStocks));
        List<UserInfo> allUsers = DAOUserInfo.getAllUserAccounts();
        assertEquals(testAccounts, allUsers);
    }
}
