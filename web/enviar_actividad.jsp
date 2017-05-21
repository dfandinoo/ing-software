<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
                   <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body style="background-color:#FFF8DC">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12"align="center" style="margin-top: 20px;">
                    <a href=""><button class="btn btn-success"><span class="glyphicon glyphicon-chevron-left"></span> Volver</button></a>
                </div>
            </div>
            <div class="row" style="margin-top: 60px;">
                <div class="col-md-6" align="center">
                    <div>
                    <img src="img/enviaractividad.png" alt="" width="225" height="225">
                    <legend style="color: red;">Enviar Acrtividad</legend>
                    </div>
                </div> 	
                <div class="col-md-6" align="center">
                    <form>                      
                                                
                         <div class="form-group">
					        <label>Descripcion:</label>
                                                <textarea class="form-control" cols="20" rows="7" name="descripcion" required></textarea>
                                                
				    </div>
                          <div class="form-group">
					        <label>Adjunto:</label>
                                                <input type="file" class="form-control" placeholder="subir aqui su archivo con la solucion a la actividad" name="Adjunto">                                                
				    </div>
                        
                         <div class="form-group" align="center">
                            <button class="btn btn-success" onclick="" name="" value=""><span class="glyphicon glyphicon-ok"></span> Crear Actividad</button>
                            <button class="btn btn-danger"  name="" value="" type="reset"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>
                        </div>
                        
                    </form>
                </div> 	
         
 	</div>
        </div>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>