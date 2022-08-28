public class E4
{
    public static void main(String[] args)
    {
        int Num;
        int V;
        
        System.out.println("Ingrese Num");
        Num = Integer.parseInt(System.console().readLine());

        System.out.println("Ingrese V");
        V = Integer.parseInt(System.console().readLine());

        Operacion operacion = new Operacion(Num, V);

        System.out.println("El resultado es: " + operacion.calcular());
    }
}
