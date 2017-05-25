<%-- 
    Document   : dashboard_docente
    Created on : 14/05/2017, 11:35:15 AM
    Author     : DANNY
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>DASHBOARD-DOCENTE</title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
                   <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body background="" style="background-color: #FFF8DC;">
        <div class="container-fluid">
            <div class="row" style="margin-top: 30px;">
                <div class="col-md-6"align="center">
                    <legend>Bienvenido Señor Docente</legend>
                    <img src="img/docente.png" width="150" height="150">
                </div>
                <div class="col-md-6" align="center">
                    <a href="logout.jsp"><button class="btn btn-danger" name="accion" value="cerrarSesion"><span class="glyphicon glyphicon-off"></span> Cerrar Sesion</button></a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6"align="center">
                    <div class="row">
                        <div class="col-md-12"align="center">
                            <div class="thumbnail" align="center" style="background-color: #3CB371; color: white;">
                                <img src="img/evaluacion.png" alt=""  width="150" height="150">
                                    <div>
                                        <caption>
                                            <button class="btn btn-danger" name="accion" value="">Crear Evaluacion Estudiantes</button></a>
                                        </caption>
                                    </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"align="center">
                            <div class="thumbnail" align="center" style="background-color:#3CB371; color: white;">
                                <img src="img/Edit.png" alt=""  width="128" height="128">
                                <div>
                                    <caption>
                                        <button class="btn btn-primary" name="accion" value="">Editar Informacion</button></a>
                                    </caption>
                                </div>
                           </div>
                        </div>
                        <div class="col-md-6"align="center">
                            <div class="thumbnail" align="center" style="background-color: 	#3CB371; color: white;">
                                    <img src="img/quejas.png" alt=""  width="150" height="150">
                                <div>
                                    <caption>
                                        <a href="QuejasyReclamos.jsp"><button class="btn btn-primary" name="accion" value="">Enviar Quejas o Reclamos</button></a>
                                    </caption>
                                </div>
                            </div>
                        </div>
                    </div>                 
                </div>
           
                <div class="col-md-6">
                    <div class="panel-group">
                        <div class="panel panel-primary" align="center">
                            <div class="panel-heading">Cursos del Docente</div>
                            <div class="panel-body">
                                <table class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <td>Nombre</td>
                                            <td>Duración en Días</td>
                                            <td>Fecha de Inicio</td>
                                            <td>Ver contenidos</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${cursosDocente}" var="cursoDoce">
                                            <tr>
                                                <td>${cursoDoce.nombre}</td>
                                                <td>${cursoDoce.duracion}</td>
                                                <td>${cursoDoce.fechaInicio}</td>
                                                <th><a href="ServletDashboardDoce?idCurso=${cursoDoce.idCurso}&accion=verContenido"><button class="btn btn-info"><span class="glyphicon glyphicon-eye-open"></span> Ver Contenidos</button></a></th>
                                            </tr>
                                        </c:forEach>    
                                    </tbody>
                                </table>
                            </div>                                    
                        </div>
                    </div>                 
                </div>
        </div>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
