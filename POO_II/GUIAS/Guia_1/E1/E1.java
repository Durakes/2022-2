public class E1 
{
    public static void main(String[] args) 
    {
        float A, B, C;
        System.out.println("Ingrese el lado mas grande");
        A = Float.parseFloat(System.console().readLine());

        System.out.println("Ingrese la base del terreno");
        B = Float.parseFloat(System.console().readLine());

        System.out.println("Ingrese el lado mas pequeño");
        C = Float.parseFloat(System.console().readLine());

        float areaT = ((A - C) * B) / 2;

        float areaB = B * C;

        float areaTotal = areaT + areaB;

        System.out.println("Ingrese el lado mas pequeño");
        System.out.println(areaTotal);
    }
}