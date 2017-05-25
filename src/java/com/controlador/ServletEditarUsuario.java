/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.BD.AdministradorJDBC;
import com.BD.DocenteJDBC;
import com.BD.EstudianteJDBC;
import com.modelo.Administrador;
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
            HttpSession session = request.getSession();
            
            String tipoUsuario = (String) request.getSession().getAttribute("tipoUsuario");
           
            if(accion.equals("editar")){
                if(tipoUsuario.equalsIgnoreCase("estudiante")){
                    int pkeyEstudiante = (int) request.getSession().getAttribute("pkeyEstudiante");
                    Estudiante estu = new Estudiante(pkeyEstudiante, nombres, apellidos, username, password, correo);
                    EstudianteJDBC estuJDBC = new EstudianteJDBC();
                    int rows = estuJDBC.update(estu);
                    request.getRequestDispatcher("dashboard_estudiante.jsp").forward(request, response);
                }else if(tipoUsuario.equalsIgnoreCase("docente")){

                    int pkeyDocente = (int) request.getSession().getAttribute("pkeyDocente");
                    Docente doce = new Docente(pkeyDocente, nombres, apellidos, username, password, correo);
                    DocenteJDBC doceJDBC = new DocenteJDBC();
                    int rows = doceJDBC.update(doce);
                    if(rows == 1){
                        session.setAttribute("pkeyAdmin", doce.getNumIdentifica());
                        session.setAttribute("nombres", doce.getNombres());
                        session.setAttribute("apellidos", doce.getApellidos());
                        session.setAttribute("username", doce.getUsername());
                        session.setAttribute("password", doce.getPassword());
                        session.setAttribute("correo", doce.getCorreo());
                        session.setAttribute("tipoUsuario", doce.getTipoUsuario());
                    }
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }else if(tipoUsuario.equalsIgnoreCase("administrador")){
                    
                    int pkeyAdmin = (int) request.getSession().getAttribute("pkeyAdmin");
                    Administrador admin = new Administrador(pkeyAdmin, nombres, apellidos, username, password, correo);
                    AdministradorJDBC adminJDBC = new AdministradorJDBC();
                    int rows = adminJDBC.update(admin);
                    if(rows ==1){
                        session.setAttribute("pkeyAdmin", admin.getNumIdentifica());
                        session.setAttribute("nombres", admin.getNombres());
                        session.setAttribute("apellidos", admin.getApellidos());
                        session.setAttribute("username", admin.getUsername());
                        session.setAttribute("password", admin.getPassword());
                        session.setAttribute("correo", admin.getCorreo());
                        session.setAttribute("tipoUsuario", admin.getTipoUsuario());
                    }
                    request.getRequestDispatcher("dashboard_admin.jsp").forward(request, response);
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
