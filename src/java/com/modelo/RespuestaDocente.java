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
public class RespuestaDocente {
    
    private String idRespuesta;
    private String textoRespuesta;
    private boolean esCorrecta;

    public RespuestaDocente() {
    }

    public RespuestaDocente(String idRespuesta, String textoRespuesta, boolean esCorrecta) {
        this.idRespuesta = idRespuesta;
        this.textoRespuesta = textoRespuesta;
        this.esCorrecta = esCorrecta;
    }

    public String getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(String idRespuesta) {
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
