<%-- 
    Document   : register
    Created on : 19/03/2017, 03:45:21 PM
    Author     : Valeria
--%>
<%
    if(session.getAttribute("username") != null){
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><h1>Registro:</h1>
        <form action="RegisterController" method="post">
            <label>Usuario:</label>
                <input type="text" name="txtusername"><br>               
            <label>Contraseña:</label>
                <input type="password" name="txtpassword"><br>
            <label>Contraseña de nuevo:</label>
                <input type="password" name="txtpassword"><br>
            <label>Nombre:</label>
                <input type = "text" name = "txtname"/><br>
           <label>Last name:</label>
                <input type = "text" name = "txtlastname"/><br>
            <input type="submit" value="registrar">  <br>
        </form> 
    </body>
</html>
