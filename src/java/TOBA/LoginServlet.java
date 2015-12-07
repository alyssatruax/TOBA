/*
Code the servlet to retrieve the username and password from the form we added to login.html.
Have the servlet check that the username is equal to jsmith@toba.com and the password is equal to “letmein”.
If the username and password match, the servlet to forward the request to the account_activity.html page.
If it is incorrect, it should forward the request to the login_failure.html page.
 */
package TOBA;

import TOBA.business.Account;
import TOBA.business.User;
import TOBA.data.AccountDB;
import TOBA.data.DBUtil;
import TOBA.data.PasswordUtil;
import TOBA.data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.persistence.EntityManager;
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
        
        User u = UserDB.selectUser(username);

        //String salt = u.getSalt();
        //String saltedAndHashedPassword = u.getSaltedAndHashedPassword();
        
                // hash and salt password
        String hashedPassword;
        String salt = "";
        String saltedAndHashedPassword;
        try {
            hashedPassword = PasswordUtil.hashPassword(password);
            salt = u.getSalt();
            saltedAndHashedPassword = PasswordUtil.hashPassword(password + salt);                    
            
        } catch (NoSuchAlgorithmException ex) {
            hashedPassword = ex.getMessage();
            saltedAndHashedPassword = ex.getMessage();
        }
        request.setAttribute("hashedPassword", hashedPassword);
        request.setAttribute("salt", salt);
        request.setAttribute("saltedAndHashedPassword", saltedAndHashedPassword);
        
        // Error :(
        //Account a = AccountDB.selectAccount(u.getUserID());
        // Throws exception state field path a.userid cannot be resolved to a valid type
        //Account account = AccountDB.selectAccount(u.getUserID(), );
        
        //if (username.equalsIgnoreCase("jsmith@toba.com") && password.equals("letmein"))
        if (username.equalsIgnoreCase(u.getUsername()) && saltedAndHashedPassword.equals(u.getSaltedAndHashedPassword()))
        {
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            //session.setAttribute("account", accounts);
            
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
