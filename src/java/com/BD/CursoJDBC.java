/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.Curso;
import com.servicio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amelia
 */
public class CursoJDBC {
    private final String SQL_INSERT =
            "INSERT INTO curso(nombre, duracion, fechaInicio, cantidadEstudiantes) "
            + "VALUES (?, ?, ?, ?)";
    
    private final String SQL_SELECT =
            "SELECT * FROM curso WHERE estado = true";
    
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
    
    public List<Curso> select(){
        Connection conn= null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Curso curso = null;
        List<Curso> cursos = new ArrayList<Curso>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null; 
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idCurso = rs.getInt(1);
                String nombre = rs.getString(2);
                int duracion = rs.getInt(3);
                String fechaInicio = rs.getString(4);
                int cantEstu = rs.getInt(5);
                int idDocente = rs.getInt(6);
                curso = new Curso();
                curso.setIdCurso(String.valueOf(idCurso));
                curso.setNombre(nombre);
                curso.setDuracion(duracion);
                try {
                    fecha = (Date) format.parse(fechaInicio);
                } catch (ParseException ex) {
                    Logger.getLogger(CursoJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
                curso.setFechaInicio(fecha);
                curso.setIdDocente(String.valueOf(idDocente));
                cursos.add(curso);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return cursos;
    }
}
