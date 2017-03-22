<%-- 
    Document   : buscar
    Created on : 20/03/2017, 07:57:27 PM
    Author     : Valeria
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelos.ComentariosPOJO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "ComentariosControlador" method = "post" >
           <label>Nombre:</label>
            <input type = "text" name = "name"/></br>
            <label>Comentario:</label>
            <textarea rows="3" cols="5" name="comentario"></textarea></br>
            <input type ="submit" value ="buscar"/> 
           <input type="hidden" name="action" value="buscar"></br
        </form>
        <%
            if(session != null){
                ArrayList  comentarios = (ArrayList)session.getAttribute("comentarios");
                if(comentarios != null){
        %>
        <table border="1"> 
            <tr>
                <th>Nombre</th>
                <th>Comentario</th>
            </tr> 
            <%
                for(Object o: comentarios){
                    ComentariosPOJO cms = (ComentariosPOJO) o;
            %>
             <tr>
                 <td><%cms.getNombre();%></td>
                 <td><%cms.getComentario();%></td>
             </tr>  
             <%}%>
        </table> 
        <% }
        }
        %>
    </body>
</html>
