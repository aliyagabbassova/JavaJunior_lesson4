package ru.geekbrains.lesson4.homework4;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


public class Program {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "aliya123";
        Connection connection;
        try {
            // Подключение к базе данных
            connection = DriverManager.getConnection(url, user, password);

            // Создание базы данных
            createDatabase(connection);
            System.out.println("Database created successfully");

            // Использование базы данных
            useDatabase(connection);
            System.out.println("Use database successfully");

            // Создание таблицы
            createTable(connection);
            System.out.println("Create table successfully");
////
//            // Закрытие соединения
//            connection.close();
//            System.out.println("Database connection close successfully");

//            Collection<SchoolDB> school = readData(connection);
//            for (var schooldb: school)
//                System.out.println(schooldb);
//            System.out.println("Read data successfully");
//
//
//            for (var schooldb: school) {
//                schooldb.updateTitle();
//                schooldb.updateDuration();
//                schooldb.updateTitle(connection, schooldb);
//            }
//            System.out.println("Update data successfully");

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

        private static void createDatabase (Connection connection) throws SQLException {
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS schoolDB;";
            PreparedStatement statement = connection.prepareStatement(createDatabaseSQL);
            statement.execute();
        }

        private static void useDatabase (Connection connection) throws SQLException {
            String useDatabaseSQL = "USE schoolDB;";
            try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
                statement.execute();
            }
        }
    private static Collection<SchoolDB> readData(Connection connection) throws SQLException {
        ArrayList<SchoolDB> schoolDBList = new ArrayList<>();
        String readDataSQL = "SELECT * FROM students;";
        try (PreparedStatement statement = connection.prepareStatement(readDataSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int duration = resultSet.getInt("duration");
                schoolDBList.add(new SchoolDB(id, title, duration));
            }
            return schoolDBList;
        }
    }
        private static void createTable (Connection connection) throws SQLException {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Courses (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), duration INT);";
            try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
                statement.execute();
            }
        }
    }



