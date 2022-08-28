public class Operacion
{
    int Num;
    int V;

    public Operacion(int Num, int V)
    {
        this.Num = Num;
        this.V = V;
    }

    double calcular()
    {
        switch(Num)
        {
            case 1:
                return 100 * V;
            case 2:
                return Math.pow(100, V);
            case 3:
                return 100 / V;
            default:
                return 0;
        }
    }

}
