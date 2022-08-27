public class Zodiaco
{
    int mes;
    int dia;
    String nombre;

    public Zodiaco(int mes, int dia)
    {
        this.mes = mes;
        this.dia = dia;
    }
    
    void signoZodiaco()
    {
        switch(mes)
        {
            case 1:
            nombre = dia <= 20 ? "Capricornio" : "Acuario";
            break;

            case 2:
            nombre = dia <= 19 ? "Acuario" : "Piscis";
            break;

            case 3:
            nombre = dia <= 20 ? "Piscis" : "Aries";
            break;

            case 4:
            nombre = dia <= 20 ? "Aries" : "Tauro";
            break;

            case 5:
            nombre = dia <= 21 ? "Tauro" : "Geminis";
            break;

            case 6:
            nombre = dia <= 21 ? "Geminis" : "Cáncer";
            break;

            case 7:
            nombre = dia <= 21 ? "Cáncer" : "Leo";
            break;

            case 8:
            nombre = dia <= 23 ? "Leo" : "Cáncer";
            break;

            case 9:
            nombre = dia <= 21 ? "Geminis" : "Cáncer";
            break;

            case 10:
            nombre = dia <= 21 ? "Geminis" : "Cáncer";
            break;

            case 11:
            nombre = dia <= 21 ? "Geminis" : "Cáncer";
            break;

            case 12:
            nombre = dia <= 21 ? "Geminis" : "Cáncer";
            break;

            default:
            break;
        }
    }
}
