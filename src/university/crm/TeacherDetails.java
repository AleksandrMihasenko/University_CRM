package university.crm;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener {
    JTextField name, surname, address, phone, email, classOne, classTwo;
    Choice teacherId;
    Jtable table;
    JButton search, print, update, add, cancel;

    TeacherDetails() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel headerLabel = new JLabel("Search by Employee Id");
        headerLabel.setBounds(20, 20, 150, 20);
        add(headerLabel);

        teacherId = new Choice();
        teacherId.setBounds(180, 20, 150, 20);
        add(teacherId);

        try {
            Connection connection = new Connection();
            ResultSet result = connection.statement.executeQuery("select * from teacher");

            while(result.next()) {
                teacherId.add(result.getString("teacherId"));
            }
        } catch (Exception error) {
            error.printStackTrace();
        }

        table = new Table();

        try {
            Connection connection = new Connection();
            ResultSet result = connection.statement.executeQuery("select * from teacher");
            table.setModel(DBUtils.resultSetToTableModel(result));
        } catch (Exception error) {
            error.printStackTrace();
        }

        JScrollPane studentTable = new JScrollPane(table);
        studentTable.setBounds(0, 100, 900, 600);
        add(studentTable);

        //control buttons
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == search) {
            String query = "select * from teacher where teacherId = '"+teacherId.getSelectedItem()"'";

            try {
                Connection connection = new Connection();
                ResultSet result = connection.statement.executeQuery(query);

                table.setModel(DbUtils.resultSetToTableModel(result));
            } catch (Exception error) {
                error.printStackTrace();
            }
        } else if (event.getSource() == print) {
            try {
                table.print();
            } catch (Exception error) {
                error.printStackTrace();
            }
        } else if (event.getSource() == add) {
            setVisible(false);
            new AddTeacher();
        } else if (event.getSource() == update) {
            setVisible(false);
            // new AddTeacher();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new TeacherDetails();
    }
}
