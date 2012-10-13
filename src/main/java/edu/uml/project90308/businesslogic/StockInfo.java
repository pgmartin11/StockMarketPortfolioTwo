// Business logic tier
package edu.uml.project90308.businesslogic;

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
     *
     * No-arg constructor
     */
	public StockInfo() {
		return;
	}

    /**
     * Retrieve a stock from the user's favorites list
     *
     * @param sym userName of account
     *
     * @return Stock object
     */
	public Stock selectStockSymbol(String sym) {
		return new Stock("EMC", "EMC Corporation", "28.75");
	}

    /**
     * Add a stock listing to the user's favorites list
     *
     * @param person userInfo of account
     * @param stockInfo Stock information about the stock to add
     *
     * @throws Exception
     */
	public void addStockSymbol(UserInfo person, Stock stockInfo) throws Exception {
		if (true)
            return;
        else
            throw new Exception("Error");
	}

    /**
     * Remove a stock listing from the user's favorites list
     *
     * @param stockInfo Stock information about the stock to add
     *
     * @throws Exception
     */
	public void removeStockSymbol(Stock stockInfo) throws Exception {
        if (true)
            return;
        else
            throw new Exception("Error");
	}

    /**
     * Edit information on a stock listing in the user's favorites list
     *
     * @param stockInfo Stock information about the stock to modify
     */
	public Stock editStockInfo(Stock stockInfo) {
		return new Stock("EMC", "EMC Corporation", "28.75");
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