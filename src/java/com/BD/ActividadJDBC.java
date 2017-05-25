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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amelia
 */
public class ActividadJDBC {
    private final String SQL_INSERT_ACTIVIDAD =
            "INSERT INTO actividad(nombre, descripcion, fechaentrega, fkeycontenido) VALUES(?, ?, ?, ?)";
    
    private final String SQL_INSERT_ACTI_DESA = 
            "INSERT INTO actividaddesarrollada(descripcion, fkeyestudiante, fkeyactividad) VALUES(?, ?, ?)";
    
    public int insertActividad(Actividad acti, int pkeyContenido){
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
    
    public int insertActividadDesarrollada(String descripcion, int pkeyEstudiante, int pkeyActividad){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_ACTI_DESA);
            int index = 1;
            stmt.setString(index++, descripcion);
            stmt.setInt(index++, pkeyEstudiante);
            stmt.setInt(index++, pkeyActividad);
            System.out.println("Ejecutando query "+SQL_INSERT_ACTI_DESA);
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
    
    public List<Actividad> selectActividad(int pkeyContenido){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        Actividad acti = null;
        ArrayList<Actividad> actividades = new ArrayList<Actividad>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM actividad WHERE fkeyContenido = (?)");
            stmt.setInt(1, pkeyContenido);
            rs = stmt.executeQuery();
            while(rs.next()){
                acti = new Actividad();
                acti.setIdActividad(rs.getInt(1));
                acti.setNombre(rs.getString(2));
                acti.setDescripcion(rs.getString(3));
                acti.setFechaEntrega(rs.getString(4));
                actividades.add(acti);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return actividades;
    }
}
