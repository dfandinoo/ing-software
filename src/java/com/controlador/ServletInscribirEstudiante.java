/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.BD.CursoJDBC;
import com.modelo.Curso;
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
public class ServletInscribirEstudiante extends HttpServlet {

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
            String accion = request.getParameter("accion");
            String idCurso = request.getParameter("idCurso");
            int pkeyEstudiante = (int) session.getAttribute("pkeyEstudiante");
            String mensaje="";
            
            if(accion.equals("inscribir")){
                CursoJDBC cursoJDBC = new CursoJDBC();
                int rows = cursoJDBC.insertInscrip(pkeyEstudiante, idCurso);

                if(rows ==1){
                    ArrayList<Curso> cursosInscritos =  (ArrayList<Curso>) cursoJDBC.selectIdCurso(pkeyEstudiante);
                    session.setAttribute("cursosInscritos", cursosInscritos);
                    mensaje="El estudiante se ha inscrito correctamente";
                    session.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("inscribirse_al_curso.jsp").forward(request, response);
                }else{
                    mensaje="Hubo error en la inscripción";
                    session.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("inscribirse_al_curso.jsp").forward(request, response);
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
