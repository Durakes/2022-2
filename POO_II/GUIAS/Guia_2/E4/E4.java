public class E4
{
    public static void main(String[] args)
    {
        int horas;

        System.out.println("Ingrese la cantidad de horas trabajadas: ");
        horas = Integer.parseInt(System.console().readLine());

        Obrero obrero = new Obrero(horas);

        System.out.println("El salario del obrero es: " + obrero.calcularSalario());
    }
}
