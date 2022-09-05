document.getElementById("sueldo").focus();

document.getElementById("ValidarForm").addEventListener("submit", function(evt)
{
    evt.preventDefault();

    let sueldo = parseFloat(document.getElementById("sueldo").value);
    let horas = parseFloat(document.getElementById("horas").value);

    let sueldoBruto = sueldo * horas;
    let descuento = sueldoBruto > 3500 ? 0.15: 0.11;
    let descuentoTotal = sueldoBruto * descuento;
    let sueldoNeto = sueldoBruto - descuentoTotal;

    document.getElementById("resultado").value = "El sueldo bruto es: " + sueldoBruto + "\n"
                                                + "El descuento total es: " + descuentoTotal + "\n"
                                                + "El sueldo neto es: " + sueldoNeto;
}, false);