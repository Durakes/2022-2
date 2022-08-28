public class E6
{
    public static void main(String[] args)
    {
        int tipo;
        int consumo;

        System.out.println("Ingrese el tipo de consumo");
        tipo = Integer.parseInt(System.console().readLine());

        System.out.println("Ingrese el consumo total");
        consumo = Integer.parseInt(System.console().readLine());

        Factura factura = new Factura(tipo, consumo);
        factura.calcularPrecio();

        if(factura.precioTotal != 0)
        {
            System.out.println("La total facturado es de: " + factura.precioTotal);
        }else
        {
            System.out.println("Datos ingresados incorrectos");
        }
    }
}