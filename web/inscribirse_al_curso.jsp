<% 
HttpSession sesion = request.getSession();
if(sesion.getAttribute("pkeyEstudiante") != null){
%>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Inscribirse al curso</title>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
	           <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
      <div class="container-fluid">
		<div class="row">
			<div class="col-md-12" align="center">
				<legend style="font-size: 25px; ">INSCRIBIRSE EN CURSO</legend>
                                    <div class="col-md-6">
					 <div class="panel panel-success" align="center">
                                            <div class="panel-heading">Cursos Disponibles</div>
                                            <div class="panel-body">Panel Content</div>
                                        </div>
                                    </div>
				<div class="col-md-6">
					<div>
						<img src="img/docente.jpg" alt="">
					</div>
					<div>
                                            <form action="ServletInscribirEstudiante">
                                                <div class="form-group">
                                                                <label>Ingresa el ID del curso</label>
                                                                <input type="text" class="form-control" name="idCurso" placeholder="Ingresa el id del curso">
                                                        </div>    
                                                   
                                                    <div style="margin-top: 20px;">
                                                         <button class="btn btn-danger"><span class="glyphicon glyphicon-ok" name="accion" value="inscribir"></span> Inscribir al Curso</button>
                                                    <a href="inscribirse_al_curso.jsp"><button class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>Cancelar</button></a>
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
<% }else{
    request.getRequestDispatcher("index.jsp").forward(request, response);  
}
%>