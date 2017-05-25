<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Contenidos Estudiante</title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
                   <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body style="background-color:#FFF8DC">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12"align="center" style="margin-top: 20px;">
                    <a href="dashboard_estudiante.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-chevron-left"></span> Volver</button></a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12"align="center" style="margin-top: 20px;">
                    <img src="img/contenidos.png" width=190" height="190">
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel-group">
                        <div class="panel panel-primary" align="center">
                            <div class="panel-heading">Contenidos del Curso ${cursoIns.nombre}</div>
                            <div class="panel-body">
                                <table class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <td>Nombre</td>
                                            <td>Descripción</td>
                                            <td>Desarrollar Activiad</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${contenidos}" var="contenido">
                                            <tr>
                                                <td>${contenido.nombre}</td>
                                                <td>${contenido.descripcion}</td>
                                                <td><a href="ServletDashboardEstu?idCurso=${cursoIns.idCurso}&accion=verContenido"><button class="btn btn-info"><span class="glyphicon glyphicon-eye-open"></span> Desarrollar Actividad</button></a></td>
                                            </tr>
                                        </c:forEach>    
                                    </tbody>
                                </table>
                            </div>                                    
                        </div>
                    </div>
                </div> 
            </div> 		
         
 	</div>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>