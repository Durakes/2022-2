package s5_s1_ejercicios;
import javax.swing.*;

public class contarCaracteres
{
    JFrame frame;
    JLabel label1, label2;
    JTextArea textArea;
    JButton buttonContar, buttonColor;

    public contarCaracteres()
    {
        frame = new JFrame();

        label1 = new JLabel("Caracteres: ");
        label1.setBounds(50, 30, 200, 20);

        label2 = new JLabel("Palabras: ");
        label2.setBounds(50,70,200,20);

        textArea = new JTextArea();
        textArea.setBounds(80, 120, 200, 80);

        buttonContar = new JButton("Contar");
        buttonContar.setBounds(50, 220, 100, 20);
        

        buttonColor = new JButton("Color");
        buttonColor.setBounds(200, 220, 100, 20);

        frame.add(label1);
        frame.add(label2);
        frame.add(textArea);
        frame.add(buttonContar);
        frame.add(buttonColor);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
