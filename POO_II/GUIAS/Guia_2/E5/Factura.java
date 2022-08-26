public class Factura
{
    int cantidad;
    double precio;

    public Factura(int cantidad, double precio)
    {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    double calculoIGV()
    {
        return (cantidad * precio) * 0.18;
    }

    double calculoTotal()
    {
        return cantidad * precio;
    }
}
