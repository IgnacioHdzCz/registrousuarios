<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href ="css/index.css" rel = "stylesheet">
<title>Insertar</title>
</head>
<body>
	<h1 id ="h1">Insertar</h1>

	<div class="list-group">
		
		<%
			if (request.getAttribute("mensaje") != null) {
		%>
		<b><%=request.getAttribute("mensaje")%></b>
		<%
			}
		%>

		<form action="/RegistroUsuario/Insertar" method="post" onsubmit="return validacion">
			<div class="form-group">

				<label for="txtnombre">Nombre</label> <input type="text" class="form-control" id="txtnombre" name ="txtnombre" 
					placeholder="Ingresar Nombre" required> 
					<script src="js/insertar.js"></script>
			</div>
			<div class="form-group">
				<label for="txtapellidoP">Apellido Paterno</label> 
				<input type="text" class="form-control" id="txtapellidoP" name ="txtapellidoP"
					placeholder="Ingresar Apellido Paterno" required>
			</div>

			<div class="form-group">
				<label for="txtapellidoM">Apellido Materno</label> 
				<input type="text" class="form-control" id="txtapellidoM" name ="txtapellidoM"
					placeholder="Ingresar Apellido Materno" required>
			</div>

<input type="submit" class="btn btn-outline-success" value = "Registrar usuario">
	<a href="/RegistroUsuario/Index" class="btn btn-outline-primary" role="button"> Regresar </a>
			
		</form>

	</div>
	
</body>


</html>