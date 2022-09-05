document.getElementById("precio").focus();

document.getElementById("ValidarForm").addEventListener("submit", function(evt)
{
    evt.preventDefault();

    let precio = parseFloat(document.getElementById("precio").value);
    let cantidad = parseFloat(document.getElementById("cantidad").value);

    let importeCompra = precio * cantidad;
    let descuento1 = 0.10 * importeCompra;
    let descuento2 = (importeCompra - descuento1) * 0.10;
    let descuentoTotal = descuento1 + descuento2;
    let importePagar  = importeCompra - descuentoTotal;
    
    document.getElementById("resultado").value = "El importe de compra es: " + importeCompra + "\n"
                                                + "El descuento total es: " + descuentoTotal + "\n"
                                                + "El importe a pagar es: " + importePagar;
}, false);