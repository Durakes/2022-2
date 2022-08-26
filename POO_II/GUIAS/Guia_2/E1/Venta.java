public class Venta 
{
    double precio;
    int cantidadNeumaticos;
    
    public Venta(int cantidad)
    {
        cantidadNeumaticos = cantidad;
    }

    void calcularPrecio()
    {
        if(cantidadNeumaticos < 3)
        {
            precio = 145;
        }else if(cantidadNeumaticos >= 3 && cantidadNeumaticos <= 5)
        {
            precio = 138;
        }else
        {
            precio = 135;
        }
    }

    double precioTotal()
    {
        calcularPrecio();
        return precio * cantidadNeumaticos;
    }
}
