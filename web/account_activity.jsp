<%-- 
This page will be used to display the customer account information.

Use a JSTL if statement.
If the User object is in the session and not null,
display a welcome message containing their first name and last name in the page.
If it does not exist, display a "Not logged in" message on the page.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html" />
<jsp:useBean id="user" class="TOBA.User" scope="session" />
        <h1>Account Activity</h1>
    <c:if test="${user != null}">
        <p>Welcome, ${user.firstName} ${user.lastName} ${user.email} ${user.password}.</p>
    </c:if>
    <c:if test="${user == null}">
        <p>Not logged in</p>
    </c:if>
<c:import url="/footer.jsp" />
