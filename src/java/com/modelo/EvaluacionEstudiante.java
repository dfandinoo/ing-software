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
public class EvaluacionEstudiante implements Evaluacion{
    
    private String idEvaluacion;
    private String nombre;
    private String descripcion;
    private int duracion;
    private ArrayList<PreguntaEstudiante> preguntas = new ArrayList<PreguntaEstudiante>();

    public EvaluacionEstudiante() {
    }

    public EvaluacionEstudiante(String idEvaluacion, String nombre, String descripcion, int duracion) {
        this.idEvaluacion = idEvaluacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public ArrayList<PreguntaEstudiante> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<PreguntaEstudiante> preguntas) {
        this.preguntas = preguntas;
    }
    
    
    
    @Override
    public String nombreEvaluacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
