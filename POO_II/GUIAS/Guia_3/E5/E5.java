public class E5
{
    public static void main(String[] args)
    {
        int año;
        int mes;
        
        System.out.println("Ingrese el mes");
        mes = Integer.parseInt(System.console().readLine());
        
        System.out.println("Ingrese el año");
        año = Integer.parseInt(System.console().readLine());

        NumeroDias signo = new NumeroDias(mes, año);
        signo.calcularDias();
        System.out.println("El mes seleccionado tiene: " + signo.totalDias);
    }
}