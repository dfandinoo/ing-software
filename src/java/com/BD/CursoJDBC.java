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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

/**
 *
 * @author Amelia
 */
public class CursoJDBC {
    private final String SQL_INSERT =
            "INSERT INTO curso(nombre, duracion, fechaInicio, cantidadEstudiantes, estado) "
            + "VALUES (?, ?, ?, ?, ?)";
    
    private final String SQL_SELECT =
            "SELECT * FROM curso WHERE estado = true";
    
    private final String SQL_SELECTDOCENTE =
            "SELECT * FROM curso WHERE estado = true AND fkeydocente is null";
    
    private final String SQL_INSERTINSCRIP =
            "INSERT INTO cursoestudiante(pkeyestudiante, pkeycurso)"
            + "VALUES (?, ?)";
    
    private final String SQL_UPDATEDOCENTE =
            "UPDATE curso SET fkeydocente = (?) WHERE idcurso = (?)";
    
    private final String SQL_SELECT_CURSOS_ESTU =
            "SELECT pkeycurso FROM cursoestudiante where pkeyestudiante = (?)";
    
    private final String SQL_CURSOS_INSCRITOS =
            "SELECT * FROM curso where idcurso = (?)";
    
    public int insertCurso(String nombre, int cantEstudi, String fecha, int duracion, boolean estado){
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
            stmt.setBoolean(index++, estado);
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
                curso.setFechaInicio(fechaInicio);
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
    
    public int insertInscrip(int pkeyEstudiante, String idCurso){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERTINSCRIP);
            int index = 1;
            stmt.setInt(index++, pkeyEstudiante);
            stmt.setInt(index++, Integer.parseInt(idCurso));
            System.out.println("Ejecutando query "+SQL_INSERTINSCRIP);
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
    
    public List<Curso> selectDocente(){
        Connection conn= null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Curso curso = null;
        List<Curso> cursos = new ArrayList<Curso>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTDOCENTE);
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
                curso.setFechaInicio(fechaInicio);
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
    
    public int updateDocente(String idCurso, String pkeyDocente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: "+SQL_UPDATEDOCENTE);
            stmt = conn.prepareStatement(SQL_UPDATEDOCENTE);
            int index =1;
            stmt.setInt(index++, Integer.valueOf(pkeyDocente));
            stmt.setInt(index++, Integer.valueOf(idCurso));
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
      
    public List<Curso> selectIdCurso(int pkeyEstudiante){
        Connection conn= null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Curso curso = null;
        List<Curso> cursos = new ArrayList<Curso>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CURSOS_ESTU);
            stmt.setInt(1, pkeyEstudiante);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idCurso = rs.getInt(1);
                cursos = selectInscritos(idCurso);
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
    private List<Curso> cursosInscritos = new ArrayList<Curso>();
    public List<Curso> selectInscritos(int idCurso){
        Connection conn= null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Curso curso = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CURSOS_INSCRITOS);
            stmt.setInt(1, idCurso);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idCurso1 = rs.getInt(1);
                String nombre = rs.getString(2);
                int duracion = rs.getInt(3);
                String fechaInicio = rs.getString(4);
                int cantEstu = rs.getInt(5);
                int idDocente = rs.getInt(6);
                curso = new Curso();
                curso.setIdCurso(String.valueOf(idCurso1));
                curso.setNombre(nombre);
                curso.setDuracion(duracion);
                curso.setFechaInicio(fechaInicio);
                curso.setIdDocente(String.valueOf(idDocente));
                cursosInscritos.add(curso);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return cursosInscritos;
    }
}
