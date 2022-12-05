package Vista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VistaListado
{
    public JFrame frame;                
    public DefaultTableModel modeloBusqueda;
    public JTable tableBusqueda;
    public JButton buttonEditar, buttonEliminar, buttonAtras;
    JScrollPane scrollPane;

    JLabel labelTitulo;

    public VistaListado()
    {
        frame = new JFrame();
        modeloBusqueda = new DefaultTableModel();
        tableBusqueda = new JTable();
        
        scrollPane = new JScrollPane(tableBusqueda);
        scrollPane.setBounds(20,40,550,200);

        labelTitulo = new JLabel("Listado de Productos");
        labelTitulo.setBounds(220,10,200,20);

        buttonEditar = new JButton("Editar");
        buttonEditar.setBounds(90,270,100,20);

        buttonEliminar = new JButton("Eliminar");
        buttonEliminar.setBounds(240,270,100,20);

        buttonAtras = new JButton("Atras");
        buttonAtras.setBounds(390,270,100,20);
        
        frame.add(buttonEditar);
        frame.add(buttonEliminar);
        frame.add(buttonAtras);
        frame.add(scrollPane);
        frame.add(labelTitulo);

        frame.setSize(600,370);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
