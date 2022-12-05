package Controlador;

import Modelo.Productos;
import Vista.ProductosVista;

public class ProductoControlador
{
    private ProductosVista vista;
    private Productos modelo;
    
    public ProductoControlador(ProductosVista vista, Productos modelo)
    {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    //Generar getters y setters
    public void setNombreProducto(String nombreProducto)
    {
        modelo.setNombreProducto(nombreProducto);
    }
    
    public String getNombreProducto()
    {
        return modelo.getNombreProducto();
    }
    
    public void setCodigoProducto(String codigoProducto)
    {
        modelo.setNombreProducto(codigoProducto);
    }
    
    public String getCodigoProducto()
    {
        return modelo.getNombreProducto();
    }
    
    public void setPrecioProducto(double precioProducto)
    {
        modelo.setPrecioProductos(precioProducto);
    }
    
    public double getPrecioProducto()
    {
        return modelo.getPrecioProductos();
    }
    
    public void mostrarVista()
    {
        vista.verDetalleProductos(modelo.getNombreProducto(), modelo.getCodProductos(), modelo.getPrecioProductos());
    }
}
