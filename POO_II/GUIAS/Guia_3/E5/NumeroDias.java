public class NumeroDias
{
    int mes;
    int año;
    int totalDias;

    public NumeroDias(int mes, int año)
    {
        this.mes = mes;
        this.año = año;
    }

    void calcularDias()
    {
        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
        {
            totalDias = 31;
        }else if(mes == 4 || mes == 6 || mes == 9 || mes == 11)
        {
            totalDias = 30;
        }else if(mes == 2)
        {
            if(año % 4 == 0)
            {
                totalDias = 29;
            }else
            {
                totalDias = 28;
            }
        }else
        {
            totalDias = 0;
        }
    }
}
