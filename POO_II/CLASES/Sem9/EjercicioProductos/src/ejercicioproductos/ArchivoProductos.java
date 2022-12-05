package ejercicioproductos;
import java.io.*;
import javax.swing.*;


public class ArchivoProductos
{
    RandomAccessFile fProductos;
    String nombreArchivo;

    public ArchivoProductos(String nombre)
    {
        nombreArchivo = nombre;
        File f = new File(nombreArchivo);
        if(!f.exists())
        {
            try
            {
                fProductos = new RandomAccessFile(nombreArchivo, "rw");
                fProductos.close();
            } catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }

    public void escribirRegistro(Producto producto)
    {
        String codigo = producto.codigo;
        String descripcion = producto.descripcion;
        double precio = producto.precio;
        int stock = producto.stock;

        if(codigo.length() < 10)
        {
            for(int i = codigo.length(); i < 10; i++)
            {
                codigo = codigo + " ";
            }
        }else
        {
            codigo = codigo.substring(0, 10);
        }

        if(descripcion.length() < 50)
        {
            for(int i = descripcion.length(); i < 50; i++)
            {
                descripcion = descripcion+ " ";
            }
        }else
        {
            descripcion = descripcion.substring(0, 50);
        }

        try
        {
            fProductos.writeChars(codigo);
            fProductos.writeChars(descripcion);
            fProductos.writeDouble(precio);
            fProductos.writeInt(stock);
        }catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public Producto leerRegistro()
    {
        String codigo,descripcion;
        double precio;
        int stock;
        Producto producto = null;

        try
        {
            codigo = "";
            for(int i = 0; i < 10; ++i)
            {
                codigo += fProductos.readChar();
            }
            descripcion = "";
            for(int i = 0; i< 50; ++i)
            {
                descripcion += fProductos.readChar();
            }

            precio = fProductos.readDouble();
            stock = fProductos.readInt();
            producto = new Producto(codigo, descripcion, precio, stock);

        }catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return producto;
    }

    public int tamanoRegistro()
    {
        return 132;
    }

    public void agregar(Producto producto)
    {
        try
        {
            fProductos = new RandomAccessFile(nombreArchivo, "rw");
            fProductos.seek(fProductos.length());
            escribirRegistro(producto);
            fProductos.close();
        }catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public int numRegistros()
    {
        long total = 0;
        try
        {
            fProductos = new RandomAccessFile(nombreArchivo, "rw");
            fProductos.seek(fProductos.length());
            total = fProductos.getFilePointer();
            fProductos.close();
        }catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return (int) (total/tamanoRegistro());
    }

    public Object[][] obtenerDatos()
    {
        int n = numRegistros();
        Object datos[][] = new Object[n][5];

        try
        {
            fProductos = new RandomAccessFile(nombreArchivo, "r");
            fProductos.seek(0);
            int i = 0;
            while(fProductos.getFilePointer() < fProductos.length())
            {
                Producto producto = leerRegistro();
                datos[i][0] = producto.codigo;
                datos[i][1] = producto.descripcion;
                datos[i][2] = producto.precio;
                datos[i][3] = producto.stock;
                i++;
            }

            fProductos.close();
        }catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return datos;
    }

    public long buscarProducto(String codigo)
    {
        long pos,x=-1;
        try
        {
            fProductos = new RandomAccessFile(nombreArchivo, "r");
            fProductos.seek(0);

            pos = fProductos.getFilePointer();
            while(fProductos.getFilePointer() < fProductos.length())
            {
                Producto producto = leerRegistro();
                if(producto.codigo.trim().compareToIgnoreCase(codigo.trim()) == 0)
                {
                    x = pos;
                    break;
                }
                pos = fProductos.getFilePointer();
            }
            fProductos.close();
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return x;
    }

    public Producto devolverProducto(long pos)
    {
        Producto producto = null;
        try
        {
            fProductos = new RandomAccessFile(nombreArchivo, "rw");
            fProductos.seek(pos);
            producto = leerRegistro();
            fProductos.close();

        }catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return producto;
    }

    public void modificaRegistro(long pos, String codigo, String descripcion, double precio, int stock)
    {
        try
        {
            fProductos = new RandomAccessFile(nombreArchivo, "rw");
            fProductos.seek(pos);
            Producto producto = new Producto(codigo, descripcion, precio, stock);
            escribirRegistro(producto);
            fProductos.close();
        }catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public boolean eliminaRegistro(String codigo)
    {
        boolean exito = false;
        try
        {
            fProductos = new RandomAccessFile(nombreArchivo, "r");
            ArchivoProductos auxiliar = new ArchivoProductos("auxiliar.txt");
            fProductos.seek(0);

            while(fProductos.getFilePointer() < fProductos.length())
            {
                Producto producto = leerRegistro();
                if(producto.codigo.trim().compareToIgnoreCase(codigo.trim()) != 0)
                {
                    auxiliar.agregar(producto);
                }else
                {
                    exito = true;
                }
            }

            fProductos.close();
            File archivo = new File(nombreArchivo);
            archivo.delete();
            File archivoaux = new File("auxiliar.txt");
            archivoaux.renameTo(archivo);
        }catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return exito;
    }


}
