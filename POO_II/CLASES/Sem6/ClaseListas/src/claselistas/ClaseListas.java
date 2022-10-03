package claselistas;
public class ClaseListas {
    public static void main(String[] args)
    {
        //Creando el ArrayList
        /*ArrayList<String> semana = new ArrayList<String>(); 
        
        semana.add("Lunes");
        semana.add("Martes");
        semana.add("Miercoles");
        semana.add("Jueves");
        semana.add("Viernes");
        semana.add("Sábado");
        semana.add("Domingo");

        Iterator itr = semana.iterator();
        
        while(itr.hasNext())
        {
            System.out.println("El dia de la semana es: "+itr.next());
        }*/
        
        //Creando LinkedList
        /*LinkedList<String> meses = new LinkedList();
        
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");
        meses.add("Mayo");
        meses.add("Junio");
        meses.add("Julio");
        meses.add("Septiembre");
        meses.add("Octubre");
        meses.add("Noviembre");
        meses.add("Diciembre");
        
        Iterator<String> itrMeses = meses.iterator();
        
        while(itrMeses.hasNext())
        {
                System.out.println("El mes del año es: "+itrMeses.next());
        }*/
        
        //Creando un vector
        /*Vector<String> meses = new Vector();
        
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");
        meses.add("Mayo");
        meses.add("Junio");
        meses.add("Julio");
        meses.add("Septiembre");
        meses.add("Octubre");
        meses.add("Noviembre");
        meses.add("Diciembre");
        
        Iterator<String> itrMeses = meses.iterator();
        
        while(itrMeses.hasNext())
        {
                System.out.println("El mes del año es: "+itrMeses.next());
        }*/
        
        //Stack
        
        /*Stack<Integer> numeros = new Stack<>();
        
        numeros.push(1);
        numeros.push(2);
        numeros.push(3);
        numeros.push(4);
        numeros.push(5);
        
        numeros.pop();
        numeros.pop();
        
        Iterator<Integer> itrNum = numeros.iterator(); //si hago un pop dsp del iterator aparecen errores, pq cambio el stack
        
        while(itrNum.hasNext())
        {
            System.out.println("El numero es: "+itrNum.next().toString());
            
        }*/
        
        cArrayList c = new cArrayList();

    }
    
}
