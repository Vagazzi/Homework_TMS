package org.example.homework.eighteenth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    public static List<Student> readDataWithDefaultQuery(String URL, String user, String password, String query) {

        try (Connection connection =
                     DriverManager.getConnection(URL, user, password);

             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(query);
            List<Student> students = new ArrayList<>();

            while (result.next()) {

                int id = result.getInt("id_student");
                String name = result.getString("name");
                String course = result.getString("course");
                String cafedre = result.getString("cafedre");
                int age = result.getInt("age");
                Student student = new Student(id, name, course, cafedre, age,"no data");
                students.add(student);

            }

            return students;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static List<Student> readDataWithJoinQuery(String URL, String user, String password, String query) {

        try (Connection connection =
                     DriverManager.getConnection(URL, user, password);

             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(query);
            List<Student> students = new ArrayList<>();

            while (result.next()) {

                int id = result.getInt("id_student");
                String name = result.getString("name");
                String course = result.getString("course");
                String cafedre = result.getString("cafedre");
                int age = result.getInt("age");
                String city = result.getString("city");
                Student student = new Student(id, name, course, cafedre, age,city);
                students.add(student);

            }

            return students;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
