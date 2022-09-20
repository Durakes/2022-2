package e2_pc2_poo2;

import java.util.ArrayList;

/*
Integrantes:
    Pajuelo Araujo, Arnold
    Toche Sanchez, Jacqueline Yvette
*/

public class Calcular2
{
    int menos40;
    int entre40y50;
    int entre50y60;
    int mas60;

    String mensaje;

    public Calcular2(ArrayList<Integer> pesos)
    {
        for(int i = 0; i < pesos.size(); i++)
        {
            if(pesos.get(i) < 40)
            {
                menos40++;
            }else if(pesos.get(i) >= 40 && pesos.get(i) < 50)
            {
                entre40y50++;
            }else if(pesos.get(i) >= 50 && pesos.get(i) < 60)
            {
                entre50y60++;
            }else if(pesos.get(i) >= 60)
            {
                mas60++;
            }
        }

        mensaje = "Alumnos de menos de 40kg: " + menos40 + "\n"
                + "Alumnos entre 40kg y 50kg: " + entre40y50 + "\n"
                + "Alumnos entre 50kg y 60kg: " + entre50y60 + "\n"
                + "Alumnos de 60kg o mas: " + mas60 + "\n";
    }
}
