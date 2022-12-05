package s8_s1_files;
import java.io.*;

public class cReader
{
    public cReader()
    {
        try
        {
            FileReader fr = new FileReader("alumno.txt");
            BufferedReader br = new BufferedReader(fr);
            
            /*String linea;
            while((linea = br.readLine()) != null)
            {
                System.out.println(linea);
            }
            br.close();*/

            int codigo;
            char caracter;
            codigo = br.read();

            while(codigo != -1)
            {
                caracter = (char) codigo;
                System.out.println(caracter);
                codigo = br.read();
            }

            br.close();

        }catch(IOException ext)
        {
            System.out.println("Error: " + ext.getMessage());
        }
    }
}
