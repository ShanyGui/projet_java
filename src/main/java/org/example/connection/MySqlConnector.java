package org.example.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {
    private static Connection connection; // Doit être lu depuis le main sans instancier la classe ( MySqlConnection.connection )
    // static block
    static {
        String username = "projetjava";
        String password = "password";
        String url = "jdbc:mysql://localhost:3306/weather";
        try {
            // charger le driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // établir la connexion avec la base de données
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}