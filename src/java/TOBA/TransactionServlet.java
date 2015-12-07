/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA;

import TOBA.business.Account;
import TOBA.business.Transaction;
import TOBA.business.User;
import TOBA.data.AccountDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TransactionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = (User)request.getSession().getAttribute("user");
        //Account savingsAccount = (Account)request.getSession().getAttribute("account");

        // Set content type
        response.setContentType("text/html;charset=UTF-8");
        
        // Get variables from form
        String fromAccount = request.getParameter("fromAccount");
        String toAccount = request.getParameter("toAccount");
        String amount = request.getParameter("amount");

        //Account savingsAccount = new Account(user, )
        
        // Store data in Transaction object
        // Does not take strings
       // Transaction transaction = new Transaction(amount, fromAccount, toAccount);
       // AccountDB.update(savingsAccount);
        //AccountDB.update(checkingAccount);
        
        // Set default url destination
        String url = "/account_activity.jsp";
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}