package org.example.homework.eighteenth;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostgreSQLDatabaseHandler psql = new PostgreSQLDatabaseHandler();
        MySQLDatabaseHandler msSQL = new MySQLDatabaseHandler();


        List<Student> MySQLStudentsDefQuery = DatabaseHandler.readDataWithDefaultQuery(msSQL.getURL(),msSQL.getUser(),msSQL.getPassword(),msSQL.getDEFAULT_QUERY());
        List<Student> MySQLStudentsJoinQuery = DatabaseHandler.readDataWithJoinQuery(msSQL.getURL(),msSQL.getUser(),msSQL.getPassword(),msSQL.getJOIN_QUERY());

        System.out.println("MySQL queries");
        System.out.println(MySQLStudentsDefQuery);
        System.out.println(MySQLStudentsJoinQuery);
        System.out.println("--------------");


        List<Student> PSQLStudentsDefQuery = DatabaseHandler.readDataWithDefaultQuery(psql.getURL(),psql.getUser(),psql.getPassword(),psql.getDEFAULT_QUERY());
        List<Student> PSQLStudentsJoinQuery = DatabaseHandler.readDataWithJoinQuery(psql.getURL(),psql.getUser(),psql.getPassword(),psql.getJOIN_QUERY());
        System.out.println("PSQL queries");
        System.out.println(PSQLStudentsDefQuery);
        System.out.println(PSQLStudentsJoinQuery);
    }


}
