<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="UTF-8">
	<title>Document</title>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
            <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script> 
            $(function() {
                $('#especialidaddocente').hide();
            })
            function activado(argument) {
                $('#especialidaddocente').show();
            }
            function desactivado(argument) {
              $('#especialidaddocente').hide();
            }
        </script>
</head>
    <body style="background-color: #FFF8DC;">
        <div class="container-fluid"> 
            <div class="row">
                <div class="col-md-4"align="center" style="margin-top: 10px;">
                    <a href="dashboard_admin.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-chevron-left"></span> Volver</button></a>
                </div>
            </div>            
            <div class="row">
 		<div class="col-md-3">  			
 		</div>
                <div class="col-md-6 " style="margin-top: 20px; background-color: #DEB887 ;">
                    <form action="ServletRegistroAdmin">
                        <div align="center">
                            <legend align="center">Formulario De Registro</legend>
                            <span  > <img src="img/registro_logo.png" alt="" width="100" height="100"></span>
                        </div>
                        <%
                         HttpSession sesion = request.getSession();
                         if( sesion.getAttribute("mensaje") == null ) {                                
                            }else if(sesion.getAttribute("mensaje")=="Registro de Docente Exitoso")
                            {
                               %> <div class="alert alert-success " role="alert">${mensaje}</div><%
                                    sesion.removeAttribute("mensaje");
                            }else
                            {
                            %><div class="alert alert-danger " role="alert">${mensaje}</div><%
                                sesion.removeAttribute("mensaje");
                            }
                          %>
                     <div class="form-group">
                            <label>Nombres:</label>	
                            <input type="text" class="form-control" name="nombres" placeholder="Ingrese su nombre " required>
                        </div>
                        <div class="form-group">                   	                 
                            <label>Apellidos:</label>
                            <input type="text" class="form-control" name="apellidos" placeholder="Ingrese sus  apellidos" required>
                        </div>
                        <div class="form-group">                                      
                            <div class="form-group">
                                <label for="sel1">Tipo de Identificacion:</label>
                                <select class="form-control" id="sel1" name="tipoIdentificacion" required>
                                    <option value="0">Ninguno</option>
                                    <option value="CC">Cedula De Ciudadania</option>
                                    <option value="TI">Tarjeta Identidad</option>

                                </select>
                            </div>
                        </div>
                        <div class="form-group">                                     
                            <label>Numero Identificacion:</label>
                            <input type="number" class="form-control" name="numidentifica" placeholder="Digite su Numero de Identificacion" required>
                        </div>
                        <div class="form-group">                                     
                            <label>Correo</label>
                            <input type="email" class="form-control" name="correo" placeholder="Digite su Correo Electronico" required>
                        </div>
                        <div class="form-group">                                     
                            <label>Username:</label>
                            <input type="text" class="form-control" name="username" placeholder="Digite su usuario" required>
                        </div>
                        <div class="form-group">                                     
                            <label>Password:</label>
                            <input type="password" class="form-control" name="password" placeholder="Digite su contraseña" required>
                        </div>
                  
                        <div class="form-group" align="center" >
                            <label>Tipo de usuario</label>
                            <div class="radio">
                                <label class="radio-inline"><input type="radio" value="estudiante" name="tipoUsuario" onclick="desactivado();">Estudiante </label> 
                                <label class="radio-inline"><input type="radio" value="docente" name="tipoUsuario" onclick="activado();"> Docente </label>
                                <label class="radio-inline"><input type="radio" value="administrador" name="tipoUsuario" onclick="desactivado();"> Administrador </label>
                            </div>

                        </div>
                        <div class="form-group" id="especialidaddocente">
                            <label>Especialidad Docente:</label>
                            <input type="text" class="form-control" name="especialidaddocente" placeholder="Digite su especialidad o area de conocimiento">
                        </div>
                        <div class="form-group" align="center">
                            <button class="btn btn-success"  name="accion" value="crear">Registrar</button>
                            <button class="btn btn-danger"  name="accion" value="cancelar" type="reset">Cancelar</button>

                        </div>
                    </form>
 			</div>
 		</div>
 		<div class="row">
 			
 		</div>
 		<div class="row">
 			
 		</div>
 	</div>


	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>