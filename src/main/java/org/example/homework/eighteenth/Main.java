package org.example.homework.eighteenth;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostgreSQLConfig psql = new PostgreSQLConfig();
        MySQLConfig msSQL = new MySQLConfig();


        List<Student> MySQLStudentsDefQuery = DatabaseHandler.readData(msSQL.getURL(),msSQL.getUser(),msSQL.getPassword(),msSQL.getDefaultQuery(),false);
        List<Student> MySQLStudentsJoinQuery = DatabaseHandler.readData(msSQL.getURL(),msSQL.getUser(),msSQL.getPassword(),msSQL.getJoinQuery(),true);

        System.out.println("MySQL queries");
        System.out.println(MySQLStudentsDefQuery);
        System.out.println(MySQLStudentsJoinQuery);
        System.out.println("--------------");


        List<Student> PSQLStudentsDefQuery = DatabaseHandler.readData(psql.getURL(),psql.getUser(),psql.getPassword(),psql.getDefaultQuery(),false);
        List<Student> PSQLStudentsJoinQuery = DatabaseHandler.readData(psql.getURL(),psql.getUser(),psql.getPassword(),psql.getJoinQuery(),true);
        System.out.println("PSQL queries");
        System.out.println(PSQLStudentsDefQuery);
        System.out.println(PSQLStudentsJoinQuery);
    }


}
