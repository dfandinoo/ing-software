/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.BD.AdministradorJDBC;

/**
 *
 * @author Amelia
 */
public class Administrador extends Usuario{

    public Administrador() {
    }

    public Administrador(String nombres, String apellidos, String correo, String tipoIdentifica, int numIdentifica, String tipoUsuario, String username, String password) {
        super(nombres, apellidos, correo, tipoIdentifica, numIdentifica, tipoUsuario, username, password);
    }

    public Administrador(String username, String password) {
        super(username, password);
    }
    
    @Override
    public int registrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
