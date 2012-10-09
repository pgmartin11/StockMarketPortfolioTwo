// Persistence tier

package edu.uml.project90308.persistence;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Alan Derrick
 *
 * This class represents a person.  The kind of person it represents is an investor for our stock
 * program.  The person has a userName, an password, and it tracks certain stock symbols.   This Person
 * will check to make sure the userName is valid (contains only letters and spaces).  This person will also
 * check to make sure the password passed to it is not a blank line.
 *
 */
public class Person {
    private String userName;
    private String password;
    private ArrayList<String> symbols;

    /**
     * This constructor will accept various parameters and fill the new Person object
     *
     * @param name Name of the person
     * @param password E-mail of the person
     * @param symbols An ArrayList of stock symbols the person is tracking
     */
    public Person(String name, String password, ArrayList<String> symbols) {
        this.userName = name;
        this.password = password;
        this.symbols = symbols;
    } // end constructor

    /**
     * This constructor will auto-populate a new Person object.  So if no arguments are given, then this
     * constructor will create the Person object with the "default" values below
     */

    public Person(String uname, String passwd) {
        this.userName = uname;
        this.password = passwd;
    }

    /**
     *
     * @return  returns userName of Person
     */
    public String getUserName(){
        return userName;
    }

    /**
     *
     * @return password of the Person
     */
    public String getPassword(){
        return password;
    }

    /**
     *
     * @return an ArrayList of the stock symbols the Person is tracking
     */
    public ArrayList<String> getSymbol(){
        return symbols;
    }

    /**
     * verifies the userName only contains letters and white space, then sets the userName
     *
     * @param userName userName of Person object
     * @throws NameException
     */
    public void setUserName(String userName) throws NameException {
        boolean isName = isAllLetters(userName);

        if ( isName ) {
            this.userName = userName;
        } else {
            throw new NameException();
        }
    } // end setUserName


    public void setPassword(String passwd) throws PasswordException  {
        boolean containsWhitespace = isWhitespace(passwd);

        if (containsWhitespace) {
            throw new PasswordException();
        } else {
            this.password = passwd;
        }
    }// end setPassword

    /**
     * sets the Person object's ArrayList to the passed ArrayList
     *
     * @param stockSymbols ArrayList stockSymbols
     */
    public void setSymbols(ArrayList stockSymbols) {
        this.symbols = stockSymbols;
    }

    /**
     * This method verifies the userName contains only letters and whitespace
     *
     * @param string string passed in to verify if it only contains letters and whitespace
     * @return boolean, true if string is only letters and whitespace
     */
    public boolean isAllLetters(String string){
        for(int x = 0 ; x < string.length();x++){
            if(!Character.isLetter(string.charAt(x)) && !Character.isWhitespace(string.charAt(x))){
                return false;
            } // end if
        } // end for
        return true;
    } // end isAllLetters

    /**
     * method to verify the string passed to it is not just a blank line
     *
     * @param string to be verified, that it isn't just a blank line
     * @return true if the string has no whitespace
     */
    public static boolean isWhitespace(String string) {
        if (string == null) {
            return false;
        }
        int sz = string.length();
        for (int i = 0; i < sz; i++) {
            if ((!Character.isWhitespace(string.charAt(i)))) {
                return false;
            } // end if
        } // end for loop
        return true;
    } // end isWhitespace

    /** method to save the Person object
     * todo should i be trying to unit test saveUser and getUser?  I'm not sure how to write those tests up.
     * todo maybe for this one I would create a Person, then try to save it?  I'm not sure how I would assert
     * todo anything in this manner.
     *
     *      * only test public methods, but make sure you   unit test the methods that call these private methods
     *
     * @param person (the Person object to be written to file)
     */
    private void saveUser(Person person) {
        // writing object to file
        try {
            FileOutputStream saveFile = new FileOutputStream(person.password);
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(person);
            save.close();   // this also closes saveFile
        }
        catch (Exception e) { // catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    } // end saveUser

    /**
     * gets a Person object from file
     * todo should i be trying to unit test saveUser and getUser?  I'm not sure how to write those tests up.
     * todo maybe for this one i could create a file in the test using saveUser, then make sure I can retrieve it?
     * todo I'm not sure how I use the assert here though.  Like I'm not sure how the test would do anything different
     * todo than the actual method is doing.
     *
     *
     * only test public methids, but make sure you   unit test the methods that call these private methods
     *
     * @param person (The person object to try & read from file)
     * @return person1 (The person object actually returned from file)
     */
    private Person getUser(Person person) {
        try {
            FileInputStream saveFile = new FileInputStream(person.password);
            ObjectInputStream restore = new ObjectInputStream(saveFile);
            // Object obj = restore.readObject();
            Person person1 = (Person) restore.readObject();
            restore.close();
            return person1;
        }
        catch (Exception e) { // catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        return person; // don't think it really should return person here...
    } // end getUser

    /**
     * Overrides the object's toString method
     *
     * @return a String probably for printing
     */
    @Override
    public String toString() {
        return ("UserName: " + this.userName + ", Password: " + this.password +
                ", Stock Symbol(s): " + this.symbols);
    } // end toString

} // end Person