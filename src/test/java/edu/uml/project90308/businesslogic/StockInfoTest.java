package edu.uml.project90308.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StockInfoTest {

    private Stock tStock;
    private StockInfo tStockInfo;

    @Before
    public void setup() {
        tStock = new Stock("EMC", "EMC Corporation", "28.75");
        tStockInfo = new StockInfo();
    }

    @Test
    public void testStockInfoConstruction() {
    }

    @Test
    public void testSearchStockSymbol() {
        Stock stock = tStockInfo.searchStockSymbol("EMC");
        assertEquals("Symbol", stock.getSymbol(), tStock.getSymbol());
        assertEquals("Full Name", stock.getFullName(), tStock.getFullName());
    }

    @Test
    public void testAddStockSymbol() {
    }

    @Test
    public void testRemoveStockSymbol() {
    }


    @Test
    public void testEditStockInfo() {
        Stock stock = tStockInfo.searchStockSymbol("EMC");
        assertEquals("Symbol", stock.getSymbol(), tStock.getSymbol());
        assertEquals("Full Name", stock.getFullName(), tStock.getFullName());
    }

    @Test
    public void testSelectStockSymbol() {
        Stock stock = tStockInfo.searchStockSymbol("EMC");
        assertEquals("Symbol", stock.getSymbol(), tStock.getSymbol());
    }

    @Test
    public void testRefreshQuote() {
    }

}
