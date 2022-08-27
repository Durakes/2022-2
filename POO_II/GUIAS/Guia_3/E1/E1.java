public class E1
{
    public static void main(String[] args)
    {
        int opcion;
        do
        {
            System.out.println("1.- Area de un Triangulo");
            System.out.println("2.- Area de un Rectángulo");
            System.out.println("3.- Area de un Circulo");
            System.out.println("4.- Area de un Cuadrado");
            System.out.println("5.- Salir");
            System.out.println("¿Que opción desea escoger?");
            opcion = Integer.parseInt(System.console().readLine());
            
            
            if(opcion >= 1 && opcion <= 4)
            {
                Figura figura = new Figura(opcion);
                figura.construirFigura();

                System.out.println("El area del " + figura.nombre + " es: " + figura.area);
                break;
            }else if(opcion == 5)
            {
                System.out.println("Programa cerrado");
                break;
            }else
            {
                System.out.println("Seleccione una opción correcta");
                System.out.println("Presione Enter para volver al menu de opciones");
                System.console().readLine();
            }

        }while(true);
    }
}