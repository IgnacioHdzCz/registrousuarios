<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Insertar</title>
</head>
<body>
	<h1>Insert</h1>

	<div class="list-group">
		<a href="/RegistroUsuario/Index"
			class="list-group-item list-group-item-action active"> Regresar </a>
		<%
			if (request.getAttribute("mensaje") != null) {
		%>
		<b><%=request.getAttribute("mensaje")%></b>
		<%
			}
		%>

		<form action="/RegistroUsuario/Insertar" method="post">
			<div class="form-group">

				<label for="txtnombre">Nombre</label> <input type="text"
					class="form-control" id="txtnombre" name ="txtnombre" 
					placeholder="Ingresa Nombre"> 
			</div>
			<div class="form-group">
				<label for="txtapellidoP">Apellido Paterno</label> <input
					type="text" class="form-control" id="txtapellidoP" name ="txtapellidoP"
					placeholder="Apellido Paterno">
			</div>

			<div class="form-group">
				<label for="txtapellidoM">Apellido Materno</label> <input
					type="text" class="form-control" id="txtapellidoM" name ="txtapellidoM"
					placeholder="Apellido Materno">
			</div>

			<input type="submit" class="btn btn-primary" value = "Registrar persona">
		</form>





	</div>


</body>
</html>