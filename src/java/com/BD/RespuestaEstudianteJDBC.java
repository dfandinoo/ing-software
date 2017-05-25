/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.RespuestaEstudiante;
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
public class RespuestaEstudianteJDBC {
    private final String SQL_INSERT_RESP_ESTU =
            "INSERT INTO respuestaestudiante(textoResp, esCorrecta, fkeyPregEstu) VALUES(?, ?, ?)";
    
    public int insertRespuestaEstu(RespuestaEstudiante respEstu, int pkeyPregEstu){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_RESP_ESTU);
            int index = 1;
            stmt.setString(index++, respEstu.getTextoRespuesta());
            stmt.setBoolean(index++, respEstu.isEsCorrecta());
            stmt.setInt(index++, pkeyPregEstu);
            System.out.println("Ejecutando query "+SQL_INSERT_RESP_ESTU);
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
    
    public List<RespuestaEstudiante> selectRespuestasEvaluacion(int pkeyPregEstu){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        RespuestaEstudiante respEstu = null;
        ArrayList<RespuestaEstudiante> respuestasEstu = new ArrayList<RespuestaEstudiante>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM respuestaestudiante WHERE fkeyPregEstu = (?)");
            stmt.setInt(1, pkeyPregEstu);
            rs = stmt.executeQuery();
            while(rs.next()){
                respEstu = new RespuestaEstudiante();
                respEstu.setIdRespuesta(rs.getInt(1));
                respEstu.setTextoRespuesta(rs.getString(2));
                respEstu.setEsCorrecta(rs.getBoolean(3));
                respuestasEstu.add(respEstu);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return respuestasEstu;
    }
}
