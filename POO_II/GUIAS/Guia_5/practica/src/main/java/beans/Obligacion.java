package beans;

public class Obligacion
{
    private String codigo;
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    private String vencimiento;
    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    private Double montoObligacion;
    public Double getMontoObligacion() {
        return montoObligacion;
    }

    public void setMontoObligacion(Double montoObligacion) {
        this.montoObligacion = montoObligacion;
    }

    private String alumno;
    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Obligacion(String codigo, String vencimiento, Double montoObligacion, String alumno, String descripcion) {
        this.codigo = codigo;
        this.vencimiento = vencimiento;
        this.montoObligacion = montoObligacion;
        this.alumno = alumno;
        this.descripcion = descripcion;
    }

    public Obligacion(){}
}
