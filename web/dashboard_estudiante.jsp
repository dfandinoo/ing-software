
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
HttpSession sesion = request.getSession();
if(sesion.getAttribute("pkeyEstudiante") != null){
--%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>DASHBOARD-ESTUDIANTE</title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
                   <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body background="" style="background-color: #FFF8DC;">
        <div class="container-fluid">
       <%--     <form name ="dashboard_estudiante" action="ServletDashboardEstu"> --%>
                <div class="row" >
                    <div class="col-md-6">
                        <h1 style="font-style: verdana; color: green;">Bienvenido: ${nombres} ${apellidos}</h1>

                    </div>
                    <div class="col-md-6" align="center" style="margin-top: 20px;">
                        <a href="logout.jsp"><button class="btn btn-danger" name="accion" value="cerrarSesion"><span class="glyphicon glyphicon-off"></span> Cerrar Sesion</button></a>
                    </div>
                </div>
                <div class="row" style="margin-top: 50px;">
                    <div class="col-md-8">
                        <div class="panel-group">
                            <div class="panel panel-primary" align="center">
                                <div class="panel-heading">Cursos en los que se encuentra Inscrito</div>
                                <div class="panel-body">
                                    <table class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <td>Nombre</td>
                                                <td>Duración en Días</td>
                                                <td>Fecha de Inicio</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${cursosInscri}" var="cursoIns">
                                                <tr>
                                                    <td>${cursoIns.nombre}</td>
                                                    <td>${cursoIns.duracion}</td>
                                                    <td>${cursoIns.fechaInicio}</td>
                                                    <td><a href="ServletDashboardEstu?idcurso=poner_el_id&accion=vercontenidosestudiante"><button class="btn btn-info"><span class="glyphicon glyphicon-eye-open"></span> Ver Contenidos</button></a></td>
                                                    <td><a href="ServletDashboardEstu?idcurso=poner_el_id&accion=presentarevaluacion"><button  class="btn btn-danger" name="accion" value="1"><span class="glyphicon glyphicon-pencil"></span> Presentar Evaluacion</button></a></td>
                                                </tr>
                                            </c:forEach>    
                                        </tbody>
                                    </table>
                                </div>                                    
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">
                            <div class="thumbnail" align="center" style="background-color: red; color: white;">
                                <img src="img/Edit.png" alt=""  width="150" height="150">
                                <div>
                                    <caption>
                                        <a href="ServletDashboardEstu?accion=editarEstu"><button  class="btn btn-primary">Editar Informacion</button></a>
                                    </caption>
                                </div>
                            </div>
                            <div class="thumbnail" align="center" style="background-color: blue; color: white;">
                                <img src="img/inscribirse.png" alt=""  width="150" height="150">
                                <div>
                                    <caption>
                                        <a href="ServletDashboardEstu?accion=inscribirEstu"><button  class="btn btn-success" name="accion" value="inscribirEstu">Inscribirse Curso</button></a>
                                    </caption>
                                </div>
                            </div>
                              <div class="thumbnail" align="center" style="background-color: red; color: white;">
                                <img src="img/quejas.png" alt=""  width="150" height="150">
                                <div>
                                    <caption>
                                       <a href="QuejasyReclamos.jsp"><button  class="btn btn-primary" value="">Enviar Quejas o Reclamos</button></a>
                                    </caption>
                                </div>
                            </div>
                        </div>
                    </div>                     
                </div>
               
           <%-- </form> --%>    
        </div>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
<%-- }else{
    request.getRequestDispatcher("index.jsp").forward(request, response);  
}
--%>
