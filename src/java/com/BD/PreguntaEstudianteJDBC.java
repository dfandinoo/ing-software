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
}
