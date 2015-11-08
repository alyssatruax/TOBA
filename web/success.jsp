<%-- 
    Using EL, display all of the attributes along with the new username and password
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html" />
    <jsp:useBean id="user" class="TOBA.User" scope="session" />
    <header>
        <h1>Thank you! Your account has been successfully created.</h1>
    </header>
        
    <p>Here is the information you provided:</p>
        <label>First name: </label>
        <span>${user.firstName}</span><br>
        <label>Last name: </label>
        <span>${user.lastName}</span><br>
        <label>Phone: </label>
        <span>${user.phone}</span><br>
        <label>Address: </label>
        <span>${user.address}</span><br>
        <label>City: </label>
        <span>${user.city}</span><br>
        <label>State: </label>
        <span>${user.state}</span><br>
        <label>Zipcode: </label>
        <span>${user.zipcode}</span><br>
        <label>Email: </label>
        <span>${user.email}</span><br>
        <p>Here is your username and temporary password:</p>
        <label>Username: </label>
        <span>${user.username}</span><br>
        <label>Password: </label>
        <span>${user.password}</span>
        
<c:import url="/footer.jsp" />


        


