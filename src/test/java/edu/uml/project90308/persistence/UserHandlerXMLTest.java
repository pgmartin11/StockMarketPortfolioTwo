package edu.uml.project90308.persistence;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import edu.uml.project90308.businesslogic.*;

public class UserHandlerXMLTest {

    private String testfil = "/Users/pgmartin/UML/90.308/StockMarketPortfolioTwo/useraccounts.xml";
    private Stock testStock;
    private UserInfo testUser;
    private List<UserInfo> testAccounts;
    private List<Stock> testStocks;

    @Before
    public void setup() {
        testAccounts = new ArrayList<UserInfo>();
        testStocks = new ArrayList<Stock>();
        testStocks.add(new Stock("GOOG", "", ""));
        testAccounts.add(new UserInfo("pgmartin", "Biking2009",testStocks));
        testStocks = new ArrayList<Stock>();
        testStocks.add(new Stock("APPL", "", ""));
        testStocks.add(new Stock("EMC", "", ""));
        testAccounts.add(new UserInfo("jharvard", "Brewhouse2012",testStocks));
    }

    @Test
    public void testParsePositive() {
        List<UserInfo> resAccounts = UserHandlerXML.parse(testfil);
        UserInfo account0 = resAccounts.get(0);
        UserInfo testAccount0 = testAccounts.get(0);
        UserInfo account1 = resAccounts.get(1);
        UserInfo testAccount1 = testAccounts.get(1);
        assertEquals(account0.getUserName(), testAccount0.getUserName());
        assertEquals(account0.getPassword(), testAccount0.getPassword());
        assertEquals(account0.getStocks(), testAccount0.getStocks());
        assertEquals(account1.getUserName(), testAccount1.getUserName());
        assertEquals(account1.getPassword(), testAccount1.getPassword());
        assertEquals(account1.getStocks(), testAccount1.getStocks());
    }
}
