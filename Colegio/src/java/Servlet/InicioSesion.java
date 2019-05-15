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
 * @author ASUS
 */
@WebServlet(name = "InicioSesion", urlPatterns = {"/InicioLogin"})
public class InicioSesion extends HttpServlet {

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
            String usuario = request.getParameter("email");
            String contraseña = request.getParameter("pass");
            Consultas coo = new Consultas();
            PreparedStatement pst = null;
            ResultSet rst = null;
            String administrador = "1";
            String catedratico = "2";
            String padre = "4";
            String estudiante = "3";
            String numero = null;
            String sql = "select * from login";
            pst = coo.getConexion().prepareStatement(sql);
            rst = pst.executeQuery();
            while (rst.next()) {
                if ((usuario.equals(rst.getString(3)))&&(contraseña.equals(rst.getString(4)))) {
                    numero = rst.getString(1);
                    break;
                }
            }
            Consultas co = new Consultas();
            if (co.autentication(usuario, contraseña)) {
                HttpSession objsesion = request.getSession();
                if (numero.equals(administrador)) {
                    objsesion.setAttribute("contraseña", contraseña);
                    objsesion.setAttribute("numero", numero);
                    response.sendRedirect("Administrador.jsp");
                }   if (numero.equals(catedratico)){
                    objsesion.setAttribute("contraseña", contraseña);
                    objsesion.setAttribute("numero", numero);
                    response.sendRedirect("Catedratico.jsp");
                }if (numero.equals(padre)){
                    objsesion.setAttribute("contraseña", contraseña);
                    objsesion.setAttribute("numero", numero);
                    response.sendRedirect("Padre.jsp");
                }if (numero.equals(estudiante)){
                    objsesion.setAttribute("contraseña", contraseña);
                    objsesion.setAttribute("numero", numero);
                    response.sendRedirect("Estudiante.jsp");
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
