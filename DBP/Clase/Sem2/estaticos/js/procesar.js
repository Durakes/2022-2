document.getElementById("_n1").focus();
var n1 = document.getElementById("_n1");
var n2 = document.getElementById("_n2");
var n3 = document.getElementById("_n3");
var n4 = document.getElementById("_n4");

function getMayor()
{
    if(parseInt(n1.value) > parseInt(n2.value) && parseInt(n1.value) > parseInt(n3.value) && parseInt(n1.value) > parseInt(n4.value))
    {
        return n1.value;
    }else if(parseInt(n2.value) > parseInt(n3.value) && parseInt(n2.value) > parseInt(n4.value))
    {
        return n2.value;
    }else if(parseInt(n3.value) > parseInt(n4.value))
    {
        return n3.value;
    }else
    {
        return n4.value;
    }
}

function getProcesar()
{

    document.getElementById("resultado").value = "El mayor es: " + getMayor() + "\n";
    n1.value = "";
    n2.value = "";
    n3.value = "";
    n4.value = "";



    n1.focus();
    return false;
}