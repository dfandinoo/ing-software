/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.util.ArrayList;

/**
 *
 * @author Amelia
 */
public class PreguntaDocente {
    
    private String idPregunta;
    private String textoPregunta;
    private ArrayList<RespuestaDocente> respuestas = new ArrayList<RespuestaDocente>();

    public PreguntaDocente() {
    }

    public PreguntaDocente(String idPregunta, String textoPregunta) {
        this.idPregunta = idPregunta;
        this.textoPregunta = textoPregunta;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public ArrayList<RespuestaDocente> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<RespuestaDocente> respuestas) {
        this.respuestas = respuestas;
    }
    
    
}
