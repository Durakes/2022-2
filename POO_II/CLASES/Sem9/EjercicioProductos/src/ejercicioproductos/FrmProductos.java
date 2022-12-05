package ejercicioproductos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmProductos extends javax.swing.JFrame
{
    ArchivoProductos archivoProductos = new ArchivoProductos("productos.txt");
    DefaultTableModel modelo = new DefaultTableModel();
    String titulos[] = {"CODIGO", "DESCRIPCION", "PRECIO", "STOCK"};

    public FrmProductos()
    {
        setLocation(300,100);
        modelo.setDataVector(archivoProductos.obtenerDatos(), titulos);
    }
}
