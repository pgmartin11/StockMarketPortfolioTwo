package edu.uml.project90308.persistence;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


/**
 * todo 1) Error running TestPerson
 * class 'edu.uml.project90308.persistence.TestPerson' not found in module 'Test'
 *
 * todo 2) Warning: uses unchecked or unsafe operations -- what's this about?
 *
 * Created with IntelliJ IDEA.
 * User: seattlecamper
 * Date: 9/26/12
 * Time: 5:12 PM
 */
public class TestPerson {

    private Person person;
    private String DEFAULT_PASSWORD =  "momPW";

    @Before
    public void setUp() throws NameException {
        ArrayList<String>SymbolArrayList = new ArrayList();
        SymbolArrayList.add("GOOG");
        person = new Person("MOM", "momPW", SymbolArrayList);
    }

    /**
     * todo I was wondering if this is how you to the teardown step, see last line in testGetName() below
     * I have similar code in all the tests below YES, see my setupMethod()
     * <p/>
     * Any method with the @After annotation will run after a test is complete. Use them to clean up after tests
     * Any method with the @Before annotation will run before a test is run. Use them to setup the baseline environment.
     *
     * @throws Exception
     */
    @Test
    public void testGetUserName() throws Exception {
        String result = person.getUserName();
        String DEFAULT_USER_NAME = "MOM";
        assertEquals(DEFAULT_USER_NAME, result);
     }

    /**
     * @throws Exception
     */
    @Test
    public void testGetPassword() throws Exception {
        String result = person.getPassword();
        assertEquals(DEFAULT_PASSWORD, result);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testGetSymbol() throws Exception {
        ArrayList<String>SymbolArrayList = new ArrayList();
        SymbolArrayList.add("GOOG");
        ArrayList<String> result = person.getSymbol();
        assertEquals(SymbolArrayList, result);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testSetName() throws Exception {
        String name = "Buddy";
        person.setUserName(name);
        String result = person.getUserName();
        assertEquals(name, result);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testSetPassword() throws Exception {
        person.setPassword(DEFAULT_PASSWORD);
        String expected_result = DEFAULT_PASSWORD;
        assertEquals(DEFAULT_PASSWORD, expected_result);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testSetSymbols() throws Exception {
        ArrayList<String> symbol = new ArrayList();
        symbol.add("GOOG");
        person.setSymbols(symbol);
        ArrayList<String> result = person.getSymbol();
        assertEquals(symbol, result);
    }

    /**
     *
     */
    @Test(expected = NameException.class)
    public void testIsAllLetters() throws Exception {
        person.setUserName("Sam");
    }

    /**
     *
     */
    @Test(expected = NameException.class)
    public void testIsAllLettersNegative() throws Exception {
        person.setUserName("213");
    }


    /**
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception {
        String expResult = "UserName: MOM, Password: momPW, Stock Symbol(s): GOOG";
        String result = person.toString();
        assertEquals(expResult, result);
    }
}