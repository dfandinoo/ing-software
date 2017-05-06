/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.BD.DocenteJDBC;
import com.BD.EstudianteJDBC;

/**
 *
 * @author Amelia
 */
public class Docente extends Usuario {
    
    private String especialidad;

    public Docente() {
    }

    public Docente(String especialidad) {
        this.especialidad = especialidad;
    }

    public Docente(String especialidad, String nombres, String apellidos, String correo, String tipoIdentifica, int numIdentifica, String tipoUsuario, String username, String password) {
        super(nombres, apellidos, correo, tipoIdentifica, numIdentifica, tipoUsuario, username, password);
        this.especialidad = especialidad;
    }

    public Docente(String username, String password) {
        super(username, password);
    }
    
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public int registrarUsuario(){
        
        return 0;
    }
    
    public int editarUsuario(int pkeyDocente, String nombres, String apellidos, String username, String password, String correo){
        
        DocenteJDBC doceJDBC = new DocenteJDBC();
        return doceJDBC.update(pkeyDocente, nombres, apellidos, username, password, correo);
    }
}
