// Business logic tier
package edu.uml.project90308.businesslogic;

import edu.uml.project90308.presentation.*;
import edu.uml.project90308.persistence.*;

public class Stock {
    private String symbol;
    private String fullName;
    private String info;

    public Stock(String symbol, String fullName, String info) {
    	this.symbol = symbol;
        this.fullName = fullName;
        this.info = info;
    }

    // getter methods
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }    
    
    public String getFullName(){
        return fullName;
    }
    public void getFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

}