package poo2_p2_pajueloaraujoarnold_01;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;


public class cInterfaz implements ActionListener
{
    
    JFrame frame;
    JTextField cantidadJugadores;
    JButton buttonGenerarDatos, buttonListaMayorTiempo, buttonTotalPuestosMinutos;

    LinkedList<Jugador> jugadores = new LinkedList<>();

    public cInterfaz()
    {
        frame = new JFrame();

        cantidadJugadores = new JTextField();
        cantidadJugadores.setBounds(20, 20, 200, 20);

        buttonGenerarDatos = new JButton("Datos");
        buttonGenerarDatos.setBounds(20, 50, 200, 20);
        buttonGenerarDatos.addActionListener(this);

        buttonListaMayorTiempo = new JButton("Mayor Tiempo");
        buttonListaMayorTiempo.setBounds(20, 90, 200, 20);
        buttonListaMayorTiempo.addActionListener(this);

        buttonTotalPuestosMinutos = new JButton("Total puestos");
        buttonTotalPuestosMinutos.setBounds(20, 130, 200, 20);
        buttonTotalPuestosMinutos.addActionListener(this);


        frame.add(cantidadJugadores);
        frame.add(buttonGenerarDatos);
        frame.add(buttonTotalPuestosMinutos);
        frame.add(buttonListaMayorTiempo);

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
            logica.GenerarDatos(Integer.parseInt(cantidadJugadores.getText()));
            jugadores = logica.listJugadores;

            JFrame frameListar = new JFrame();
            frameListar.setLocationRelativeTo(frame);

            JLabel labelListado = new JLabel("Datos generales");
            labelListado.setBounds(80, 15, 250, 20);

            JTextArea textList = new JTextArea();
            textList.setBounds(20, 40, 600, 200);

            JScrollPane scrollPane = new JScrollPane(textList);
            scrollPane.setBounds(20, 40, 600, 200);

            String mensaje1 = "Puesto: ";
            String mensaje2 = "Minutos: ";

            for(Jugador jugador: logica.listJugadores)
            {
                mensaje1 += jugador.puesto + "\t";
                mensaje2 += jugador.minutosJugados + "\t";
            }
            
            textList.setText(mensaje1 + "\n" + mensaje2);
            frameListar.getContentPane().add(scrollPane);

            frameListar.add(labelListado);
            frameListar.setSize(700, 300);
            frameListar.setLayout(null);
            frameListar.setVisible(true);
        }else if(event.getSource() == buttonTotalPuestosMinutos)
        {
            cLogica logica = new cLogica();
            int puestos[][] = logica.Total_PuestosyMinutos(jugadores);

            
            JFrame frameListar = new JFrame();
            frameListar.setLocationRelativeTo(frame);

            JLabel labelListado = new JLabel("Datos generales");
            labelListado.setBounds(80, 15, 250, 20);

            JTextArea textList = new JTextArea();
            textList.setBounds(20, 40, 600, 200);

            JScrollPane scrollPane = new JScrollPane(textList);
            scrollPane.setBounds(20, 40, 600, 200);

            String mensaje1 = "Puesto \t Cantidad \t Total \n";

            mensaje1 += "A \t" + puestos[0][0] + "\t" + puestos[0][1] + "\n";
            mensaje1 += "D \t" + puestos[1][0] + "\t" + puestos[1][1] + "\n";
            mensaje1 += "M \t" + puestos[2][0] + "\t" + puestos[2][1] + "\n";
            mensaje1 += "E \t" + puestos[3][0] + "\t" + puestos[3][1] + "\n";
            
            textList.setText(mensaje1);
            frameListar.getContentPane().add(scrollPane);

            frameListar.add(labelListado);
            frameListar.setSize(700, 300);
            frameListar.setLayout(null);
            frameListar.setVisible(true);
        }else if(event.getSource() == buttonListaMayorTiempo)
        {
            cLogica logica = new cLogica();
            Jugador jugador = logica.Lista_MayorTiempo(jugadores);

            
            JFrame frameListar = new JFrame();
            frameListar.setLocationRelativeTo(frame);

            JLabel labelListado = new JLabel("Datos generales");
            labelListado.setBounds(80, 15, 250, 20);

            JTextArea textList = new JTextArea();
            textList.setBounds(20, 40, 600, 200);

            JScrollPane scrollPane = new JScrollPane(textList);
            scrollPane.setBounds(20, 40, 600, 200);

            String mensaje1 = "Puesto \t Minutos \n";

            mensaje1 += jugador.puesto + "\t" + jugador.minutosJugados + "\n";            
            textList.setText(mensaje1);
            frameListar.getContentPane().add(scrollPane);

            frameListar.add(labelListado);
            frameListar.setSize(700, 300);
            frameListar.setLayout(null);
            frameListar.setVisible(true);
        }
    }
}
