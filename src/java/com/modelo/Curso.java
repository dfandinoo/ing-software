/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.BD.CursoJDBC;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Amelia
 */
public class Curso {
    
    private String idCurso;
    private String nombre;
    private int cantEstudiantes;
    private int duracion;
    private Date fechaInicio;
    private Evaluacion evaluacion;
    private String idDocente;
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Contenido> contenidos = new ArrayList<>();

    public Curso() {
    }

    public Curso(String idCurso, String nombre, int cantEstudiantes, int duracion, Date fechaInicio, Evaluacion evaluacion, String idDocente) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.cantEstudiantes = cantEstudiantes;
        this.duracion = duracion;
        this.fechaInicio = fechaInicio;
        this.evaluacion = evaluacion;
        this.idDocente = idDocente;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantEstudiantes() {
        return cantEstudiantes;
    }

    public void setCantEstudiantes(int cantEstudiantes) {
        this.cantEstudiantes = cantEstudiantes;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(ArrayList<Contenido> contenidos) {
        this.contenidos = contenidos;
    }
    
    public int insertarCurso(String nombre, int cantEstudi, String fecha, int duracion){
        
        CursoJDBC cursoJDBC = new CursoJDBC();
        return cursoJDBC.insertCurso(nombre, cantEstudi, fecha, duracion);
    }
}
