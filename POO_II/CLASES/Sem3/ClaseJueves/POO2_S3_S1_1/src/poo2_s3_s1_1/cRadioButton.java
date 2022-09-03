package poo2_s3_s1_1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class cRadioButton implements ActionListener
{
    JFrame frame; 
    JRadioButton radioButton1, radioButton2;
    ButtonGroup buttonGroup;
    JButton button;
    JLabel label;
    
    public cRadioButton()
    {
        frame = new JFrame("Ejemplo RadioButton");
        radioButton1 = new JRadioButton("Femenino");
        radioButton1.setBounds(100, 50, 100, 30);

        radioButton2 = new JRadioButton("Masculino");
        radioButton2.setBounds(100, 100, 100, 30);
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        button = new JButton("Mostrar");
        button.setBounds(100, 150, 80, 30);
        button.addActionListener(this);

        label = new JLabel();

        frame.add(radioButton1);
        frame.add(radioButton2);
        frame.add(button);
        frame.add(label);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        try 
        {
            if(radioButton1.isSelected())
            {
                JOptionPane.showMessageDialog(frame, "Femenino", "Genero", JOptionPane.ERROR_MESSAGE);
            }

            if(radioButton2.isSelected())
            {
                JOptionPane.showMessageDialog(frame, "Masculino", "Genero", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
