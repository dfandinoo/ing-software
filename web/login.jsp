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
                            <input type="text" class="form-control" name="username" placeholder="Ingrese su nombre de usuario" required>
                        </div>

                        <div class="form-group">                   	                 
                            <label>Contrase�a</label>
                            <input type="password" class="form-control" name=password placeholder="Digite su contraseña" required>
                        </div>
                        <%
                        HttpSession sesion = request.getSession();
                         if( sesion.getAttribute("mensaje") == null ) {                                
                            }else if(sesion.getAttribute("mensaje") =="Login Correcto")
                            {
                               %> <div class="alert alert-success " role="alert">${mensaje}</div><%
                                    sesion.removeAttribute("mensaje");
                            }else
                            {
                            %><div class="alert alert-danger " role="alert">${mensaje}</div><%
                                sesion.removeAttribute("mensaje");
                            }
                          %>
                    
                        <div class="form-group" align="center">
                            <button class="btn btn-success" onclick="submit();" name="accion" value="ingresar"><span class="glyphicon glyphicon-ok"></span> Ingresar</button>
                            <button class="btn btn-danger"  name="accion" value="cancelar" type="reset"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>
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