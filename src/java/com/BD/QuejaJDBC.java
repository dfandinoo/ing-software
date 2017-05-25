/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.Quejas;
import com.servicio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author felipe
 */
public class QuejaJDBC {
    
    private final String SQL_INSERT_QUEJA_ESTU =
            "INSERT INTO queja(asunto, textoqueja, correo, fkeyestudiante) VALUES(?, ?, ?, ?)";
    
    private final String SQL_INSERT_QUEJA_DOCE =
            "INSERT INTO queja(asunto, textoqueja, correo, fkeyDocente) VALUES(?, ?, ?, ?)";
    
    public int insertQuejaEstu(Quejas queja, int pkeyEstudiante){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_QUEJA_ESTU);
            int index = 1;
            stmt.setString(index++, queja.getAsunto());
            stmt.setString(index++, queja.getTextoQueja());
            stmt.setString(index++, queja.getCorreo());
            stmt.setInt(index++, pkeyEstudiante);
            System.out.println("Ejecutando query "+SQL_INSERT_QUEJA_ESTU);
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
    
    public int insertQuejaDoce(Quejas queja, int pkeyDocente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_QUEJA_DOCE);
            int index = 1;
            stmt.setString(index++, queja.getAsunto());
            stmt.setString(index++, queja.getTextoQueja());
            stmt.setString(index++, queja.getCorreo());
            stmt.setInt(index++, pkeyDocente);
            System.out.println("Ejecutando query "+SQL_INSERT_QUEJA_DOCE);
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
}
