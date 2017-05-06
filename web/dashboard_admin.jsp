<%-- 
    Document   : dashboard_admin
    Created on : 26/04/2017, 11:18:04 AM
    Author     : DANNY
--%>
<% 
HttpSession sesion = request.getSession();
if(sesion.getAttribute("pkeyAdmin") != null){
%>
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
    <body background="img/fondo_registro1.jpg">
        <div class="container-fluid">
            <div class="row" align="center">
                <div class="col-md-6">
                    <h1 style="font-style: verdana; color: green;">BIENVENIDO ADMINISTRADOR : </h1>
                </div>
            </div>
            <div class="row" style="margin-top: 50px;">
                <div class="col-md-6">
                    <div class="panel-group">
                        <div class="panel panel-success" align="center">
                            <div class="panel-heading">Cursos Disponibles
                            </div>
                            <div class="panel-body">Panel Content
                            </div>
                        </div>
                    </div>
                </div>   
                <div class="col-md-6">
                    <div class="panel-group">
                        <div class="panel panel-info" align="center">
                            <div class="panel-heading">Docentes
                            </div>
                            <div class="panel-body">Panel Content
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
                                    <a href="ingresar_contenido_curso.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-share-alt"></span> Ingresar Contenidos</button></a>
                                </div>
                            </caption>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail" align="center" style="background-color: #D2691E; color: white;">
                        <img src="img/cursos.jpg" alt=""  width="200" height="200" >
                         <div>
                             <caption>
                                <div style="margin-top: 20px;">
                                    <a href="crear_cursos.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Crear Cursos</button></a>
                                </div>
                             </caption>
                         </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail" align="center" style="background-color: #D2691E; color: white;">
                        <img src="img/docente1.png" alt="" width="200" height="200">
                         <div>
                             <caption>
                                <div style="margin-top: 20px;">
                                    <a href="asignar_docente.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-user"></span> Asignar Docente</button></a>
                                </div>
                             </caption>
                         </div>
                    </div>
                </div>          
            </div>
        </div>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
<% }else{
    request.getRequestDispatcher("index.jsp").forward(request, response);  
}
%>