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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author soporte
 */
public class InicioSesiones extends HttpServlet {
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
            String contraseña = request.getParameter("pass");
            Consultas coo = new Consultas();
            PreparedStatement pst = null;
            ResultSet rst = null;
            String estandar = "1";
            String premium = "2";
            String ventas = "3";
            String administrador = "4";
            String numero = null;
            String sql = "select * from login";
            pst = coo.getConexion().prepareStatement(sql);
            rst = pst.executeQuery();
            while (rst.next()) {
                if (contraseña.equals(rst.getString(2))) {
                    numero = rst.getString(3);
                    break;
                }
            }
            Consultas co = new Consultas();
            if (co.autentication(contraseña)) {
                HttpSession objsesion = request.getSession();
                if ((numero.equals(administrador)) != (numero.equals(ventas))) {
                    objsesion.setAttribute("contraseña", contraseña);
                    objsesion.setAttribute("numero", numero);
                    response.sendRedirect("Registro.jsp");
                }   if ((numero.equals(estandar)) != (numero.equals(premium))){
                    objsesion.setAttribute("contraseña", contraseña);
                    objsesion.setAttribute("numero", numero);
                    response.sendRedirect("Menu.jsp");
                }
            } else {
                response.sendRedirect("index.jsp?error=Clave Incorrecto");
            }
        } catch (Exception e) {
            response.sendRedirect("index.jsp?error=Clave Incorrecto");
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
