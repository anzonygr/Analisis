<%-- 
    Document   : Cerrar
    Created on : 25/10/2018, 11:52:43 AM
    Author     : agonzalez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession sesionsalir = request.getSession();
            sesionsalir.invalidate();
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
