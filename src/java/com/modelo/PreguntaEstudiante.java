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
public class PreguntaEstudiante {
    
    private String idPregunta;
    private String textoPregunta;
    private double valorPregunta;
    private ArrayList<PreguntaEstudiante> preguntas = new ArrayList<PreguntaEstudiante>();

    public PreguntaEstudiante() {
    }

    public PreguntaEstudiante(String idPregunta, String textoPregunta, double valorPregunta) {
        this.idPregunta = idPregunta;
        this.textoPregunta = textoPregunta;
        this.valorPregunta = valorPregunta;
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

    public double getValorPregunta() {
        return valorPregunta;
    }

    public void setValorPregunta(double valorPregunta) {
        this.valorPregunta = valorPregunta;
    }

    public ArrayList<PreguntaEstudiante> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<PreguntaEstudiante> preguntas) {
        this.preguntas = preguntas;
    }
    
    
}
