/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.BD.ContenidoJDBC;
import com.modelo.Contenido;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author damian
 */
public class ServletIngresarContenido extends HttpServlet {

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
        String pkeyCurso = request.getParameter("idCurso");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();
        String mensaje="";
        if(accion.equals("ingresar")){
            Contenido conten = new Contenido(nombre, descripcion);
            ContenidoJDBC contenJDBC = new ContenidoJDBC();
            int rows = contenJDBC.insertContenido(conten, Integer.parseInt(pkeyCurso));
            if(rows==1){
                mensaje = "Contenido creado";
                session.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("ingresar_contenido_curso.jsp").forward(request, response);
            }else{
                mensaje="No se ha podido crear en contenido al curso";
                session.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("ingresar_contenido_curso.jsp");
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
