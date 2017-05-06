/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author Amelia
 */
public abstract class Usuario {
    
    private String nombres;
    private String apellidos;
    private String correo;
    private String tipoIdentifica;
    private int numIdentifica;
    private String tipoUsuario;
    private String username;
    private String password;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, String correo, String tipoIdentifica, int numIdentifica, String tipoUsuario, String username, String password) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tipoIdentifica = tipoIdentifica;
        this.numIdentifica = numIdentifica;
        this.tipoUsuario = tipoUsuario;
        this.username = username;
        this.password = password;
    }
    
    public Usuario(String username, String password){
        this.username=username;
        this.password=password;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoIdentifica() {
        return tipoIdentifica;
    }

    public void setTipoIdentifica(String tipoIdentifica) {
        this.tipoIdentifica = tipoIdentifica;
    }

    public int getNumIdentifica() {
        return numIdentifica;
    }

    public void setNumIdentifica(int numIdentifica) {
        this.numIdentifica = numIdentifica;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public abstract int registrarUsuario();
    
}
