package Modelo;

public class Producto
{
    private int codProducto;
    private String categoriaProducto;
    private String nombreProducto;
    private double precioProducto;
    private double costoProducto;
    private int stockProducto;
    private String descripcion;
    String cabecera[] = {"Codigo","Categoria","Nombre","Precio","Costo","Stock","Descripcion"};

    public Producto(int codProducto, String categoriaProducto, String nombreProducto, double precioProducto, double costoProducto, int stockProducto, String descripcion)
    {
        this.codProducto = codProducto;
        this.categoriaProducto = categoriaProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.costoProducto = costoProducto;
        this.stockProducto = stockProducto;
        this.descripcion = descripcion;
    }
    
    public int getCodProducto() {return codProducto;}
    public void setCodProducto(int codProducto) {this.codProducto = codProducto;}

    public String getCategoriaProducto() {return categoriaProducto;}
    public void setCategoriaProducto(String categoriaProducto) {this.categoriaProducto = categoriaProducto;}

    public String getNombreProducto() {return nombreProducto;}
    public void setNombreProducto(String nombreProducto) {this.nombreProducto = nombreProducto;}

    public double getPrecioProducto() {return precioProducto;}
    public void setPrecioProducto(double precioProducto) {this.precioProducto = precioProducto;}

    public double getCostoProducto() {return costoProducto;}
    public void setCostoProducto(double costoProducto) {this.costoProducto = costoProducto;}

    public int getStockProducto() {return stockProducto;}
    public void setStockProducto(int stockProducto) {this.stockProducto = stockProducto;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
}
