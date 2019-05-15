<%-- 
    Document   : Asignacion_Curso
    Created on : 12-may-2019, 13:25:39
    Author     : ASUS
--%>

<%@page import="Controlador.Consultas"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="navbar-brand text-white bg-dark">Administrador</a>
                    <a class="nav-item nav-link" href="Registro_Estudiante.jsp">Registro de Estudiante</a>
                    <a class="nav-item nav-link" href="Registro_Encargado.jsp">Registro de Encargado</a>
                    <a class="nav-item nav-link" href="Registro_Catedratico.jsp">Registro de Catedratico</a>
                    <a class="nav-item nav-link" href="Asignacion_Curso.jsp">Asignacion de Cursos</a>
                    <a class="nav-item nav-link" href="Usuario.jsp">Usuarios</a>
                </div>
            </div>
            <a href="Cerrar.jsp" class="form-inline my-2 my-lg-0">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Salir</button>
            </a>
        </nav>

        <form action="R_Catedratico_Curso.jsp" method="post" class="container">
            <h1>Asignacion de Cursos</h1>

            <div class="content-wrapper col-12">
                <div class="container-fluid ">
                    <br/>
                    <br/>
                    
                    <table class="col table table-striped table-bordered table-responsive">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">CODIGO</th> 
                                <th scope="col">ROL</th>    
                                <th scope="col">NOMBRE</th>  
                                <th scope="col">TELEFONO</th>  
                                <th scope="col">DIRECCION</th>  
                                <th scope="col">DPI</th>   
                                <th scope="col">CORREO</th>    
                                <th scope="col">TITULO</th>   
                                <th scope="col">PROCESO</th>   
                            </tr>
                        </thead>
                        <tbody>
                            <%

                                ResultSet rst = null;
                                ResultSet rst2 = null;
                                ResultSet rst3 = null;

                                try {
                                    Consultas co = new Consultas();

                                    rst = co.nombre_catedratico_completo();

                                    String codigo = null;
                                    String rol = null;
                                    String nombre = null;
                                    String telefono = null;
                                    String direccion = null;
                                    String cui = null;
                                    String correo = null;
                                    int i = 1;
                                    while (rst.next()) {

                                        out.print("<tr><td>" + i + "</td>");
                                        out.print("<td>" + rst.getString(1) + "</td><td>" + rst.getString(2) + "</td><td>" + rst.getString(3) + "</td><td>" + rst.getString(4) + "</td><td>" + rst.getString(5) + "</td><td>" + rst.getString(6) + "</td><td>" + rst.getString(7) + "</td><td>" + rst.getString(8) + "</td><td>");
                                        codigo = rst.getString(1);
                            %>

                        <button action="asignacion" type="submit" name="prueba" value="<%=codigo%>" class="btn btn-primary">Asignar</button>

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
