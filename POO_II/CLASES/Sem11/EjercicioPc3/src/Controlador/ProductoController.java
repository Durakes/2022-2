package Controlador;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Vista.VistaListado;
import Vista.VistaProducto;
import Vista.VistaEditar;
import Modelo.Producto;

public class ProductoController implements ActionListener
{
    private VistaProducto vistaProd;
    private VistaListado vistaList;
    private VistaEditar vEditar;
    private RandomAccessFile archivoProd;
    private Producto producto;
    private ArrayList<Producto> productos = new ArrayList<>();
    
    public ProductoController()
    {
        this.vistaProd = new VistaProducto();

        vistaProd.buttonAgregar.addActionListener(this);
        vistaProd.buttonListar.addActionListener(this);
        vistaProd.buttonBuscar.addActionListener(this);
        
        try
        {
            archivoProd = new RandomAccessFile("productos.txt","rw");
            cargarDatosArray();
        }catch (Exception e)
        {
            System.out.println("error:"+e.toString());
        }
    }
    
    public int getCodProducto() {return producto.getCodProducto();}
    public void setCodProducto(int codigo) { producto.setCodProducto(codigo);}

    public String getCategoriaProducto() {return producto.getNombreProducto();}
    public void setCategoriaProducto(String catProducto) {producto.setNombreProducto(catProducto);}

    public String getNombreProducto() {return producto.getNombreProducto();}
    public void setNombreProducto(String nomProducto) {producto.setNombreProducto(nomProducto);}

    public double getPrecioProducto() {return producto.getPrecioProducto();}
    public void setPrecioProducto(double precioProducto) {producto.setPrecioProducto(precioProducto);}

    public double getCostoProducto() {return producto.getCostoProducto();}
    public void setCostoProducto(double costoProducto) { producto.setCostoProducto(costoProducto);}

    public int getStockProducto() {return producto.getCodProducto();}
    public void setStockProducto(int stock) {producto.setCodProducto(stock);}

    public String getDescripcionProducto() {return producto.getDescripcion();}
    public void setDescripcionProducto(String descripcion) {producto.setDescripcion(descripcion);}

