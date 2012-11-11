package edu.uml.project90308.presentation;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.ArrayList;

import edu.uml.project90308.businesslogic.*;
import edu.uml.project90308.persistence.*;

/**
 * @author Peter G. Martin
 *
 * A servlet fot testing ability to obtain user information saved during login.
 *
 */
public class DiagnosticServlet extends HttpServlet  {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title></title></head>");
        out.println("<body>");

        // Fetch session parameters
        HttpSession session = req.getSession(true);
        UserInfo user = (UserInfo) session.getAttribute("session.userinfo");

        out.println("<p>username: " + user.getUserName() + "</p>");
        out.println("<p>password: " + user.getPassword() + "</p>");

        List<Stock> stocks = user.getStocks();
        for (Stock stock : stocks) {
            out.println("<p>" + stock.getSymbol() + " " + stock.getFullName() + " " + stock.getInfo() + "</p>");
        }

        out.println("</body>");
        out.println("</html");

        // close the session
        Authenticate.processLogout(session);
    }

}
