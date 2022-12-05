package com.mycompany.s10_2_mvc;

import Modelo.Productos;
import Controlador.ProductoControlador;
import Vista.ProductosVista;

public class S10_2_mvc {

    public static void main(String[] args) {
        Productos modelo = DatosProductos();
        ProductosVista vista = new ProductosVista();
        ProductoControlador controlador = new ProductoControlador(vista, modelo);
        
        controlador.mostrarVista();
        
    }
    
    private static Productos DatosProductos()
    {
        Productos prod = new Productos();
        prod.setNombreProducto("Tablet");
        prod.setCodProductos("AG111");
        prod.setPrecioProductos(250.50);
        
        return prod;
    }
}
