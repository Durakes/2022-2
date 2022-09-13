package beans;

public class Persona
{
    private String codigo;
    private String nombrePersona;
    private String direccion;
    private String dni;

    public Persona() {}

    public Persona(String codigo,  String nombre, String direccion, String dni)
    {
        this.codigo = codigo;
        this.nombrePersona = nombre;
        this.direccion = direccion;
        this.dni = dni;
    }

    
}
