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
 * @author ASUS
 */
@WebServlet(name = "R_Encargado", urlPatterns = {"/R_Encargado"})
public class R_Encargado extends HttpServlet {

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
            String usuario = request.getParameter("email_encargado");
            String contraseña = request.getParameter("password_encargado");
            int cod_encargado = 0;
            int cod_rol = 4;
            String nombre = request.getParameter("nombre_encargado");
            String apellido = request.getParameter("apellido_encargado");
            String direccion = request.getParameter("direccion_encargado");
            int telefono1 = Integer.parseInt(request.getParameter("telefono1_encargado"));
            int telefono2 = Integer.parseInt(request.getParameter("telefono2_encargado"));
            String parentesco = request.getParameter("parentesco");
            String dpi = request.getParameter("dpi_encargado");
            
            PreparedStatement pst = null;
            ResultSet rst = null;
            PreparedStatement pst2 = null;
            ResultSet rst2 = null;
            
            int cont = 1;
            int cont2 = 1;

            Consultas coo = new Consultas();
            String sql = "select * from encargado";
            pst = coo.getConexion().prepareStatement(sql);
            rst = pst.executeQuery();
            while (rst.next()) {
                cont++;
            }
            
            Consultas co = new Consultas();
            String sql2 = "select * from login";
            pst2 = co.getConexion().prepareStatement(sql2);
            rst2 = pst2.executeQuery();
            while (rst2.next()) {
                cont2++;
            }
            
            
            cod_encargado = cont;
            cod_login = cont2;
            
            Consultas co2 = new Consultas();
            Consultas co3 = new Consultas();
            if (co2.regis_encargado(cod_encargado, cod_rol, nombre, apellido, telefono1, telefono2, usuario, parentesco, direccion, dpi)) {
                
                if (co3.registrar(cod_rol, cod_login, usuario, contraseña)) {
                    response.sendRedirect("Administrador.jsp");
                } else {
                    response.sendRedirect("Registro_Estudiante.jsp");
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