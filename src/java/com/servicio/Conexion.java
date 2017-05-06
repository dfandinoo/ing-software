/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author BORDADORA
 */
public class Conexion {
    
    private static String JDBC_DRIVER = "org.postgresql.Driver";
    private static String db = "CursosVirtuales";
    private static String JDBC_URL = "jdbc:postgresql://localhost:5432/"+db;
    private static String JDBC_USER = "postgres";
    private static String JDBC_PASS = "admin";
    private static Driver driver = null;
    
    public static synchronized  Connection getConnection()throws SQLException{
        
        if(driver == null){
            try{
                
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
            }catch(Exception e){
                System.out.println("Fallo en cargar el driver JDBC");
                e.printStackTrace();
            }
        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public static void close(ResultSet rs){
        
        try{
            if(rs != null){
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void close(PreparedStatement stmt){
        
        try{
            if(stmt != null){
                stmt.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void close(Connection conn){
        
        try{
            if(conn != null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}