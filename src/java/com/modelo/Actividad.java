/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.util.Date;

/**
 *
 * @author Amelia
 */
public class Actividad {
    
    private String idActividad;
    private String nombre;
    private String descripcion;
    private Date fechaEntrega;
    private ActividadDesarrollada actividadDesa;

    public Actividad() {
    }

    public Actividad(String idActividad, String nombre, String descripcion, Date fechaEntrega, ActividadDesarrollada actividadDesa) {
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.actividadDesa = actividadDesa;
    }

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
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

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public ActividadDesarrollada getActividadDesa() {
        return actividadDesa;
    }

    public void setActividadDesa(ActividadDesarrollada actividadDesa) {
        this.actividadDesa = actividadDesa;
    }
    
    
}
