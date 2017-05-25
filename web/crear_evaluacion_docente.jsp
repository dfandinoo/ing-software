<!DOCTYPE html>

<%--
String cantPreguntas=request.getParameter("cantPreguntas");
int cont=Integer.parseInt(cantPreguntas);
--%>
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
            <a href="dashboard_admin.jsp">  <button class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Dashboard</button></a>
    	  </div>
    </div>
       <div class="row" style="margin-top: 5px;">
   	   	   <div class="col-md-12" style="" align="center">
   	   	   	  <legend>Crear Evaluacion Docente</legend>
                          <img src="img/quejas.png" alt="" width="100" height="100">
   	   	   </div>
       </div>
       <div class="row" style="">
   	   	   <div class="col-md-12" style="" align="center">
   	   	   	<div class="row" style="">
                                                <div class="col-md-3 col-md-offset-3 form-group" style="" align="center">
                                                        <legend align="center" >NOMBRE DEL CURSO</legend>
                                                        <input type="text" name=""  style="background-color: aliceblue; color: greenyellow;" class="form-control" placeholder="AQUI SE PONE EL NOMBRE DEL CURSO" readonly="false">
                                                </div>
                                                        <div class="col-md-3 form-group" style="" align="center">
                                                        <legend align="center" >DOCENTE ASIGNADO</legend>
                                                        <input type="text" name="" style="background-color: aliceblue; color: aliceblue;" class="form-control" placeholder="AQUI SE PONE EL DOCENTE ASIGNADO AL CURSO" readonly="false">
                                                </div>

                        </div> 
   	   	   </div>
       </div>
           <div class="row">
               <div class="col-md-6">
                    <div class="form-group">
                                       <legend align="center" >Ingrese la Pregunta 1:</legend>
                                        <input type="text" name="pregunta1"  class="form-control" placeholder="Ingrese la Pregunta">
                   </div>
                    <div class="form-group">
                                       <legend align="center" >Ingrese la Pregunta 2:</legend>
                                        <input type="text" name="pregunta2"  class="form-control" placeholder="Ingrese la Pregunta">
                   </div>
                    <div class="form-group">
                                       <legend align="center" >Ingrese la Pregunta 3:</legend>
                                        <input type="text" name="pregunta3"  class="form-control" placeholder="Ingrese la Pregunta">
                    </div>
                     <div class="form-group">
                                       <legend align="center">Ingrese la Pregunta 4:</legend>
                                       <input type="text" name="pregunta4"  class="form-control" placeholder="Ingrese la Pregunta">
                    </div>
                     <div class="form-group">
                                       <legend align="center">Ingrese la Pregunta 1:</legend>
                                        <input type="text" name="pregunta5"  class="form-control" placeholder="Ingrese la Pregunta">
                   </div>                
                                
                   
                                
               </div>
                <div class="col-md-6">
                   <div class="form-group">
                                       <legend align="center">Ingrese la Pregunta 6:</legend>
                                        <input type="text" name="pregunta6"  class="form-control" placeholder="Ingrese la Pregunta">
                   </div>
                    <div class="form-group">
                                       <legend align="center">Ingrese la Pregunta 7:</legend>
                                        <input type="text" name="pregunta7"  class="form-control" placeholder="Ingrese la Pregunta">
                   </div>
                    <div class="form-group">
                                       <legend align="center">Ingrese la Pregunta 8:</legend>
                                        <input type="text" name="pregunta8"  class="form-control" placeholder="Ingrese la Pregunta">
                   </div>
                    <div class="form-group">
                                       <legend align="center">Ingrese la Pregunta 9:</legend>
                                        <input type="text" name="pregunta9"  class="form-control" placeholder="Ingrese la Pregunta">
                   </div>
                    <div class="form-group">
                                       <legend align="center">Ingrese la Pregunta 10:</legend>
                                        <input type="text" name="pregunta10"  class="form-control" placeholder="Ingrese la Pregunta">
                   </div>
               </div>
           </div>
           <div class="row">
   	   	   <div class="col-md-12">
   	   	   	  <form>
   	   	   	  	<div class="form-group">
   	   	   	  		
   	   	   	  	</div>
                              
                                  <div class="form-group" align="center">
                            <button class="btn btn-success" onclick="submit();" name="accion" value="enviar"><span class="glyphicon glyphicon-ok"></span> Crear Evaluacion Docente</button>
                            <button class="btn btn-danger"  name="" value="" type="reset"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>
                        </div>
   	   	   	  </form>
   	   	   </div>


   	   </div>
           </div>
   </div>




	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
