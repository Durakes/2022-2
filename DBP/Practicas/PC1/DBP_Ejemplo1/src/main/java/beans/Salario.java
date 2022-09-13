package beans;
public class Salario
{
    private double reparto;
    private double salario;
    private double antiguedad;
    
    public Salario(double salario, double antiguedad)
    {
        this.antiguedad = antiguedad;
        this.salario = salario;
    }
    
    public double getReparto() {return reparto;}
    public void setReparto(double reparto) {this.reparto = reparto;}
    
    public double getSalario() {return salario;}
    public void setSalario(double salario)  {this.salario = salario;}

    public double getAntiguedad() {return antiguedad;}
    public void setAntiguedad(double antiguedad) {this.antiguedad = antiguedad;}
    

    public void getRepartoTotal()
    {
        if(antiguedad < 1)
        {
            reparto = salario * 0.05;
        }else if(antiguedad >= 1 && antiguedad < 2 )
        {
            reparto = salario * 0.07;
        }else if(antiguedad >= 2 && antiguedad < 5 )
        {
            reparto = salario * 0.1;
        }else if(antiguedad >= 5 && antiguedad < 10 )
        {
            reparto = salario * 0.15;
        }else if(antiguedad >= 10 )
        {
            reparto = salario * 0.20;
        }else
        {
            reparto = 0;
        }
    }
}
