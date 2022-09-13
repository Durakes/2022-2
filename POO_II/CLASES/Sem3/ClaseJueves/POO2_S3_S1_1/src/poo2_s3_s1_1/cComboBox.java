package poo2_s3_s1_1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cComboBox implements ActionListener
{
    JFrame frame;
    JLabel label;
    JButton button;
    JComboBox<Object> comboBox;

    //String productos[];

    public cComboBox()
    {
        frame = new JFrame("Ejemplo de Combo Box");

        label = new JLabel();
        //label.setBounds(200, 100, 400, 100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400,100);


        button = new JButton("Opera");
        button.setBounds(200, 100, 75, 20);
        button.addActionListener(this);

        String productos[] = {"Pizza", "Hamburguesa", "Gaseosa"};

        comboBox = new JComboBox(productos); //Verificar error
        comboBox.setBounds(50, 100, 90, 20);
        
        frame.add(label);
        frame.add(button);
        frame.add(comboBox);

        frame.setSize(350, 350);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        try 
        {
            
            String mensaje = "El producto elegido es: " + comboBox.getSelectedItem();
            //mensaje += comboBox.getItemAt(comboBox.getSelectedIndex());

            label.setText(mensaje);

        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

}
