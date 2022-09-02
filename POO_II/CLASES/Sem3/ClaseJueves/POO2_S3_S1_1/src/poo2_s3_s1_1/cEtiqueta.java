package poo2_s3_s1_1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cEtiqueta implements ActionListener
{
    JFrame frame;
    JTextField textField;
    JButton button;
    JLabel label;

    public cEtiqueta()
    {
        textField = new JTextField();
        textField.setBounds(50, 50, 150, 20); // posX, posY, x , y;

        label = new JLabel();
        label.setBounds(50, 100, 250, 20);

        button = new JButton("Busca IP");
        button.setBounds(50, 150, 95, 30);
        button.addActionListener(this);
        
        frame = new JFrame("Ejemplo Label");

        frame.add(textField);
        frame.add(label);
        frame.add(button);

        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        try 
        {
            String host = textField.getText();
            String ip = java.net.InetAddress.getByName(host).getHostAddress();
            String mensaje = "La IP de " + host + " es: " + ip;           
            
            label.setText(mensaje);

        } catch (Exception exception)
        {
            label.setText(exception.toString());
        }
    }
}
