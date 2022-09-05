document.getElementById("nota1").focus();

document.getElementById("ValidarForm").addEventListener("submit", function(evt)
{
    evt.preventDefault();

    let nota1 = parseFloat(document.getElementById("nota1").value);
    let nota2 = parseFloat(document.getElementById("nota2").value);
    let nota3 = parseFloat(document.getElementById("nota3").value);

    let promedioFinal = (nota1 * 0.20) + (nota2 * 0.35) + (nota3 * 0.45);
    let condicion = promedioFinal >= 13 ? "Aprobado" : "Desaprobado";

    document.getElementById("resultado").value = "El promedio final es: " + promedioFinal + "\n"
                                                + "La condición del alumno es: " + condicion;
}, false);