public class E2
{
    public static void main(String[] args)
    {
        String categoria;
        int horas;

        System.out.println("Ingrese la cantidad de horas del trabajador");
        horas = Integer.parseInt(System.console().readLine());
        
        System.out.println("Ingrese la categoria del trabajador");
        categoria = System.console().readLine();
        
        Trabajador trabajador = new Trabajador(categoria, horas);

        trabajador.calculoSalario();
        
        if(trabajador.salario != 0)
            System.out.println("El salario del trabajador es " + trabajador.salario);
    }
}
