document.getElementById("codigo").focus();
/* traer valores de cajas a variables */
var cod=document.getElementById("codigo");
var nom=document.getElementById("nombre");
var ape=document.getElementById("apellidos");
var eda=document.getElementById("edad");

function procesarCliente()
{
    if(parseInt(eda.value)>17)
    {
        var estado="Mayor de edad";
    }
    else
    {
        var estado="Menor de edad";
    }
    document.getElementById("text").innerHTML = "Codigo: "+cod.value + "\n"+ 
                                                "Nombre: "+nombre.value+"\n"+
                                                "Apellidos: "+apellidos.value+ "\n"+
                                                "Edad: "+eda.value+"\n"+estado;
                                                
    return false;
}