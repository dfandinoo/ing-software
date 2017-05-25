<!DOCTYPE html>
<html lang="en"> 
<head>
	<meta charset="UTF-8">
	<title>Quejas y Reclamos</title>
	  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
	           <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body style="background-color: #FFF8DC;">
   <div class="container-fluid">
    <div class="row">
        <div class="col-md-12" style="margin-top: 10px;" align="center">
            <a href="dashboard_estudiante.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Volver</button></a>
        </div>
    </div>
       <div class="row" style="margin-top: 15px;">
   	   	   <div class="col-md-6" style="margin-top: 130px;" align="center">
   	   	   	  <legend> Enviar quejas y/o Reclamos </legend>
                          <img src="img/quejas.png" alt="" width="150" height="150">
   	   	   </div>
   	   	   <div class="col-md-6">
   	   	   	  <form action="">
   	   	   	  	<div class="form-group">
   	   	   	  		<legend>Correo:</legend>
   	   	   	  		<input type="text" name="correo"  class="form-control" placeholder="Ingrese la direccion de correo a donde recibira respuesta" required>
   	   	   	  	</div>
   	   	   	  	<div class="form-group">
   	   	   	  		<legend>Asunto:</legend>
   	   	   	  		<input type="text" name="asunto"  class="form-control" placeholder="Ingrese el asunto del mensaje" required>
   	   	   	  	</div>
   	   	   	  	<div class="form-group">
   	   	   	  		<legend>Descripcion:</legend>
   	   	   	  		<textarea name="descripcion" id="" cols="30" rows="12" class="form-control" placeholder="Puede introducir aqui su mesaje " required></textarea>
   	   	   	  	</div>
                                                <div style="margin-top: 20px;">
                                                    <button class="btn btn-success"  name="accion" value=""><span class="glyphicon glyphicon-ok"></span> Enviar </button>
                                                    <button class="btn btn-danger"  name="accion" value="" type="reset"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>

						</div>
   	   	   	  </form>
   	   	   </div>


   	   </div>
   </div>




	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>