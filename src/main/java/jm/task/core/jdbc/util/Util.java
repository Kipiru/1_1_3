package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getConnection() {
        Connection connection = null;
        String dbURL = "jdbc:mysql://localhost:3306/schema1_1_3?useSSL=false";
        String dbUsername = "root";
        String dbPassword = "root";
        try {
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
