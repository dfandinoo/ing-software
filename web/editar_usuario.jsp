<% 
HttpSession sesion = request.getSession();
if(sesion.getAttribute("pkeyEstudiante") != null || sesion.getAttribute("pkeyDocente") != null || sesion.getAttribute("pkeyAdmin") != null){
%>
<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="UTF-8">
	<title>Editar-Usuario</title>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
	           <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body background="img/editar.jpg">
        <div class="container-fluid">
            <div class="row">
		<div class="col-md-6 col-md-offset-3" style="margin-top: 140px; background-color: white;">
                    <form name ="registro" action="ServletEditarUsuario">
                        <div align="center">
                            <legend align="center">Editar  Datos</legend>
                            <span> <img src="img/editar.png" alt="" width="80" height="80"></span>
                        </div>
                        <div class="form-group" align="center" style="margin-top: 19px; ">
                            <label>Nombres</label>	
                            <input type="text" class="form-control" name="nombres" placeholder="Ingrese su nombre " value="${nombres}">

                            <label>Apellidos</label>
                            <input type="text" class="form-control" name="apellidos" placeholder="Ingrese sus  apellidos" value="${apellidos}">
                                                                  
                            <label>Username</label>
                            <input type="text" class="form-control" name="username" placeholder="Digite su usuario" value="${username}">
                          
                            <label>Password</label>	
                            <input type="Password" class="form-control" name="password" placeholder="Ingrese su nueva password " value="${password}">
                
                            <label>Correo</label>	
                            <input type="email" class="form-control" name="correo" placeholder="Ingrese su correo " value="${correo}">
                        </div>
                        <% if(sesion.getAttribute("estudiante") != null){  %>
                        <input type="hidden" name="tipoUsuario" value="estudiante">
                        <%}else if(sesion.getAttribute("docente") != null){%>
                        <input type="hidden" name="tipoUsuario" value="docente">
                        <%}else if(sesion.getAttribute("administrador") != null){%>
                        <input type="hidden" name="tipoUsuario" value="administrador">
                        <%}%>
                        <div style="margin:19px;" align="center">
                           <button class="btn btn-info" style="font-size: 20px;" name="accion" value="editar"><span class="glyphicon glyphicon-pencil" name="accion" value="editar"> Editar</span></button>
                           <button class="btn btn-danger" style="font-size: 20px;"><span class="glyphicon glyphicon-remove">Cancelar</span></button>
                        </div>
                    </form>
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