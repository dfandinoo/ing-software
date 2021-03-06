/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.Docente;
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
    
    private final String SQL_UPDATE_USUARIO =
            "UPDATE usuario SET username = (?), password = (?) WHERE fkeydocente = (?)";
    
    private final String SQL_SELECT =
            "SELECT * FROM docente";
    
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
    
    public int update(Docente doce){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: "+SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index =1;
            stmt.setString(index++, doce.getNombres());
            stmt.setString(index++, doce.getApellidos());
            stmt.setString(index++, doce.getUsername());
            stmt.setString(index++, doce.getPassword());
            stmt.setString(index++, doce.getCorreo());
            stmt.setInt(index++, doce.getNumIdentifica());
            rows = stmt.executeUpdate();
            updateUsuario(doce.getUsername(), doce.getPassword(), doce.getNumIdentifica());
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
    
    public void updateUsuario(String username, String password, int pkeyDocente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: "+SQL_UPDATE_USUARIO);
            stmt = conn.prepareStatement(SQL_UPDATE_USUARIO);
            int index =1;

            stmt.setString(index++, username);
            stmt.setString(index++, password);
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
    }
    
    public List<Docente> selectDocentes(){
        Connection conn= null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Docente doce = null;
        List<Docente> docentes = new ArrayList<Docente>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int pkeyDocente = rs.getInt(1);
                String tipoIdenti = rs.getString(2);
                String nombres = rs.getString(3);
                String apellidos = rs.getString(4);
                String correo = rs.getString(5);
                String tipoUsuario = rs.getString(6);
                String username = rs.getString(7);
                String password = rs.getString(8);
                String especialidad = rs.getString(9);
                doce = new Docente();
                doce.setNumIdentifica(pkeyDocente);
                doce.setTipoIdentifica(tipoIdenti);
                doce.setNombres(nombres);
                doce.setApellidos(apellidos);
                doce.setCorreo(correo);
                doce.setTipoUsuario(tipoUsuario);
                doce.setUsername(username);
                doce.setPassword(password);
                doce.setEspecialidad(especialidad);
                docentes.add(doce);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return docentes;
    }
}
