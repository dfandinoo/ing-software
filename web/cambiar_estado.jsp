<%@page import="com.modelo.Curso"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%---
HttpSession sesion = request.getSession();
if(sesion.getAttribute("pkeyEstudiante") != null){
--%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Cambiar Estado</title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row" style="padding-top: 5px;">
                <div class="col-md-6">
                    <div align="left">
                        <a href="dashboard_admin.jsp"><button class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span> Dashboard</button></a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" align="center">
                    <legend style="font-size: 25px; ">Cambiar Estado</legend>
                            
                        <div>
                            <img src="img/docente.jpg" alt="">
                        </div>
                        <div>                            
                            <form action="">
                                <div class="form-group">
                                    <label>Seleccione el Docente</label>
                                        <select name="" class="form-control selectpicker" required>
                                                 <option value="">
                                                 Eliga el docente al cual le quiere cambiar el estado
                                                </option>
                                                <option value="">Eliga el docente al cual le quiere cambiar el estado</option>
                                    <option value="">docente1</option>
                                     <option value="">docente2</option>
                                      <option value="">docente3</option>
                                       <option value="">docente4</option>
                                          </select>
                                </div>
                                <label>Seleccione El Estado</label>                                  
                                
                                
                            <div class="radio form-group">
                                <label class="radio-inline "><input type="radio" value="ACTIVO" name="tipoUsuario" >Activo </label> 
                                <label class="radio-inline "><input type="radio" value="INACTIVO" name="tipoUsuario" > Inactivo </label>
                              
                            </div>
                                
                                <div style="margin-top: 20px;">
                                    <button class="btn btn-success" name="" value=""><span class="glyphicon glyphicon-ok"></span> Cambiar Estado</button>
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
<%-- }else{
    request.getRequestDispatcher("index.jsp").forward(request, response);  
}
--%>