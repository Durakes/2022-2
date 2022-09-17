package s5_s1_ejercicios;

public class logica
{
    String mensaje;
    
    public logica(String mensaje)
    {
        this.mensaje = mensaje;
    }

    public int caracteres()
    {
        int car = this.mensaje.length();
        return car;
    }

    public int palabras()
    {
        String[] palabras = mensaje.split("\\s");
        int cPalabras = palabras.length;
        return cPalabras; 
    }
}
