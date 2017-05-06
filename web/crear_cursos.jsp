<% 
HttpSession sesion = request.getSession();
if(sesion.getAttribute("pkeyAdmin") != null){
%>
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
<body style="background-color: 	#B0C4DE;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12" align="center">
				<legend style="font-size: 25px; ">Crear Curso</legend>
                        </div>
			<div class="col-md-6 col-md-offset-3" align="center">
					<div>
						<img src="img/cursos.jpg" alt="">
					</div>
			<div>
				<form name="CrearCurso" action="ServletCrearCurso">
			            <div class="form-group">
					        <label>Nombre del Curso:</label>
						<input type="text" class="form-control" name="nombrecurso" placeholder="Ingresa el nombre del curso">
				    </div>
				    <div class="form-group">
						<label>Fecha inicio del Curso: dd/mm/aa</label>
						<input type="text" class="form-control" name="fechini" placeholder="Ingresa la fecha de inicio del curso">
				    </div>
				    <div class="form-group">
						<label>Duracion:</label>
						<input type="text" class="form-control" name="duracion" placeholder="Ingresa la Duracion curso">
				    </div>
				    <div class="form-group">
					        <label>Cantidad Maxima de Estudiantes:</label>
						<input type="text" class="form-control" name="cantmaxima" placeholder="Ingresa la cantidd maxima de estudiantes">
						<div style="margin-top: 20px;">
						   <button class="btn btn-success" class="glyphicon glyphicon-ok" name="accion" value="crear"> Crear Curso</button>
                                                   <button class="btn btn-danger" class="glyphicon glyphicon-ok" name="accion" value="cancelar"> Cancelar</button>

						</div>
				    </div>
				</form>
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