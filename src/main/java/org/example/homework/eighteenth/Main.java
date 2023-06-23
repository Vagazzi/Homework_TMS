package org.example.homework.eighteenth;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostgreSQLConfig psql = new PostgreSQLConfig();
        MySQLConfig msSQL = new MySQLConfig();


        List<Student> mySqlStudentsDefQuery = DatabaseHandler.readData(msSQL.getURL(),msSQL.getUser(),msSQL.getPassword(),msSQL.getDefaultQuery(),false);
        List<Student> mySqlStudentsJoinQuery = DatabaseHandler.readData(msSQL.getURL(),msSQL.getUser(),msSQL.getPassword(),msSQL.getJoinQuery(),true);

        System.out.println("MySQL queries");
        System.out.println(mySqlStudentsDefQuery);
        System.out.println(mySqlStudentsJoinQuery);
        System.out.println("--------------");


        List<Student> pSqlStudentsDefQuery = DatabaseHandler.readData(psql.getURL(),psql.getUser(),psql.getPassword(),psql.getDefaultQuery(),false);
        List<Student> pSqlStudentsJoinQuery = DatabaseHandler.readData(psql.getURL(),psql.getUser(),psql.getPassword(),psql.getJoinQuery(),true);
        System.out.println("PSQL queries");
        System.out.println(pSqlStudentsDefQuery);
        System.out.println(pSqlStudentsJoinQuery);
    }


}
