/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.servicio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author Amelia
 */
public class CursoJDBC {
    private final String SQL_INSERT =
            "INSERT INTO curso(nombre, duracion, fechaInicio, cantidadEstudiantes) "
            + "VALUES (?, ?, ?, ?)";
    
    public int insertCurso(String nombre, int cantEstudi, String fecha, int duracion){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, nombre);
            stmt.setInt(index++, cantEstudi);
            stmt.setString(index++, fecha);
            stmt.setInt(index++, duracion);
            System.out.println("Ejecutando query "+SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros Afectados "+rows);
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }
    
    public int select(String username, String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT COUNT(*) FROM estudiante WHERE username = '"+username+"' AND password = '"+password+"'");
            int index = 1;
            rs = stmt.executeQuery();
            rs.next();
            rows = rs.getInt(1);      
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return rows;
    }
}
