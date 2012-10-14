package edu.uml.project90308.persistence;

import com.sun.xml.internal.ws.server.EndpointMessageContextImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import edu.uml.project90308.businesslogic.*;

public class UserInfoTest {

    private UserInfo user;
    private String DEFAULT_USERNAME = "MOM";
    private String DEFAULT_PASSWORD =  "momPW";

    @Before
    public void setUp() {
        List<Stock>StockList = new ArrayList<Stock>();
        StockList.add(new Stock("EMC", "EMC Corporation", "28.80"));
        user = new UserInfo(DEFAULT_USERNAME, DEFAULT_PASSWORD, StockList);
    }

    @Test
    public void testGetUserName() {
        String result = user.getUserName();
        assertEquals(DEFAULT_USERNAME, result);
     }

    @Test
    public void testGetPassword() {
        String result = user.getPassword();
        assertEquals(DEFAULT_PASSWORD, result);
    }

    @Test
    public void testGetStocks() {
        List<Stock>tStockList = new ArrayList<Stock>();
        tStockList.add(new Stock("EMC", "EMC Corporation", "28.80"));
        List<Stock> result = user.getStocks();
        assertEquals(tStockList, result);
    }

    @Test
    public void testSetName() {
        String name = "Buddy";
        user.setUserName(name);
        String result = user.getUserName();
        assertEquals(name, result);
    }

    @Test
    public void testSetPassword() {
        String newPassword = "Tco2012";
        user.setPassword(newPassword);
        String result = user.getPassword();
        assertEquals(newPassword, result);
    }

    @Test
    public void testSetStocks() {
        List<Stock>tStockList = new ArrayList<Stock>();
        tStockList.add(new Stock("EMC", "EMC Corporation", "28.80"));
        tStockList.add(new Stock("GOOG", "Google, Inc.", "744.75"));
        user.setStocks(tStockList);
        List<Stock> result = user.getStocks();
        assertEquals(tStockList, result);
    }

}