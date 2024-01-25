package ru.geekbrains.lesson4.homework4;

import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private static void insertData(Connection connection, SchoolDB Courses) throws SQLException {
        String insertDataSQL = "INSERT INTO Courses(id, title,duration) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
            statement.setInt(1, Courses.getId());
            statement.setString(2, Courses.getTitle());
            statement.setInt(3, Courses.getDuration());
            statement.executeUpdate();
        }
    }
       private static void updateData(Connection connection, SchoolDB Courses) throws SQLException {
        String updateDataSQL = "UPDATE students SET id=?, title=? WHERE duration=?;";
        try (PreparedStatement statement = connection.prepareStatement(updateDataSQL)) {
            statement.setInt(1, Courses.getId());
            statement.setString(2, Courses.getTitle());
            statement.setInt(3, Courses.getDuration());
            statement.executeUpdate();
        }
    }


      private static void deleteData(Connection connection, int id) throws SQLException {
        String deleteDataSQL = "DELETE FROM Courses WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(deleteDataSQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }
}


