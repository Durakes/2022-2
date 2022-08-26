public class E5
{
    public static void main(String[] args)
    {
        int cantidad;
        double precio;
        double descuento;

        System.out.println("Ingrese la cantidad de articulos comprados");
        cantidad = Integer.parseInt(System.console().readLine());

        System.out.println("Ingrese el precio por unidad del articulo");
        precio = Double.parseDouble(System.console().readLine());

        Factura factura = new Factura(cantidad, precio);
        
        descuento = factura.calculoIGV();

        System.out.println("El monto total de la compra es: " + factura.calculoTotal());
        System.out.println("El monto del IGV es: " + descuento);
        System.out.println("El monto sin IGv es: " + (factura.calculoTotal() - descuento));
    }
}
