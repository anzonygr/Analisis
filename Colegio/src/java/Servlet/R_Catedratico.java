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

/**
 *
 * @author agonzalez
 */
@WebServlet(name = "R_Catedratico", urlPatterns = {"/regis_cate"})
public class R_Catedratico extends HttpServlet {

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
            
            String usuario = request.getParameter("email_catedratico");
            String contraseña = request.getParameter("password_catedratico");
            
            int cod_rol = 2;
            String nombre = request.getParameter("nombre_catedratico");
            String apellido = request.getParameter("apellido_catedratico");
            String direccion = request.getParameter("direccion_catedratico");
            int telefono1 = Integer.parseInt(request.getParameter("telefono1_catedratico"));
            int telefono2 = Integer.parseInt(request.getParameter("telefono2_catedratico"));
            String sexo = request.getParameter("sexo_catedratico");
            String dpi = request.getParameter("dpi_catedratico");
            String fecha = request.getParameter("fecha_catedratico");
            String titulo = request.getParameter("titulo_catedratico");
            
            Consultas co2 = new Consultas();
            Consultas co3 = new Consultas();
            if (co2.regis_catedratico(cod_rol, nombre, apellido, telefono1, telefono2, usuario, direccion, dpi, sexo, fecha, titulo)) {
                
                if (co3.registrar(cod_rol, usuario, contraseña)) {
                    response.sendRedirect("Administrador.jsp");
                } else {
                    response.sendRedirect("Registro_Catedratico.jsp");
                }
            } else {
                response.sendRedirect("Registro_Catedratico.jsp");
            }

        } catch (Exception e) {
            response.sendRedirect("index.jsp");
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
