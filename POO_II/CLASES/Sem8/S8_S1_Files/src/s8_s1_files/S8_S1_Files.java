package s8_s1_files;
import java.util.*;
import java.io.*;


public class S8_S1_Files
{
    public static void main(String[] args)
    {
        Scanner entrada =   new Scanner(System.in);
        String nombre;
        System.out.print("Nombre del archivo: ");
        nombre = entrada.nextLine();
        File archivo = new File(nombre);

        cWrite cw = new cWrite();
        cReader cd = new cReader();

        if(archivo.exists() && archivo.isFile())
        {
            System.out.println("Nombre: " + archivo.getName());
            System.out.println("Ruta Absoluta: " + archivo.getAbsolutePath());
            System.out.println("¿Admmite lectura?: " + archivo.canRead());
            System.out.println("¿Admite escritura?: " + archivo.canWrite());
            System.out.println("Tamaño en bytes: " + archivo.length());
            System.out.println("Fecha de ultima modificacion: " + new Date(archivo.lastModified()));
        }else
        {
            System.out.println("No existe el archivo en esa ruta");
        }
    }
    
}
