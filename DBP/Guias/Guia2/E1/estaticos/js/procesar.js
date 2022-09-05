document.getElementById("precio").focus();

document.getElementById("ValidarForm").addEventListener("submit", function(evt)
{
    evt.preventDefault();

    let precio = parseFloat(document.getElementById("precio").value);
    let cantidad = parseFloat(document.getElementById("cantidad").value);

    let importeCompra = precio * cantidad;
    let descuento = cantidad > 10 ? 0.15: 0.05;
    let descuentoTotal = importeCompra * descuento;
    let importePagar = importeCompra - descuentoTotal;
    let obsequio = importePagar > 200 ? "Agenda" : "Cuaderno";


    document.getElementById("resultado").value = "El importe de compra es: " + importeCompra + "\n"
                                                + "El descuento total es: " + descuentoTotal + "\n"
                                                + "El importe a pagar es: " + importePagar + "\n"
                                                + "El obsqueio para el cliente es: " + obsequio;
}, false);