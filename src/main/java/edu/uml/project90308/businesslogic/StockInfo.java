// Business logic tier
package edu.uml.project90308.businesslogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.uml.project90308.presentation.*;
import edu.uml.project90308.persistence.*;

/**
 * @author Peter G. Martin
 *
 * A class which contains methods for manipulating the "favorites" list of stock symbols associated with a user account.
 *
 */
public class StockInfo {

    /**
     * Retrieve a stock from the user's favorites list
     *
     * @param user userInfo of account
     * @param sym Symbol of stock information to retrieve
     *
     * @return Stock object
     */
	public List<Stock> selectStock(UserInfo user, String sym) {
        boolean found = false;
        List<Stock> stocks = new ArrayList<Stock>();
        List<Stock> userStocks = user.getStocks();

        for (Stock ustock : userStocks) {
            if (ustock.getSymbol().equals(sym)) {
                stocks.add(ustock);
                found = true;
                break;
            }
        }

        if (found)
		    return stocks;
        else
            return Collections.emptyList();
  	}

    /**
     * Add a stock to the user's favorites list
     *
     * @param user userInfo of account
     * @param stock Stock object to add
     *
     * @throws Exception
     */
	public void addStock(UserInfo user, Stock stock) {
        List<Stock> stocks = user.getStocks();
        stocks.add(stock);
        user.setStocks(stocks);
	}

    /**
     * Remove a stock from the user's favorites list
     *
     * @param user UserInfo of account
     * @param stock Stock object to remove
     *
     * @throws Exception
     */
	public boolean removeStock(UserInfo user, Stock stock) {
        boolean changed = false;

        List<Stock> stocks = user.getStocks();
        changed = stocks.remove(stock);
        if (changed) {
            user.setStocks(stocks);
        }

        return changed;
	}

    /**
     * Edit information on a stock listing in the user's favorites list
     *
     * @param user UserInfo of account
     * @param stock Stock information about the stock to modify
     */
	public boolean editStock(UserInfo user, Stock stock) {
        boolean changed = false;
        List<Stock> stocks = new ArrayList<Stock>();
        List<Stock> userStocks = user.getStocks();

        for (Stock ustock : userStocks) {
            if (ustock.getSymbol().equals(stock.getSymbol())) {
                stocks.remove(ustock);
                stocks.add(stock);
                changed = true;
                break;
            }
        }

        return changed;
	}

    /**
     * Obtain a new quote for the selected stock listing
     *
     * @param sym Stock information about the stock to modify
     *
     * @throws Exception
     */
	public void refreshQuote(String sym) throws Exception {
        if (true)
            return;
        else
            throw new Exception("Error");
	} 
	
}