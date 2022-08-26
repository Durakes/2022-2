public class Obrero
{
    int horasTrabajadas;

    public Obrero(int horas)
    {
        horasTrabajadas = horas;
    }

    double calcularSalario()
    {
        if(horasTrabajadas < 40)
        {
            return horasTrabajadas * 16;
        }else
        {
            return 40 * 16 + (horasTrabajadas - 40) * 20;
        }
    }
}
