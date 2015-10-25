/*
Code the servlet to retrieve the new customer form data and just
redirect to the success.html page

Server side validation - Code the NewCustomerServlet to validate the user
has entered in values for all form fields. If not, assign a message variable
and display the message on the new_customer.html page
 */
package TOBA;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String email = request.getParameter("email");
        String url = "/success.html";
        
        if (firstName.length() == 0 || lastName.length() == 0
                || phone.length() == 0 || address.length() == 0 
                || city.length() == 0 || state.length() == 0 
                || zipcode.length() == 0 || email.length() == 0) {
            String errorMessage = "Please fill out all fields :)";
            PrintWriter out = response.getWriter();
            try {
                out.println("<p>" + errorMessage + "</p>");
            }
            finally {
                out.close();
            }
        }
        else {
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            doPost(request, response);
    }
    
}