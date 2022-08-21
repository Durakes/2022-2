public class E15
{
    public static void main(String[] args) 
    {
        int numero;
        System.out.println("Ingrese el numero a verificar");
        numero = Integer.parseInt(System.console().readLine());
    
        if (numero < 1 || numero > 100)
        {
            System.out.println("Número incorrecto");
        }else if (numero < 10)
        {
            System.out.println("El número tiene 1 dígito");
        }else if (numero < 100)
        {
            System.out.println("El número tiene 2 dígitos");
        }else
        {
            System.out.println("El número tiene 3 dígitos");
        }
    }
}
