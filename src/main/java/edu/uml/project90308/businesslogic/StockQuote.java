package edu.uml.project90308.businesslogic;

import java.net.*;
import java.io.*;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;

import edu.uml.project90308.persistence.*;

/**
 * @author Peter G. Martin
 *
 * A static class which contains a method for obtaining a stock quote for the stock symbol provided. Uses Yahoo's stock
 * quoting service which provides free stock quotes although the latest stock price is delayed by twenty minutes.
 *
 */
public class StockQuote {

    /**
     * Obtain a stock quote for the supplied stock symbol
     *
     * @param sym Stock symbol of the stock
     *
     * @return Stock quote information as a CSV string
     *
     * @throws CouldNotReadDataException
     */
    public static String getQuote(String sym) throws CouldNotReadDataException {

        String params = "sl1d1t1c1ohgv";
        String theUrl = "http://download.finance.yahoo.com/d/quotes.csv?s=" + sym + "&f=" + params;

        InputStream inputStream = null;
        StringWriter stringWriter = null;
        try {
            URL url = new URL(theUrl);
            inputStream = url.openStream();
            stringWriter = new StringWriter();
            IOUtils.copy(inputStream, stringWriter);
        }
        catch (IOException ioe) {
            throw new CouldNotReadDataException("IO Error: " + ioe.getMessage());
        }

        return stringWriter.toString();
    }

    /**
     * Obtain stock quotes for a list of supplied stock symbols
     *
     * @param syms Stock symbols of the stocks of which to obtain quotes
     *
     * @return Stock quotes as a list of CSV strings
     *
     * @throws CouldNotReadDataException
     */
    public static List<String> getQuotes(List<String> syms) throws CouldNotReadDataException {
        List<String> quotes = new ArrayList<String>();
        for (String sym : syms) {
            quotes.add(getQuote(sym));
        }

        return quotes;
    }
}
