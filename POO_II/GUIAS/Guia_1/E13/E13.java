public class E13
{
    public static void main(String[] args) 
    {
        int numero;
        String numText;
        System.out.println("Ingrese el número a evaluar");
        numText = System.console().readLine();
        numero = Integer.parseInt(numText);
    
        if (numero < 100 || numero > 999) 
        {
            System.out.println("Número incorrecto");
        } else 
        {
            char[] nArray = numText.toCharArray();
            //! Forma 1
            for(int i = 2; i >= 0; i--)
            {
                System.out.print(nArray[i]);
            }
            //! Forma 2
            //System.out.println(""+nArray[2] + nArray[1] + nArray[0]);
        }
    }
}
