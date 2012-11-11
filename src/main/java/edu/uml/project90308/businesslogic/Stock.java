// Business logic tier
package edu.uml.project90308.businesslogic;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import edu.uml.project90308.presentation.*;
import edu.uml.project90308.persistence.*;

/**
 * @author Peter G. Martin
 *
 * A class which represents information associated with a stock symbol. This information comprises the ArrayList elements
 * associated with a UserInfo object.
 *
 */
public class Stock {
    private String symbol;
    private String fullName;
    private String info;

    /**
     * Constructor used to create an instance of Stock
     *
     * @param symbol Name of the stock symbol
     * @param fullName Name of the company represented by the stock symbol
     * @param info Information about the company stock
     */
    public Stock(String symbol, String fullName, String info) {
    	this.symbol = symbol;
        this.fullName = fullName;
        this.info = info;
    }

    // mutators

    /**
     *
     * @return stock symbol
     */
    public String getSymbol() {
        return symbol;
    }
    /**
     *
     * @param symbol stock symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return company name
     */
    public String getFullName(){
        return fullName;
    }
    /**
     *
     * @param  fullName company name
     */
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    /**
     *
     * @return stock information
     */
    public String getInfo() {
        return info;
    }
    /**
     *
     * @param  info stock information
     */
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals (Object stock) {
        if (stock == this)
            return true;
        if (!(stock instanceof Stock))
            return false;
        return symbol.equals(((Stock) stock).getSymbol()) &&
            fullName.equals(((Stock) stock).getFullName()) &&
            info.equals(((Stock) stock).getInfo());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(symbol).
                append(fullName).
                append(info).
                toHashCode();
    }
}