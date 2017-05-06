/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Docente;
import com.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletEditarUsuario", urlPatterns = {"/ServletEditarUsuario"})
public class ServletEditarUsuario extends HttpServlet {

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
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String correo = request.getParameter("correo");
            
            String accion = request.getParameter("accion");
            
            
            String tipoUsuario = (String) request.getSession().getAttribute("tipoUsuario");
           
            if(accion.equals("editar")){
                if(tipoUsuario.equals("estudiante")){
                    int pkeyEstudiante = (int) request.getSession().getAttribute("pkeyEstudiante");
                    Estudiante estu = new Estudiante();
                    estu.editarUsuario(pkeyEstudiante, nombres, apellidos, username, password, correo);
                    request.getRequestDispatcher("dashboard_estudiante.jsp").forward(request, response);
                }else if(tipoUsuario.equals("docente")){

                    int pkeyDocente = (int) request.getSession().getAttribute("pkeyDocente");
                    Docente doce = new Docente();
                    doce.editarUsuario(pkeyDocente, nombres, apellidos, username, password, correo);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
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
