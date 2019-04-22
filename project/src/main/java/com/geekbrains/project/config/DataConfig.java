package com.geekbrains.project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConfig {
    private final String DB_DRIVER = "org.sqlite.JDBC";
    private final String URL = "jdbc:sqlite:database.db";

    public Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
