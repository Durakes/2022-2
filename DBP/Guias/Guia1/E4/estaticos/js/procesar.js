document.getElementById("sueldo").focus();

document.getElementById("ValidarForm").addEventListener("submit", function(evt)
{
    evt.preventDefault();

    let sueldo = parseFloat(document.getElementById("sueldo").value);
    let horas = parseFloat(document.getElementById("horas").value);

    let sueldoBruto = sueldo * horas;
    let descuento = 0.15 * sueldoBruto;
    let sueldoNeto = sueldoBruto - descuento;

    document.getElementById("resultado").value = "El sueldo bruto es: " + sueldoBruto + "\n"
                                                + "El descuento total es: " + descuento + "\n"
                                                + "El sueldo neto es: " + sueldoNeto;
}, false);