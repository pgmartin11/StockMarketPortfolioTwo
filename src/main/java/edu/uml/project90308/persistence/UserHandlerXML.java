package edu.uml.project90308.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.IOException;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.uml.project90308.businesslogic.*;

/**
 * @author Peter G. Martin
 *
 * A static class which contains methods for retrieving and persistihg user account information in XML format
 *
 */
public class UserHandlerXML extends DefaultHandler {

    private static boolean uname = false;
    private static boolean passwd = false;
    private static boolean stock = false;

    private static StringBuilder sbUsername = new StringBuilder();
    private static StringBuilder sbPassword = new StringBuilder();
    private static StringBuilder sbStock = new StringBuilder();

    private static List<UserInfo> accounts = new ArrayList<UserInfo>();
    private static List<Stock> stocks;
    private static UserInfo user;

    private static String ROOT_ELEMENT = "users";
    private static String USER_ELEMENT = "user";
    private static String USERNAME_ELEMENT = "username";
    private static String PASSWORD_ELEMENT = "password";
    private static String STOCKS_ELEMENT = "stocks";
    private static String STOCK_ELEMENT = "stock";

    private static String OFILENAME = "userinfofile.xml";

    /**
     * Using the SAX Parser retrieve all XML formatted information for each user account stored as follows:
     *
     *
     *  <users>
     *      <user>
     *          <username>pgmartin</username>
     *          <password>Biking2009</password>
     *          <stocks>
     *              <stock>GOOG</stock>
     *          </stocks>
     *      </user>
     *  </users>
     *
     * @param ifilename name of user account file to parse
     *
     * @return A list containing UserInfo objects for all user accounts
     */
    public static List<UserInfo> parse(String ifilename) throws SAXException, IOException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setValidating(true);

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setContentHandler(new UserHandlerXML());
        xmlReader.parse(ifilename);

        return accounts;
    }

    /**
     * SAX parser callbacks
     */
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

    /**
     * Using the DOM API save all user account information as an XML formatted file.
     *
     *
     *  <users>
     *      <user>
     *          <username>pgmartin</username>
     *          <password>Biking2009</password>
     *          <stocks>
     *              <stock>GOOG</stock>
     *          </stocks>
     *      </user>
     *  </users>
     *
     *
     * @param accounts A list containing UserInfo objects for all user accounts
     */
    public static void persist(List<UserInfo> accounts) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement(ROOT_ELEMENT);
        doc.appendChild(rootElement);

        Element userElement;
        List<Stock> accountStocks;
        for (UserInfo account : accounts) {
            // user element
            userElement = doc.createElement(USER_ELEMENT);
            rootElement.appendChild(userElement);

            // username element
            Element usernameElement = doc.createElement(USERNAME_ELEMENT);
            usernameElement.appendChild(doc.createTextNode(account.getUserName()));
            userElement.appendChild(usernameElement);

            // lastname element
            Element passwordElement = doc.createElement(PASSWORD_ELEMENT);
            passwordElement.appendChild(doc.createTextNode(account.getPassword()));
            userElement.appendChild(passwordElement);

            // stocks element
            Element stocksElement = doc.createElement(STOCKS_ELEMENT);
            userElement.appendChild(stocksElement);

            // stock elements
            accountStocks = account.getStocks();
            Element stockElement;
            for (Stock stock : accountStocks) {
                stockElement = doc.createElement(STOCK_ELEMENT);
                stockElement.appendChild(doc.createTextNode(stock.getSymbol()));
                stocksElement.appendChild(stockElement);
            }
        }

        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(OFILENAME));

        transformer.transform(source, result);
     }
}
