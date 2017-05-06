/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.Estudiante;
import com.servicio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amelia
 */
public class EstudianteJDBC {
    private final String SQL_INSERT =
            "INSERT INTO estudiante(pkeyEstudiante, tipoIdentifica, nombres, apellidos,"
            + "correo, tipoUsuario, username, password, estado) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private final String SQL_INSERT_USU =
            "INSERT INTO usuario(username, password, fkeyEstudiante)"
            + "VALUES (?, ?, ?)";
    
    private final String SQL_UPDATE =
            "UPDATE estudiante SET nombres = (?), apellidos = (?), username = (?), "
            + "password = (?), correo = (?) WHERE pkeyEstudiante = (?)";
    
    
    public int verificarUsuario(Estudiante estu){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        int insert = 0;
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:  SELECT COUNT(*) FROM usuario where fkeyEstudiante = "+ estu.getNumIdentifica());
            stmt = conn.prepareStatement("SELECT COUNT(*) FROM usuario where fkeyEstudiante = "+ estu.getNumIdentifica());
            rs = stmt.executeQuery();
            while(rs.next()){
                rows = rs.getInt(1);
            }
            if(rows ==0){
                insert = insertEstudiante(estu);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        
        return insert;
    }
            
    public int insertEstudiante(Estudiante estu){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setInt(index++, estu.getNumIdentifica());
            stmt.setString(index++, estu.getTipoIdentifica());
            stmt.setString(index++, estu.getNombres());
            stmt.setString(index++, estu.getApellidos());
            stmt.setString(index++, estu.getCorreo());
            stmt.setString(index++, estu.getTipoUsuario());
            stmt.setString(index++, estu.getUsername());
            stmt.setString(index++, estu.getPassword());
            stmt.setBoolean(index++, estu.isEstado());
            System.out.println("Ejecutando query "+SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros Afectados "+rows);
            insertUsuario(estu);
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }
    
    public void insertUsuario(Estudiante estu){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_USU);
            int index = 1;
            stmt.setString(index++, estu.getUsername());
            stmt.setString(index++, estu.getPassword());
            stmt.setInt(index++, estu.getNumIdentifica());
            System.out.println("Ejecutando query "+SQL_INSERT_USU);
            rows = stmt.executeUpdate();
            System.out.println("Registros Afectados "+rows);
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
        }
    }
    
    public Estudiante select(Estudiante estudi){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        Estudiante estu = new Estudiante();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM estudiante WHERE username = '"+estudi.getUsername()+
                    "' AND password = '"+estudi.getPassword()+"'");
            rs = stmt.executeQuery();
            rs.next();
            estu.setNumIdentifica(rs.getInt(1));
            estu.setTipoIdentifica(rs.getString(2));
            estu.setNombres(rs.getString(3));
            estu.setApellidos(rs.getString(4));
            estu.setCorreo(rs.getString(5));
            estu.setTipoUsuario(rs.getString(6));
            estu.setUsername(rs.getString(7));
            estu.setPassword(rs.getString(8));
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return estu;
    }
    
    public int update(int pkeyEstudiante, String nombres, String apellidos, String username, String password, String correo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: "+SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index =1;
            stmt.setString(index++, nombres);
            stmt.setString(index++, apellidos);
            stmt.setString(index++, username);
            stmt.setString(index++, password);
            stmt.setString(index++, correo);
            stmt.setInt(index++, pkeyEstudiante);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados "+rows);
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }

}
