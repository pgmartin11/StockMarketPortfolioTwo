// Persistence tier

package edu.uml.project90308.persistence;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import edu.uml.project90308.businesslogic.*;

/**
 * @author Alan Derrick
 *
 * Modifications made by Peter G. Martin
 *
 * This class represents a Userinfo.  The kind of Userinfo it represents is an investor for our stock
 * program.  The Userinfo has a userName, an password, and it tracks certain stock symbols.   This Userinfo
 * will check to make sure the userName is valid (contains only letters and spaces).  This Userinfo will also
 * check to make sure the password passed to it is not a blank line.
 *
 */
public class UserInfo {
    private String userName;
    private String password;
    private List<Stock> stocks;

    public UserInfo() {
        //
    }
    /**
     *
     * This constructor will accept various parameters and fill the new Userinfo object
     *
     * @param name Name of the user
     * @param password password of the user
     * @param stocks A List of stock items the user is tracking
     */
    public UserInfo(String name, String password, List<Stock> stocks) {
        this.userName = name;
        this.password = password;
        this.stocks = stocks;
    } // end constructor

    /**
     * This constructor will auto-populate a new Userinfo object.  So if no arguments are given, then this
     * constructor will create the Userinfo object with the "default" values below
     */

    public UserInfo(String uname, String passwd) {
        this.userName = uname;
        this.password = passwd;
    }

    /**
     *
     * @return  returns userName
     */
    public String getUserName(){
        return userName;
    }

    /**
     *
     * @return password
     */
    public String getPassword(){
        return password;
    }

    /**
     *
     * @return stock symbols from the favorites list
     */
    public List<Stock> getStocks() {
        return stocks;
    }

    /**
     * verifies the userName only contains letters and white space, then sets the userName
     *
     * @param userName userName of Person object
     *
     */
    public void setUserName(String userName) {
        this.userName = userName;
    } // end setUserName


    public void setPassword(String passwd) {
        this.password = passwd;
    }// end setPassword

    /**
     * sets the stock symbols in the favorites list
     *
     * @param stocks List stockSymbols
     */
    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public boolean equals (Object user) {
        if (user == this)
            return true;
        if (!(user instanceof UserInfo))
            return false;
        return userName.equals(((UserInfo) user).getUserName()) &&
                password.equals(((UserInfo) user).getPassword()) &&
                stocks.equals(((UserInfo) user).getStocks());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(userName).
                append(password).
                toHashCode();
    }

} // end UserInfo