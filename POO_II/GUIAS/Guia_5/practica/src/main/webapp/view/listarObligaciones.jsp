<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.Obligacion" %>
<%@page import="controller.obligacionController" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link ref="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h3>Buscar <input type="text" class="form-control"  id="myInput" placeholder="Ingrese criterio de busqueda"></h3>
        <%
            obligacionController oblController = new obligacionController(); //CREO OBJ CONTROLLER
            List<Obligacion> lst = oblController.getLstObligacionController();//USANDO LA FUNCION CREO UNA LISTA DE LOS OBJ REGISTRADOS EN LA BD

            Double montoMayor = 0.0;
            String idMayor = "";

            for(Obligacion x:lst)
            {
                if(x.getMontoObligacion() >= montoMayor)
                {
                    montoMayor = x.getMontoObligacion();
                    idMayor = x.getAlumno();
                }
            }
            
        %>

            <p>
                El alumno con mayor pensión es: <%out.print(montoMayor);%>
            </p>
            <p>El id del alumno con mayor pensión es: <%out.print(idMayor);%></p>
        <table class="table">
            <tr>
                <td>Codigo</td>
                <td>Vencimiento</td>
                <td>Monto Obligacion</td>
                <td>Id_Alumno</td>
                <td>Id_Descripcion</td>
            </tr>
            <tbody id="myTable">
            <tr>
                <%
                    for(Obligacion x:lst)
                    {
                    %>
                        <tr>
                            <td><%=x.getCodigo()%></td>
                            <td><%=x.getVencimiento()%></td>
                            <td><%=x.getMontoObligacion()%></td>
                            <td><%=x.getAlumno()%> </td>
                            <td><%=x.getDescripcion()%> </td>
                        </tr>
                    <%
                    }
                
                %>
            </tr>
            </tbody>
        </table>
        </div>
    </body>
</html>

<script>//SE PROGRAMA LO DE LA BUSQUEDA
$(document).ready(function () {
    $("#myInput").on("keyup", function () {
        
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});
</script>