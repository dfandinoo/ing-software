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
public class RespuestaEstudiante {
    
    private int idRespuesta;
    private String textoRespuesta;
    private boolean esCorrecta;

    public RespuestaEstudiante() {
    }

    public RespuestaEstudiante(int idRespuesta, String textoRespuesta, boolean esCorrecta) {
        this.idRespuesta = idRespuesta;
        this.textoRespuesta = textoRespuesta;
        this.esCorrecta = esCorrecta;
    }
    
    public RespuestaEstudiante(String textoRespuesta, boolean esCorrecta) {
        this.textoRespuesta = textoRespuesta;
        this.esCorrecta = esCorrecta;
    }
    
    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    public boolean isEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }
    
    
}
