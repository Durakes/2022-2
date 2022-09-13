<%-- 
    Document   : listar
    Created on : 13 set. 2022, 09:57:48
    Author     : apa16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.Salario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            double salarioIndividual = Double.parseDouble(request.getParameter("txtSalario"));
            double antiguedad = Double.parseDouble(request.getParameter("txtAntiguedad"));

            Salario salario = new Salario(salarioIndividual, antiguedad);
            salario.getRepartoTotal();
        %>

        <h1>Resumen Salario</h1>
        <h3><% out.print("Salario: " + salario.getSalario() + " soles."); %></h3>
        <h3><% out.print("Antiguedad: " + salario.getAntiguedad() + " años."); %></h3>
        <h3><% out.print("Reparto de utilidades anual: " + salario.getReparto() + " soles."); %></h3>
        
    </body>
</html>
