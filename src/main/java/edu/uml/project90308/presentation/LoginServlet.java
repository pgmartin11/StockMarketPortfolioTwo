package edu.uml.project90308.presentation;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

import edu.uml.project90308.businesslogic.*;
import edu.uml.project90308.persistence.*;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title></title></head>");
        out.println("<body>");

        UserInfo user;
        try {
            if (username.isEmpty() || password.isEmpty()) {
                out.println("<h1>Either name or password not entered</h1>");
            }
            else {
                user = Authenticate.processLogin(username, password);
                resp.sendRedirect("test");

                // Create a new session.
                HttpSession session = req.getSession(true);
                session.setAttribute("session.userinfo", user);

                // Fetch session parameters
                //UserInfo user = (UserInfo) session.getAttribute("session.userinfo");
                out.println("<h1>You have been successfully logged in</h1>");
            }
        }
        catch (UnableToObtainAccountsException utoae) {
            //
        }
        catch (UserNotFoundException unfe) {
            out.println("<h1>User not found</h1>");
        }
        catch (MoreThanOneUserFoundException mtoufe) {
            //
        }
        finally {
            out.println("</body>");
            out.println("</html");
        }
    }
}
