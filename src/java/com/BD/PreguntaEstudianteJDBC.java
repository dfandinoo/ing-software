/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.PreguntaEstudiante;
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
public class PreguntaEstudianteJDBC {
    private final String SQL_INSERT_PREG_ESTU =
            "INSERT INTO preguntaestudiante(textoPregunta, valorPregunta, fkeyEvalEstu) VALUES(?, ?, ?)";
    
    public int insertPregEstu(PreguntaEstudiante pregEstu, int pkeyEvalEstu){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_PREG_ESTU);
            int index = 1;
            stmt.setString(index++, pregEstu.getTextoPregunta());
            stmt.setDouble(index++, pregEstu.getValorPregunta());
            stmt.setInt(index++, pkeyEvalEstu);
            System.out.println("Ejecutando query "+SQL_INSERT_PREG_ESTU);
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
    
    public List<PreguntaEstudiante> selectContenidoCurso(int pkeyEvalEstu){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        PreguntaEstudiante pregEstu = null;
        ArrayList<PreguntaEstudiante> pregunstasEstu = new ArrayList<PreguntaEstudiante>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM preguntaestudiante WHERE fkeyEvalEstu = (?)");
            stmt.setInt(1, pkeyEvalEstu);
            rs = stmt.executeQuery();
            while(rs.next()){
                pregEstu = new PreguntaEstudiante();
                pregEstu.setIdPregunta(rs.getInt(1));
                pregEstu.setTextoPregunta(rs.getString(2));
                pregEstu.setValorPregunta(rs.getDouble(3));
                pregunstasEstu.add(pregEstu);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return pregunstasEstu;
    }
}
