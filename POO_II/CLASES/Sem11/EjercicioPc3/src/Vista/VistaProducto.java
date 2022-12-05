package Vista;
import javax.swing.*;

public class VistaProducto
{
    JFrame frame;
    JLabel labelCodigo, labelCategoria, labelNombre, labelPrecio, labelCosto, labelStock, labelDescr;
    public JTextField textCodigo, textNombre, textPrecio, textCosto, textStock, textDescr;
    public JButton buttonAgregar, buttonBuscar, buttonListar;
    public JTable tblResults;
    public JScrollPane scrollPane;
    public JComboBox<String> comboCategoria;
    String categorias[] = {"Computadoras","Celulares","Software","Accesorios"};
    
    public VistaProducto()
    {
        frame = new JFrame();
        
        labelCodigo = new JLabel("Codigo:");
        labelCodigo.setBounds(130,20,100,20);
        
        labelCategoria = new JLabel("Categoría:");
        labelCategoria.setBounds(130,60,100,20);

        labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(130,100,100,20);
        
        labelPrecio = new JLabel("Precio:");
        labelPrecio.setBounds(130,140,100,20);
        
        labelCosto = new JLabel("Costo:");
        labelCosto.setBounds(130,180,100,20);
        
        labelStock = new JLabel("Stock:");
        labelStock.setBounds(130,220,100,20);
        
        labelDescr = new JLabel("Descripción:");
        labelDescr.setBounds(130,260,100,20);

        textCodigo = new JTextField();
        textCodigo.setBounds(210,20,100,20);
        
        comboCategoria = new JComboBox<>();
        for(int i = 0; i < 4; i++)
        {
            comboCategoria.addItem(categorias[i]);
        }
        comboCategoria.setBounds(210,60,100,20);
        
        textNombre = new JTextField();
        textNombre.setBounds(210,100,100,20);
        
        textPrecio = new JTextField();
        textPrecio.setBounds(210,140,100,20);
        
        textCosto = new JTextField();
        textCosto.setBounds(210,180,100,20);

        textStock = new JTextField();
        textStock.setBounds(210,220,100,20);

        textDescr = new JTextField();
        textDescr.setBounds(210,260,100,20);
        
        buttonBuscar = new JButton("Buscar");
        buttonBuscar.setBounds(80,310,100,20);

        buttonAgregar = new JButton("Agregar");
        buttonAgregar.setBounds(200,310,100,20);

        buttonListar = new JButton("Listar");
        buttonListar.setBounds(320,310,100,20);
        
        frame.add(labelCodigo);
        frame.add(labelCategoria);
        frame.add(labelNombre);
        frame.add(labelPrecio);
        frame.add(labelCosto);
        frame.add(labelStock);
        frame.add(labelDescr);
        frame.add(textCodigo);
        frame.add(comboCategoria);
        frame.add(textNombre);
        frame.add(textPrecio);
        frame.add(textCosto);
        frame.add(textStock);
        frame.add(textDescr);
        frame.add(buttonAgregar);
        frame.add(buttonListar);
        frame.add(buttonBuscar);
        
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
