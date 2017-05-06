/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.Docente;
import com.modelo.Estudiante;
import com.servicio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amelia
 */
public class DocenteJDBC {
    private final String SQL_INSERT =
            "INSERT INTO docente(pkeyDocente, tipoIdentifica, nombres, apellidos,"
            + "correo, tipoUsuario, username, password, especialidad) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private final String SQL_INSERT_USU =
            "INSERT INTO usuario(username, password, fkeyDocente)"
            + "VALUES (?, ?, ?)";
    
    private final String SQL_UPDATE =
            "UPDATE docente SET nombres = (?), apellidos = (?), username = (?), "
            + "password = (?), correo = (?) WHERE pkeyDocente = (?)";
    
    public int verificarUsuario(Docente doce){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        int insert = 0;
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:  SELECT COUNT(*) FROM usuario where fkeyDocente = "+ doce.getNumIdentifica());
            stmt = conn.prepareStatement("SELECT COUNT(*) FROM usuario where fkeyDocente = "+ doce.getNumIdentifica());
            rs = stmt.executeQuery();
            while(rs.next()){
                rows = rs.getInt(1);
            }
            if(rows ==0){
                insert = insertDocente(doce);
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
    
    public int insertDocente(Docente doce){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setInt(index++, doce.getNumIdentifica());
            stmt.setString(index++, doce.getTipoIdentifica());
            stmt.setString(index++, doce.getNombres());
            stmt.setString(index++, doce.getApellidos());
            stmt.setString(index++, doce.getCorreo());
            stmt.setString(index++, doce.getTipoUsuario());
            stmt.setString(index++, doce.getUsername());
            stmt.setString(index++, doce.getPassword());
            stmt.setString(index++, doce.getEspecialidad());
            System.out.println("Ejecutando query "+SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros Afectados "+rows);
            insertUsuario(doce);
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }
    
    public void insertUsuario(Docente doce){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_USU);
            int index = 1;
            stmt.setString(index++, doce.getUsername());
            stmt.setString(index++, doce.getPassword());
            stmt.setInt(index++, doce.getNumIdentifica());
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
    
     public Docente select(Docente docen){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Docente doce = new Docente();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM docente WHERE username = '"+docen.getUsername()+"'"
                    + " AND password = '"+docen.getPassword()+"'");
            rs = stmt.executeQuery();
            rs.next();
            doce.setNumIdentifica(rs.getInt(1));
            doce.setTipoIdentifica(rs.getString(2));
            doce.setNombres(rs.getString(3));
            doce.setApellidos(rs.getString(4));
            doce.setCorreo(rs.getString(5));
            doce.setTipoUsuario(rs.getString(6));
            doce.setUsername(rs.getString(7));
            doce.setPassword(rs.getString(8)); 
            doce.setEspecialidad(rs.getString(9));
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return doce;
    }
    
    public int update(int pkeyDocente, String nombres, String apellidos, String username, String password, String correo){
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
            stmt.setInt(index++, pkeyDocente);
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
