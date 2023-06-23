package org.example.homework.eighteenth;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostgreSQLConfig psql = new PostgreSQLConfig();
        MySQLConfig msSQL = new MySQLConfig();


        List<Student> mySqlDefaultStudents = DatabaseHandler.readData(msSQL.getURL(),msSQL.getUser(),msSQL.getPassword(),msSQL.getDefaultQuery(),false);
        List<Student> mySqlJoinStudents = DatabaseHandler.readData(msSQL.getURL(),msSQL.getUser(),msSQL.getPassword(),msSQL.getJoinQuery(),true);

        System.out.println("MySQL queries");
        System.out.println(mySqlDefaultStudents);
        System.out.println(mySqlJoinStudents);
        System.out.println("--------------");


        List<Student> pSqlDefaultStudents = DatabaseHandler.readData(psql.getURL(),psql.getUser(),psql.getPassword(),psql.getDefaultQuery(),false);
        List<Student> pSqlJoinStudents = DatabaseHandler.readData(psql.getURL(),psql.getUser(),psql.getPassword(),psql.getJoinQuery(),true);
        System.out.println("PSQL queries");
        System.out.println(pSqlDefaultStudents);
        System.out.println(pSqlJoinStudents);
    }


}
