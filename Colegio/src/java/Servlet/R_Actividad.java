/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "R_Actividad", urlPatterns = {"/R_Actividad"})
public class R_Actividad extends HttpServlet {

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
            ResultSet rst = null;
            String string = request.getParameter("prueba");
            String[] parts = string.split("-");
            String codigo_grado = parts[0];
            String codigo_curso = parts[1];
            String codigo_seccion = parts[2];
            String codigo_catedratico = parts[3];
            int cod_catedratico = Integer.parseInt(codigo_catedratico);
            int cod_grado = Integer.parseInt(codigo_grado);
            int cod_curso = Integer.parseInt(codigo_curso);
            int cod_seccion = Integer.parseInt(codigo_seccion);
            int cod_actividad = 0;
            int cod_asignacion = 0;
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            String fecha = request.getParameter("fecha");
            int nota = Integer.parseInt(request.getParameter("nota"));
            String nombre_asignacion = "";

            Consultas co = new Consultas();
            cod_actividad = co.actividiad();
            rst = co.actividiad_cod_asignacion(cod_grado, cod_curso, cod_seccion, cod_catedratico);
            while (rst.next()) {
                nombre_asignacion = rst.getString(1);
            }
            cod_asignacion = Integer.parseInt(nombre_asignacion);

            Consultas co2 = new Consultas();
            if (co.regis_actividad(cod_actividad, cod_asignacion, cod_grado, cod_curso, cod_seccion, cod_catedratico, titulo, descripcion, nota, fecha)) {
                response.sendRedirect("Catedratico.jsp");
            } else {
                response.sendRedirect("Crear_Tarea.jsp");
            }
//            out.print(cod_actividad+"  "+ cod_asignacion+"  "+ cod_grado+"  "+ cod_curso+"  "+ cod_seccion+"  "+ cod_catedratico+"  "+ titulo+"  "+ descripcion+"  "+ nota+"  "+ fecha);
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
