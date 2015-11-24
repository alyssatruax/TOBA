/*
 * Reset password servlet
 */
package TOBA;

import TOBA.data.UserDB;
import TOBA.business.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        // Set content type
        response.setContentType("text/html;charset=UTF-8");
        
        // Get variables from form
        //String username = request.getParameter("username");
        //String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        
        // Get a session object
        HttpSession session = request.getSession();
        
        // Create user object
        User user = (User) session.getAttribute("user");
        
        // Set new password for user object
        session.setAttribute("user", user);
        user.setPassword(newPassword);
        

        
        UserDB.update(user);
        
        // Set default url destination
        String url = "/account_activity.jsp";
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
