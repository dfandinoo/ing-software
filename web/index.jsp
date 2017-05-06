<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="UTF-8">
	<title>Home</title>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
	           <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body style="background-color: 	#DEB887;" background="">
	<div class="container-fluid">
            <div class="row">
                <div class="col-md-12" align="center" style="text-shadow: 3px 2px black;">
                    <legend style="font-style: oblique; font"><h1><span style="color :red;font-size: 60px;">AULA</span> <span style="color:blue ;font-size: 60px;">VIRTUAL</span></h1></legend>
                </div>
            </div>
            <% HttpSession sesion = request.getSession();  %>
            <% if(sesion.getAttribute("pkeyEstudiante") == null && sesion.getAttribute("pkeyDocente") == null && sesion.getAttribute("pkeyAdmin") == null){ %>
		<div class="row" style="margin-top: 10px;">
                    <div class="col-md-6 " align="center">
                        <a href="login.jsp"><button class="btn btn-success"><span class=" glyphicon glyphicon-user"></span> Iniciar Sesion</button></a>
                    </div>
                    <div class="col-md-6" align="center">
			<a href="register.jsp"><button class="btn btn-info"><span class=" glyphicon glyphicon-download-alt"></span> Registrarse</button></a>
                    </div>
		</div>
            <% }else if(sesion.getAttribute("pkeyEstudiante") != null){ %>
                <div class="row" style="margin-top: 10px;">
                    <div class="col-md-6 " align="center">
                        <a href="dashboard_estudiante.jsp"><button class="btn btn-success"><span class=" glyphicon glyphicon-user"></span> Dashboard</button></a>
                    </div>
		</div>
            <% }else if(sesion.getAttribute("pkeyDocente") != null){ %>
                <div class="row" style="margin-top: 10px;">
                    <div class="col-md-6 " align="center">
                        <a href="dashboard_docente.jsp"><button class="btn btn-success"><span class=" glyphicon glyphicon-user"></span> Dashboard</button></a>
                    </div>
		</div>
            <% }else if(sesion.getAttribute("pkeyAdmin") != null){ %>
                <div class="row" style="margin-top: 10px;">
                    <div class="col-md-6 " align="center">
                        <a href="dashboard_admin.jsp"><button class="btn btn-success"><span class=" glyphicon glyphicon-user"></span> Dashboard</button></a>
                    </div>
		</div>
            <% } %>
		
            <div class="row" style="padding-top: 10px;">
                <div class="col-md-12">
                    <div id="carousel" class="carousel slide" data-ride="carousel">
                        <!--Indicadores-->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel" data-slide-to="1" ></li>
                            <li data-target="#carousel" data-slide-to="2" ></li>
                            <li data-target="#carousel" data-slide-to="3" ></li>     
                        </ol>

                        <!--contenedro slider-->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img src="img/slide/slide1.jpg"  class="image-responsive" width="2001" height="604" > 
                                <div class="carousel-caption">
                                    <h2>REGISTRATE AHORA MISMO</h2>
                                    <a href="register.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-download-alt"></span> Registate Aqui</button></a>
                                </div>
                            </div> 

                            <div class="item">
                                <img src="img/slide/slide2.jpg"  class="image-responsive"  width="2001" height="604"> 
                                <div class="carousel-caption">
                                    <h2 style="color:blue">FACIL,RAPIDO,SENCILLO </h2>
                                </div>
                            </div> 

                            <div class="item">
                                <img src="img/slide/slide3.jpg"   > 
                                <div class="carousel-caption" >
                                    <H2 style="color: blue">CURSOS NUEVOS </H2>
                                </div>
                            </div> 
                            
                            <div class="item">
                                <img src="img/slide/slide4.jpg"   width="2001" height="604"> 
                                <div class="carousel-caption"  >
           
                                    <H2 style="color:blue">CONOCIMIENTO A TU ALCANCE</H2>
                                </div>
                            </div> 


                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row" style="margin-top: 20px;">
                <div class="col-md-4">
       
                    <div class="thumbnail" align="justify" style="background-color: red;">
                        <span class="glyphicon glyphicon-ok" style="font-size: 30px; color:green;"></span>
                        <div class="caption">
                            <p style="color: white;">Buenos contenidos, actividades que fomentan el aprendizaje y cursos actualizados disponibles para ti constantemenre esto y mucho mas encontraras en Aulavirtual.com</p>
                        </div>
                    </div>
       
                </div>
       
                <div class="col-md-4">
                    <div class="thumbnail" align="justify" style="background-color: red;">
                        <span class="glyphicon glyphicon-user " style="font-size: 30px; color:green;"></span>
       			<div class="caption">
                            <p style="color:white;">Nuestro equipo de formadores son expertos reconocidos en software, negocios creatividad y otras areas del conociemiento, adaptan los contenidos de acuerdo a tu nivel de aprendizaje y los presentan en breves y prácticas acividades o material de estudio.</p>
                        </div>
       		</div>
       		
       	</div>
       	<div class="col-md-4">
       	
       		<div class="thumbnail" align="justify"w style="background-color: red;">
       		<span class="glyphicon glyphicon-pencil" style="font-size: 30px; color:green;"></span>
       			<div class="caption">

       			<p style="color: white;">Evaluaciones que permitiran evaluar a los deocentes y evaluarte a ti mismo ,el nivel de apripiacion sobre los temas del curso y saber que tendras que reforzar recuerda que estas en un proceso de aprendizaje y aveces hay cosas que se pasan por alto </p>
       		   </div>
       		</div>
       		</div>
       	</div>
       </div>
       
	</div>


</body>
<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</html>