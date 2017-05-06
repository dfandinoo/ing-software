/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.Administrador;
import com.modelo.Docente;
import com.servicio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amelia
 */
public class AdministradorJDBC {
    
    private final String SQL_INSERT =
            "INSERT INTO administrador(pkeyAdmin, tipoIdentifica, nombres, apellidos,"
            + "correo, tipoUsuario, username, password) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    private final String SQL_INSERT_USU =
            "INSERT INTO usuario(username, password, fkeyAdmin)"
            + "VALUES (?, ?, ?)";
    
    
    public int verificarUsuario(Administrador admin){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        int insert = 0;
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:  SELECT COUNT(*) FROM usuario where fkeyAdmin = "+ admin.getNumIdentifica());
            stmt = conn.prepareStatement("SELECT COUNT(*) FROM usuario where fkeyAdmin = "+ admin.getNumIdentifica());
            rs = stmt.executeQuery();
            while(rs.next()){
                rows = rs.getInt(1);
            }
            if(rows ==0){
                insert = insertAdministrador(admin);
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
    
    public int insertAdministrador(Administrador admin){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setInt(index++, admin.getNumIdentifica());
            stmt.setString(index++, admin.getTipoIdentifica());
            stmt.setString(index++, admin.getNombres());
            stmt.setString(index++, admin.getApellidos());
            stmt.setString(index++, admin.getCorreo());
            stmt.setString(index++, admin.getTipoUsuario());
            stmt.setString(index++, admin.getUsername());
            stmt.setString(index++, admin.getPassword());
            System.out.println("Ejecutando query "+SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros Afectados "+rows);
            insertUsuario(admin);
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }
    
    public void insertUsuario(Administrador admin){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_USU);
            int index = 1;
            stmt.setString(index++, admin.getUsername());
            stmt.setString(index++, admin.getPassword());
            stmt.setInt(index++, admin.getNumIdentifica());
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
    
    public Administrador select(Administrador adminis){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Administrador admin = new Administrador();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM administrador WHERE username = '"+adminis.getUsername()+"'"
                    + " AND password = '"+adminis.getPassword()+"'");
            rs = stmt.executeQuery();
            rs.next();
            admin.setNumIdentifica(rs.getInt(1));
            admin.setTipoIdentifica(rs.getString(2));
            admin.setNombres(rs.getString(3));
            admin.setApellidos(rs.getString(4));
            admin.setCorreo(rs.getString(5));
            admin.setTipoUsuario(rs.getString(6));
            admin.setUsername(rs.getString(7));
            admin.setPassword(rs.getString(8));      
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return admin;
    }
}
