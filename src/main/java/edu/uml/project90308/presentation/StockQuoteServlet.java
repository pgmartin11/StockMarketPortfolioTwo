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

public class StockQuoteServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        // Create a new session or open an existing one
        HttpSession session = req.getSession(true);

        // Fetch session parameters
        UserInfo user = (UserInfo) session.getAttribute("sessioninfo.count");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html");
        out.println("<head><title>Stock Symbol Report</title></head>");
        out.println("<body>");

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
                    out.println("<th></th>");
                    out.println("</tr>");
                    out.println("<tr>");
                    for (String qu : quote) {
                        out.println("<td>" + qu + "</td>");
                    }
                    out.println("<td><a href=\"\">Add to favorites</a></td>");
                    out.println("</tr>");
                    out.println("</table>");
                }
                else {
                    out.println("<p>Error: The stock symbol specified was not found</p>");
                }
            }
            catch (CouldNotReadDataException cnrde) {
                out.println("<p>Error occurred while trying to obtain stock quote</p");
                System.err.println("Error: " + cnrde.getMessage());
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
    }

    private boolean isValidStockQuote(List<String> quote) {
        return !quote.isEmpty() && !(quote.get(1).equals("0.00") && quote.get(2).equals("N/A"));
    }

}
