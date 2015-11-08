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
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set content type
        response.setContentType("text/html;charset=UTF-8");
        
        // Get variables from form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Set default url destination
        String url = "/login_failure.html";
        
        if (username.equalsIgnoreCase("jsmith@toba.com") && password.equals("letmein"))
        {
            HttpSession session = request.getSession();
            
            User user = (User) session.getAttribute("user");
            request.setAttribute("user", user);
            
            // Set url destination to account activity page if username/pw correct
            url = "/account_activity.jsp";
        }
        
        // Forward to url
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request, response);
    }
    
}
