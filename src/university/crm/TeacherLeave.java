package university.crm;

import javax.swing.*;
import java.awl.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awl.event.*;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice numberId, chosenTime;
    JDateChooser chosenDate;
    JButton sumbit, cancel;

    TeacherLeave() {
        setSize(500, 550);
        setLocation(600, 100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);

        Jlabel headerLabel = new JLabel("Apply leave (Teacher)");
        headerLabel.setBounds(40, 50, 300, 30);
        headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(headerLabel);

        JLabel teacherRoll = new JLabel("Search by Employee Id");
        teacherRoll.setBounds(60, 100, 200, 20);
        teacherRoll.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(teacherRoll);

        numberId = new Choice();
        numberId.setBounds(60, 130, 200, 20);
        add(numberId);

        try {
            Connection connection = new Connection();
            ResultSet result = connection.statement.executeQuery("select * from teacher");

            while(result.next()) {
                numberId.add(result.getString("rollno"));
            }
        } catch (Exception error) {
            error.printStackTrace();
        }

        JLabel date = new JLabel("Date");
        date.setBounds(60, 180, 200, 20);
        date.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(date);

        chosenDate = new JDateChooser();
        chosenDate.setBounds(60, 210, 200, 25);
        add(chosenDate);

        JLabel time = new JLabel("Time Duration");
        time.setBounds(60, 260, 200, 20);
        time.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(time);

        chosenTime = new Choice();
        chosenTime.setBounds(60, 290, 200, 20);
        chosenTime.add("Full Day");
        chosenTime.add("Half Day");
        add(chosenTime);

        //buttons
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 16));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 16));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == submit) {
            String roll = teacherRoll.getSelectedItem();
            String date = ((JTextField) chosenDate.getDateEditor().getUiComponent()).getText();
            String duration = chosenTime.getSelectedItem();

            String query = String query = "insert into teacher values('"+roll+"', '"+date+"', '"+duration+"')"

            try {
                Connection connection = new Connection();
                ResultSet result = connection.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception error) {
                error.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
