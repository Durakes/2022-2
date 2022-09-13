package e2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Interfaz
{
    JFrame frame;
    JButton button;
    JLabel edadLabel, nacionalidadLabel;
    JTextField edadField;
    JComboBox<Object> nacionalidadBox;


    public Interfaz()
    {
        frame = new JFrame("Guia 1 - Ejemplo 2");

        edadLabel = new JLabel("Ingrese su edad");
        edadLabel.setBounds(30, 30, 100, 20);

        nacionalidadLabel = new JLabel("Seleccione su nacionalidad");
        nacionalidadLabel.setBounds(30, 80, 250, 20);

        edadField = new JTextField();
        edadField.setBounds(250, 30, 100, 20);

        nacionalidadBox = new JComboBox<>();
        nacionalidadBox.setBounds(250, 80, 100, 20);

        frame.add(edadLabel);
        frame.add(nacionalidadLabel);
        frame.add(edadField);
        frame.add(nacionalidadBox);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
