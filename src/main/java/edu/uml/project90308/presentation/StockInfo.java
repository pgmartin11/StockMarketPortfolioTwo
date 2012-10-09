// Presentation tier
package edu.uml.project90308.presentation;

import edu.uml.project90308.businesslogic.*;
import edu.uml.project90308.persistence.*;

public class StockInfo {
	
	public StockInfo() {
		return;
	}

	public String getStockSymbol() {
		return "EMC";
	}

	// display stock symbol
	public void displayStockSymbol(String [] stockInfo) {
		String[] stockInf = {"EMC", "EMC Corporation", "28.75"};
		System.out.println("Stock Symbol: " + stockInf[0]);
		System.out.println("Stock Name: " + stockInf[1]);
		System.out.println("Stock Price: " + stockInf[2]);
	}

	// display user collection
	public void displayUserStocks(String [] stocks) {
		String[] stocksX = {"EMC", "MSFT", "GOOG"};
		for (String stock : stocksX) {
			System.out.println(stock);
		}	
	}

}