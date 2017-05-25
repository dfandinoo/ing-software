<!DOCTYPE html>

<% 
String cantPreguntas=request.getParameter("cantPreguntas");
int cont=Integer.parseInt(cantPreguntas);
%>
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
    	  </div>
    </div>
       <div class="row" style="margin-top: 15px;">
   	   	   <div class="col-md-6" style="margin-top: 130px;" align="center">
   	   	   	  <legend> Registrar Preguntas</legend>
                          <img src="img/quejas.png" alt="" width="150" height="150">
   	   	   </div>
   	   	   <div class="col-md-6">
   	   	   	  <form action="listado_preguntas.jsp">
   	   	   	  	<div class="form-group">
   	   	   	  		
   	   	   	  	</div>
                                <%
                                    for(int i=1;i<=cont;i++)
                                    {
                                        
                                        out.write("<div class=\"form-group\">");
                                        out.write("<legend>Ingrese la pregunta numero: "+i+"</legend>");
                                        out.println("<input type=\"text\" name=\"pregunta${i}\"  class=\"form-control\" placeholder=\"Ingrese la Pregunta\">");
                                        out.write("</div>");
                                    }
                                %>
                                  <div class="form-group" align="center">
                            <button class="btn btn-success" onclick="submit();" name="accion" value="enviar"><span class="glyphicon glyphicon-ok"></span> Registrar Preguntas</button>
                            <button class="btn btn-danger"  name="" value="" type="reset"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>
                        </div>
   	   	   	  </form>
   	   	   </div>


   	   </div>
   </div>




	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
