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
public class Quejas {
    
    private String idQueja;
    private String textoQueja;
    private String asunto;
    private String correo;
    private Usuario usuario;

    public Quejas() {
    }

    public Quejas(String idQueja, String textoQueja, String asunto, String correo, Usuario usuario) {
        this.idQueja = idQueja;
        this.textoQueja = textoQueja;
        this.asunto = asunto;
        this.correo = correo;
        this.usuario = usuario;
    }
    
    public Quejas(String textoQueja, String asunto, String correo) {
        this.textoQueja = textoQueja;
        this.asunto = asunto;
        this.correo = correo;
    }
    
    public Quejas(String idQueja, String textoQueja, Usuario usuario) {
        this.idQueja = idQueja;
        this.textoQueja = textoQueja;
        this.usuario = usuario;
    }
    
    public String getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(String idQueja) {
        this.idQueja = idQueja;
    }

    public String getTextoQueja() {
        return textoQueja;
    }

    public void setTextoQueja(String textoQueja) {
        this.textoQueja = textoQueja;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
