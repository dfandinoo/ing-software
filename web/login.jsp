<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
                   <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body style="background-color:#FFF8DC">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4"align="center" style="margin-top: 20px;">
                    <a href="index.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-chevron-left"></span> Volver</button></a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" align="center">
                    <img src="img/logo.png" alt="" width="225" height="225">
                </div>		
            </div>
 		
            <div class="row">
                <div class="col-md-4">  			
                </div>
                <div class="col-md-4 " style="margin-top: 40px; background-color: white;">
                    <form name="login" action="ServletLogin">
                        <div align="center">
                            <span class="glyphicon glyphicon-user" style="color: green; size: 15px;" ></span>
                        </div>

                        <legend align="center">Inicio De Sesion</legend>

                        <div class="form-group">
                            <label>Usuario:</label>	
                            <input type="text" class="form-control" name="username" placeholder="Ingrese su nombre de usuario">
                        </div>

                        <div class="form-group">                   	                 
                            <label>Contraseña</label>
                            <input type="password" class="form-control" name=password placeholder="Digite su contraseÃ±a">
                        </div>

                        <div class="form-group" align="center">
                            <button class="btn btn-success" onclick="submit();" name="accion" value="ingresar">Ingresar</button>
                            <button class="btn btn-danger"  name="accion" value="cancelar">Cancelar</button>
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