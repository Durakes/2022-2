package poo2_s3_s1_1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cTextArea implements ActionListener
{
    JFrame frame;
    JLabel label1, label2;
    JButton button;
    JTextArea textArea;

    public cTextArea()
    {
        frame = new JFrame("Ejemplo de Text Area");

        label1 = new JLabel();
        label1.setBounds(50, 25, 100, 30);
        
        label2 = new JLabel();
        label2.setBounds(160, 25, 100, 30);

        textArea = new JTextArea();
        textArea.setBounds(20, 75, 250, 200);

        button = new JButton("Contar Palabras");
        button.setBounds(100, 300, 120, 30);
        button.addActionListener(this);

        frame.add(label1);
        frame.add(label2);
        frame.add(textArea);
        frame.add(button);

        frame.setSize(450, 450);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        String texto = textArea.getText();
        String palabras[] = texto.split("\\s");

        label1.setText("Palabras: " + palabras.length);
        label2.setText("Caracteres: " + texto.length());
    }
}
