/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.BD.CursoJDBC;
import com.BD.DocenteJDBC;
import com.BD.EstudianteJDBC;
import com.modelo.Curso;
import com.modelo.Docente;
import com.modelo.Estudiante;
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
 * @author Amelia
 */
public class ServletDashboardAdmin extends HttpServlet {

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
            if(accion.equals("ingresarContenido")){
                CursoJDBC cursoJDBC = new CursoJDBC();
                ArrayList<Curso> cursos = (ArrayList<Curso>) cursoJDBC.select(); 
                session.setAttribute("cursos", cursos);
                request.getRequestDispatcher("ingresar_contenido_curso.jsp").forward(request, response);
            }else if(accion.equals("asignarDocente")){
                
                CursoJDBC cursoJDBC = new CursoJDBC();
                DocenteJDBC doceJDBC = new DocenteJDBC();
                ArrayList<Curso> cursos = (ArrayList<Curso>) cursoJDBC.selectDocente();  
                ArrayList<Docente> docentes = (ArrayList<Docente>) doceJDBC.selectDocentes();
                session.setAttribute("cursos", cursos);
                session.setAttribute("docentes", docentes);
                request.getRequestDispatcher("asignar_docente.jsp").forward(request, response);
                
            }else if(accion.equals("crearCursos")){
                request.getRequestDispatcher("crear_cursos.jsp").forward(request, response);
            }else if(accion.equals("cerrarSesion")){
                request.getRequestDispatcher("logout.jsp").forward(request, response);
            }else if(accion.equals("registrarAdmin")){
                request.getRequestDispatcher("register_admin.jsp").forward(request, response);
            }else if(accion.equals("cambiarEstado")){
                EstudianteJDBC estuJDBC = new EstudianteJDBC();
                ArrayList<Estudiante> estudiantes = (ArrayList<Estudiante>) estuJDBC.selectEstu();
                session.setAttribute("estudiantes", estudiantes);
                request.getRequestDispatcher("cambiar_estado.jsp").forward(request, response);
            }else if(accion.equals("editarUsuario")){
                request.getRequestDispatcher("editar_usuario.jsp").forward(request, response);
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
