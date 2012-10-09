// Business logic tier
package edu.uml.project90308.businesslogic;

import edu.uml.project90308.presentation.*;
import edu.uml.project90308.persistence.*;

public class StockInfo {

	public StockInfo() {
		return;
	}

	public Stock searchStockSymbol(String stockName) {
		return new Stock("EMC", "EMC Corporation", "28.75");
	} 

	public void addStockSymbol(Person person, Stock stockInfo) throws Exception {
		if (true)
            return;
        else
            throw new Exception("Error");
	}

	public void removeStockSymbol(Stock stockInfo) throws Exception {
        if (true)
            return;
        else
            throw new Exception("Error");
	}

	public Stock editStockInfo(Stock stockInfo) {
		return new Stock("EMC", "EMC Corporation", "28.75");
	}

	public Stock selectStockSymbol(String stockName) {
 		return new Stock("EMC", "EMC Corporation", "28.75");
 	}
 
	public void refreshQuote(String stockName) throws Exception {
        if (true)
            return;
        else
            throw new Exception("Error");
	} 
	
}