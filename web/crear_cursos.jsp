<%--
HttpSession sesion = request.getSession();
if(sesion.getAttribute("pkeyAdmin") != null){
--%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Crear curso</title>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
	           <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body style="background-color: 	#FFF8DC;">
	<div class="container-fluid">
            <div class="row" style="padding-top: 10px;">
                <div class="col-md-6">
                     <div align="left">
                         <a href="dashboard_admin.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Volver</button></a>
                     </div>
                </div>
            </div>
		<div class="row">
			<div class="col-md-12" align="center">
				<legend style="font-size: 25px; ">Crear Curso</legend>
                        </div>
			<div class="col-md-6 col-md-offset-3" align="center">
					<div>
                                            <img src="img/crear_curso.png" alt="" width="150" height="150">
					</div>
			<div>
                            <form name="CrearCurso" action="ServletCrearCurso">
                                <div class="form-group">
                                    <label>Nombre del Curso:</label>
                                    <input type="text" class="form-control" name="nombrecurso" placeholder="Ingresa el nombre del curso" required>
                                </div>
                                <div class="form-group">
                                    <label>Fecha inicio del Curso: dd/mm/aa</label>
                                    <input type="date" class="form-control" name="fechini" placeholder="Ingresa la fecha de inicio del curso" required>
                                </div>
                                <div class="form-group">
                                    <label>Duracion:</label>
                                    <input type="number" class="form-control" name="duracion" placeholder="Ingresa la Duracion curso" required>
                                </div>
                                <div class="form-group">
                                    <label>Cantidad Maxima de Estudiantes:</label>
                                    <input type="number" class="form-control" name="cantmaxima" placeholder="Ingresa la cantidd maxima de estudiantes" required>
                                    <div style="margin-top: 20px;">
                                       <button class="btn btn-success" class="glyphicon glyphicon-ok" name="accion" value="crear"> Crear Curso</button>
                                       <button class="btn btn-danger" class="glyphicon glyphicon-ok" name="accion" value="cancelar" type="reset"> Cancelar</button>
                                    </div>
                                </div>
                                <%
                                 HttpSession sesion = request.getSession();
                         if( sesion.getAttribute("mensaje") == null ) {                                
                            }else if(sesion.getAttribute("mensaje") =="Creaci�n del Curso Exitosa")
                            {
                               %> <div class="alert alert-success " role="alert">${mensaje}</div><%
                                    sesion.removeAttribute("mensaje");
                            }else
                            {
                            %><div class="alert alert-danger " role="alert">${mensaje}</div><%
                                sesion.removeAttribute("mensaje");
                            }
                          %>
                               
                            </form>
			</div>
		   </div>
		</div>
	</div>

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
<%-- }else{
    request.getRequestDispatcher("index.jsp").forward(request, response);  
}
--%>
