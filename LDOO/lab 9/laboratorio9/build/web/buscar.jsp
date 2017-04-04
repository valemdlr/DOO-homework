<%-- 
    Document   : buscar
    Created on : 28/03/2017, 07:47:05 PM
    Author     : SEG11
--%><!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="models.ComentariosPOJO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ComentariosControladors" method="POST" >
            <label>Nombre: </label>
                <input type="text" value="" name="nombre"><br/>
            <label>Comentario: </label>
                <textarea rows="5" cols="15" name="comentario"></textarea><br/>
            <input type="submit" value = "buscar">
            <input type="hidden" name="action" value="buscar">
        </form>
        <%  if(session != null){
            ArrayList  comentarios = (ArrayList)session.getAttribute("comentarios");
            if(comentarios!=null){
        %>
                <table border="1">
                    <tr>
                        <th>Nombre: </th>
                        <th>Comentario: </th>
                    </tr>
                <% 
                    for(Object o : comentarios){
                        ComentariosPOJO comentario = (ComentariosPOJO) o;
                %>    
                    <tr>
                        <td><%=comentario.getNombre()%></td>
                        <td><%=comentario.getComentario()%></td>
                    </tr>
                <%  } %>    
                </table>
            <%  }
                }%>
    </body>
</html>
