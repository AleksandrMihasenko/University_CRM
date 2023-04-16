package university.crm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JButton loginButton, cancelButton;

    Login () {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //username
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(40, 20, 100, 20);
        add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 20, 150, 20);
        add(usernameField);

        //password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 70, 100, 20);
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 20);
        add(passwordField);

        //buttons
        loginButton = new JButton("Login");
        loginButton.setBounds(40, 140, 120, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        loginButton.setFont(new Font("serif", Font.BOLD, 16));
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 140, 120, 30);
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setForeground(Color.BLACK);
        cancelButton.addActionListener(this);
        cancelButton.setFont(new Font("serif", Font.BOLD, 16));
        add(cancelButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == loginButton) {

        } else if (event.getSource() == cancelButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
