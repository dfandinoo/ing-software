/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.BD.AdministradorJDBC;
import com.BD.DocenteJDBC;
import com.BD.EstudianteJDBC;
import com.BD.UsuarioJDBC;
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
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tipoUsuario = request.getParameter("tipoUsuario");
        String accion = request.getParameter("accion");
        
        HttpSession sesion = request.getSession();
        String mensaje;
        String usuario;
        
        if(accion.equals("ingresar")){
            
            UsuarioJDBC usuaJDBC = new UsuarioJDBC();
            usuario = usuaJDBC.select(username, password);
            
            if(usuario.equals("Estudiante")){
                Estudiante estu = new Estudiante(username, password);
                EstudianteJDBC estuJDBC = new EstudianteJDBC();
                estu = estuJDBC.select(estu);
                if(estu!=null){
                    mensaje="Login Correcto";
                    sesion.setAttribute("mensaje", mensaje);
                    sesion.setAttribute("pkeyEstudiante", estu.getNumIdentifica());
                    sesion.setAttribute("nombres", estu.getNombres());
                    sesion.setAttribute("apellidos", estu.getApellidos());
                    sesion.setAttribute("username", estu.getUsername());
                    sesion.setAttribute("password", estu.getPassword());
                    sesion.setAttribute("correo", estu.getCorreo());
                    sesion.setAttribute("tipoUsuario", estu.getTipoUsuario());
                    request.getRequestDispatcher("dashboard_estudiante.jsp").forward(request, response);                    
                }else{
                    mensaje="Login Incorrecto";
                    sesion.setAttribute("pkeyEstudiante", "");
                    sesion.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("login.jsp").forward(request, response);                  
                }
            }else{
                if(usuario.equals("Docente")){
                    Docente doce = new Docente(username, password);
                    DocenteJDBC doceJDBC = new DocenteJDBC();
                    doce=doceJDBC.select(doce);
                    if(doce!=null){
                        mensaje="Login Correcto";
                        sesion.setAttribute("mensaje", mensaje);
                        sesion.setAttribute("pkeyDocente", doce.getNumIdentifica());
                        sesion.setAttribute("nombres", doce.getNombres());
                        sesion.setAttribute("apellidos", doce.getApellidos());
                        sesion.setAttribute("username", doce.getUsername());
                        sesion.setAttribute("password", doce.getPassword());
                        sesion.setAttribute("correo", doce.getCorreo());
                        sesion.setAttribute("tipoUsuario", doce.getTipoUsuario());
                        request.getRequestDispatcher("editar_usuario.jsp").forward(request, response); 
                    }else{
                        mensaje="Login Incorrecto";
                        sesion.setAttribute("pkeyDocente", "");
                        sesion.setAttribute("mensaje", mensaje);
                        request.getRequestDispatcher("login.jsp").forward(request, response); 
                    }
                }else{
                    if(usuario.equals("Administrador")){
                        Administrador admin = new Administrador(username, password);
                        AdministradorJDBC adminJDBC = new AdministradorJDBC();
                        admin=adminJDBC.select(admin);
                        if(admin != null){
                            mensaje="Login Correcto";
                            sesion.setAttribute("mensaje", mensaje);
                            sesion.setAttribute("pkeyAdmin", admin.getNumIdentifica());
                            sesion.setAttribute("nombres", admin.getNombres());
                            sesion.setAttribute("apellidos", admin.getApellidos());
                            sesion.setAttribute("username", admin.getUsername());
                            sesion.setAttribute("password", admin.getPassword());
                            sesion.setAttribute("correo", admin.getCorreo());
                            sesion.setAttribute("tipoUsuario", admin.getTipoUsuario());
                            request.getRequestDispatcher("editar_usuario.jsp").forward(request, response); 
                        }else{
                            mensaje="Login Incorrecto";
                            sesion.setAttribute("administrador", "");
                            sesion.setAttribute("mensaje", mensaje);
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                    } 
                } 
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
