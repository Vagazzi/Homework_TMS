package org.example.homework.eighteenth;

import lombok.Getter;

@Getter
public class PostgreSQLConfig {

    private  final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private  final String user = "raze";
    private  final String password = "null";
    private  final String default_query = "SELECT * FROM STUDENTS";
    private  final String join_query = "select ID_STUDENT::integer, NAME,COURSE,CAFEDRE,AGE,CITY from Students INNER JOIN city on City.ID_CITY::integer = CITY_ID::integer";

}

