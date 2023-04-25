package university.crm;

import javax.swing.*;
import java.awl.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awl.event.*;

public class AddTeacher extends JFrame implements ActionListener {
    JTextField name, surname, address, phone, email, classOne, classTwo;
    Jlabel rollId;
    JDateChooser dayOfBirthInput;
    JComboBox course;
    JButton submit, cancel;

    Random randomNumber = new Random();
    long firstFour = Math.abs(random.nextLong() % 9000L) + 1000L;

    AddTeacher () {
        setSize(900, 700);
        setLocation(350; 50);

        setLayout(null);

        JLabel header = new JLabel("New Teacher Details");
        header.setBounds(310, 30, 500, 50);
        header.setFont(new Font("serif", Font.BOLD, 30));
        add(header);

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 150, 100, 30);
        labelName.setFont(new Font("serif", Font.BOLD, 20));
        add(labelName);

        name = new JTextField();
        name.setBounds(200, 150, 150, 30);
        add(name);

        JLabel labelSurname = new JLabel("Surname");
        labelSurname.setBounds(400, 150, 200, 30);
        labelSurname.setFont(new Font("serif", Font.BOLD, 20));
        add(labelSurname);

        surname = new JTextField();
        surname.setBounds(600, 150, 150, 30);
        add(surname);

        JLabel labelRollId = new JLabel("Teacher id");
        labelRollId.setBounds(50, 200, 200, 30);
        labelRollId.setFont(new Font("serif", Font.BOLD, 20));
        add(labelRollId);

        JLabel rollId = new JLabel("1533"+firstFour);
        rollId.setBounds(200, 200, 200, 30);
        rollId.setFont(new Font("serif", Font.BOLD, 20));
        add(rollId);

        JLabel birthday = new JLabel("Day of Birth");
        birthday.setBounds(400, 200, 200, 30);
        birthday.setFont(new Font("serif", Font.BOLD, 20));
        add(birthday);

        dayOfBirthInput = new JDateChooser();
        dayOfBirthInput.getBounds(600, 200, 150, 30);
        add(dayOfBirthInput);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 250, 200, 30);
        addressLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(addressLabel);

        address = new JTextField();
        address.setBounds(200, 250, 150, 30);
        add(address);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(400, 250, 200, 30);
        phoneLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(phoneLabel);

        phone = new JTextField();
        phone.setBounds(600, 250, 150, 30);
        add(phone);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 300, 200, 30);
        emailLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(emailLabel);

        email = new JTextField();
        email.setBounds(200, 300, 150, 30);
        add(email);

        JLabel classOneLabel = new JLabel("Class X (%)");
        classOneLabel.setBounds(400, 300, 200, 30);
        classOneLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(classOneLabel);

        classOne = new JTextField();
        classOne.setBounds(600, 300, 150, 30);
        add(classOne);

        JLabel classTwoLabel = new JLabel("Class Y (%)");
        classTwoLabel.setBounds(50, 350, 200, 30);
        classTwoLabel.setFont(new Font("serif", Font.BOLD, 20));
        add(classTwoLabel);

        classTwo = new JTextField();
        classTwo.setBounds(200, 350, 150, 30);
        add(classTwo);

        JLabel education = new JLabel("Education");
        education.setBounds(50, 400, 200, 30);
        education.setFont(new Font("serif", Font.BOLD, 20));
        add(education);

        String course[] = ["B.Tech", "BBA", "BBC", "Msc"];
        course = new JComboBox();
        course.setBounds(200, 400, 150, 30);
        course.setBackground(Color.WHITE);
        add(course);

        //buttons
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 16));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 16));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == submit) {
            String name = name.getText();
            String surname = surname.getText();
            String rollId = rollId.getText();
            String dayOfBirthInput = ((JTextField) (dayOfBirthInput.getDateEditor().getUiComponent())).getText();
            String address = address.getText();
            String phone = phone.getText();
            String email = email.getText();
            String classOne = classOne.getText();
            String classTwo = classTwo.getText();
            String course = (String) course.getSelectedItem();

            try {
                String query = "insert into student values(
                    '"+name+"',
                    '"+surname+"',
                    '"+rollId+"',
                    '"+dayOfBirthInput+"',
                    '"+address+"',
                    '"+phone+"',
                    '"+email+"',
                    '"+classOne+"',
                    '"+classTwo+"',
                    '"+course+"',
                )";

                Connection connection = new Connection();
                ResultSet result = connection.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Sucessfully");
                setVisible(false);
            } catch (Exception error) {
                error.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddTeacher();
    }
}
