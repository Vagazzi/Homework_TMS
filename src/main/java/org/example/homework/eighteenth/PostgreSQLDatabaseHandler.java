package org.example.homework.eighteenth;

import lombok.Getter;

@Getter
public class PostgreSQLDatabaseHandler {

    private  final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private  final String user = "raze";
    private  final String password = "null";
    private  final String DEFAULT_QUERY = "SELECT * FROM STUDENTS";
    private  final String JOIN_QUERY = "select ID_STUDENT::integer, NAME,COURSE,CAFEDRE,AGE,CITY from Students INNER JOIN city on City.ID_CITY::integer = CITY_ID::integer";

}
