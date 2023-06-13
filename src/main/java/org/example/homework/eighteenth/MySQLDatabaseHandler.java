package org.example.homework.eighteenth;

import lombok.Getter;

@Getter
public class MySQLDatabaseHandler {

    private final String URL = "jdbc:mysql://localhost:3306";
    private final String user = "root";
    private final String password = "null";
    private final String DEFAULT_QUERY = "SELECT * FROM test_db.STUDENTS";
    private final String JOIN_QUERY = "select ID_STUDENT, NAME,COURSE,CAFEDRE,AGE,CITY from test_db.Students INNER JOIN test_db.city on City.ID_CITY = CITY_ID";

}
