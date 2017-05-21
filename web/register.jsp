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
        
</head>
    <body style="background-color: #FFF8DC;">
        <div class="container-fluid"> 
 <div class="row">
                <div class="col-md-4"align="center" style="margin-top: 10px;">
                    <a href="index.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-chevron-left"></span>Volver</button></a>
                </div>
            </div>            
            <div class="row">
 		<div class="col-md-3">  			
 		</div>
                <div class="col-md-6 " style="margin-top: 20px; background-color: #DEB887 ;">
                    <form name ="registro" action="ServletRegistro">
                        <div align="center">
                            <legend align="center">Formulario De Registro</legend>
                            <span  > <img src="img/registro_logo.png" alt="" width="100" height="100"></span>
                        </div>
                        <div class="alert alert-danger alert-dismissible" role="alert">${mensaje}</div>
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
                        <div class="form-group" align="center">
                            <button class="btn btn-success" onclick="submit();" name="accion" value="crear">Registrar</button>
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
