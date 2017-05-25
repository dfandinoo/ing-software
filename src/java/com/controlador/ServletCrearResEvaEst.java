/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.BD.RespuestaEstudianteJDBC;
import com.modelo.RespuestaEstudiante;
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
public class ServletCrearResEvaEst extends HttpServlet {

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
        String respuesta = request.getParameter("respuesta");
        String esCorrecta = request.getParameter("esCorrecta");
        String accion = request.getParameter("accion");
        boolean ban=false;
        String mensaje="";
        if(accion.equals("crearPregunta")){
            String pkeyPregEstu = (String) session.getAttribute("pkeyPregEstu");
            if(esCorrecta.equals("correcta")){
                ban=true;
            }else if(esCorrecta.equals("incorrecta")){
                ban=false;
            }
            RespuestaEstudiante respEstu = new RespuestaEstudiante(respuesta, ban);
            RespuestaEstudianteJDBC respEstuJDBC = new RespuestaEstudianteJDBC();
            int rows = respEstuJDBC.insertRespuestaEstu(respEstu, Integer.parseInt(pkeyPregEstu));
            if(rows==1){
                    ArrayList<RespuestaEstudiante> respuestasEstu = (ArrayList<RespuestaEstudiante>) respEstuJDBC.selectRespuestasEvaluacion(Integer.parseInt(pkeyPregEstu));
                    mensaje="Respuesta creada Exitosamente";
                    session.setAttribute("respuestasEstu", respuestasEstu);
                    session.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("respuestas_evaluacion.jsp").forward(request, response);
                }else{
                    mensaje="La respuesta no fue Creada";
                    session.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("respuestas_evaluacion.jsp").forward(request, response);
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
