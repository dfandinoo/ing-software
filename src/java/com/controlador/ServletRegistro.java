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
@WebServlet(name = "ServletRegistro", urlPatterns = {"/ServletRegistro"})
public class ServletRegistro extends HttpServlet {

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
            String apelildos = request.getParameter("apellidos");
            String tipoIdentifiacion = request.getParameter("tipoIdentificacion");
            int numIdentificacion = Integer.parseInt(request.getParameter("numidentifica"));
            String correo = request.getParameter("correo");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String tipoUsuario = request.getParameter("tipoUsuario");
            String accion = request.getParameter("accion");
            
            HttpSession sesion = request.getSession();
            String mensaje = null;
            
            if(accion.equals("crear")){
                if(tipoUsuario.equals("docente")){
                    String especialidad = request.getParameter("especialidaddocente");
                    Docente docente = new Docente(especialidad, nombres, apelildos, correo, tipoIdentifiacion, numIdentificacion, tipoUsuario, username, password);
                    DocenteJDBC doceJDBC = new DocenteJDBC();
                    int rows = doceJDBC.insertDocente(docente);
                    if(rows==1){
                        mensaje = "Registro de Docente Exitoso";
                    }else{
                        mensaje = "Error, Registro Docente";
                    }
                }else if(tipoUsuario.equals("estudiante")){
                    Estudiante estudiante = new Estudiante(nombres, apelildos, correo, tipoIdentifiacion, numIdentificacion, tipoUsuario, username, password, false);
                    EstudianteJDBC estuJDBC = new EstudianteJDBC();
                    int rows = estuJDBC.verificarUsuario(estudiante);
                    if(rows==1){
                        mensaje = "Registro de Estudiante Exitoso";
                    }else{
                        mensaje = "Error, Registro Estudiante";
                    }
                }else{
                    if(tipoUsuario.equals("administrador")){
                        Administrador admin = new Administrador(nombres, apelildos, correo, tipoIdentifiacion, numIdentificacion, tipoUsuario, username, password);
                        AdministradorJDBC adminJDBC = new AdministradorJDBC();
                        int rows = adminJDBC.verificarUsuario(admin);
                        if(rows==1){
                            mensaje = "Registro de Administrador Exitoso";
                        }else{
                            mensaje = "Error, Registro Administrador";
                        }
                    }
                }
                sesion.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
