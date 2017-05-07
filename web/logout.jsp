<%-- 
    Document   : logout
    Created on : 6/05/2017, 09:17:31 PM
    Author     : DANNY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logout</title>
    </head>
    <body>
        <%
            session.invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response); 
        %>
    </body>
</html>
