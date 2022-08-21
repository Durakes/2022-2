public class E10 
{
    public static void main(String[] args)
    {
        float velocidad, distancia, tiempo;

        System.out.println("Ingrese la velocidad");
        velocidad = Float.parseFloat(System.console().readLine());

        System.out.println("Ingrese la distancia");
        distancia = Float.parseFloat(System.console().readLine());

        tiempo = distancia / velocidad;

        System.out.println("El tiempo que se demorará en llegar es " + tiempo + " segundos.");
    }
}
