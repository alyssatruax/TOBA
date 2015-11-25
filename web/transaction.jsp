<%-- 
    Document   : transaction
    Created on : Nov 24, 2015, 6:46:18 PM
    Author     : alyssatruax
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html" />
<jsp:useBean id="user" class="TOBA.business.User" scope="session" />
        <h1>Account Activity</h1>
        <c:choose>
            <c:when test="${user.username != ''}">
                <p>Welcome, ${user.firstName} ${user.lastName}.</p><br>
                <p>Account Balances: </p>
                <p>Savings Balance: ${savingsAccount.balance}</p>
                <p>Checking Balance: ${checkingAccount.balance}</p><br>
                <p>Make a transaction: </p>
                <form action="transaction" method="post">
                <p>From account:</p>
                <label>Savings:</label>
                <input type="radio" name="fromAccount" value="savings">
                <label>Checking:</label>
                <input type="radio" name="fromAccount" value="checking"><br>
                <p>To account:</p>
                <label>Savings:</label>
                <input type="radio" name="toAccount" value="savings">
                <label>Checking:</label>
                <input type="radio" name="toAccount" value="checking"><br><br>
                <label>Amount:</label>
                <input type="number" name="amount" required><br><br>
                <input type="submit" value="Transfer Funds">
        </form>
            </c:when>
            <c:otherwise>
                <p>Not logged in</p>
            </c:otherwise>
        </c:choose>
<c:import url="/footer.jsp" />
