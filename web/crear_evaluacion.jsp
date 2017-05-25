<%--
#B0C4DE;
HttpSession sesion = request.getSession();
if(sesion.getAttribute("pkeyAdmin") != null){
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Crear Evaluacion</title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body style="background-color: 	#FFF8DC;">
        <div class="container-fluid">
            <div class="row" style="padding-top: 10px;">
                <div class="col-md-6">
                    <div align="left">
                        <a href="dashboard_docente.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Volver</button></a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" align="center">
                    <legend style="font-size: 25px; ">Crear Evaluacion</legend>
                </div>
                <div class="col-md-6 col-md-offset-3" align="center">
                    <div>
                        <img src="img/crear_evaluacion.png" alt="" width="100" height="100">
                    </div>
                </div>
                <div class="col-md-6">
                        <div class="panel-group">
                            <div class="panel panel-primary" align="center">
                                <div class="panel-heading">Evaluación del Curso</div>
                                <div class="panel-body">
                                    <table class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <td>Nombre</td>
                                                <td>Duración en Horas</td>
                                                <td>Descripción</td>
                                                <td>Crear Preguntas</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${evaluacionEstu}" var="evalEstu">
                                                <tr>
                                                    <td>${evalEstu.nombre}</td>
                                                    <td>${evalEstu.duracion}</td>
                                                    <td>${evalEstu.descripcion}</td>
                                                    <td><a href="ServletCrearEvaluacionEstudiante?idCurso=${evalEstu.idEvaluacion}&accion=crearPreguntas"><button  class="btn btn-danger" name="accion" value="1"><span class="glyphicon glyphicon-pencil"></span> Crear Preguntas</button></a></td>
                                                </tr>
                                            </c:forEach>    
                                        </tbody>
                                    </table>
                                </div>                                    
                            </div>
                        </div>
                   </div>
                <div class="col-md-6">                                    
                    <form name="" action="ServletCrearEvaluacionEstudiante" method="get">
                        <div class="form-group">
                            <label>Nombre de la Evalucion:</label>
                            <input type="text" class="form-control" name="nombreEvaluacion" placeholder="Ingresa el nombre de la Evaluacion" required>
                        </div>
                        <div class="form-group">
                            <label>Descripcion:</label>
                            <textarea class="form-control" cols="20" rows="7" name="descripcion" required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Duracion:</label>
                            <input type="number" class="form-control" name="duracion" placeholder="Ingresa la Duracion De la evalucion" required>
                        </div>
                        <div class="form-group">
                            <div style="margin-top: 20px;">
                                <button class="btn btn-success" class="glyphicon glyphicon-ok" name="accion" value="crearEvaluacion" onclick="submit();" > Crear Evaluacion</button>
                                <button class="btn btn-danger" class="glyphicon glyphicon-ok" name="accion" value="cancelar" type="reset"> Cancelar</button>
                            </div>
                        </div>
                        <div class="alert alert-danger alert-dismissible" role="alert">${mensaje}</div>
                    </form>
                </div>
            </div>
        </div>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
<%-- }else{
    request.getRequestDispatcher("index.jsp").forward(request, response);  
}
--%>