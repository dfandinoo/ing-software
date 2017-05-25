<%-- 
    Document   : dashboard_admin
    Created on : 26/04/2017, 11:18:04 AM
    Author     : DANNY
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
HttpSession sesion = request.getSession();
if(sesion.getAttribute("pkeyAdmin") != null){
--%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>DASHBOARD-ADMIN</title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body background="" style="background-color: #FFF8DC;">
        <div class="container-fluid" style="margin-top: 20px;">
            <form name ="dashboard_admin" action="ServletDashboardAdmin">
                <div class="row" align="center">
                    <div class="col-md-6">
                        <h1 style="font-style: verdana; color: green;">Bienvenido: ${nombres} ${apellidos}</h1>
                    </div>
                    <div class="col-md-6" align="center">
                        <button class="btn btn-danger" name="accion" value="cerrarSesion"><span class="glyphicon glyphicon-off"></span> Cerrar Sesion</button>
                     </div>
                </div>
                <div class="row" style="margin-top: 50px;">
                    <div class="col-md-6">
                        <div class="panel-group">
                            <div class="panel panel-success" align="center">
                                <div class="panel-heading">Cursos Disponibles</div>  
                                <div class="panel-body">
                                    <table value="idCurso" class="table table-striped table-bordered">
                                        <thead>
                                            <td>Nombre</td>
                                            <td>Duración en Días</td>
                                            <td>Fecha de Inicio</td>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${cursos}" var="curso">
                                                <tr>
                                                    <td>${curso.nombre}</td>
                                                    <td>${curso.duracion}</td>
                                                    <td>${curso.fechaInicio}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>   
                    <div class="col-md-6">
                        <div class="panel-group">
                            <div class="panel panel-info" align="center">
                                <div class="panel-heading">Docentes</div>
                                <div class="panel-body">
                                    <table value="idCurso" class="table table-striped table-bordered">
                                        <thead>
                                            <td>Nombre</td>
                                            <td>Correo</td>
                                            <td>Especialidad</td>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${docentes}" var="docente">
                                                <tr>
                                                    <td>${docente.nombres} ${docente.apellidos}</td>
                                                    <td>${docente.correo}</td>
                                                    <td>${docente.especialidad}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>                     
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <div class="thumbnail" align="center" style="background-color: #D2691E; color: white;">
                            <img src="img/ingresar.jpg" alt=""  width="200" height="200">
                            <div>
                                <caption>
                                    <div style="margin-top: 20px;">
                                        <button class="btn btn-success" name="accion" value="ingresarContenido"><span class="glyphicon glyphicon-share-alt"></span> Ingresar Contenidos</button>
                                    </div>
                                </caption>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="thumbnail" align="center" style="background-color: #1E90FF; color: white;">
                            <img src="img/cursos.jpg" alt=""  width="200" height="200" >
                             <div>
                                 <caption>
                                    <div style="margin-top: 20px;">
                                        <button class="btn btn-success" name="accion" value="crearCursos"><span class="glyphicon glyphicon-plus-sign"></span> Crear Cursos</button>
                                    </div>
                                 </caption>
                             </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="thumbnail" align="center" style="background-color: red; color: white;">
                            <img src="img/docente1.png" alt="" width="200" height="200">
                             <div>
                                 <caption>
                                    <div style="margin-top: 20px;">
                                        <button class="btn btn-success" name="accion" value="asignarDocente"><span class="glyphicon glyphicon-user"></span> Asignar Docente</button>
                                    </div>
                                 </caption>
                             </div>
                        </div>
                    </div>          
                </div>
                 <div class="row">
                        <div class="col-md-4 ">
                            <div class="thumbnail" align="center" style="background-color: red; color: white;">
                                <img src="img/Edit.png" alt=""  width="150" height="150">
                                <div>
                                    <caption>
                                        <button class="btn btn-success" name="accion" value="editarUsuario">Editar Informacion</button></a>
                                    </caption>
                                </div>
                            </div>
                        </div>
                     <div class="col-md-4 ">
                            <div class="thumbnail" align="center" style="background-color: red; color: white;">
                                <img src="img/registrar_usuarios.png" alt=""  width="150" height="150">
                                <div>
                                    <caption>
                                        <button class="btn btn-success" name="accion" value="registrarAdmin">Registrar Usuarios</button></a
                                    </caption>
                                </div>
                            </div>
                        </div>
                      <div class="col-md-4 ">
                            <div class="thumbnail" align="center" style="background-color: red; color: white;">
                                <img src="img/cambiar.png" alt=""  width="150" height="150">
                                <div>
                                    <caption>
                                        <button class="btn btn-success" name="accion" value="cambiarEstado">Cambiar Estado Usuario</button>
                                    </caption>
                                </div>
                            </div>  
                        </div>
                   </div>
            </form>
        </div>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
<%-- }else{
    request.getRequestDispatcher("index.jsp").forward(request, response);  
}
--%>