package org.example.homework.eighteenth;

import lombok.Getter;

@Getter
public class MySQLConfig {

    private final String URL = "jdbc:mysql://localhost:3306";
    private final String user = "root";
    private final String password = "null";
    private final String defaultQuery = "SELECT * FROM test_db.STUDENTS";
    private final String joinQuery = "select ID_STUDENT, NAME,COURSE,CAFEDRE,AGE,CITY from test_db.Students INNER JOIN test_db.city on City.ID_CITY = CITY_ID";

}
