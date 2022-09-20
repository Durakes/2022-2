/*
Escriba un programa en Java, que permita calcular el promedio final de los N alumnos que
contiene una sección si se sabe que el promedio de cada alumno se obtiene de la siguiente
forma:
 55% del Examen Final
 30% de Examen Parcial
 15% del Trabajo final
Por último hallar el promedio de los N alumnos ingresados.
 */
package poo2_p1_tochejacqueline_1;


import java.util.ArrayList;
/*
Integrantes:
Pajuelo Araujo Arnold
Toche Sanchez Jacqueline Yvette
 */
public class Logica {
    
    ArrayList<Integer> notasEF;
    ArrayList<Integer> notasEP;
    ArrayList<Integer> notasTF;
    ArrayList<Double> promedios = new ArrayList<Double>();
    
    public Logica(ArrayList<Integer> notasEF, ArrayList<Integer> notasEP, ArrayList<Integer> notasTF) {
        this.notasEF = notasEF;
        this.notasEP = notasEP;
        this.notasTF = notasTF;
    }

    public double getPromIndividual(int index)
    {
        double prom=0.0;
        
        prom = 0.55*notasEF.get(index) + 0.3*notasEP.get(index) + 0.15*notasTF.get(index);
        
        promedios.add(prom);
        return prom;
    }
    public double getPromTotal()
    {
        double acumulado = 0.0;
        double promTot = 0.0;
        for(int i = 0; i<promedios.size();i++)
        {
            acumulado += promedios.get(i);
        }
        promTot = acumulado/promedios.size();
        return promTot;
    }
    
    
    
    
}
