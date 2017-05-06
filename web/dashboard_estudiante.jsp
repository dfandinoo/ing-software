
<% 
HttpSession sesion = request.getSession();
if(sesion.getAttribute("pkeyEstudiante") != null){
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>DASHBOARD-ESTUDIANTE</title>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
	           <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body background="img/fondo_registro1.jpg">
     <div class="container-fluid">
        <div class="row" align="center">
            <div class="col-md-12">
     		<h1 style="font-style: verdana; color: green;">BIENVENIDO ESTUDIANTE : </h1>
     	    </div>
        </div>
     	<div class="row" style="margin-top: 50px;">
            <div class="col-md-8">
                <div class="panel-group">
                    <div class="panel panel-success" align="center">
                        <div class="panel-heading">Cursos Disponibles</div>
                            <div class="panel-body">Panel Content</div>
                    </div>

                    <div class="panel panel-primary" align="center">
                        <div class="panel-heading">Cursos en los cuales esta inscrito</div>
                           <div class="panel-body">Panel Content</div>
                       </div>
                   </div>
            </div>
    <div class="row">
        <div class="col-md-3">
                        <div class="thumbnail" align="center" style="background-color: red; color: white;">
                                 <span class="glyphicon glyphicon-pencil" style="font-size: 25px;"></span>
                             <div>
                                 <caption>
                                     <a href="editar_usuario.jsp"><button class="btn btn-primary">Editar Informacion</button></a>
                                 </caption>
                             </div>
                        </div>
                  <div class="thumbnail" align="center" style="background-color: blue; color: white;">
                     <span class="glyphicon glyphicon-share-alt" style="font-size: 25px;"></span>
                         <div>
                             <caption>
                                 <a href="inscribirse_al_curso.jsp"><button class="btn btn-success">Inscribir Curso</button></a>
                             </caption>
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
