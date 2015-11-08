<%-- 
Using EL, bind the User object to a form field in a page
Allow the user to change their password
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html" />
        <h1>Reset your password</h1>
        <form action="password_reset" method="post">
            <label>Username:</label>
            <input type="text" name="username" required><br>
            <label>Current Password:</label>
            <input type="password" name="currentPassword" required value="${user.password}"><br>
            <label>New Password:</label>
            <input type="password" name="newPassword" required><br>
            <input type="submit" value="Change Password">
        </form>
<c:import url="/footer.jsp" />
