public class E3
{
    public static void main(String[] args)
    {
        int diametro;
        int cantidad;
        
        System.out.println("Ingrese el diametro de la pizza");
        diametro = Integer.parseInt(System.console().readLine());

        System.out.println("Ingrese la cantidad de Ingredientes Extra");
        cantidad = Integer.parseInt(System.console().readLine());

        Pizza pizza = new Pizza(diametro, cantidad);

        System.out.println("El precio de la pizza es: " + pizza.calcularPrecio());
    }
}
