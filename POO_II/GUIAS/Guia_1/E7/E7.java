public class E7 
{
    public static void main(String[] args)
    {
        int horasTot;
        float tarifaHora, sueldoBase, sueldoBruto, sueldoNeto;
        final float bonificacion = 0.18f;
        final float descuento = 0.12f;

        System.out.println("Ingrese el numero de horas trabajadas");
        horasTot = Integer.parseInt(System.console().readLine());
        
        System.out.println("Ingrese la tarifa por hora");
        tarifaHora = Integer.parseInt(System.console().readLine());

        sueldoBase = horasTot * tarifaHora;
        sueldoBruto = Math.round((sueldoBase * (1 + bonificacion)) * 100);
        sueldoNeto = Math.round((sueldoBruto * (1 - descuento)) * 100);

        System.out.println("El sueldo básico es: " + sueldoBase);
        System.out.println("El sueldo bruto es: " + sueldoBruto);
        System.out.println("El sueldo neto es: " + sueldoNeto);
    }
}
