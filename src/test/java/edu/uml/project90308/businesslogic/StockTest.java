package edu.uml.project90308.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StockTest {

    private String testSymbol;
    private String testFullName;
    private String testInfo;

    @Before
    public void setup() {
        testSymbol = "EMC";
        testFullName = "EMC Corporation";
        testInfo = "28.75";
    }

    @Test
    public void testStockConstruction() {
        Stock emc = new Stock("EMC", "EMC Corporation", "28.75");
        assertEquals("Symbol", emc.getSymbol(), testSymbol);
        assertEquals("fullName", emc.getFullName(), testFullName);
        assertEquals("fullName", emc.getFullName(), testFullName);
    }

}
