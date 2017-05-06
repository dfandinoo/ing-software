/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD;

import com.modelo.Estudiante;
import com.servicio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amelia
 */
public class UsuarioJDBC {
    
    public String select(String username, String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int pkeyEstudiante = 0;
        int pkeyDocente = 0;
        int pkeyAdmin = 0;
        String usuario="";
        
        Estudiante estu = new Estudiante();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT fkeyEstudiante, fkeyDocente, fkeyAdmin FROM usuario WHERE username = '"+username+"' AND password = '"+password+"'");
            rs = stmt.executeQuery();
            rs.next();
            pkeyEstudiante = rs.getInt(1);
            pkeyDocente = rs.getInt(2);
            pkeyAdmin = rs.getInt(3);
            
            if(pkeyEstudiante != 0){
                usuario = "Estudiante";
            }else{
                if(pkeyDocente != 0){
                    usuario = "Docente";
                }else{
                    if(pkeyAdmin != 0){
                        usuario = "Administrador";
                    }
                }
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return usuario;
    }
}
