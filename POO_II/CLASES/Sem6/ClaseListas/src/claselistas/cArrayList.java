package claselistas;
import java.util.*;

public class cArrayList {
    public cArrayList()
    {
        ArrayList<String> frutas = new ArrayList();
    
        frutas.add("Manzana");
        frutas.add("Plátano");
        frutas.add("Uva");
        frutas.add("Naranja");
        frutas.add("Mango");
        frutas.add("Arandano");
        

        for(String fruta : frutas)
        {
            System.out.println(fruta);            
        }
        System.out.println("Mostrando el 2do elemento (fruta): "+frutas.get(1));
        
        //Manipular el elemento
        frutas.set(1, "Fresa"); // cambio Plátano por Fresa
        System.out.println("Mostrando el 2do elemento (fruta): "+frutas.get(1));
        
        //Ordenar la lista
        Collections.sort(frutas);
        for(String fruta : frutas)
        {
            System.out.println(fruta);            
        }
        
        //Ordenar lista con numeros
        ArrayList<Integer> numeros = new ArrayList<>();
        
        numeros.add(1);
        numeros.add(5);
        numeros.add(-6);
        numeros.add(4);
        numeros.add(40);
        numeros.add(10);
        numeros.add(0);
        
        System.out.println(numeros);
        Collections.sort(numeros);
        System.out.println(numeros);

        //Recorriendo la lista de manera inversa
        ListIterator<String> lst = frutas.listIterator(frutas.size());
        System.out.println("Lista frutas inversa");
        while(lst.hasPrevious())
        {
            String miFruta = lst.previous();
            System.out.println(miFruta);
        }

        Alumno al1 = new Alumno(1001, "Carlos", 22);
        Alumno al2 = new Alumno(1002, "Pepe", 23);
        Alumno al3 = new Alumno(1003, "Ekaterina", 24);
        Alumno al4 = new Alumno(1004, "Roxana", 25);
        
        ArrayList<Alumno> lstAlumno = new ArrayList<>();

        lstAlumno.add(al1);
        lstAlumno.add(al2);
        lstAlumno.add(al3);
        lstAlumno.add(al4);

        Iterator itr = lstAlumno.iterator();

        while(itr.hasNext())
        {
            Alumno al = (Alumno)itr.next();
            System.out.println("El alumno se llama: " + al.nombre + " con código: " + al.codigo + " de edad: " + al.edad);
        } 

    }

}
