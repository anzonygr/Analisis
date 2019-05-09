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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author soporte
 */
public class RegistroSesion extends HttpServlet {

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
            PreparedStatement pst = null;
            ResultSet rst = null;
            int tipo_cuenta = Integer.parseInt(request.getParameter("tipo_cuenta"));
            int cod_login = 0;
            String contraseña = "prueba";
            Consultas co1 = new Consultas();
            contraseña = "hola";
            String contador = "select * from login";
            pst = co1.getConexion().prepareStatement(contador);
            rst = pst.executeQuery();
            while (rst.next()) {
                cod_login++;
                if (contraseña.equals(rst.getString(2))){
                    contraseña = co1.generar_password();
                }
                
            }
            Consultas co = new Consultas();
            if (co.registrar(cod_login, contraseña, tipo_cuenta)) {
                String prueba = contraseña;
                request.setAttribute("clave", prueba);
                RequestDispatcher rd = request.getRequestDispatcher("contraseña.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("Registro.jsp");
            }
        } catch (Exception e) {
            response.sendRedirect("index.jsp?error=Error al ingresar datos en la base de datos, hablar con el Administrador");
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
