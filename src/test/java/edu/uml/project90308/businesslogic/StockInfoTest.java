package edu.uml.project90308.businesslogic;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.uml.project90308.persistence.*;

public class StockInfoTest {

    private Stock tStock;
    private StockInfo stockInfo;

    private UserInfo user;
    private String DEFAULT_USERNAME = "MOM";
    private String DEFAULT_PASSWORD =  "momPW";

    @Before
    public void setup() {
        stockInfo = new StockInfo();
        List<Stock> StockList = new ArrayList<Stock>();
        StockList.add(new Stock("EMC", "EMC Corporation", "28.80"));
        StockList.add(new Stock("GOOG", "Google, Inc.", "744.75"));
        user = new UserInfo(DEFAULT_USERNAME, DEFAULT_PASSWORD, StockList);
    }

    @Test
    public void testSelectStockPositive() {
        List<Stock> stock = stockInfo.selectStock(user, "EMC");
        tStock = new Stock("EMC", "", "");
        assertEquals("Symbol", stock.get(0).getSymbol(), tStock.getSymbol());
    }

    @Test
    public void testSelectStockNegative() {
        List<Stock> stock = stockInfo.selectStock(user, "FOO");
        tStock = new Stock("EMC", "", "");
        assertTrue(stock.isEmpty());
    }

    @Test
    public void testAddStock() {
        List<Stock>tStockList = new ArrayList<Stock>();
        tStockList.add(new Stock("EMC", "EMC Corporation", "28.80"));
        tStockList.add(new Stock("GOOG", "Google, Inc.", "744.75"));
        Stock nStock = new Stock("YHOO", "Yahoo! Inc.", "16.79");
        tStockList.add(nStock);
        stockInfo.addStock(user, nStock);
        assertEquals(tStockList, user.getStocks());
    }

    @Test
    public void testRemoveStockPositive() {
        List<Stock>tStockList = new ArrayList<Stock>();
        tStockList.add(new Stock("GOOG", "Google, Inc.", "744.75"));
        Stock nStock = new Stock("EMC", "EMC Corporation", "28.80");
        assertTrue(stockInfo.removeStock(user, nStock));
        assertEquals(tStockList, user.getStocks());
    }

    @Test
    public void testRemoveStockNegative() {
        List<Stock>tStockList = new ArrayList<Stock>();
        tStockList.add(new Stock("EMC", "EMC Corporation", "28.80"));
        tStockList.add(new Stock("GOOG", "Google, Inc.", "744.75"));
        assertFalse(stockInfo.removeStock(user, new Stock("YHOO", "Yahoo! Inc.", "16.79")));
        assertEquals(tStockList, user.getStocks());
    }

    @Test
    public void testEditStockPositive() {
        List<Stock>tStockList = new ArrayList<Stock>();
        Stock nStock = new Stock("EMC", "EMC Corporation", "999.99");
        tStockList.add(nStock);
        tStockList.add(new Stock("GOOG", "Google, Inc.", "744.75"));
        assertTrue(stockInfo.editStock(user, nStock));
        List<Stock> stock = stockInfo.selectStock(user, "EMC");
        assertEquals(stock.get(0), stockInfo.selectStock(user, nStock.getSymbol()).get(0));
    }

    @Test
    public void testEditStockNegative() {
        List<Stock>tStockList = new ArrayList<Stock>();
        Stock nStock = new Stock("YHOO", "Yahoo! Inc.", "16.79");
        tStockList.add(nStock);
        tStockList.add(new Stock("GOOG", "Google, Inc.", "744.75"));
        assertFalse(stockInfo.editStock(user, nStock));
    }

    @Test
    public void testRefreshQuote() {
    }
}
