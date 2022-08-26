public class E2
{
    public static void main(String[] args)
    {
        int edad;
        String genero;

        System.out.println("Ingrese la edad de la persona: ");
        edad = Integer.parseInt(System.console().readLine());

        System.out.println("Ingrese el genero de la persona: ");
        genero = System.console().readLine();

        Seguro seguro = new Seguro(genero, edad);
        
        if(seguro.calcularPrecio() == 0)
        {
            System.out.println("Datos incorrectos ingresados");
        }else
        {
            System.out.println("El monto a pagar por el seguro es: " + seguro.calcularPrecio());
        }
    }
}
