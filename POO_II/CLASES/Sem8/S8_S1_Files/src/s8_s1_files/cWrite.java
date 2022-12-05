package s8_s1_files;
import java.io.*;

public class cWrite
{
    public cWrite()
    {
        try
        {
            FileWriter fw = new FileWriter("alumno.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Hola, tengo hambre");
            pw.println("Padoru Padoru");
            pw.println("Ana <3");
            pw.close();
        }catch(IOException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        
    }
}
 