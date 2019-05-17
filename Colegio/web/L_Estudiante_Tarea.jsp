<%-- 
    Document   : L_Estudiante_Tarea
    Created on : 16/05/2019, 05:14:51 PM
    Author     : agonzalez
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
    
        <form action="L_Estudiante" method="post">

            <div class="content-wrapper col-12">
                <div class="container-fluid ">
                    <br/>
                    <br/>

                    <table class="col table table-striped table-bordered table-responsive">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">CURSO</th> 
                                <th scope="col">ZONA</th>
                                <th scope="col">PARCIAL 1</th>
                                <th scope="col">PARCIAL 2</th>
                                <th scope="col">EXAMEN</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                try {
                                    ResultSet rst = null;
                                    String string = request.getParameter("prueba");
                                    String[] parts = string.split("-");
                                    String codigo_grado = parts[0];
                                    String codigo_curso = parts[1];
                                    String codigo_seccion = parts[2];
                                    String codigo_catedratico = parts[3];
                                    String codigo_estudiante = parts[4];
                                    int cod_grado = Integer.parseInt(codigo_grado);
                                    int cod_curso = Integer.parseInt(codigo_curso);
                                    int cod_seccion = Integer.parseInt(codigo_seccion);
                                    int cod_catedratico = Integer.parseInt(codigo_catedratico);
                                    int cod_estudiante1 = Integer.parseInt(codigo_estudiante);

                                    Consultas co = new Consultas();

                                    rst = co.nombre_list_asignacion_estudiante(cod_grado, cod_curso, cod_seccion, cod_catedratico, cod_estudiante1);

                                    int i = 1;
                                    while (rst.next()) {

                                        out.print("<tr><td>" + i + "</td>");
                                        out.print("<td>" + rst.getString(1) + "</td><td>" + rst.getString(2) + "</td><td>" + rst.getString(3) + "</td><td>" + rst.getString(4) + "</td><td>" + rst.getString(5) + "</td></tr>");

                                        i++;
                                    }

                            %>
                        </tbody>
                    </table>

                    <br>
                    <br>
                    <h1 align="center">Lista de Tareas</h1>
                    <br>
                    <br>
                    
                </div>
                <table class="col table table-striped table-bordered table-responsive">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">NOMBRE</th> 
                            <th scope="col">DESCRIPCION</th>
                            <th scope="col">NOTA</th>
                            <th scope="col">FECHA DE ENTREGA</th>
                            <th scope="col">ESTADO</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%                            
                            ResultSet rst2 = null;
                            ResultSet rst3 = null;

                            Consultas co2 = new Consultas();
                            
                            String cod_actividad = "";

                            rst2 = co2.entrega_actividiad_cod_actividad(cod_grado, cod_curso, cod_seccion, cod_catedratico, cod_estudiante1);
                            

                            while (rst2.next()) {
                                cod_actividad = rst2.getString(1);
                            
                            int cod_actividad1 = Integer.parseInt(cod_actividad);
                            
                            rst3 = co.nombre_entrega_actividad(cod_actividad1, cod_grado, cod_curso, cod_seccion, cod_catedratico, cod_estudiante1);
                            
                            String codigo = null;
                            int i2 = 1;
                            while (rst3.next()) {

                                out.print("<tr><td>" + i2 + "</td>");
                                out.print("<td>" + rst3.getString(1) + "</td><td>" + rst3.getString(2) + "</td><td>" + rst3.getString(3) + " / " + rst3.getString(4) + "</td><td>" + rst3.getString(5) + "</td><td>"+ rst3.getString(6)+"</td></tr>");
                                codigo = Integer.toString(cod_estudiante1);

                                i2++;
                            }
                            }
                        %>
                    </tbody>
                    
                </table>
            </div>

            <% } catch (Exception e) {
                    out.print(e.toString());
                }
            %>
        
        </form>
        <div align="center">
            <a href="Padre.jsp" type="submit" class="btn btn-primary">Regresar</a>
        </div>
    </body>
</html>
