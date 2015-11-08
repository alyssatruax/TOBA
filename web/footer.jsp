<%-- 
Dynamically display the current date in the copyright information
--%>

<%@page import="java.util.GregorianCalendar, java.util.Calendar" %>
<% 
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<p>Copyright <%= currentYear %> Titan Online Banking Application</p>
    </body>
</html>
