package e1;
import java.util.*;
public class cArrayList
{
    Scanner sc = new Scanner(System.in);
    public cArrayList()
    {
        int numPernos = 0;
        int diametroValidar = 0;
        
        System.out.println("Ingrese la cantidad de pernos que desean analizar: ");
        numPernos = sc.nextInt();
        System.out.println("\n");

        validarDatos(numPernos);

        System.out.println("Ingrese el diametro a analizar: ");
        diametroValidar = sc.nextInt();
        System.out.println("\n");

        validarDiametro(diametroValidar);
    }

    public void validarDatos(int num)
    {
        int max = 30;
        int min = 5;
        float suma = 0f;
        if(num > 100)
        {
            System.out.println("Numero de pernos demasiado alto, ingrese un numero menor a 100");
            validarDatos(sc.nextInt());
        }else
        {
            List<Integer> diametros = new ArrayList<>();
            for(int i = 0; i < num; i++)
            {
                int diametro = (int) Math.floor(Math.random() * (max - min + 1) + min);
                diametros.add(diametro);
                suma += diametro;
            }

            Iterator<Integer> itr = diametros.iterator();
            while(itr.hasNext())
            {
                System.out.println(itr.next());
            }

            float promedio = (float) (suma / num);

            Collections.sort(diametros);
            System.out.println("\n");
            System.out.println("Los diametros ordenados son: ");
        
            Iterator<Integer> its = diametros.iterator();
            while(its.hasNext())
            {
                System.out.println(its.next());
            }
            System.out.print("\n");
            System.out.println("El promedio es: " + promedio);
        }
    }

    public void validarDiametro(int diametro)
    {
        
    }
}
