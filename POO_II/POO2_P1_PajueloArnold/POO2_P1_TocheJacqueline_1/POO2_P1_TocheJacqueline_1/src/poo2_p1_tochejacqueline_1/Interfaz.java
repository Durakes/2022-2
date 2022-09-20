/*
Escriba un programa en Java, que permita calcular el promedio final de los N alumnos que
contiene una sección si se sabe que el promedio de cada alumno se obtiene de la siguiente
forma:
 55% del Examen Final
 30% de Examen Parcial
 15% del Trabajo final
Por último hallar el promedio de los N alumnos ingresados.
 */
package poo2_p1_tochejacqueline_1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
/*
Integrantes:
Pajuelo Araujo Arnold
Toche Sanchez Jacqueline Yvette
 */
public class Interfaz implements ActionListener{
    
    JFrame frame;
    JLabel lblTitulo, lblCantAlumnos, lblEF, lblEP,lblTF, lblNumAl;
    JTextField tfCant, tfEF, tfEP, tfTF;
    JButton btnProcesar, btnSiguiente;
    ArrayList<Integer> notasEF = new ArrayList<Integer>();
    ArrayList<Integer> notasEP = new ArrayList<Integer>();
    ArrayList<Integer> notasTF = new ArrayList<Integer>();
    int cantA, numA=1;
    Logica objAlumno = new Logica(notasEF,notasEP,notasTF);
    
    public Interfaz()
    {
        //Frame
        frame = new JFrame("Ejercicio 1");
        
        lblTitulo = new JLabel("Calcular promedio de alumnos");
        lblTitulo.setBounds(100,10,200,20);
        
        //Lbl y TF de cantidad de alumnos
        lblCantAlumnos = new JLabel("Cantidad de alumnos:");
        lblCantAlumnos.setBounds(50,60,150,20);
        tfCant = new JTextField();
        tfCant.setBounds(200,60,80,20);
        
        lblNumAl = new JLabel("Alumno i");
        lblNumAl.setBounds(150, 90,150,20);
        lblNumAl.setVisible(false);
        
        //Lbl y TF Examen Final
        lblEF = new JLabel("Examen Final:");
        lblEF.setBounds(50,120,150,20);
        tfEF = new JTextField();
        tfEF.setBounds(200,120,80,20);
        tfEF.setVisible(false);
        
        
        //Lbl y TF Examen Parcial
        lblEP = new JLabel("Examen Parcial:");
        lblEP.setBounds(50,150,150,20);
        tfEP = new JTextField();
        tfEP.setBounds(200,150,80,20);
        tfEP.setVisible(false);
        
        //Lbl y TF Trabajo Final
        lblTF = new JLabel("Trabajo Final:");
        lblTF.setBounds(50,180,150,20);
        tfTF = new JTextField();
        tfTF.setBounds(200,180,80,20);
        tfTF.setVisible(false);
        
        //Boton procesar
        btnProcesar = new JButton("Procesar");
        btnProcesar.setBounds(200,230,100,20);
        btnProcesar.setEnabled(false);
        btnProcesar.addActionListener(this);
        
        //Boton siguiente
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setBounds(90,230,100,20);
        btnSiguiente.addActionListener(this);
        
        
        tfCant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cantA = Integer.parseInt(tfCant.getText());
                lblNumAl.setText("Alumno 1");
                lblNumAl.setVisible(true);
                tfEF.setVisible(true);
                tfEP.setVisible(true);
                tfTF.setVisible(true);
            }
        });
        
        frame.add(lblTitulo);
        frame.add(lblCantAlumnos);
        frame.add(tfCant);
        frame.add(lblEF);
        frame.add(tfEF);
        frame.add(lblEP);
        frame.add(tfEP);
        frame.add(btnProcesar);
        frame.add(lblNumAl);
        frame.add(lblTF);
        frame.add(tfTF);
        frame.add(btnSiguiente);
        
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        try 
        {
            int notaEF = 0;
            int notaEP = 0;
            int notaTF = 0;
            if (e.getSource() == btnSiguiente)
            {
                notaEF = Integer.parseInt(tfEF.getText());
                notaEP = Integer.parseInt(tfEP.getText());
                notaTF = Integer.parseInt(tfTF.getText());
                
                notasEF.add(notaEF);
                notasEP.add(notaEP);
                notasTF.add(notaTF);
                
                
                JOptionPane.showMessageDialog(frame, "El promedio del alumno es "+objAlumno.getPromIndividual(numA-1));
                
                tfEF.setText("");
                tfEP.setText("");
                tfTF.setText("");
                
                lblNumAl.setText("Alumno: "+String.valueOf(numA+=1));
                if(numA == cantA+1)
                {
                    btnSiguiente.setEnabled(false);
                    btnProcesar.setEnabled(true);
                    tfEF.setEnabled(false);
                    tfEP.setEnabled(false);
                    tfTF.setEnabled(false);
                    lblNumAl.setVisible(false);
                    
                }
              
                
                
                
            }
            if(e.getSource() == btnProcesar)
            {
                JOptionPane.showMessageDialog(frame, "El promedio total es: "+objAlumno.getPromTotal());
            }
            
        } 
        catch (Exception ex) 
        {
            System.out.println("Error: "+ex.toString());
        }
        
    }
}
