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
    	  	  <button class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Dashboard</button>
                  <div style="margin-top: 20px;">
                      <img src="img/respuestas.png" width="150" height="150">
                      <legend>Registrar Respuestas</legend>
                  </div>
    	  </div>
    </div>
       <div class="row" style="margin-top: 15px;">
   	   	   <div class="col-md-4" style="margin-top: " align="center">
                        <div class="form-group">
                                <label>Respuesta A:</label>
                                 <input type="text" class="form-control" name="RespuestaA" placeholder="Ingresa la respuesta" required>
                        </div>
   	   	   </div>
   	   	   <div class="col-md-4">
   	   	   	  <div class="form-group" align="center">
                                <label>Respuesta B:</label>
                                 <input type="text" class="form-control" name="RespuestaB" placeholder="Ingresa la respuesta" required>
                        </div>
   	   	   </div>
                    <div class="col-md-4">
   	   	   	  <div class="form-group" align="center">
                                <label>Respuesta C:</label>
                                 <input type="text" class="form-control" name="RespuestaC" placeholder="Ingresa la respuesta" required>
                        </div>
   	   	   </div>


   	  </div>
       <div class="row" style="margin-top: 15px;">
            <div class="col-md-4 col-md-offset-4">
   	   	   	<div class="form-group" align="center">
                                <label>Respuesta D:</label>
                                 <input type="text" class="form-control" name="RespuestaD" placeholder="Ingresa la respuesta" required>
                        </div>  
   	   </div>
       </div>
        <div class="row" style="margin-top: 15px;">
            <div class="col-md-6 col-md-offset-3">
   	   	   	<div class="form-group" align="center">
                                <label>Seleccione la respuesta Correcta:</label>
                                 <select name="" class="form-control selectpicker" required style="background-color: greenyellow;">
                                                 <option value="">
                                                 Seleccione la Respuesta Correcta
                                                </option>                                               
                                    <option value="A">Respuesta A</option>
                                     <option value="B">Respuesta B</option>
                                      <option value="C">Respuesta C</option>
                                       <option value="D">Respuesta D</option>
                                          </select>
                                
                        </div>  
                <div class="form-group" align="center">
                    <button class="btn btn-success" name="accion" value=""><span class="glyphicon glyphicon-ok"  ></span> Registrar Respuestas</button>
                    <button class="btn btn-danger" name="accion" value="" type="reset"><span class="glyphicon glyphicon-ok" ></span> Cancelar</button>

                </div>
   	   </div>
       </div>
   </div>




	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>