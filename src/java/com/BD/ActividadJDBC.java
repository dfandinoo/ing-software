/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.Actividad;
import com.servicio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amelia
 */
public class ActividadJDBC {
    private final String SQL_INSERT_ACTIVIDAD =
            "INSERT INTO actividad(nombre, descripcion, fechaentrega, fkeycontenido) VALUES(?, ?, ?, ?)";
    
    public int insertContenido(Actividad acti, int pkeyContenido){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_ACTIVIDAD);
            int index = 1;
            stmt.setString(index++, acti.getNombre());
            stmt.setString(index++, acti.getDescripcion());
            stmt.setString(index++, acti.getFechaEntrega());
            stmt.setInt(index++, pkeyContenido);
            System.out.println("Ejecutando query "+SQL_INSERT_ACTIVIDAD);
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
