document.getElementById("precio").focus();

document.getElementById("ValidarForm").addEventListener("submit", function(evt)
{
    evt.preventDefault();

    let precio = parseFloat(document.getElementById("precio").value);
    let cantidad = parseFloat(document.getElementById("cantidad").value);

    let importeCompra = precio * cantidad;
    let descuento = 0.07 * importeCompra;
    let importePagar = importeCompra - descuento;
    

    document.getElementById("resultado").value = "El importe de compra es: " + importeCompra + "\n"
                                                + "El descuento total es: " + descuento + "\n"
                                                + "El importe a pagar es: " + importePagar + "\n";
}, false);