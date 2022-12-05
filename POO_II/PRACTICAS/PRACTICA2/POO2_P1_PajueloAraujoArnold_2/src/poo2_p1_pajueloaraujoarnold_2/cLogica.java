package poo2_p1_pajueloaraujoarnold_2;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;


public class cLogica
{
    String respuestas[] = {"Menos de un año", "Entre 1 y 3 años", "Entre 4 y 8 años", "Mas de 8 años"};
    String satisfaccion[] = {"Excelente", "Muy bueno", "Bueno", "Regular", "Malo"};
    Random rand = new Random();
    ArrayList<Encuesta> listEncuestas = new ArrayList<>();

    void GenerarDatos(int numero)
    {
        for(int i = 0; i < numero; i++)
        {
            int randomRespuestas = rand.nextInt(4);
            int randomSatisfaccion = rand.nextInt(5);
            int edadRandom = (int)Math.floor(Math.random()*(60-18+1)+18);

            Encuesta encuesta = new Encuesta();
            encuesta.fechaCliente = respuestas[randomRespuestas];
            encuesta.satisfaccion = satisfaccion[randomSatisfaccion];
            encuesta.edad = edadRandom;

            listEncuestas.add(encuesta);
        }
    }

    double Porcentaje_4y8_malo(ArrayList<Encuesta> encuestas)
    {
        double totalEncuestas = encuestas.size();
        double index = 0;

        for(Encuesta x: encuestas)
        {
            if(x.fechaCliente == "Entre 4 y 8 años" && x.satisfaccion == "Malo")
            {
                index++;
            }
        }

        double porcentaje = index / totalEncuestas;

        return porcentaje;
    }

    double Promedio_edad(ArrayList<Encuesta> encuestas)
    {
        double sumaEdad = 0;
        double index = 0;

        for(Encuesta x: encuestas)
        {
            if(x.satisfaccion == "Excelente")
            {
                sumaEdad+= x.edad;
                index++;
            }
        }

        double promedio = sumaEdad / index;

        return promedio;
    }

    ArrayList<Integer> Listado_ordenado(ArrayList<Encuesta> encuestas)
    {

        ArrayList<Integer> edades = new ArrayList<>();

        for(Encuesta x: encuestas)
        {
            edades.add(x.edad);
        }

        Collections.sort(edades);

        return edades;
    }

} 
