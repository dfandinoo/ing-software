/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.BD.EvaluacionEstudianteJDBC;
import com.BD.PreguntaEstudianteJDBC;
import com.modelo.EvaluacionEstudiante;
import com.modelo.PreguntaEstudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author damian
 */
public class ServletCrearEvaluacionEstudiante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nombreEvaluacion = request.getParameter("nombreEvaluacion");
        String descripcion = request.getParameter("descripcion");
        String duracion = request.getParameter("duracion");
        String accion = request.getParameter("accion");
        String pkeyCurso =  (String) session.getAttribute("pkeyCurso");
        String mensaje ="";
        if(accion.equals("crearEvaluacion")){
            EvaluacionEstudiante evalEstu = new EvaluacionEstudiante(Integer.parseInt(duracion), nombreEvaluacion, descripcion);
            EvaluacionEstudianteJDBC evalEstuJDBC = new EvaluacionEstudianteJDBC();
            int rows = evalEstuJDBC.insertEvalEstu(evalEstu, Integer.parseInt(pkeyCurso));
            if(rows ==1){
                ArrayList<EvaluacionEstudiante> evaluacionEstu = (ArrayList<EvaluacionEstudiante>) evalEstuJDBC.selectEvalEstu(Integer.parseInt(pkeyCurso));
                mensaje = "Evaluación creada con exito";
                session.setAttribute("evaluacionEstu", evaluacionEstu);
                session.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("crear_evaluacion.jsp").forward(request, response);
            }else{
                mensaje = "La evaluación no ha sido creada";
                session.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("crear_evaluacion.jsp").forward(request, response);
            }
        }else if(accion.equals("crearPreguntas")){
            PreguntaEstudianteJDBC pregEstuJDBC = new PreguntaEstudianteJDBC();
            String pkeyEvaluacion = request.getParameter("idEval");
            ArrayList<PreguntaEstudiante> preguntasEstu = (ArrayList<PreguntaEstudiante>) pregEstuJDBC.selectPreguntaEvaluacion(Integer.parseInt(pkeyEvaluacion));
            session.setAttribute("preguntasEstu", preguntasEstu);
            session.setAttribute("pkeyEvalEstu", pkeyEvaluacion);
            request.getRequestDispatcher("preguntas_evaluacion_estudiante.jsp").forward(request, response);
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
