package edu.uml.project90308.presentation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import edu.uml.project90308.presentation.*;

public class CSVRETest {

    List<String> testString = new ArrayList<String>();
    String testCSV = "\"one\",two,three,";

    @Before
    public void setUp() {
        testString.add("one");
        testString.add("two");
        testString.add("three");
     }

    @Test
    public void testParse() {
        CSVRE csvre = new CSVRE();
        List<String> res = csvre.parse(testCSV);
        assertEquals(testString, res);
    }

}
