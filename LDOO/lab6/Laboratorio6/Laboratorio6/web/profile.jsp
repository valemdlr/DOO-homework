<%-- 
    Document   : profile
    Created on : 7/03/2017, 07:29:09 PM
    Author     : SEG11
--%>
<%
            if(session.getAttribute("username") == null){
                response.sendRedirect("login.jsp");
            }
            String color= "";
            
            Cookie cookie ;
            Cookie[] cookiesArray ;

            cookiesArray = request.getCookies();
            for (int i = 0; i < cookiesArray.length; i++){
                if(cookiesArray[i].getName().equals("color")){
                    cookie = cookiesArray[i];
                    color = cookie.getValue();                  
                }
            }            
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: <%= color %>" >             
        <form action = "ProfileController">
        <h1> Bienvenido <%= session.getAttribute("nombre") %> </h1>
        <h1>nombre: <%= session.getAttribute("nombre") %></h1>
        <h1>Usuario: <%= session.getAttribute("username") %></h1>
        <label>Color:</label>
        <select name = "select">
            <option name="" value="purple">morado</option>
            <option name="" value="blue">azul</option>
            <option name="" value="pink">rosa</option>
            <option name="" value="black">negro</option>
        </select>
        <input type = "submit" value = "Guardar"/>
        <h2><a href="LogoutController">Cerrar Sesión</a></h2>
        </form>
    </body>
</html>
