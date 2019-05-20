/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author agonzalez
 */
@WebServlet(name = "R_Estudiante", urlPatterns = {"/regis_est"})
public class R_Estudiante extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int cod_login = 0;
            String usuario = request.getParameter("email_estudiante");
            String contraseña = request.getParameter("password_estudiante");
            int cod_rol = 3;
            String nombre = request.getParameter("nombre_estudiante");
            String apellido = request.getParameter("apellido_estudiante");
            String direccion = request.getParameter("direccion_estudiante");
            int telefono1 = Integer.parseInt(request.getParameter("telefono1_estudiante"));
            int telefono2 = Integer.parseInt(request.getParameter("telefono2_estudiante"));
            String sexo = request.getParameter("sexo_estudiante");
            String cui = request.getParameter("cui_estudiante");
            String fecha = request.getParameter("fecha_estudiante");
            int cod_seccion = Integer.parseInt(request.getParameter("seccion_estudiante"));
            int cod_encargado = Integer.parseInt(request.getParameter("encargado"));
            int cod_grado = 0;
            int cod_curso = 0;
            String horario = "15:30";
            int cod_catedratico = 0;
            int zona = 20;
            int parcial_1 = 7;
            int parcial_2 = 15;
            int examen_final = 40;
            int test = 0;
            String estado = "asignado";

            ResultSet rst = null;
            ResultSet rst2 = null;
            ResultSet rst3 = null;
            ResultSet rst4 = null;
            
            Consultas co = new Consultas();
            Consultas co2 = new Consultas();
            Consultas co3 = new Consultas();
            

            int cod_estudiante = 0;
            
            rst = co.cod_grado_seccion(cod_seccion);
            while (rst.next()) {
                cod_grado = Integer.parseInt(rst.getString(1));
            }
            rst2 = co.nombre_grado_curso(cod_grado);

            if (co2.regis_estudiante(cod_rol, nombre, apellido, telefono1, telefono2, sexo, direccion, cui, fecha, cod_grado, cod_encargado, usuario)) {
                if (co3.registrar(cod_rol, usuario, contraseña)) {
                    Consultas co4 = new Consultas();
                    rst4 = co4.cod_estudiante(nombre, apellido, usuario);
                    while (rst4.next()) {
                        cod_estudiante = Integer.parseInt(rst4.getString(1));
                    }
                    while (rst2.next()) {
                        cod_curso = Integer.parseInt(rst2.getString(1));
                        Consultas co5 = new Consultas();
                        rst3 = co5.nombre_catedratico_asignacion(cod_grado, cod_curso, cod_seccion);
                        while (rst3.next()) {
                            cod_catedratico = Integer.parseInt(rst3.getString(1));
                            Consultas co6 = new Consultas();
                            co6.regis_asignacion(cod_grado, cod_curso, cod_seccion, cod_catedratico, cod_estudiante, horario, zona, parcial_1, parcial_2, examen_final, estado);
                            
                        }
                    }
                    //out.print("<h1>"+cod_estudiante+"</h1>");
                    

                    response.sendRedirect("Administrador.jsp");
                } else {
                    response.sendRedirect("Registro_Estudiante.jsp");
                }
            } else {
                response.sendRedirect("Registro_Estudiante.jsp");
            }

        } catch (Exception e) {
            
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
