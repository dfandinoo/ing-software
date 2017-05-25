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
    
    private int idActividad;
    private String nombre;
    private String descripcion;
    private String fechaEntrega;
    private ActividadDesarrollada actividadDesa;

    public Actividad() {
    }

    public Actividad(int idActividad, String nombre, String descripcion, String fechaEntrega, ActividadDesarrollada actividadDesa) {
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.actividadDesa = actividadDesa;
    }
    
    public Actividad(String nombre, String descripcion, String fechaEntrega) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
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

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public ActividadDesarrollada getActividadDesa() {
        return actividadDesa;
    }

    public void setActividadDesa(ActividadDesarrollada actividadDesa) {
        this.actividadDesa = actividadDesa;
    }
    
    
}
