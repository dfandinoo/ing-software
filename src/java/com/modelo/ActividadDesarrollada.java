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
public class ActividadDesarrollada {
    
    private String idActividadDesa;
    private String descripcion;
    private String idEstudiante;   

    public ActividadDesarrollada() {
    }

    public ActividadDesarrollada(String idActividadDesa, String descripcion, String idEstudiante) {
        this.idActividadDesa = idActividadDesa;
        this.descripcion = descripcion;
        this.idEstudiante = idEstudiante;
    }
    
    public String getIdActividadDesa() {
        return idActividadDesa;
    }

    public void setIdActividadDesa(String idActividadDesa) {
        this.idActividadDesa = idActividadDesa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    
    
}
