public class E1
{
    public static void main(String[] args)
    {
        int cantidad;
        System.out.println("Ingrese la cantidad de neumaticos a comprar");
        cantidad = Integer.parseInt(System.console().readLine());

        Venta venta = new Venta(cantidad);

        System.out.println("El monto total de la venta: " + venta.precioTotal());
    }
}
