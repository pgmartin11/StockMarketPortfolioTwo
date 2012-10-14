package edu.uml.project90308.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.uml.project90308.businesslogic.*;

public class StockTest {

    private String testSymbol;
    private String testFullName;
    private String testInfo;
    Stock testStock;

    @Before
    public void setup() {
        testSymbol = "EMC";
        testFullName = "EMC Corporation";
        testInfo = "28.75";
        testStock = new Stock(testSymbol, testFullName, testInfo);
    }

    @Test
    public void testStockConstruction() {

        assertEquals("Symbol", testSymbol, testStock.getSymbol());
        assertEquals("fullName", testFullName, testStock.getFullName());
        assertEquals("info", testInfo, testStock.getInfo());
    }

    @Test
    public void testSetSymbol() {
        String stockname = "GOOG";
        testStock.setSymbol(stockname);
        assertEquals(stockname, testStock.getSymbol());
    }

    @Test
    public void testSetFullName() {
        String fullname = "Google, Inc.";
        testStock.setFullName(fullname);
        assertEquals(fullname, testStock.getFullName());
    }

    @Test
    public void testSetFullInfo() {
        String info = "744.45";
        testStock.setInfo(info);
        assertEquals(info, testStock.getInfo());
    }

    @Test
    public void testEquals() {
        Stock anotherTestStock = new Stock(testSymbol, testFullName, testInfo);
        assertEquals(anotherTestStock, testStock);
    }
}
