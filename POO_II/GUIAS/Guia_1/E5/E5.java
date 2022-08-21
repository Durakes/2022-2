public class E5 
{
    public static void main(String[] args) 
    {
        float precioC, precioV, porcentajeG;
    
        System.out.println("Precio de compra de la pieza a vender");
        precioC = Float.parseFloat(System.console().readLine());
    
        System.out.println("Porcentaje que desea ganar (Indicar como numero entero)");
        porcentajeG = Float.parseFloat(System.console().readLine());
    
        porcentajeG = porcentajeG / 100;
    
        precioV = precioC * (1 + porcentajeG);
    
        System.out.println("El precio de venta final es: " + precioV + " Soles.");
    
    }
}
