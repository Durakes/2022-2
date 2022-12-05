package Modelo;

public class Productos
{
    //declarando variables
    private String nombreProducto;
    private String codProductos;
    private double precioProductos;

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the codProductos
     */
    public String getCodProductos() {
        return codProductos;
    }

    /**
     * @param codProductos the codProductos to set
     */
    public void setCodProductos(String codProductos) {
        this.codProductos = codProductos;
    }

    /**
     * @return the precioProductos
     */
    public Double getPrecioProductos() {
        return precioProductos;
    }

    /**
     * @param precioProductos the precioProductos to set
     */
    public void setPrecioProductos(Double precioProductos) {
        this.precioProductos = precioProductos;
    }
    
    
}
