
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Crear Contenido Curso</title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12" align="center">                                 
                    <legend style="font-size: 25px; ">INGRESAR CONTENIDO AL CURSO</legend>
                    <div align="left">
                        <a href="dashboard_admin.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Volver</button></a>
                    </div>
                    <div class="col-md-6" style="margin-top: 10px;">
                        <div class="panel panel-success" align="center">
                            <div class="panel-heading">Cursos Creados</div>
                            <div class="panel-body">
                                <table value="idCurso" class="table table-striped table-bordered">
                                    <thead>                                         
                                        <td>Nombre</td>
                                        <td>Duracion en Días</td>
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
                    <div class="col-md-6">
                        <div>
                            <img src="img/ingresar.jpg" alt="">
                        </div>
                        <div>
                            <form action="ServletIngresarContenido">    
                                <div class="form-group">
                                                <%
                                    HttpSession sesion = request.getSession();
                                    if( sesion.getAttribute("mensaje") == null ) {                                
                                       }else if(sesion.getAttribute("mensaje")=="Contenido creado")
                                       {
                                          %> <div class="alert alert-success " role="alert">${mensaje}</div><%
                                               sesion.removeAttribute("mensaje");
                                       }else
                                       {
                                       %><div class="alert alert-danger " role="alert">${mensaje}</div><%
                                           sesion.removeAttribute("mensaje");
                                       }
                                     %>
                                   
                                    <label>Seleccione el Curso</label>
                                    <select name="idCurso" class="form-control selectpicker" required>
                                        <c:forEach items="${cursos}" var="curso">
                                            <option value="${curso.idCurso}">
                                                ${curso}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>    
                                <div class="form-group">
                                    <label>Nombre del Tema:</label>
                                    <input type="text" class="form-control" name="nombre" placeholder="Ingresa el nombre del tema" required>
                                </div>
                                <div class="form-group">
                                    <label>Descripcion:</label>
                                    <textarea name="descripcion" id="" class="form-control" cols="30" rows="10" required></textarea>
                                </div>
                                <div style="margin-top: 20px;">
                                    <button class="btn btn-info" name="accion" value="ingresar"><span class="glyphicon glyphicon-ok"></span> Ingresar Contenido</button>
                                    <a href="ingresar_contenido_curso.jsp"><button class="btn btn-danger" type="reset"><span class="glyphicon glyphicon-remove"></span>Cancelar</button></a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
