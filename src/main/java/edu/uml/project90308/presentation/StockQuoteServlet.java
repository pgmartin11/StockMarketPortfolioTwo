package edu.uml.project90308.presentation;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.io.*;

import edu.uml.project90308.businesslogic.*;
import edu.uml.project90308.persistence.*;

public class StockQuoteServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        // Create a new session.
        List<Stock>StockList = new ArrayList<Stock>();
        StockList.add(new Stock("EMC", "EMC Corporation", "28.80"));
        StockList.add(new Stock("GOOG", "Google, Inc.", "744.75"));
        HttpSession session = req.getSession(true);
        session.setAttribute("sessioninfo.userinfo", new UserInfo("pg.martin", "Biking2009", StockList));

        // Fetch session parameters
        UserInfo user = (UserInfo) session.getAttribute("sessioninfo.count");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html");
        out.println("<head><title>Stock Symbol Report</title></head>");

        // test getQuotes with prepopulate stock symbol list
        List<String> syms = new ArrayList<String>();
        syms.add("EMC");
        syms.add("GOOG");
        syms.add("YHOO");

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
                //if (isValidStockQuote(quote)) // assume only valid stock symbols are in favorites
                for (String col : quoteLine) {
                    out.println("<td>" + col + "</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
        }
        catch (CouldNotReadDataException CouldNotReadDataException) {
            // print out something on the screen too
            System.err.println("Error: " + CouldNotReadDataException.getMessage());
        }
        finally {
            out.println("<p><a href=\"main.jsp\">Return to main page</a></p>");
            out.println("</html");
        }
/*
        String symbol = req.getParameter("stocksymbol");
         if (!symbol.isEmpty()) {
            out.println("<body>");
            try {
                CSVRE csvre = new CSVRE();
                List<String> quote = csvre.parse(StockQuote.getQuote(symbol));
                if (isValidStockQuote(quote)) {
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
                    out.println("<tr>");
                    for (String qu : quote) {
                        out.println("<td>" + qu + "</td>");
                    }
                    out.println("</tr>");
                    out.println("</table>");
                }
                else {
                    out.println("<p>Error: The stock symbol specified was not found</p>");
                }
            }
            catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
            finally {
                out.println("<p><a href=\"main.jsp\">Return to main page</a></p>");
                out.println("</html");
            }
        }
        else {
            out.println("<html");
            out.println("<head><title>Error Page</title></head>");
            out.println("<body>");
            out.println("<p>");
            out.println("Error: No stock symbol entered");
            out.println("</p>");
            out.println("<p><a href=\"main.jsp\">Try again</a></p>");
            out.println("</body>");
            out.println("</html");
        }
 */
    }

    private boolean isValidStockQuote(List<String> quote) {
        return !quote.isEmpty() && !(quote.get(1).equals("0.00") && quote.get(2).equals("N/A"));
    }

}
