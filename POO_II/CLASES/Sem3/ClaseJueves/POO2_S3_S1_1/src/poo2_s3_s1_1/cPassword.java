package poo2_s3_s1_1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cPassword implements ActionListener
{
    JFrame frame;
    JLabel label1, label2, labelUser, labelPassword;
    JPasswordField pass;
    JButton button;
    JTextField textField;

    
    public cPassword()
    {
        frame = new JFrame("Ejemplo de JPasswordField");
        label1 = new JLabel();
        label1.setBounds(20, 150, 200, 50);

        label2 = new JLabel();
        label2.setBounds(20, 170, 200, 50);

        pass = new JPasswordField();
        pass.setBounds(100, 75, 100, 30);

        labelUser = new JLabel("Usuario");
        labelUser.setBounds(20, 20, 80, 30);

        labelPassword = new JLabel("Contraseña");
        labelPassword.setBounds(20, 75, 80, 30);

        button = new JButton("Login");
        button.setBounds(100, 120, 80, 30);
        button.addActionListener(this);

        textField = new JTextField();
        textField.setBounds(100, 20, 100 ,30);

        frame.add(label1);
        frame.add(label2);
        frame.add(pass);
        frame.add(labelUser);
        frame.add(labelPassword);
        frame.add(button);
        frame.add(textField);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        try 
        {
            String usuario = textField.getText();
            char[] password = pass.getPassword();

            String mensaje = "User: " + usuario;           
            //String mensaje2 =  "Passsword: " + password.toString(); /* Se consigue el hasheo */
            String mensaje2 = "Password: " + new String(password); /* Te consigue la contraseña sin hash */

            label1.setText(mensaje);
            label2.setText(mensaje2);

        } catch (Exception exception)
        {
            label1.setText(exception.toString());
        }
    }
}
