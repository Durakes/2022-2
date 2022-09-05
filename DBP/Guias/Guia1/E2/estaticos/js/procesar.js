document.getElementById("precio").focus();

document.getElementById("ValidarForm").addEventListener("submit", function(evt)
{
    evt.preventDefault();

    let precio = parseFloat(document.getElementById("precio").value);
    let cantidad = parseFloat(document.getElementById("cantidad").value);

    let importeCompra = precio * cantidad;
    let descuento = 0.15 * importeCompra;
    let importePagar = importeCompra - descuento;
    let chocolates = cantidad * 3;
    
    document.getElementById("resultado").value = "El importe de compra es: " + importeCompra + "\n"
                                                + "El descuento total es: " + descuento + "\n"
                                                + "El importe a pagar es: " + importePagar + "\n"
                                                + "La cantidad de chocolates de cortesía son: " + chocolates;
}, false);