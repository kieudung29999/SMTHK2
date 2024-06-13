package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import controller.HNHNconnect;

public class connect {
    public static Connection getConnection() {
        Connection c = null;
        try {
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/hehthong";
            String username = "root";
            String pass = "vtkdăâêộ̀̉̃́đ";

            c = DriverManager.getConnection(url, username, pass);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testConnection() {
        Connection c = getConnection();
        if (c != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Connection failed!");
        }
        closeConnection(c);
    }

    public static void main(String[] args) {
        testConnection();
    }
}
