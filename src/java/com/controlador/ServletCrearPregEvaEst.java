/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.BD.PreguntaEstudianteJDBC;
import com.modelo.PreguntaEstudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author damian
 */
@WebServlet(name = "ServletCrearPregEvaEst", urlPatterns = {"/ServletCrearPregEvaEst"})
public class ServletCrearPregEvaEst extends HttpServlet {

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
        String pkeyEvalEstu = (String) session.getAttribute("pkeyEvalEstu");
        String pregunta = request.getParameter("pregunta");
        String valor = request.getParameter("valor");
        String accion = request.getParameter("accion");
        String mensaje="";
            if(accion.equals("crearPregunta")){
                PreguntaEstudiante pregEstu = new PreguntaEstudiante(pregunta, Double.parseDouble(valor));
                PreguntaEstudianteJDBC pregEstuJDBC = new PreguntaEstudianteJDBC();
                int rows = pregEstuJDBC.insertPregEstu(pregEstu, Integer.parseInt(pkeyEvalEstu));
                
                if(rows==1){
                    ArrayList<PreguntaEstudiante> preguntasEstu = (ArrayList<PreguntaEstudiante>) pregEstuJDBC.selectContenidoCurso(Integer.parseInt(pkeyEvalEstu));
                    mensaje="Pregunta creada Exitosamente";
                    session.setAttribute("preguntasEstu", preguntasEstu);
                    session.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("preguntas_evaluacion_estudiante.jsp").forward(request, response);
                }else{
                    mensaje="Pregunta creada ExitosamenteS";
                    session.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("preguntas_evaluacion_estudiante.jsp").forward(request, response);
                }
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
