public class E3 
{
    public static void main(String[] args) 
    {
        float carmela, javier, eulogio;
        float total;
        System.out.println("Ingrese el aporte de Carmela");
        carmela = Float.parseFloat(System.console().readLine());
    
        System.out.println("Ingrese el aporte de Javier");
        javier = Float.parseFloat(System.console().readLine());
    
        System.out.println("Ingrese el aporte de Eulogio");
        eulogio = Float.parseFloat(System.console().readLine());
    
        total = carmela + javier + eulogio;
    
        System.out.println("Eulogio aportó el " + (eulogio / total) * 100 + "% del total");
        System.out.println("Javier aportó el " + (javier / total) * 100 + "% del total");
        System.out.println("Carmela aportoó el " + (carmela / total) * 100 + "% del total");
    }
}
