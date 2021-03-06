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
public class Contenido {
    
    private int idContenido;
    private String nombre;
    private String descripcion;
    private Actividad actividad;

    public Contenido() {
    }

    public Contenido(int idContenido, String nombre, String descripcion, Actividad actividad) {
        this.idContenido = idContenido;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.actividad = actividad;
    }
    
    public Contenido(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public int getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(int idContenido) {
        this.idContenido = idContenido;
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

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
    
}
