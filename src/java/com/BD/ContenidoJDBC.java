/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.Contenido;
import com.servicio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author felipe
 */
public class ContenidoJDBC {
    private final String SQL_INSERT_CONTENIDO= 
            "INSERT INTO contenido(nombre, descripcion, fkeycurso) VALUES(?, ?, ?)";
    
    public int insertContenido(Contenido conten, int pkeyCurso){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_CONTENIDO);
            int index = 1;
            stmt.setString(index++, conten.getNombre());
            stmt.setString(index++, conten.getDescripcion());
            stmt.setInt(index++, pkeyCurso);
            System.out.println("Ejecutando query "+SQL_INSERT_CONTENIDO);
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
