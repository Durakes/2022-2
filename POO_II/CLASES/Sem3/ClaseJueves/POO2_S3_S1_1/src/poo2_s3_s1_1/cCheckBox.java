package poo2_s3_s1_1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cCheckBox implements ActionListener
{
    JFrame frame;
    JCheckBox checkBox1, checkBox2, checkBox3;
    JButton button;
    JLabel label;


    public cCheckBox()
    {
        frame = new JFrame("Ejemplo de Checkbox");
        
        label = new JLabel("Ordena tu pedido");
        label.setBounds(50, 50, 300, 20);

        checkBox1 = new JCheckBox("Pizza -> 50");
        checkBox1.setBounds(100, 100, 150, 20);

        checkBox2 = new JCheckBox("Hamburguesa -> 30");
        checkBox2.setBounds(100, 150, 150, 20);

        checkBox3 = new JCheckBox("Gaseosa -> 10");
        checkBox3.setBounds(100, 200, 150, 20);
        
        button = new JButton("Ordena aquí");
        button.setBounds(100, 250, 80, 30);
        button.addActionListener(this); //Leaking this in constructor

        frame.add(label);
        frame.add(checkBox1);
        frame.add(checkBox2);
        frame.add(checkBox3);
        frame.add(button);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)  //Add @Override Annotation
    {
        try
        {
            double monto = 0;
            String opciones = "";

            if(checkBox1.isSelected())
            {
                monto += 50;
                opciones += "Pizza -> 50 \n";
            }

            if(checkBox2.isSelected())
            {
                monto += 30;
                opciones += "Hamburguesa -> 30 \n";
            }

            if(checkBox3.isSelected())
            {
                monto += 10;
                opciones += "Gaseosa -> 10 \n";
            }

            opciones += "------------------\n";
            String totAPagar = "Total a pagar es: " + monto;

            JOptionPane.showMessageDialog(frame, opciones + totAPagar, "Orden a Pagar", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e)
        {
            System.out.println("Error: " + e.toString());
        }
    }
}
