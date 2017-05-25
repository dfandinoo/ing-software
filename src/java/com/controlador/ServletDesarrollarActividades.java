/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.BD.ActividadJDBC;
import com.modelo.Actividad;
import java.io.IOException;
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
public class ServletDesarrollarActividades extends HttpServlet {

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
        String pkeyContenido = request.getParameter("idContenido");
        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();
        String mensaje="";
        if(accion.equals("verContenido")){
            ActividadJDBC actiJDBC = new ActividadJDBC();
            ArrayList<Actividad> actividades = (ArrayList<Actividad>) actiJDBC.selectActividad(Integer.parseInt(pkeyContenido));
            Actividad acti = actividades.get(0);
            session.setAttribute("pkeyActividad", acti.getIdActividad());
            session.setAttribute("actividades", actividades);
            session.setAttribute("pkeyContenido", pkeyContenido);
            request.getRequestDispatcher("enviar_actividad.jsp").forward(request, response);
        }else if(accion.equals("enviar")){
            String descripcion = request.getParameter("descripcion");
            int pkeyEstudiante = (int) session.getAttribute("pkeyEstudiante");
            int pkeyActividad = (int) session.getAttribute("pkeyActividad");
            ActividadJDBC actiJDBC = new ActividadJDBC();
            int rows = actiJDBC.insertActividadDesarrollada(descripcion, pkeyEstudiante, pkeyActividad);
            if(rows == 1){
                mensaje="Actividad Desarrollada correctamente";
                session.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("enviar_actividad.jsp").forward(request, response);
            }else{
                mensaje="La actividad no se ha podido desarrollar correctamente";
                session.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("enviar_actividad.jsp").forward(request, response);
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
