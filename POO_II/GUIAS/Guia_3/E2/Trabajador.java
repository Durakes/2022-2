public class Trabajador
{
    String categoria;
    double salario = 0;
    int horas;

    public Trabajador(String categoria, int horas)
    {
        this.categoria = categoria;
        this.horas = horas;
    }

    void calculoSalario()
    {
        switch(categoria)
        {
            case "A":
            salario = horas * 30;
            break;

            case "B":
            salario = horas * 35;
            break;

            case "C":
            salario = horas * 40;
            break;

            case "D":
            salario = horas * 45;
            break;
            
            case "E":
            salario = horas * 50;
            break;

            default:
            System.out.println("Categoría incorrecta");
            break;
        }
    }

}
