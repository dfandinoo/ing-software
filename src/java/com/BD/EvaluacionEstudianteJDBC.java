/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.Contenido;
import com.modelo.EvaluacionEstudiante;
import com.servicio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipe
 */
public class EvaluacionEstudianteJDBC {
    private final String SQL_INSERT_EVALESTU =
            "INSERT INTO evaluacionestudiante(duracion, nombre, descripcion, fkeyCurso) VALUES(?, ? ,?, ?)";
    
    public int insertEvalEstu(EvaluacionEstudiante evalEstu, int pkeyCurso){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_EVALESTU);
            int index = 1;
            stmt.setInt(index++, evalEstu.getDuracion());
            stmt.setString(index++, evalEstu.getNombre());
            stmt.setString(index++, evalEstu.getDescripcion());
            stmt.setInt(index++, pkeyCurso);
            System.out.println("Ejecutando query "+SQL_INSERT_EVALESTU);
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
    
    public List<EvaluacionEstudiante> selectEvalEstu(int pkeyCurso){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        EvaluacionEstudiante evalEstu = null;
            ArrayList<EvaluacionEstudiante> evaluacionesEstu = new ArrayList<EvaluacionEstudiante>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM evaluacionestudiante WHERE fkeyCurso = (?)");
            stmt.setInt(1, pkeyCurso);
            rs = stmt.executeQuery();
            while(rs.next()){
                evalEstu = new EvaluacionEstudiante();
                evalEstu.setIdEvaluacion(rs.getInt(1));
                evalEstu.setDuracion(rs.getInt(2));
                evalEstu.setNombre(rs.getString(3));
                evalEstu.setDescripcion(rs.getString(4));
                evaluacionesEstu.add(evalEstu);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return evaluacionesEstu;
    }
}
