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
            String cod_catedratico = null;
            String cod_estudiante = null;
            String cod_encargado = null;
            String sql = "select * from login";
            pst = coo.getConexion().prepareStatement(sql);
            rst = pst.executeQuery();
            while (rst.next()) {
                if ((usuario.equals(rst.getString(3))) && (contraseña.equals(rst.getString(4)))) {
                    numero = rst.getString(1);
                    break;
                }
            }
            Consultas co = new Consultas();
            if (co.autentication(usuario, contraseña)) {
                HttpSession objsesion = request.getSession();
                if (numero.equals(administrador)) {
                    objsesion.setAttribute("usuario", usuario);
                    objsesion.setAttribute("numero", numero);
                    response.sendRedirect("Administrador.jsp");
                } else if (numero.equals(catedratico)) {
                    Consultas co2 = new Consultas();
                    ResultSet rst2 = co2.cod_usuario_login_catedratico(usuario);
                    while (rst2.next()) {
                        cod_catedratico = rst2.getString(1);
                    }
                    objsesion.setAttribute("usuario", usuario);
                    objsesion.setAttribute("numero", numero);
                    objsesion.setAttribute("cod_catedratico", cod_catedratico);
                    response.sendRedirect("Catedratico.jsp");
                } else if (numero.equals(padre)) {
                    Consultas co3 = new Consultas();
                    ResultSet rst2 = co3.cod_usuario_login_encargado(usuario);
                    while (rst2.next()) {
                        cod_encargado = rst2.getString(1);
                    }
                    objsesion.setAttribute("usuario", usuario);
                    objsesion.setAttribute("numero", numero);
                    objsesion.setAttribute("cod_encargado", cod_encargado);
                    response.sendRedirect("Padre.jsp");
                } else if (numero.equals(estudiante)) {
                    Consultas co4 = new Consultas();
                    ResultSet rst2 = co4.cod_usuario_login_estudiante(usuario);
                    while (rst2.next()) {
                        cod_estudiante = rst2.getString(1);
                    }
                    objsesion.setAttribute("usuario", usuario);
                    objsesion.setAttribute("numero", numero);
                    objsesion.setAttribute("cod_estudiante", cod_estudiante);
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
