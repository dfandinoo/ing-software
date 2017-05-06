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
    private Usuario usuario;

    public Quejas() {
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
}
