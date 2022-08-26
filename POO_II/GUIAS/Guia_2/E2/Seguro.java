public class Seguro
{
    String genero;
    int edad;

    public Seguro(String genero, int edad)
    {
        this.genero = genero;
        this.edad = edad;
    }

    int calcularPrecio()
    {
        if(genero.equals("M"))
        {
            if(edad < 25)
            {
                return 1000;
            }else
            {
                return 700;
            }
        }else if(genero.equals("F"))
        {
            if(edad < 21)
            {
                return 800;
            }else
            {
                return 500;
            }
        }else
        {
            return 0;
        }
    }
}
