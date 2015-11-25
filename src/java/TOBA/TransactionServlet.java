/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA;

import TOBA.business.Transaction;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TransactionServlet extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set content type
        response.setContentType("text/html;charset=UTF-8");
        
        // Get variables from form
        String fromAccount = request.getParameter("fromAccount");
        String toAccount = request.getParameter("toAccount");
        double amount = request.getParameter("amount");

        // Store data in User object
        Transaction transaction = new Transaction(amount, user, );
        
        // Set default url destination
        String url = "/account_activity.jsp";
        
    }


}