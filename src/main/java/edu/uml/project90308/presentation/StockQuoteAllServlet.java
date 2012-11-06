package edu.uml.project90308.presentation;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import java.io.IOException;
import java.io.PrintWriter;

import edu.uml.project90308.businesslogic.*;
import edu.uml.project90308.persistence.*;

public class StockQuoteAllServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Create a new session or open an existing one
        HttpSession session = req.getSession(true);

        // Fetch session parameters
        UserInfo user = (UserInfo) session.getAttribute("session.userinfo");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html");
        out.println("<head><title>Stock Symbol Report</title></head>");
        out.println("<body>");

        // Get list of user's stock favorites
        List<Stock> StockList = new ArrayList<Stock>();
        // for debugging
        StockList.add(new Stock("EMC", "EMC Corporation", "28.80"));
        StockList.add(new Stock("GOOG", "Google, Inc.", "744.75"));
        user = new UserInfo("jharvard", "Brewhouse2012", StockList);

        List<Stock> stocks = user.getStocks();
        List<String> syms = new ArrayList<String>();
        for (Stock stock : stocks) { syms.add(stock.getSymbol()); }

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Symbol</th>");
        out.println("<th>Last Trade</th>");
        out.println("<th>Last Trade Date</th>");
        out.println("<th>Last Trade Time</th>");
        out.println("<th>Change</th>");
        out.println("<th>Open</th>");
        out.println("<th>Day High</th>");
        out.println("<th>Day Low</th>");
        out.println("<th>Volume</th>");
        out.println("</tr>");

        List<String> quotes;
        List<String> quoteLine;
        try {
            CSVRE csvre = new CSVRE();
            quotes = StockQuote.getQuotes(syms);
            for (String quote : quotes) {
                quoteLine = csvre.parse(quote);
                out.println("<tr>");
                for (String col : quoteLine) {
                    out.println("<td>" + col + "</td>");
                }
                out.println("<td><a href=\"\">Remove from favorites</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
        catch (CouldNotReadDataException cnrde) {
            out.println("<p>Error occurred while trying to obtain stock quote</p");
            System.err.println("Error: " + cnrde.getMessage());
        }
        finally {
            out.println("<p><a href=\"main.jsp\">Return to main page</a></p>");
            out.println("</body>");
            out.println("</html");
        }
    }

}
