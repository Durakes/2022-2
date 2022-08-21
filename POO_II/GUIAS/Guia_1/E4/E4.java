public class E4 
{
    public static void main(String[] args) 
    {
        int accionA, accionB, accionC;
        float gananciaT, accionesT;
    
        System.out.println("Indique la cantidad de acciones de A");
        accionA = Integer.parseInt(System.console().readLine());
    
        System.out.println("Indique la cantidad de acciones de B");
        accionB = Integer.parseInt(System.console().readLine());
    
        System.out.println("Indique la cantidad de acciones de C");
        accionC = Integer.parseInt(System.console().readLine());
    
        System.out.println("Indique la ganancia total");
        gananciaT = Integer.parseInt(System.console().readLine());
    
        accionesT = accionA + accionB + accionC;
    
        System.out.println("La ganancia de cada accionista es: ");
        System.out.println("A: " + (accionA / accionesT) * gananciaT + " Soles");
        System.out.println("B: " + (accionB / accionesT) * gananciaT + " Soles");
        System.out.println("C: " + (accionC / accionesT) * gananciaT + " Soles");
    }
}
