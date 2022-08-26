public class Pizza
{
    int diametro;
    int cantidadExtras;

    public Pizza(int diametro, int cantidad)
    {
        this.diametro = diametro;
        this.cantidadExtras = cantidad;
    }

    double calcularPrecio()
    {
        return diametro * 1.5 + cantidadExtras * 2.5;
    }
}
