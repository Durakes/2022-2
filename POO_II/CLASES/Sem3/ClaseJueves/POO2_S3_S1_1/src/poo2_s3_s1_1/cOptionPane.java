package poo2_s3_s1_1;
import javax.swing.*;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class cOptionPane extends WindowAdapter
{
    JFrame frame;

    public cOptionPane()
    {
        frame = new JFrame("Ejemplo de OptionPane");
        /*String nombre;
        
        nombre = JOptionPane.showInputDialog(frame, "Ingresa tu nombre: ");

        String mensaje = "Hola, bienvenido: " + nombre;
        JOptionPane.showMessageDialog(frame, mensaje,"Saludo", JOptionPane.WARNING_MESSAGE);*/

        frame.addWindowListener(this);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public void windowClosing(WindowEvent e)
    {
        int valor = JOptionPane.showConfirmDialog(frame, "Estas seguro que quieres salir: ");

        if(valor == JOptionPane.YES_OPTION)
        {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
