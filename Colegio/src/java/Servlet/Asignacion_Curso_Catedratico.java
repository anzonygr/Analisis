/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "Asignacion_Curso_Catedratico", urlPatterns = {"/Asig_Cate"})
public class Asignacion_Curso_Catedratico extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
        String string = request.getParameter("codigo_prueba");
        String[] parts = string.split("-");
        String codigo_grado = parts[0];
        String codigo_curso = parts[1];
        String codigo_seccion = parts[2];
        String codigo_catedratico = parts[3];
        
        int cod_catedratico = Integer.parseInt(codigo_catedratico);
        int cod_grado = Integer.parseInt(codigo_grado);
        int cod_curso = Integer.parseInt(codigo_curso);
        int cod_seccion = Integer.parseInt(codigo_seccion);
        int cod_asignacion = 0;
        int cod_estudiante = 0;
        String horario = "15:30";
        int zona = 0;
        int parcial_1 = 0;
        int parcial_2 = 0;
        int examen_final = 0;
        String estado = "asignado";

        Consultas co2 = new Consultas();
        cod_asignacion = co2.asignacion();

            Consultas co = new Consultas();
            if (co.regis_asignacion(cod_asignacion, cod_grado, cod_curso, cod_seccion, cod_catedratico , cod_estudiante, horario, zona, parcial_1, parcial_2, examen_final, estado)){
                response.sendRedirect("Administrador.jsp");
            }else {
            out.print(cod_asignacion + " " + cod_grado + " " + cod_curso + " " + cod_seccion + " " + cod_catedratico + " " + cod_estudiante + " " + horario + " " + zona + " " + parcial_1 + " " + parcial_2 + " " + examen_final + " " + estado);
            }
            
        } catch(Exception e){
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
