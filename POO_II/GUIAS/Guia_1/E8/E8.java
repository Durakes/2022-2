public class E8 
{
    public static void main(String[] args)
    {
        float tarifaHora, sueldoBruto, descuentoESS, descuentoAFP, sueldoNeto;
        int numHoras;
        final float essalud = 0.09f;
        final float afp = 0.115f;

        System.out.println("Ingrese el numero de horas trabajadas");
        numHoras = Integer.parseInt(System.console().readLine());

        System.out.println("Ingrese la tarifa horaria a pagar");
        tarifaHora = Float.parseFloat(System.console().readLine());

        sueldoBruto = numHoras * tarifaHora;
        descuentoAFP = sueldoBruto * afp;
        descuentoESS = sueldoBruto * essalud;
        sueldoNeto = sueldoBruto - descuentoAFP - descuentoESS;

        System.out.println("El sueldo bruto es: " + sueldoBruto);
        System.out.println("El descuento de ESSALUD es: " + descuentoESS);
        System.out.println("El descuento de AFP es: " + descuentoAFP);
        System.out.println("El sueldo neto es: " + sueldoNeto);
    }
}
