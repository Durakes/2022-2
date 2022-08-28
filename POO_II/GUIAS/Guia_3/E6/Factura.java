public class Factura
{
    int tipo;
    int consumo;
    double precioTotal;

    public Factura(int tipo, int consumo)
    {
        this.tipo = tipo;
        this.consumo = consumo;
    }

    void calcularPrecio()
    {
        if(tipo == 1)
        {
            precioTotal = 1.58 * consumo;
        }else if(tipo == 2)
        {
            if(consumo <= 100)
            {
                precioTotal  = 0.35 * consumo;
            }else if(consumo > 100 && consumo <= 500)
            {
                precioTotal = (100 * 0.35) + ((consumo - 100) * 1.05);
            }else if(consumo > 500)
            {
                precioTotal = (100 * 0.35) + (500 * 1.05) + ((consumo - 500) * 1.36);
            }else
            {
                precioTotal = 0;
            }
        }else
        {
            precioTotal = 0;
        }
    }
}
