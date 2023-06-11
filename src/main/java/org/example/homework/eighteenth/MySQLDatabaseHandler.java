package org.example.homework.eighteenth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLDatabaseHandler {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String user = "root";
    private static final String password = "null";

    private static final String DEFAULT_QUERY = "SELECT * FROM test_db.STUDENTS";
    private static final String JOIN_QUERY = "select ID_STUDENT, NAME,COURSE,CAFEDRE,AGE,CITY from test_db.Students INNER JOIN test_db.city on City.ID_CITY = CITY_ID";

    public static void main(String[] args) throws SQLException {
        MySQLDatabaseHandler main = new MySQLDatabaseHandler();
        List<Student> studentsDefQuery = main.readDataWithDefaultQuery();
        List<Student> studentsJoinQuery = main.readDataWithJoinQuery();

        System.out.println(studentsDefQuery);
        System.out.println(studentsJoinQuery);

    }

    private List<Student> readDataWithDefaultQuery() {

        try (Connection connection =
                     DriverManager.getConnection(URL, user, password);

             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(DEFAULT_QUERY);
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

    private List<Student> readDataWithJoinQuery() {

        try (Connection connection =
                     DriverManager.getConnection(URL, user, password);

             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(JOIN_QUERY);
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
