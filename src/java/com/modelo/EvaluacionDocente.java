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
public class EvaluacionDocente implements Evaluacion{
    
    private String idEvaluacion;
    private String nombre;
    private String descripcion;
    private ArrayList<PreguntaDocente> preguntas = new ArrayList<PreguntaDocente>();

    public EvaluacionDocente() {
    }

    public EvaluacionDocente(String idEvaluacion, String nombre, String descripcion) {
        this.idEvaluacion = idEvaluacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public String getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(String idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<PreguntaDocente> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<PreguntaDocente> preguntas) {
        this.preguntas = preguntas;
    }
    
    @Override
    public String nombreEvaluacion() {
        return nombre;
    }
    
}
