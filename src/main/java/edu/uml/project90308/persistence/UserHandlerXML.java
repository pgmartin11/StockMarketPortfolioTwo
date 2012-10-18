package edu.uml.project90308.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import edu.uml.project90308.businesslogic.*;

public class UserHandlerXML extends DefaultHandler {

    static boolean uname = false;
    static boolean passwd = false;
    static boolean stock = false;

    static StringBuilder sbUsername = new StringBuilder();
    static StringBuilder sbPassword = new StringBuilder();
    static StringBuilder sbStock = new StringBuilder();

    static List<UserInfo> accounts = new ArrayList<UserInfo>();
    static List<Stock> stocks;
    static UserInfo user;

    public static List<UserInfo> parse(String file) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setValidating(true);

        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new UserHandlerXML());
            //xmlReader.parse("useraccounts.xml");
            xmlReader.parse(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return accounts;
        }
    }

    public void startElement(String nsURI, String localName, String rawName, Attributes atts) throws SAXException {
        if (rawName.equals("user")) {
            user = new UserInfo();
            stocks = new ArrayList<Stock>();
        }
        if (rawName.equals("username"))
            uname = true;
        if (rawName.equals("password"))
            passwd = true;
        if (rawName.equals("stock"))
            stock = true;
    }

    public void endElement(String nsURI, String localName, String rawName) throws SAXException {
        if (rawName.equals("user")) {
            user.setStocks(stocks);
            accounts.add(user);
        }
        if (uname) {
            user.setUserName(sbUsername.toString().trim());
            sbUsername.delete(0,sbUsername.length());
            uname = false;
        }
        if (passwd) {
            user.setPassword(sbPassword.toString().trim());
            sbPassword.delete(0,sbPassword.length());
            passwd = false;
        }
        if (stock) {
            stocks.add(new Stock(sbStock.toString().trim(), "", ""));
            sbStock.delete(0,sbStock.length());
            stock = false;
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (uname) {
            sbUsername.append(ch, start, length);
        }
        if (passwd) {
            sbPassword.append(ch, start, length);
        }
        if (stock) {
            sbStock.append(ch, start, length);
        }
    }

}
