
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en"> 
    <head>
        <meta charset="UTF-8">
        <title>Crear Respuestas</title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body style="background-color: 	#FFF8DC;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6" style="margin-top: 10px;" align="left">
                    <a href="preguntas_evaluacion_estudiante.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Volver</button></a>
                </div>
            </div>
            <div class="row" style="margin-top: 15px;">
                <div class="col-md-12" style="margin-top: 10px;" align="center">
                    <div style="margin-top: 20px;">
                        <img src="img/respuestas.png" width="150" height="150">
                        <legend>Registrar Respuestas</legend>
                    </div>
                </div>
                <div class="col-md-6">
                        <div class="panel-group">
                            <div class="panel panel-primary" align="center">
                                <div class="panel-heading">Respuestas de la Pregunta</div>
                                <div class="panel-body">
                                    <table class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <td>Pregunta</td>
                                                <td>Valor</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${respuestasEstu}" var="RespPreg">
                                                <tr>
                                                    <td>${RespPreg.textoRespuesta}</td>
                                                    <td>${RespPreg.esCorrecta}</td>
                                                </tr>
                                            </c:forEach>    
                                        </tbody>
                                    </table>
                                </div>                                    
                            </div>
                        </div>
                </div>
                <div class="col-md-6">
                    <form method="get" action="ServletCrearResEvaEst">
                        <div class="form-group">
                        </div>
                        <div class="form-group">
                            <legend align="center">Ingrese la Respuesta:</legend>
                            <input type="text" name="respuesta"  class="form-control" placeholder="Ingrese la Respuesta">
                        </div>
                        <div class="form-group">
                            <legend align="center">Seleccione si la respuesta es correcta o incorrecta:</legend>
                            <div class="radio">
                                <label class="radio-inline"><input type="radio" value="correcta" name="esCorrecta">Correcta </label> 
                                <label class="radio-inline"><input type="radio" value="incorrecta" name="esCorrecta"> Incorrecta </label>
                            </div>
                        </div>
                        <div class="form-group" align="center">
                            <button class="btn btn-success" name="accion" value="crearPregunta"><span class="glyphicon glyphicon-ok"></span> Registrar Pregunta</button>
                            <button class="btn btn-danger"  name="" value="" type="reset"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
