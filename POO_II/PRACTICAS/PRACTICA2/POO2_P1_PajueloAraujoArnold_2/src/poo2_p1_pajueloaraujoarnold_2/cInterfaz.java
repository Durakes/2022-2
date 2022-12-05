package poo2_p1_pajueloaraujoarnold_2;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cInterfaz implements ActionListener
{
    JFrame frame;
    JTextField datosClientes;
    JButton buttonGenerarDatos, button4y8, buttonPromedioEdad, buttonListaOrdenado;

    ArrayList<Encuesta> encuestas = new ArrayList<>();
    public cInterfaz()
    {
        frame = new JFrame();

        datosClientes = new JTextField();
        datosClientes.setBounds(20, 20, 200, 20);

        buttonGenerarDatos = new JButton("Generar_Y_Mostrar");
        buttonGenerarDatos.setBounds(20, 50, 200, 20);
        buttonGenerarDatos.addActionListener(this);

        button4y8 = new JButton("Porcentaje_4y8_malo");
        button4y8.setBounds(20, 90, 200, 20);
        button4y8.addActionListener(this);

        buttonPromedioEdad = new JButton("Promedio_edad");
        buttonPromedioEdad.setBounds(20, 130, 200, 20);
        buttonPromedioEdad.addActionListener(this);

        buttonListaOrdenado = new JButton("Listado_ordenado");
        buttonListaOrdenado.setBounds(20, 170, 200, 20);
        buttonListaOrdenado.addActionListener(this);

        frame.add(datosClientes);
        frame.add(buttonGenerarDatos);
        frame.add(buttonPromedioEdad);
        frame.add(button4y8);
        frame.add(buttonListaOrdenado);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == buttonGenerarDatos)
        {
            cLogica logica = new cLogica();
            logica.GenerarDatos(Integer.parseInt(datosClientes.getText()));
            encuestas = logica.listEncuestas;

            JFrame frameListar = new JFrame();
            frameListar.setLocationRelativeTo(frame);

            JLabel labelListado = new JLabel("Datos generales");
            labelListado.setBounds(80, 15, 250, 20);

            JTextArea textList = new JTextArea();
            textList.setBounds(20, 40, 600, 200);

            JScrollPane scrollPane = new JScrollPane(textList);
            scrollPane.setBounds(20, 40, 600, 200);

            String mensaje1 = "Encuestas: \n";

            for(Encuesta encuesta: encuestas)
            {
                mensaje1 += encuesta.edad + "\t" + encuesta.fechaCliente + "\t" + encuesta.satisfaccion + "\n";
            }
            
            textList.setText(mensaje1);
            frameListar.getContentPane().add(scrollPane);

            frameListar.add(labelListado);
            frameListar.setSize(700, 300);
            frameListar.setLayout(null);
            frameListar.setVisible(true);
        }else if(event.getSource() == button4y8)
        {
            cLogica logica = new cLogica();
            double promedio = logica.Porcentaje_4y8_malo(encuestas);

            
            JFrame frameListar = new JFrame();
            frameListar.setLocationRelativeTo(frame);

            JLabel labelListado = new JLabel("Datos generales");
            labelListado.setBounds(80, 15, 250, 20);

            JTextArea textList = new JTextArea();
            textList.setBounds(20, 40, 600, 200);

            JScrollPane scrollPane = new JScrollPane(textList);
            scrollPane.setBounds(20, 40, 600, 200);

            String mensaje1 = "Promedio 4 y 8 años y satsifaccion mala: " + promedio + "% de clientes";
            
            textList.setText(mensaje1);
            frameListar.getContentPane().add(scrollPane);

            frameListar.add(labelListado);
            frameListar.setSize(700, 300);
            frameListar.setLayout(null);
            frameListar.setVisible(true);
        }else if(event.getSource() == buttonPromedioEdad)
        {
            cLogica logica = new cLogica();
            double promedio = logica.Promedio_edad(encuestas);

            
            JFrame frameListar = new JFrame();
            frameListar.setLocationRelativeTo(frame);

            JLabel labelListado = new JLabel("Datos generales");
            labelListado.setBounds(80, 15, 250, 20);

            JTextArea textList = new JTextArea();
            textList.setBounds(20, 40, 600, 200);

            JScrollPane scrollPane = new JScrollPane(textList);
            scrollPane.setBounds(20, 40, 600, 200);

            String mensaje1 = "Promedio edad de satisfaccion excelente: " + promedio;
            
            textList.setText(mensaje1);
            frameListar.getContentPane().add(scrollPane);

            frameListar.add(labelListado);
            frameListar.setSize(700, 300);
            frameListar.setLayout(null);
            frameListar.setVisible(true);
        }else if(event.getSource() == buttonListaOrdenado)
        {
            cLogica logica = new cLogica();
            ArrayList<Integer> promedio = logica.Listado_ordenado(encuestas);

            
            JFrame frameListar = new JFrame();
            frameListar.setLocationRelativeTo(frame);

            JLabel labelListado = new JLabel("Datos generales");
            labelListado.setBounds(80, 15, 250, 20);

            JTextArea textList = new JTextArea();
            textList.setBounds(20, 40, 600, 200);

            JScrollPane scrollPane = new JScrollPane(textList);
            scrollPane.setBounds(20, 40, 600, 200);

            String mensaje1 = "Edades ordenadas: \n ";

            for(Integer x: promedio)
            {
                mensaje1+= x + "\n";
            }
            
            textList.setText(mensaje1);
            frameListar.getContentPane().add(scrollPane);

            frameListar.add(labelListado);
            frameListar.setSize(700, 300);
            frameListar.setLayout(null);
            frameListar.setVisible(true);
        }
    }
}