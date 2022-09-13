document.getElementById("cantidad").focus();

document.getElementById("ValidarForm").addEventListener("submit", function(evt)
{
    evt.preventDefault();

    let cantidad = parseInt(document.getElementById("cantidad").value);
    let precio = 11000;
    let descuento = 0;
    let importeCompra = precio * cantidad;

    if(cantidad < 5)
    {
        descuento = 0.10; 
    }else if(cantidad >= 5 && cantidad < 10)
    {
        descuento = 0.20;
    }else if(cantidad >= 10)
    {
        descuento = 0.40;
    }


    let descuentoTotal = importeCompra * descuento;
    let importePagar = importeCompra - descuentoTotal;


    document.getElementById("resultado").value ="El importe de compra es: " + importeCompra + "\n"
                                                + "El descuento total es: " + descuentoTotal + "\n"
                                                + "El importe a pagar es: " + importePagar;
}, false);