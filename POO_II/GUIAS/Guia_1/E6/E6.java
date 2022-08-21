public class E6 
{
    public static void main(String[] args)
    {
        float precio, descuentoI, descuentoT, precioF, importe;
        int cantidad;

        System.out.println("Ingrese el precio del producto");
        precio = Integer.parseInt(System.console().readLine());

        System.out.println("Ingrese la cantidad que desea adquirir");
        cantidad = Integer.parseInt(System.console().readLine());

        System.out.println("Indique el porcentaje de descuento a aplicar");
        descuentoI = Integer.parseInt(System.console().readLine());

        precioF = precio * cantidad;
        descuentoT = precioF * (descuentoI / 100);
        importe = precioF - descuentoT;

        System.out.println("El precio total es: " + precioF);
        System.out.println("El descuento total es: " + descuentoT);
        System.out.println("El importe total es: " + importe);
    }
}
