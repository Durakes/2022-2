package e2_pc2_poo2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfaz2 implements ActionListener
{
    JFrame frame;
    JLabel labelTitulo, labelNumero, labelPeso;
    JTextField numField, pesoField;
    JTextArea result;
    JButton buttonFinal;
    ArrayList<Integer> pesos = new ArrayList<Integer>();

    int numeroAlumnos = 0;
    int index = 1;

    public Interfaz2()
    {
        frame = new JFrame("Ejercicio 2");

        labelTitulo = new JLabel("Estadística Pesos");
        labelTitulo.setBounds(150, 20, 200, 20);

        labelNumero = new JLabel("Ingrese la cantidad de alumnos");
        labelNumero.setBounds(20, 60, 200, 20);

        labelPeso = new JLabel("Ingrese el peso individual de cada alumno");
        labelPeso.setBounds(20, 100, 450, 20);

        numField = new JTextField();
        numField.setBounds(300, 60, 100, 20);
        numField.addActionListener(this);

        pesoField = new JTextField();
        pesoField.setBounds(300, 100, 100, 20);
        pesoField.addActionListener(this);

        result = new JTextArea();
        result.setBounds(100, 150, 250, 100);

        buttonFinal = new JButton("Procesar");
        buttonFinal.setBounds(200, 300, 100, 20);
        buttonFinal.addActionListener(this);

        frame.add(numField);
        frame.add(pesoField);
        frame.add(result);
        frame.add(labelTitulo);
        frame.add(labelNumero);
        frame.add(labelPeso);
        frame.add(buttonFinal);

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        try
        {
            if(event.getSource() == numField)
            {
                numeroAlumnos = Integer.parseInt(numField.getText());
                numField.setEnabled(false);
                labelPeso.setText("Ingrese el peso del alumno 1: ");
            }else if(event.getSource() == pesoField)
            {
                pesos.add(Integer.parseInt(pesoField.getText()));
                pesoField.setText("");
                index++;
                labelPeso.setText("Ingrese el peso del alumno " + index + ": ");
                if(index == numeroAlumnos+1)
                {
                    pesoField.setEnabled(false);
                    labelPeso.setText("Ingrese el peso individual de cada alumno");
                    result.setText("Datos Completos \nClick en procesar para \nobtener resultados.");
                }
            }else if(event.getSource() == buttonFinal)
            {
                Calcular2 calculo = new Calcular2(pesos);
                result.setText("");
                result.setText(calculo.mensaje);
            }

        }catch (Exception exception)
        {
            System.out.println(exception.toString());
        }
    }


}
