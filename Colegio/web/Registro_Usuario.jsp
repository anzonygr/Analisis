<%-- 
    Document   : Registro_Usuario
    Created on : 12-may-2019, 13:25:09
    Author     : ASUS
--%>

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
                    <a class="nav-item nav-link" href="Registro_Usuario.jsp">Registro de Usuario</a>
                    <a class="nav-item nav-link" href="Asignacion_Curso.jsp">Asignacion de Cursos</a>
                    <a class="nav-item nav-link" href="Usuario.jsp">Usuarios</a>
                </div>
            </div>
            <a href="Cerrar.jsp" class="form-inline my-2 my-lg-0">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Salir</button>
            </a>
        </nav>

        <form class="container">
            <h1>Registro Usuario</h1>
            <br>
            <br>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Email</label>
                    <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Password</label>
                    <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">Nombre</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="Alex Rodriguez">
            </div>
            <div class="form-group">
                <label for="inputAddress2">Direccion</label>
                <input type="text" class="form-control" id="inputAddress2" placeholder="Apartmento, o piso">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">Telefono</label>
                    <input type="text" class="form-control" id="inputCity" placeholder="12345678">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputCity">NIT</label>
                    <input type="text" class="form-control" id="inputCity" placeholder="592315-9">
                </div>



                <div class="form-group col-md-6">
                    <label for="inputState">Perfil</label>
                    <select id="inputState" class="form-control">
                        <option selected>Opciones...</option>
                        <option>Adminstrador</option>
                        <option>Catedratico</option>
                        <option>Padre</option>
                        <option>Estudiante</option>
                    </select>
                </div>
            </div>
            <br>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Grado</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td><input type="text" class="form-control" id="inputAddress" placeholder="Alex Rodriguez"></td>
                        <td>
                            <select id="inputState" class="form-control">
                                <option selected>Opciones...</option>
                                <option>Adminstrador</option>
                                <option>Catedratico</option>
                                <option>Padre</option>
                                <option>Estudiante</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td><input type="text" class="form-control" id="inputAddress" placeholder="Alex Rodriguez"></td>
                        <td>
                            <select id="inputState" class="form-control">
                                <option selected>Opciones...</option>
                                <option>Adminstrador</option>
                                <option>Catedratico</option>
                                <option>Padre</option>
                                <option>Estudiante</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td><input type="text" class="form-control" id="inputAddress" placeholder="Alex Rodriguez"></td>
                        <td>
                            <select id="inputState" class="form-control">
                                <option selected>Opciones...</option>
                                <option>Adminstrador</option>
                                <option>Catedratico</option>
                                <option>Padre</option>
                                <option>Estudiante</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">4</th>
                        <td><input type="text" class="form-control" id="inputAddress" placeholder="Alex Rodriguez"></td>
                        <td>
                            <select id="inputState" class="form-control">
                                <option selected>Opciones...</option>
                                <option>Adminstrador</option>
                                <option>Catedratico</option>
                                <option>Padre</option>
                                <option>Estudiante</option>
                            </select>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br>
            <div align="center">
                <button type="submit" class="btn btn-primary">Registrar</button>
            </div>
            <br>
        </form>
    </body>
</html>
