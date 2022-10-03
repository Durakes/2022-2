package ejerciciotaxi;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfaz implements ActionListener
{
    JFrame frame;
    JButton buttonRegistro, buttonListar, buttonEliminar;
    JLabel labelCodigo, labelNombre, labelPlaca, labelNumero, labelMarca;
    JTextField textCodigo, textNombre, textPlaca, textNumero, textMarca;
    JLabel titulo;

    ArrayList<Conductor> conductores = new ArrayList<>();

    public Interfaz()
    {
        frame = new JFrame();

        titulo = new JLabel("Registrar Conductor");
        titulo.setBounds(150, 30, 200, 20);

        textCodigo = new JTextField();
        textCodigo.setBounds(150, 60, 200, 20);

        labelCodigo = new JLabel("Codigo");
        labelCodigo.setBounds(30, 60, 200, 20);

        textNombre = new JTextField();
        textNombre.setBounds(150, 90, 200, 20);

        labelNombre = new JLabel("Nombre");
        labelNombre.setBounds(30, 90, 200, 20);

        textPlaca = new JTextField();
        textPlaca.setBounds(150, 120, 200, 20);
        
        labelPlaca = new JLabel("Placa");
        labelPlaca.setBounds(30, 120, 200, 20);

        textNumero = new JTextField();
        textNumero.setBounds(150, 150, 200, 20);

        labelNumero = new JLabel("Numero Cel");
        labelNumero.setBounds(30, 150, 200, 20);

        textMarca = new JTextField();
        textMarca.setBounds(150, 180, 200, 20);

        labelMarca = new JLabel("Marca del Vehiculo");
        labelMarca.setBounds(30, 180, 200, 20);

        buttonEliminar = new JButton("Eliminar");
        buttonEliminar.setBounds(40, 230, 80, 20);
        buttonEliminar.addActionListener(this);

        buttonRegistro = new JButton("Registro");
        buttonRegistro.setBounds(150, 230, 82, 20);
        buttonRegistro.addActionListener(this);

        buttonListar = new JButton("Listar");
        buttonListar.setBounds(260, 230, 80, 20);
        buttonListar.addActionListener(this);

        frame.add(titulo);
        frame.add(labelCodigo);
        frame.add(labelNombre);
        frame.add(labelPlaca);
        frame.add(labelNumero);
        frame.add(labelMarca);
        frame.add(textCodigo);
        frame.add(textNombre);
        frame.add(textPlaca);
        frame.add(textNumero);
        frame.add(textMarca);
        frame.add(buttonEliminar);
        frame.add(buttonRegistro);
        frame.add(buttonListar);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == buttonRegistro)
        {
            Conductor conductor = new Conductor();

            conductor.codConductor = textCodigo.getText();
            conductor.nombreConductor = textNombre.getText();
            conductor.numeroCelular = textNumero.getText();
            conductor.placaVehiculo = textPlaca.getText();
            conductor.tipoVehiculo = textMarca.getText();

            conductores.add(conductor);
            
            textCodigo.setText("");
            textNombre.setText("");
            textNumero.setText("");
            textPlaca.setText("");
            textMarca.setText("");

        }else if(event.getSource() == buttonListar)
        {
            JFrame frameListar = new JFrame();
            frameListar.setLocationRelativeTo(frame);

            JLabel labelListado = new JLabel("Listado de Conductores");
            labelListado.setBounds(80, 15, 250, 20);

            JTextArea textList = new JTextArea();
            textList.setBounds(20, 40, 250, 430);

            JScrollPane scrollPane = new JScrollPane(textList);
            scrollPane.setBounds(20, 40, 250, 430);

            String mensaje ="";
            int index = 1;
            for (Conductor conductor : conductores)
            {
                mensaje += "Conductor " + index + "\n" + "Codigo Conductor: " + conductor.codConductor + "\n" + "Nombre Conductor: " + conductor.nombreConductor + "\n" + "Numero Conductor: " + conductor.numeroCelular + "\n" + "Placa Conductor: " + conductor.placaVehiculo + "\n" + "Tipo Conductor: " + conductor.tipoVehiculo + "\n \n"; 
                index++;
            }

            textList.setText(mensaje);
            frameListar.getContentPane().add(scrollPane);

            frameListar.add(labelListado);
            frameListar.setSize(300, 550);
            frameListar.setLayout(null);
            frameListar.setVisible(true);

        }else if(event.getSource() == buttonEliminar)
        {
            JFrame frameListar = new JFrame();
            frameListar.setLocationRelativeTo(frame);

            JLabel labelOpcion = new JLabel("<html>Ingrese el numero de conductor que <br>desea eliminar: </html>");
            labelOpcion.setBounds(20, 10, 280, 40);

            JTextField textOpcion = new JTextField();
            textOpcion.setBounds(20, 50, 100, 20);

            JButton buttonConfirmacion = new JButton("Eliminar");
            buttonConfirmacion.setBounds(150, 50, 100, 20);
            buttonConfirmacion.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    conductores.remove(Integer.parseInt(textOpcion.getText()) - 1);
                    frameListar.setVisible(false);
                    frameListar.dispose();
                }
            });

            JLabel labelListado = new JLabel("Listado de Conductores");
            labelListado.setBounds(80, 75, 250, 20);

            JTextArea textList = new JTextArea();
            textList.setBounds(20, 100, 250, 430);

            JScrollPane scrollPane = new JScrollPane(textList);
            scrollPane.setBounds(20, 100, 250, 430);

            String mensaje ="";
            int index = 1;
            for (Conductor conductor : conductores)
            {
                mensaje += "Conductor " + index + "\n" + "Codigo Conductor: " + conductor.codConductor + "\n" + "Nombre Conductor: " + conductor.nombreConductor + "\n" + "Numero Conductor: " + conductor.numeroCelular + "\n" + "Placa Conductor: " + conductor.placaVehiculo + "\n" + "Tipo Conductor: " + conductor.tipoVehiculo + "\n \n"; 
                index++;
            }

            textList.setText(mensaje);
            frameListar.getContentPane().add(scrollPane);

            frameListar.add(textOpcion);
            frameListar.add(labelOpcion);
            frameListar.add(labelListado);
            frameListar.add(buttonConfirmacion);
            frameListar.setSize(300, 600);
            frameListar.setLayout(null);
            frameListar.setVisible(true);
            
        }
    }
}



