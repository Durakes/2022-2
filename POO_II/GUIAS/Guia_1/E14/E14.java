public class E14
{
    public static void main(String[] args) 
    {
        int numero;
        String numText;
        System.out.println("Ingrese el número a evaluar");
        numText = System.console().readLine();
        numero = Integer.parseInt(numText);

        if(numero < 100 || numero > 999)
        {
            System.out.println("Número incorrecto");
        }else
        {
            if(numText.charAt(0) == numText.charAt(2))
            {
                System.out.println("Es número capicua");
            }else
            {
                System.out.println("No es número capicua");
            }
        }
    }
}
