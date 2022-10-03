<%-- 
    Document   : listarAlumno
    Created on : 22 set. 2022, 09:36:58
    Author     : apa16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="controller.alumnoController"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            alumnoController aluController = new alumnoController();
            List<Alumno> lst = aluController.getLstAlumnoController();
        %>
        
        <table border="2">
            <tr>
                <td>Codigo</td>
                <td>Apellido Paterno</td>
                <td>Apellido Materno</td>
                <td>Nombres</td>
            </tr>

            <%
                for(Alumno x:lst)
                {
            %>
                    <tr>
                        <td><%=x.getCodigo()%></td>
                        <td><%=x.getPaterno()%></td>
                        <td><%=x.getMaterno()%></td>
                        <td><%=x.getNombre()%></td>
                    </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
