/*
Code the servlet to retrieve the username and password from the form we added to login.html.
Have the servlet check that the username is equal to jsmith@toba.com and the password is equal to “letmein”.
If the username and password match, the servlet to forward the request to the account_activity.html page.
If it is incorrect, it should forward the request to the login_failure.html page.
 */
package TOBA;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String url = "/login_failure.html";
        
        if (username.equalsIgnoreCase("jsmith@toba.com") && password.equals("letmein"))
        {
            url = "/account_activity.html";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request, response);
    }
    
}
