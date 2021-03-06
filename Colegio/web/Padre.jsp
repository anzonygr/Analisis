<%-- 
    Document   : Padre
    Created on : 12-may-2019, 12:30:04
    Author     : ASUS
--%>

<%@page import="Controlador.Consultas"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession objsession = request.getSession(false);
    String usuario = (String) objsession.getAttribute("usuario");
    String numero = (String) objsession.getAttribute("numero");
    String cod_encargado = (String) objsession.getAttribute("cod_encargado");
    if (usuario == null) {
        response.sendRedirect("index.jsp?error=No haz iniciado sesion");
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Encargado</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <script src="lib/jquery/jquery.min.js"></script>
        <script src="lib/jquery/jquery-migrate.min.js"></script>
        <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/superfish/hoverIntent.js"></script>
        <script src="lib/superfish/superfish.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/counterup/counterup.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/isotope/isotope.pkgd.min.js"></script>
        <script src="lib/lightbox/js/lightbox.min.js"></script>
        <script src="lib/touchSwipe/jquery.touchSwipe.min.js"></script>
        <!-- Contact Form JavaScript File -->
        <script src="contactform/contactform.js"></script>

        <script>
            $(document).ready(function () {
                $('#fecha').datepicker();
            });
        </script>
        <!-- Template Main Javascript File -->
        <script src="js/main2.js"></script>

        <script src="js/jquery/jquery-2.2.4.min.js"></script>
        <!-- Popper js -->
        <script src="js/bootstrap/popper.min.js"></script>
        <!-- Bootstrap js -->
        <script src="js/bootstrap/bootstrap.min.js"></script>
        <!-- All Plugins js -->
        <script src="js/plugins/plugins.js"></script>
        <!-- Active js -->
        <script src="js/active.js"></script>
        <link rel="icon" href="img/core-img/favicon.ico">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">
        <link rel="stylesheet" href="style.css">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-danger">

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="navbar-brand text-white bg-danger" href="Padre.jsp">Encargado</a>

                </div>
            </div>
            <a href="Cerrar.jsp" class="form-inline my-2 my-lg-0">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Salir</button>
            </a>
        </nav>

        <form action="L_Curso.jsp" method="post">

            <div class="content-wrapper col-12">
                <div class="container-fluid ">
                    <br/>
                    <br/>
                    <h1 align="center">Listado de Cursos</h1>
                    <table class="col table table-striped table-bordered table-responsive">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">NOMBRE COMPLETO</th>     
                                <th scope="col">GRADO</th>  
                                <th scope="col">SECCION</th>
                                <th scope="col">PROCEDER</th>   
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                try {
                                    ResultSet rst = null;

                                    int cod_encargado1 = Integer.parseInt(cod_encargado);
                                    Consultas co = new Consultas();
                                    rst = co.nombre_encargado_estudiante(cod_encargado1);
                                    String codigo = null;
                                    int i = 1;
                                    String nombre = null;
                                    String grado = null;
                                    String seccion = null;
                                    String cod_estudiante = null;
                                    String nombre2 = null;
                                    String grado2 = null;
                                    String seccion2 = null;
                                    String cod_estudiante2 = null;
                                    while (rst.next()) {
                                        nombre = rst.getString(1);
                                        grado = rst.getString(2);
                                        seccion = rst.getString(3);
                                        cod_estudiante = rst.getString(4);
                                        if ((rst.getString(1).equals(nombre2)) && (rst.getString(2).equals(grado2)) && (rst.getString(3).equals(seccion2)) && (rst.getString(4).equals(cod_estudiante2))) {
                                            nombre2 = nombre;
                                            grado2 = grado;
                                            seccion2 = seccion;
                                            cod_estudiante2 = cod_estudiante;

                                        } else {
                                            out.print("<tr><td>" + i + "</td>");
                                            out.print("<td>" + rst.getString(1) + "</td><td>" + rst.getString(2) + "</td><td>" + rst.getString(3)+ "</td><td>");
                                            codigo = rst.getString(4);
                                            nombre2 = nombre;
                                            grado2 = grado;
                                            seccion2 = seccion;
                                            cod_estudiante2 = cod_estudiante;
                                        
                            %>

                        <button type="submit" name="prueba" value="<%=codigo%>" class="btn btn-primary">Ver</button>

                        <%
                                out.println("</td></tr>");
                                i++;
                                }
                            }

                        %>
                        </tbody>
                    </table>


                </div>

            </div>

            <% } catch (Exception e) {
                    out.print(e.toString());
                }
            %>
        </form>
    </body>
</html>
