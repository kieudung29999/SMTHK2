package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hehthong";
    private static final String USER = "root";
    private static final String PASSWORD = "vtkdăâêộ̀̉̃́đ";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();  // Log the exception to understand why the connection is failing
            return null;  // Explicitly return null if connection fails
        }
    }
}

