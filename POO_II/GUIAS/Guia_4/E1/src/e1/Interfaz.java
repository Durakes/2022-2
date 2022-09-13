package e1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz implements ActionListener
{
    JFrame frame;
    JLabel fabricante, tipoPrograma, dispositivo, precioFinal;
    JComboBox<Object> fabricanteBox, tipoProgramaBox, dispositivoBox;
    JTextArea textArea;
    JButton button;


    public Interfaz()
    {
        frame = new JFrame("Guia 1 - Ejemplo 1");

        fabricante = new JLabel("Fabricante");
        fabricante.setBounds(30, 30, 100, 20);

        fabricanteBox = new JComboBox<>();
        fabricanteBox.setBounds(230, 30, 200, 20);

        tipoPrograma = new JLabel("Tipo de Programa");
        tipoPrograma.setBounds(30, 80, 300, 20);
        tipoPrograma.setVisible(false);

        tipoProgramaBox = new JComboBox<>();
        tipoProgramaBox.setBounds(230, 80, 200, 20);
        tipoProgramaBox.setVisible(false);
        tipoProgramaBox.addActionListener(this);

        dispositivo = new JLabel("Dispositivo");
        dispositivo.setBounds(30, 130, 100, 20);
        dispositivo.setVisible(false);

        dispositivoBox = new JComboBox<>();
        dispositivoBox.setBounds(230, 130, 200, 20);
        dispositivoBox.setVisible(false);

        precioFinal = new JLabel("Precio final");
        precioFinal.setBounds(30, 180, 100, 20);
        precioFinal.setVisible(false);

        textArea = new JTextArea();
        textArea.setBounds(180, 180, 280, 100);
        textArea.setVisible(false);

        button = new JButton("Calcular");
        button.setBounds(180, 320, 100, 20);

        frame.add(fabricante);
        frame.add(tipoPrograma);
        frame.add(dispositivo);
        frame.add(precioFinal);
        frame.add(fabricanteBox);
        frame.add(tipoProgramaBox);
        frame.add(dispositivoBox);
        frame.add(textArea);
        frame.add(button);

        frame.setSize(500, 450);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        try 
        {
            String dispositivos[] = {"Celulares", "Tablas", "Otros"};
            if(tipoProgramaBox.getSelectedIndex() == 1)
            {
                dispositivo.setVisible(true);
                dispositivoBox.setVisible(true);
                dispositivoBox.removeAllItems();
                for(String disp: dispositivos)
                {
                    dispositivoBox.addItem(disp);
                }
            }else
            {
                dispositivo.setVisible(false);
                dispositivoBox.setVisible(false);
            }
        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void seleccionOpciones()
    {
        String fabricantes[] = {"Microsoft", "Apple", "Linux"};
        String tipoProgramas[] = {"Sistema Operativo", "Lenguaje de Programación"};
        
        for(String fab: fabricantes)
        {
            fabricanteBox.addItem(fab);
        }

        for(String tipo: tipoProgramas)
        {
            tipoProgramaBox.addItem(tipo);
        }

        tipoPrograma.setVisible(true);
        tipoProgramaBox.setVisible(true);
        
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                precioFinal.setVisible(true);
                textArea.setVisible(true);

                Proceso proceso = new Proceso();

                proceso.calcularPrecio(fabricanteBox.getSelectedIndex(), tipoProgramaBox.getSelectedIndex(), dispositivoBox.getSelectedIndex());

                String mensaje = "La boleta es: \nFabricante: " + fabricanteBox.getSelectedItem() + "\nTipo de Programa: " + tipoProgramaBox.getSelectedItem();
                
                if(tipoProgramaBox.getSelectedIndex() == 1)
                {
                    mensaje += "\nDispositivo: " + dispositivoBox.getSelectedItem();
                }

                mensaje += "\nEl precio es: " + proceso.precioFinal;

                textArea.setText(mensaje);
            } 
        });

    }

}
