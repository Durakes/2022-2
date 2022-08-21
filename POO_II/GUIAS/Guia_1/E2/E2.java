public class E2 
{
    public static void main(String[] args) 
    {
        float A, B, L, precio;
        System.out.println("Ingrese el alto de la piscina");
        A = Float.parseFloat(System.console().readLine());
    
        System.out.println("Ingrese la largo de la piscina");
        L = Float.parseFloat(System.console().readLine());
    
        System.out.println("Ingrese el ancho de la piscina");
        B = Float.parseFloat(System.console().readLine());
    
        System.out.println("Ingrese el precio por metro cubico");
        precio = Float.parseFloat(System.console().readLine());
    
        float volumenT = A * B * L;
        float precioT = precio * volumenT;
    
        System.out.println("El precio total es: " + precioT);
    }
}
