<%-- 
    Document   : Crear_Tarea
    Created on : 15-may-2019, 0:46:32
    Author     : ASUS
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession objsession = request.getSession(false);
    String usuario = (String)objsession.getAttribute("usuario");
    String numero = (String)objsession.getAttribute("numero");
    String cod_catedratico = (String)objsession.getAttribute("cod_catedratico");
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
        <form action="R_Actividad" method="post" class="container">
            <h1>Nueva Tarea</h1>
            <br>
            <br>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputAddress">TITULO</label>
                    <input type="text" name="titulo" class="form-control" id="inputAddress" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputAddress">NOTA</label>
                    <input type="text" name="nota" class="form-control" id="inputAddress" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="exampleFormControlTextarea1">DESCRIPCION</label>
                    <textarea name="descripcion" class="form-control" id="exampleFormControlTextarea1" rows="3" required></textarea>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputAddress">FECHA ENTREGA</label>
                    <input type="text" name="fecha" class="form-control" id="inputAddress" required>
                </div>
            </div>
            <br>
            <br>
            <%try {
                                    String string = request.getParameter("prueba");
                                    String[] parts = string.split("-");
                                    String codigo_grado = parts[0];
                                    String codigo_curso = parts[1];
                                    String codigo_seccion = parts[2];
                                    String codigo_catedratico = parts[3];
                                    String codigo = codigo_grado+"-"+codigo_curso+"-"+codigo_seccion+"-"+codigo_catedratico;
%>
             <div align="center">
                <button value="<%=codigo%>" name="prueba" type="submit" class="btn btn-primary">CREAR</button>
            </div>
            <br>
             <% } catch (Exception e) {
                    out.print(e.toString());
                }
            %>
        </form>
    </body>
</html>
