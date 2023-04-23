package university.crm.Connection;

import java.sql.*;

public class Connection {
    Connection connection;
    Statement statement;

    Connection () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///universitycrmsystem", "root", "root");
            statement = connection.createStatement();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
