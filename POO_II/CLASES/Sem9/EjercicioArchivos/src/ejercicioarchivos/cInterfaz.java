package ejercicioarchivos;

import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class cInterfaz implements ActionListener
{
    JFrame frame;
    JLabel label;
    JTextField textNumber;
    JButton buttonMostrar;
    JTextArea textResult;
    ArrayList<String> numeros = new ArrayList<>();

    public cInterfaz()
    {
        frame = new JFrame();

        label = new JLabel("Ingrese los numeros");
        label.setBounds(20, 50, 200, 20);

        textNumber = new JTextField();
        textNumber.setBounds(20, 70, 200, 20);
        textNumber.addActionListener(this);

        buttonMostrar = new JButton("Mostrar");
        buttonMostrar.setBounds(20, 100, 100,20);
        buttonMostrar.addActionListener(this);

        textResult = new JTextArea();
        textResult.setBounds(20, 130, 120,120);


        frame.add(buttonMostrar);
        frame.add(textResult);
        frame.add(label);
        frame.add(textNumber);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent event)
    {
            if(event.getSource() == textNumber)
            {
                try
                {
                    FileWriter fw = new FileWriter("numeros.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw);

                    String linea = textNumber.getText();
                    
                    out.append(linea + "\n");
                    bw.close();

                    textNumber.setText("");

                }catch(IOException ext)
                {
                    System.out.println("Error: " + ext.getMessage());
                }
            }else if(event.getSource() == buttonMostrar)
            {
                try
                {
                    FileReader fr = new FileReader("numeros.txt");
                    BufferedReader br = new BufferedReader(fr);
                    
                    String linea;
                    numeros.clear();
                    while((linea = br.readLine()) != null)
                    {
                        numeros.add(linea);
                    }
                    br.close();

                }catch(IOException ext)
                {
                    System.out.println("Error: " + ext.getMessage());
                }

                String mensaje="";
                textResult.setText("");

                for(String numero:numeros)
                {
                    mensaje+=numero + "\n";
                }
                textResult.setText(mensaje);

            }
    }
}
