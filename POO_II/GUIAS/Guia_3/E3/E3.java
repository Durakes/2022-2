public class E3
{
    public static void main(String[] args)
    {
        int dia;
        int mes;

        System.out.println("Ingrese el día de nacimiento");
        dia = Integer.parseInt(System.console().readLine());

        System.out.println("Ingrese el mes de nacimiento");
        mes = Integer.parseInt(System.console().readLine());

        Zodiaco signo = new Zodiaco(mes, dia);
        signo.signoZodiaco();
        if(signo.nombre == "Sin Asignar")
            System.out.println("Su signo zodiacal es: " + signo.nombre);
        else
            System.out.println(signo.nombre);
    }
}
