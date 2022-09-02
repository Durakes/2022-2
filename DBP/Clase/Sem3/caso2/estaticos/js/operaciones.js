document.getElementById("ValidarFormulario").addEventListener("submit", 
function(evt)
{
    let name = document.getElementById("nombre").value; //!averiguar sobre "let"
    let n1 = parseInt(document.getElementById("_n1").value);
    let n2 = parseInt(document.getElementById("_n2").value);
    let suma = n1 + n2;
    document.getElementById("resultado").value = "El nombre es: " + name + "\n" + "Suma = " + suma + "\n";
} , false);