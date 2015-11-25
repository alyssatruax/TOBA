/*
Code the servlet to retrieve the new customer form data and just
redirect to the success.html page

Server side validation - Code the NewCustomerServlet to validate the user
has entered in values for all form fields. If not, assign a message variable
and display the message on the new_customer.html page
 */
package TOBA;

import TOBA.data.UserDB;
import TOBA.business.User;
import TOBA.data.AccountDB;
import TOBA.business.Account;
import TOBA.business.Type;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set content type
        response.setContentType("text/html;charset=UTF-8");
        
        // Get variables from form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String email = request.getParameter("email");
        
        // Create username and temporary password
        String username = lastName + zipcode;
        String password = "welcome1";
        
        // Store data in User object
        User user = new User(firstName, lastName, phone, address, city, 
            state, zipcode, email, username, password);
        
        Account savingsAccount = new Account (user, 25.00, Type.SAVINGS);
        Account checkingAccount = new Account (user, 0, Type.CHECKING);
        
        // Set default url destination
        String url = "/success.jsp";
        
        // If any field is empty, print error message
        if (firstName.length() == 0 || lastName.length() == 0
                || phone.length() == 0 || address.length() == 0 
                || city.length() == 0 || state.length() == 0 
                || zipcode.length() == 0 || email.length() == 0) {
            
            // Set error message
            String errorMessage = "Please go back and fill out all fields";
            PrintWriter out = response.getWriter();
            
            // Print error message
            try {
                out.println("<p>" + errorMessage + "</p>");
            }
            finally {
                out.close();
            }
        }
        // If all fields are filled, create session and forward to default url
        else {
            // Create session
            HttpSession session = request.getSession();
            
            // Set user attribute
            session.setAttribute("user", user);
            UserDB.insert(user);
            
            // Set account session attribute?
            //AccountDB.insert(savingsAccount);
            //AccountDB.insert(checkingAccount);

            // Forward to URL
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request, response);
    }
    
}
