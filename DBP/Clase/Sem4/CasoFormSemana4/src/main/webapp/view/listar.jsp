<%-- 
    Document   : listar
    Created on : 8 set. 2022, 09:15:28
    Author     : apa16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.Usuario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String codigo = request.getParameter("txtCodigo");
            String nombre = request.getParameter("txtNombre");
            String DNI = request.getParameter("txtDni");
            int edad = Integer.parseInt(request.getParameter("txtEdad"));
            
            
            Usuario objUsu = new Usuario(codigo, nombre, DNI, edad);
        %>
        <h1>Resultados de perfil</h1>
        <h3><% out.print("Codigo: " + objUsu.getCod()); %></h3>
        <h3><% out.print("Nombres: " + objUsu.getNom()); %></h3>
        <h3><% out.print("DNI: " + objUsu.getDni()); %></h3>
        <h3><% out.print("Edad: " + objUsu.getEdad()); %></h3>
        <h3><% out.print("Edad: " + objUsu.getEstado()); %></h3>

        <%
            if(edad >= 0 && edad <= 11)
            {
                out.print("Matame");
            }
        %>
    </body>
</html>
