public class E12 
{
    public static void main(String[] args)
    {
        double gigas; 
        double precio = 0;

        System.out.println("Ingrese la cantidad de gigas consumidos");
        gigas = Double.parseDouble(System.console().readLine());

        if(gigas > 0 && gigas <= 4)
        {
            precio = 50;
        }else if(gigas <= 8)
        {
            precio = 85;
        }else if(gigas > 8)
        {
            precio = 85 + (gigas - 8) * 4.5;
        }else
        {
            System.out.println("Cantidad Incorrecta");
        }

        System.out.println("El precio a pagar mensual es: " + precio);
    }
}