    public void actualizarArchivo()
    {
        try
        {
            FileWriter fw = new FileWriter("productos.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for(Producto producto:productos)
            {
                String registro = producto.getCodProducto()+";"+producto.getCategoriaProducto()+";"+producto.getNombreProducto()+";"+producto.getPrecioProducto()+";"+producto.getCostoProducto()+";"+producto.getStockProducto()+";"+producto.getDescripcion();
                pw.println(registro);
            }
            pw.close();
        }catch (Exception e)
        {
            System.out.println("error:"+e.toString());
        }
        
    }
    public void agregarRegistro(Producto producto)
    {
        try
        {
            FileWriter fw = new FileWriter("productos.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            productos.add(producto);
            String registro = producto.getCodProducto()+";"+producto.getCategoriaProducto()+";"+producto.getNombreProducto()+";"+producto.getPrecioProducto()+";"+producto.getCostoProducto()+";"+producto.getStockProducto()+";"+producto.getDescripcion();
            pw.append(registro + "\n");
            pw.close();
            
        }catch(Exception e)
        {
            System.out.println("error:"+e.toString());
        }
    }

    public Producto obtenerProducto(int codigo)
    {
        for (int i = 0; i < productos.size(); i++) 
        {
            if (codigo == productos.get(i).getCodProducto())
            {
                return productos.get(i);
            }
        }
        return null;
    }
    
    public void modificarRegistro(Producto objMod)
    {
        for (int i = 0; i < productos.size(); i++) 
        {
            if (objMod.getCodProducto() == productos.get(i).getCodProducto()) 
            {
                productos.get(i).setCodProducto(objMod.getCodProducto());
                productos.get(i).setCategoriaProducto(objMod.getCategoriaProducto());
                productos.get(i).setNombreProducto(objMod.getNombreProducto());
                productos.get(i).setPrecioProducto(objMod.getPrecioProducto());
                productos.get(i).setCostoProducto(objMod.getCostoProducto());
                productos.get(i).setStockProducto(objMod.getStockProducto());
                productos.get(i).setDescripcion(objMod.getDescripcion());
                break;
            }
        }
        actualizarArchivo();
    }
    
    public ArrayList<Producto> busquedaProducto(String nombre)
    {
        ArrayList<Producto> productosResul = new ArrayList<>();

        for (int i = 0; i < productos.size(); i++) 
        {
            if (nombre.equals(productos.get(i).getNombreProducto())) 
            {
                productosResul.add(productos.get(i));
            }
        }
        return productosResul;
    }
    
    public void eliminarRegistro(int codigo)
    {
        int index = 0;
        for(Producto producto:productos)
        {
                if(codigo == producto.getCodProducto())
                {
                    index = productos.indexOf(producto);
                }
        }
        productos.remove(index);
        actualizarArchivo();
    }
    
    public Object[][] obtenerDatos()
    {

        Object datos[][] = new Object[productos.size()][7];
        if(productos.size()!=0)
        {
            try 
            {
                for(int i = 0; i < productos.size(); i++)
                {
                    datos[i][0] = productos.get(i).getCodProducto();
                    datos[i][1] = productos.get(i).getCategoriaProducto();
                    datos[i][2] = productos.get(i).getNombreProducto();
                    datos[i][3] = productos.get(i).getPrecioProducto();
                    datos[i][4] = productos.get(i).getCostoProducto();
                    datos[i][5] = productos.get(i).getStockProducto();
                    datos[i][6] = productos.get(i).getDescripcion();
                }
            } 
            catch (Exception e) 
            {
                System.out.println("error obtenerDat:"+e.toString());
            }
        }
        return datos;
    }
    
    public void cargarDatosArray()
    {
        try 
        {
            int codigo,stock;
            String categoria, nombre, descripcion;
            double precio,costo;
            BufferedReader br = new BufferedReader(new FileReader("productos.txt"));
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] temporal = new String[7];
                temporal = line.split(";");
                codigo = Integer.parseInt(temporal[0]);
                categoria = temporal[1];
                nombre = temporal[2];
                precio = Double.parseDouble(temporal[3]);
                costo = Double.parseDouble(temporal[4]);
                stock = Integer.parseInt(temporal[5]);
                descripcion = temporal[6];
                
                Producto producto = new Producto(codigo,categoria,nombre,precio,costo,stock, descripcion);
                productos.add(producto);
            }
            br.close();
        } 
        catch (Exception e) 
        {
            System.out.println("error cargarDat:"+e.toString());
        }
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == vistaProd.buttonAgregar)
        {
            int codigo = Integer.parseInt(vistaProd.textCodigo.getText());
            String categoria = vistaProd.comboCategoria.getSelectedItem().toString();
            String nombre = vistaProd.textNombre.getText();
            double precio = Double.parseDouble(vistaProd.textPrecio.getText());
            double costo = Double.parseDouble(vistaProd.textCosto.getText());
            int stock = Integer.parseInt(vistaProd.textStock.getText());
            String descripcion = vistaProd.textDescr.getText();

            Producto producto = new Producto(codigo, categoria, nombre, precio, costo, stock, descripcion);

            agregarRegistro(producto);

            vistaProd.textCodigo.setText("");
            vistaProd.textNombre.setText("");
            vistaProd.textPrecio.setText("");
            vistaProd.textCosto.setText("");
            vistaProd.textStock.setText("");
            vistaProd.textDescr.setText("");

            JOptionPane.showMessageDialog(null, "Se realizo el registro correctamente","Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
        }else if(event.getSource() == vistaProd.buttonBuscar)
        {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre a buscar");

            ArrayList<Producto> resultados = busquedaProducto(nombre);

            if(resultados.size() > 0)
            {
                String mensaje = "Los productos encontrados son:\n";

                for(int i = 0; i < resultados.size(); i++)
                {
                    mensaje += "Nombre: " + resultados.get(i).getNombreProducto() + "\n" +
                                "Categoria: " + resultados.get(i).getCategoriaProducto() + "\n" +
                                "Stock: " +resultados.get(i).getStockProducto() + "\n \n";
                }

                JOptionPane.showMessageDialog(null, mensaje,"Resultados", JOptionPane.INFORMATION_MESSAGE);
            }else
            {
                String mensaje = "No hay resultados";

                JOptionPane.showMessageDialog(null, mensaje,"Resultados", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(event.getSource() == vistaProd.buttonListar)
        {

            vistaList = new VistaListado();
            String cabecera[] = {"Codigo","Categoria","Nombre","Precio","Costo","Stock","Descripcion"};

            vistaList.modeloBusqueda.setDataVector(obtenerDatos(), cabecera);
            vistaList.tableBusqueda.setModel(vistaList.modeloBusqueda);

            vistaList.buttonEditar.addActionListener(this);
            vistaList.buttonEliminar.addActionListener(this);
            vistaList.buttonAtras.addActionListener(this);
        }else if(event.getSource() == vistaList.buttonAtras)
        {
            vistaList.frame.dispose();
        }else if(event.getSource() == vistaList.buttonEliminar)
        {
            String cabecera[] = {"Codigo","Categoria","Nombre","Precio","Costo","Stock","Descripcion"};
            String codigo = JOptionPane.showInputDialog(null, "Ingrese el codigo del producto que desea eliminar", "Eliminar", JOptionPane.WARNING_MESSAGE);

            eliminarRegistro(Integer.parseInt(codigo));
            JOptionPane.showMessageDialog(null, "El registro se eliminó","Advertencia",JOptionPane.WARNING_MESSAGE);
            vistaList.modeloBusqueda.setDataVector(obtenerDatos(), cabecera);
        }else if(event.getSource() == vistaList.buttonEditar)
        {
            String codigo = JOptionPane.showInputDialog(null, "Ingrese el codigo del producto que desea modificar", "Modificar", JOptionPane.QUESTION_MESSAGE);

            Producto objModificar = obtenerProducto(Integer.parseInt(codigo));

            vEditar = new VistaEditar();

            vEditar.textCodigo.setText(String.valueOf(objModificar.getCodProducto()));
            vEditar.comboCategoria.setSelectedItem(objModificar.getCategoriaProducto());
            vEditar.textNombre.setText(objModificar.getNombreProducto());
            vEditar.textPrecio.setText(String.valueOf(objModificar.getPrecioProducto()));
            vEditar.textCosto.setText(String.valueOf(objModificar.getCostoProducto()));
            vEditar.textStock.setText(String.valueOf(objModificar.getStockProducto()));
            vEditar.textDescr.setText(objModificar.getDescripcion());

            vEditar.buttonGuardar.addActionListener(this);
        }else if(event.getSource() == vEditar.buttonGuardar)
        {
            int codigo = Integer.parseInt(vEditar.textCodigo.getText());
            String categoria = vEditar.comboCategoria.getSelectedItem().toString();
            String nombre = vEditar.textNombre.getText();
            double precio = Double.parseDouble(vEditar.textPrecio.getText());
            double costo = Double.parseDouble(vEditar.textCosto.getText());
            int stock = Integer.parseInt(vEditar.textStock.getText());
            String descripcion = vEditar.textDescr.getText();

            Producto tempProducto = new Producto(codigo, categoria, nombre, precio, costo, stock, descripcion);

            modificarRegistro(tempProducto);

            String cabecera[] = {"Codigo","Categoria","Nombre","Precio","Costo","Stock","Descripcion"};

            vistaList.modeloBusqueda.setDataVector(obtenerDatos(), cabecera);

            vEditar.frame.dispose();
        }
    }

}
