package edu.uml.project90308.businesslogic;

import java.net.*;
import java.io.*;

import org.apache.commons.io.IOUtils;

public class StockQuote {
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
