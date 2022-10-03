package beans;
public class Alumno
{
    private String codigo;
    private String paterno;
    private String materno;
    private String nombre;
    private String sexo;
    private String codModular;
    private String estadoCivil;
    private String correo;

    //List.rimub

    public Alumno(String codigo, String paterno, String materno, String nombre, String sexo, String codModular,String estadoCivil, String correo) {
        this.codigo = codigo;
        this.paterno = paterno;
        this.materno = materno;
        this.nombre = nombre;
        this.sexo = sexo;
        this.codModular = codModular;
        this.estadoCivil = estadoCivil;
        this.correo = correo;
    }

    public Alumno(){}

    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
    
    public String getPaterno() {return paterno;}
    public void setPaterno(String paterno) {this.paterno = paterno;}

    public String getMaterno() {return materno;}
    public void setMaterno(String materno) {this.materno = materno;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getSexo() {return sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}

    public String getCodModular() {return codModular;}
    public void setCodModular(String codModular) {this.codModular = codModular;}

    public String getEstadoCivil() {return estadoCivil;}
    public void setEstadoCivil(String estadoCivil) {this.estadoCivil = estadoCivil;}

    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
}
