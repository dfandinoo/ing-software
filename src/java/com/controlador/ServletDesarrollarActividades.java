/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.BD.ActividadJDBC;
import com.modelo.Actividad;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
>>>>>>> origin/master
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
import javax.servlet.http.Part;
>>>>>>> origin/master

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
<<<<<<< HEAD
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
=======
        Date fecha = new Date();
        String adjunto = request.getParameter("adjunto");
        String descripcion = request.getParameter("descripcion");
        String accion = request.getParameter("accion");
        if(accion.equals("enviar")){
            Part filePart = request.getPart("adjunto"); // Obtiene el archivo
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

            //InputStream fileContent = filePart.getInputStream(); //Lo transforma en InputStream

            String path="/archivos/";
            File uploads = new File(path); //Carpeta donde se guardan los archivos
            uploads.mkdirs(); //Crea los directorios necesarios
            File file = File.createTempFile("cod"+fecha.getTime()+"-", "-"+fileName, uploads); //Evita que hayan dos archivos con el mismo nombre

            try (InputStream input = filePart.getInputStream()){
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
        
>>>>>>> origin/master
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
