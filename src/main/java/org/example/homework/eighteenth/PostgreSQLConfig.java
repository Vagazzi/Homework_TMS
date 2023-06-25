package org.example.homework.eighteenth;

import lombok.Getter;

@Getter
public class PostgreSQLConfig {

    private  final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private  final String user = "raze";
    private  final String password = "null";
    private  final String defaultQuery = "SELECT * FROM STUDENTS";
    private  final String joinQuery = "select ID_STUDENT::integer, NAME,COURSE,CAFEDRE,AGE,CITY from Students INNER JOIN city on City.ID_CITY::integer = CITY_ID::integer";

}

