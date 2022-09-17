package ejcalc;
import javax.swing.*;

import org.w3c.dom.Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lCalculadora/*implements ActionListener*/
{
    JFrame frame;
    int i;
    JTextField result;
    JButton numButtons[] = new JButton[10];
    JButton operButtons[] = new JButton[4];
    String operator[] = {"+", "-", "*", "/"};
    JButton clearButton;
    JButton resultButton;

    int xNumber = 100;
    int yNumber = 120;

    int xOperator = 300;
    int yOperator = 120;

    public lCalculadora()
    {
        frame = new JFrame("Calculadora");
        for(i = 0; i < 10; i++)
        {
            final int final_i = i + 1;
            if(i!=9)
            {
                numButtons[i] = new JButton(String.valueOf(i+1));
                numButtons[i].setBounds(xNumber, yNumber, 45, 45);
                numButtons[i].addActionListener(e -> result.setText(result.getText() + String.valueOf(final_i)));
                frame.add(numButtons[i]);
                xNumber+=70;
            }else
            {
                numButtons[i] = new JButton(String.valueOf("0"));
                numButtons[i].setBounds(xNumber, yNumber, 45, 45);
                numButtons[i].addActionListener(e -> result.setText(result.getText() + "0"));
                frame.add(numButtons[i]);
            }
            
            if(i == 2 || i == 5)
            {
                xNumber = 100;
                yNumber+= 70;
            }else if(i == 8)
            {
                xNumber = 170;
                yNumber += 70;
            }
        }
        
        for(int i = 0; i < 4; i++)
        {
            final int final_i = i;

            operButtons[i] = new JButton(operator[i]);
            operButtons[i].setBounds(xOperator, yOperator, 45, 45);
            operButtons[i].addActionListener(e -> result.setText(result.getText() + String.valueOf(operator[final_i])));
            frame.add(operButtons[i]);
            yOperator+=70;
        }

        clearButton = new JButton("Limpiar");
        clearButton.setBounds(90, 330, 55, 45);    

        result = new JTextField();
        result.setBounds(100, 50, 195, 45);

        frame.add(clearButton);
        frame.add(result);
        frame.setSize(450, 450);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource() == numButtons[0])
            {
                result.setText(result.getText() + "1");
            }
            
        } catch (Exception exception)
        {
            System.out.println(exception.toString());
        }
    }*/

}
