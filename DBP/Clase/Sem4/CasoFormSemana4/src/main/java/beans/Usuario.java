package beans;
public class Usuario
{
    private String cod;    
    private String nom;
    private String dni;
    private int edad;

    public Usuario()
    {

    }

    public Usuario(String cod, String nom, String dni, int edad)
    {
        this.cod = cod;
        this.nom = nom;
        this.dni = dni;
        this.edad = edad;
    }

    public String getCod() {return cod;}
    public void setCod(String cod) {this.cod = cod;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public String getDni() {return dni;}
    public void setDni(String dni) {this.dni = dni;}

    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

    public String getEstado()
    {
        if(edad >= 0 && edad <= 11)
        {
            return "Soy un niño";
        }else if(edad >= 12 && edad <= 17)
        {
            return "Soy un adolescente";
        }else if(edad >= 18 && edad <= 25)
        {
            return "Soy un joven";
        }else if(edad >= 26 && edad <= 54)
        {
            return "Soy un adulto";
        }else
        {
            return "Soy un anciano";
        }
    }

}
