/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.BD.ActividadJDBC;
import com.modelo.Actividad;
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
public class ServletCrearActividades extends HttpServlet {

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
        String nombre = request.getParameter("nombActividad");
//        String tipo = request.getParameter("tipoActividad");
        String fechaEntrega = request.getParameter("fechaEntrega");
        String descripcion = request.getParameter("descripcion");
        String pkeyContenido = request.getParameter("idContenido");
        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();
        String mensaje="";
        if(accion.equals("crearActividad")){
            pkeyContenido = (String) session.getAttribute("pkeyContenido");
            Actividad acti = new Actividad(nombre, descripcion, fechaEntrega);
            ActividadJDBC actiJDBC = new ActividadJDBC();
            int rows = actiJDBC.insertContenido(acti, Integer.parseInt(pkeyContenido));
            if(rows == 1){
                mensaje="Actividad creada con exito";
                session.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("dashboard_docente.jsp").forward(request, response);
            }else{
                mensaje="Error al crear la Actividad";
                session.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("crear_actividad.jsp").forward(request, response);
            }
        }else if(accion.equals("verContenido")){
            session.setAttribute("pkeyContenido", pkeyContenido);
            request.getRequestDispatcher("crear_actividad.jsp").forward(request, response);
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
