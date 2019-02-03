package com.exotale.mysql.api;

import java.sql.*;

public class Manager {

//By Watterdev

    public static void createDatabase(String USER,String PASS,String host,String database) {

        final String DB_URL = "jdbc:mysql://"+host+"/";
        Connection conn = null;
        Statement stmt = null;
        try{

            Class.forName("com.mysql.jdbc.Driver");


            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            System.out.println("Creating database...");
            stmt = conn.createStatement();

            String sql = "create database if not exists "+database;
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{

            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
                se2.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }


}
