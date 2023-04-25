package university.crm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    Project() {
        setSize(1540, 850);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("assets/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar menuBar = new JMenuBar();

        //new information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        menuBar.add(newInformation);

        JMenuItem groupInfo = new JMenuItem("New Group Information");
        groupInfo.setForeground(Color.BLACK);
        groupInfo.addActionListener(this);
        newInformation.add(groupInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setForeground(Color.BLACK);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        //details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        menuBar.add(details);
        
        JMenuItem groupDetails = new JMenuItem("View Group Details");
        groupDetails.setForeground(Color.BLACK);
        details.add(groupDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setForeground(Color.BLACK);
        details.add(studentDetails);

        //leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        menuBar.add(leave);
        
        JMenuItem groupLeave = new JMenuItem("Group Leave");
        groupLeave.setForeground(Color.BLACK);
        leave.add(groupLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setForeground(Color.BLACK);
        leave.add(studentLeave);

        //leave details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        menuBar.add(leaveDetails);
        
        JMenuItem groupLeaveDetails = new JMenuItem("Group Leave Details");
        groupLeaveDetails.setForeground(Color.BLACK);
        leaveDetails.add(groupLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setForeground(Color.BLACK);
        leaveDetails.add(studentLeaveDetails);

        //exams
        JMenu exam = new JMenu("Examinations");
        exam.setForeground(Color.BLUE);
        menuBar.add(exam);
        
        JMenuItem examDetails = new JMenuItem("Examinations Results");
        examDetails.setForeground(Color.BLACK);
        exam.add(examDetails);

        JMenuItem studentMarks = new JMenuItem("Student Marks");
        studentMarks.setForeground(Color.BLACK);
        exam.add(studentMarks);

        //update info
        JMenu updateInfo = new JMenu("Update information");
        updateInfo.setForeground(Color.RED);
        menuBar.add(updateInfo);
        
        JMenuItem updateGroupInfo = new JMenuItem("Update Group Details");
        updateGroupInfo.setForeground(Color.BLACK);
        updateInfo.add(updateGroupInfo);

        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setForeground(Color.BLACK);
        updateInfo.add(updateStudentInfo);

        //fees
        JMenu fees = new JMenu("Fees Details");
        fees.setForeground(Color.BLUE);
        menuBar.add(fees);
        
        JMenuItem feesStructure = new JMenuItem("Fees Structure");
        feesStructure.setForeground(Color.BLACK);
        fees.add(feesStructure);

        JMenuItem feesForm = new JMenuItem("Student Fees Form");
        feesForm.setForeground(Color.BLACK);
        fees.add(feesForm);

        //utilities
        JMenu utilities = new JMenu("Utilities");
        utilities.setForeground(Color.RED);
        menuBar.add(utilities);
        
        JMenuItem notePad = new JMenuItem("Notepad");
        notePad.setForeground(Color.BLACK);
        notePad.addActionListener(this);
        utilities.add(notePad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setForeground(Color.BLACK);
        calc.addActionListener(this);
        utilities.add(calc);

        //exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        menuBar.add(exit);
        
        JMenuItem exitField = new JMenuItem("Exit");
        exitField.setForeground(Color.BLACK);
        exitField.addActionListener(this);
        exit.add(exitField);

        setJMenuBar(menuBar);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String message = event.getActionCommand();

        if (message.equals("Exit")) {
            setVisible(false);
        } else if (message.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception error) {}
        } else if (message.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception error) {}
        } else if (message.equals("New Group Information")) {
            new AddTeacher();
        } else if (message.equals("New Student Information")) {
            new AddStudent();
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}