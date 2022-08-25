public class Estudiante
{
    int codigo;
    String nombre;
    String genero;
    int edad;

    public Estudiante(){}

    public Estudiante(int codigo, String nombre, String genero, int edad)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
    }

    void registraDatos(int codigo1, String nombre1, String genero1, int edad1)
    {
        codigo = codigo1;
        nombre = nombre1;
        genero = genero1;
        edad = edad1;
    }

    void muestraDatos()
    {
        System.out.println("Codidgo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Genero: " + genero);
        System.out.println("Edad: " + edad);
    }
}
