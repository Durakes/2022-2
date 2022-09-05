document.getElementById("ventas").focus();

document.getElementById("ValidarForm").addEventListener("submit", function(evt)
{
    evt.preventDefault();

    let ventas = parseFloat(document.getElementById("ventas").value);

    let sueldoBasico = 350.75;
    let comision = 0.05 * ventas;
    let sueldoBruto = sueldoBasico + comision;
    let descuento = 0.15 * sueldoBruto;
    let sueldoNeto = sueldoBruto - descuento;

    document.getElementById("resultado").value = "El sueldo bruto es: " + sueldoBruto + "\n"
                                                + "El descuento total es: " + descuento + "\n"
                                                + "El sueldo neto es: " + sueldoNeto;
}, false);