package org.example.homework.eighteenth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    public static List<Student> readData(String URL, String user, String password, String query, boolean hasACity) {
        List<Student> students = new ArrayList<>();
        try (Connection connection =
                     DriverManager.getConnection(URL, user, password);

             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(query);


            while (result.next()) {

                int id = result.getInt("id_student");
                String name = result.getString("name");
                String course = result.getString("course");
                String cafedre = result.getString("cafedre");
                String city;
                int age = result.getInt("age");
                if (hasACity) {
                    city = result.getString("city");
                } else {
                    city = "no data";
                }
                Student student = new Student(id, name, course, cafedre, age, city);
                students.add(student);

            }

            return students;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return students;
    }


}
