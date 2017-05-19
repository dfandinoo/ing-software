<%-- 
    Document   : dashboard_docente
    Created on : 14/05/2017, 11:35:15 AM
    Author     : DANNY
--%>
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
                    <button class="btn btn-danger"><span class=" glyphicon glyphicon-off"></span> Cerrar Sesion</button>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6"align="center">
                   <div class="row">
                            <div class="col-md-6"align="center">
                                 <div class="thumbnail" align="center" style="background-color: #7FFF00; color: white;">
                                       <img src="img/evaluacion.png" alt=""  width="150" height="150">
                                            <div>
                                                <caption>
                                                    <button class="btn btn-danger" name="accion" value="">Crear Evaluacion Estudiantes</button></a>
                                                </caption>
                                            </div>
                                 </div>
                            </div>
                            <div class="col-md-6"align="center">
                                  <div class="thumbnail" align="center" style="background-color: #7FFF00; color: white;">
                                             <img src="img/actividades.png" alt=""  width="185" height="185">
                                                    <div>
                                                        <caption>
                                                            <button class="btn btn-danger" name="accion" value="">Crear Actividades</button></a>
                                                        </caption>
                                                    </div>
                                   </div>
                            </div>
                   </div>
                       <div class="row">
                            <div class="col-md-6"align="center">
                                 <div class="thumbnail" align="center" style="background-color:#7FFF00; color: white;">
                                       <img src="img/Edit.png" alt=""  width="128" height="128">
                                            <div>
                                                <caption>
                                                    <button class="btn btn-primary" name="accion" value="">Editar Informacion</button></a>
                                                </caption>
                                            </div>
                                </div>
                            </div>
                            <div class="col-md-6"align="center">
                                <div class="thumbnail" align="center" style="background-color: 	#7FFF00; color: white;">
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
                     <div class="panel panel-success" align="center">
                                    <div class="panel-heading">SUS CURSOS</div>
                                            <div class="panel-body">
                                                <table class="table table-striped table-bordered">
                                                    <thead>
                                                    <tr>
                                                    <th>columna1</th>
                                                    <th>columna2</th>
                                                    <th>columna3</th>
                                                    <th>columna4</th>
                                                    <th>columna5</th>
                                                    <th>boton</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                        
                                                        <tr>
                                                    <th>datos1</th>
                                                     <th>datos1</th>
                                                      <th>datos1</th>
                                                       <th>datos1</th>
                                                        <th>datos1</th>
                                                        <th><button class="btn btn-info"><span class="glyphicon glyphicon-eye-open"></span> Ver Contenidos</button></th>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                     </div>
                            <div class="panel panel-primary" align="center">
                                    <div class="panel-heading">SUS ESTUDIANTES</div>
                                            <div class="panel-body">
                                                DATOS
                                            </div> 
                            </div>      
                </div>
        </div>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
