<%-- 
    Document   : L_Estudiante
    Created on : 14-may-2019, 23:58:34
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
    if (usuario == null) {
        response.sendRedirect("index.jsp?error=No haz iniciado sesion");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catedratico</title>
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="navbar-brand text-white bg-primary" href="Catedratico.jsp">CATEDRATICO</a>
                    <a class="nav-item nav-link" href="Nueva_Actividad.jsp">Nueva Tarea</a>
                </div>
            </div>
            <a href="Cerrar.jsp" class="form-inline my-2 my-lg-0">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Salir</button>
            </a>
        </nav>
        <form action="L_Estudiante" method="post">

            <div class="content-wrapper col-12">
                <div class="container-fluid ">
                    <br/>
                    <br/>
                    <h1 align="center">Listado de Usuarios</h1>
                    <table class="col table table-striped table-bordered table-responsive">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">NOMBRE</th> 
                                <th scope="col">APELLIDO</th>    
                                <th scope="col">TELEFONO</th>  
                                <th scope="col">CORREO</th>   
                                <th scope="col">ZONA</th>
                                <th scope="col">PARCIAL 1</th>
                                <th scope="col">PARCIAL 2</th>
                                <th scope="col">EXAMEN</th>
                                <th scope="col">PROCEDER</th>   
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                try {
                                    ResultSet rst = null;
                                    ResultSet rst2 = null;
                                    ResultSet rst3 = null;
                                    String string = request.getParameter("prueba");
                                    String[] parts = string.split("-");
                                    String codigo_grado = parts[0];
                                    String codigo_curso = parts[1];
                                    String codigo_seccion = parts[2];
                                    String codigo_catedratico = parts[3];
                                    int cod_grado = Integer.parseInt(codigo_grado);
                                    int cod_curso = Integer.parseInt(codigo_curso);
                                    int cod_seccion = Integer.parseInt(codigo_seccion);
                                    int cod_catedratico = Integer.parseInt(codigo_catedratico);

                                    Consultas co = new Consultas();

                                    rst = co.nombre_list_asignacion(cod_grado, cod_curso, cod_seccion, cod_catedratico);
                                    rst2 = co.nombre_catedratico_completo();
                                    rst3 = co.nombre_estudiante_completo();

                                    String codigo = null;
                                    int i = 1;
                                    while (rst.next()) {

                                        out.print("<tr><td>" + i + "</td>");
                                        out.print("<td>" + rst.getString(1) + "</td><td>" + rst.getString(2) + "</td><td>" + rst.getString(3) + "</td><td>" + rst.getString(4) + "</td><td>" + rst.getString(5) + "</td><td>" + rst.getString(6) + "</td><td>" + rst.getString(7) + "</td><td>" + rst.getString(8) + "</td><td>");
                                        codigo = numero;

                            %>

                        <button type="submit" name="prueba" value="<%=codigo%>" class="btn btn-primary">Calificar</button>

                        <%
                                out.println("</td></tr>");
                                i++;
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
