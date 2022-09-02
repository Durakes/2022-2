package poo2_s3_s1_1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cPassword
{
    JFrame frame;
    JLabel label, labelUser, labelPassword;
    JPasswordField pass;
    JButton button;
    JTextField textField;

    
    public cPassword()
    {
        frame = new JFrame("Ejemplo de JPasswordField");
        label = new JLabel();
        label.setBounds(20, 150, 200, 50);

        pass = new JPasswordField();
        pass.setBounds(100, 75, 100, 30);

        labelUser = new JLabel("Usuario");
        labelUser.setBounds(20, 20, 80, 30);

        labelPassword = new JLabel("Contraseña");
        labelPassword.setBounds(20, 75, 80, 30);

        button = new JButton("Login");
        button.setBounds(100, 120, 80, 30);

        textField = new JTextField();
        textField.setBounds(100, 20, 100 ,30);

        frame.add(label);
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
}
