package edu.uml.project90308.businesslogic;

import java.net.*;
import java.io.*;

import org.apache.commons.io.IOUtils;

/**
 * @author Peter G. Martin
 *
 * A static class which contains a method for obtaining a stock quote for the stock symbol provided. Uses Yahoo's stock
 * quoting service which provides free stock quotes although the latest stock price is delayed by twenty minutes.
 *
 */
public class StockQuote {

    /**
     * verifies the userName only contains letters and white space, then sets the userName
     *
     * @param sym Stock symbol of the stock
     *
     * @return Stock quote information as a CSV string
     */
    public static String getQuote(String sym) throws Exception {

        String params = "sl1d1t1c1ohgv";
        String theUrl = "http://download.finance.yahoo.com/d/quotes.csv?s=" + sym + "&f=" + params;

        InputStream inputStream = null;
        StringWriter stringWriter = null;
        URL url = new URL(theUrl);
        inputStream = url.openStream();
        stringWriter = new StringWriter();
        IOUtils.copy(inputStream, stringWriter);

        return stringWriter.toString();
    }
}
