package com.geekbrains.lesson8;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input command: (1 - select; 2 - insert; 3 - delete; 4 - find by name; 5 - find by price; 6 - exit)");
        String cmd = scanner.nextLine();
        try {
            connect();
            switch (cmd) {
                case ("1"):
                    readAll();
                    break;
                case ("2"):
                    System.out.println("Input product name: ");
                    String name = scanner.nextLine();
                    System.out.println("Input product price: ");
                    double price = scanner.nextDouble();
                    System.out.println("Input product quantity: ");
                    int quantity = scanner.nextInt();
                    insert(name, price, quantity);
                    System.out.println("Data successfully added!");
                    break;
                case ("3"):
                    System.out.println("Input product id: ");
                    int id = scanner.nextInt();
                    deleteById(id);
                    System.out.println("Data successfully deleted!");
                    break;
                case ("4"):
                    System.out.println("Input product name: ");
                    name = scanner.nextLine();
                    findByName(name);
                    break;
                case ("5"):
                    System.out.println("Input cost range: ");
                    System.out.println("a: ");
                    double a = scanner.nextDouble();
                    System.out.println("b: ");
                    double b = scanner.nextDouble();
                    findByPrice(a, b);
                    break;
                case ("6"):
                    break;
                default:
                    System.out.println("Сommand not found!");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            new RuntimeException("Connection failed");
        }
    }

    private static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void readAll() {
        String sql = "SELECT * FROM Product;";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            mapRow(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insert(String name, double price, int quantity) {
        String sql = "INSERT INTO Product (name, price, quantity) VALUES (?, ?, ?);";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setInt(3, quantity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteById(int id) {
        String sql = "DELETE FROM Product WHERE id = ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void findByName(String name) {
        String sql = "SELECT * FROM Product WHERE name = ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            mapRow(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void findByPrice(double a, double b) {
        String sql = "SELECT * FROM Product WHERE price between ? and ?;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, a);
            preparedStatement.setDouble(2, b);
            ResultSet resultSet = preparedStatement.executeQuery();
            mapRow(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void mapRow(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getDouble("price") + " " + rs.getInt("quantity"));
        }
    }
}
