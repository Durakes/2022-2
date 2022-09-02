document.getElementById("username").focus();
var user = document.getElementById("username");
var pass = document.getElementById("password");
var error = document.getElementById("error");

function Validar()
{
    let errores = [];
    if(user.value === null || user.value === "")  // == tipos de dato iguales, === tipos de dato diferentes.
    {
        errores.push("Ingrese Usuario");
    }

    if(pass.value === null || pass.value === "")
    {
        errores.push("Ingrese Contraseña");
    }

    error.innerHTML = errores.join(" , ");

    return false;
}