<%--
#B0C4DE;
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
                         <a href="dashboard_docente.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Dashboard</button></a>
                     </div>
                </div>
            </div>
		<div class="row">
			<div class="col-md-12" align="center">
				<legend style="font-size: 25px; ">Crear Evaluacion</legend>
                        </div>
			<div class="col-md-6 col-md-offset-3" align="center">
					<div>
                                            <img src="img/crear_evaluacion.png" alt="" width="100" height="100">
					</div>
			<div>
                            <form name="" action="preguntas_evaluacion_estudiante.jsp" method="get">
			            <div class="form-group">
					        <label>Nombre de la Evalucion:</label>
						<input type="text" class="form-control" name="nombreEvaluacion" placeholder="Ingresa el nombre de la Evaluacion" required>
				    </div>
				    <div class="form-group">
						<label>Descripcion:</label>
                                    <textarea class="form-control" cols="20" rows="7" name="descripcion" required></textarea>

				    </div>
				    <div class="form-group">
						<label>Duracion:</label>
						<input type="number" class="form-control" name="duracion" placeholder="Ingresa la Duracion De la evalucion" required>
				    </div>
				    <div class="form-group">
					        <label>Cantidad de Preguntas:</label>
						<input type="number" class="form-control" name="cantPreguntas" placeholder="Ingresa la cantidd de Preguntas" required>
						<div style="margin-top: 20px;">
                                                    <button class="btn btn-success" class="glyphicon glyphicon-ok" name="accion" value="enviar" onclick="submit();" > Crear Evaluacion</button>
                                                   <button class="btn btn-danger" class="glyphicon glyphicon-ok" name="accion" value="cancelar" type="reset"> Cancelar</button>

						</div>
				    </div>
                                    <div class="alert alert-danger alert-dismissible" role="alert">aqui van los mensajes correspondientes</div>
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