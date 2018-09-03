<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<title>Ver</title>
</head>
<body>
<img src ="img/leer.jpeg" >
	<h1>Ver Lista</h1>

	<div class="list-group">
		


		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido Paterno</th>
					<th scope="col">Apellido Materno</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var ="item" items="${list}">

				<tr>
					<th scope="row"><c:out value = "${item.getId()}"></c:out></th>
					<td><c:out value = "${item.getNombre()}"></c:out></td>
					<td><c:out value = "${item.getApellidoP()}"></c:out></td>
					<td><c:out value = "${item.getApellidoM()}"></c:out></td>
					<th><input class="btn btn-danger" type="button" value="Eliminar" onclick="eliminar('${item.getId()}');"></th>
					<th><input class="btn btn-success" type="button" value="Editar" onclick="editar('${item.getId()}');"></th>
				</tr>

				</c:forEach>

			</tbody>
			
		</table>
		<a href="/RegistroUsuario/Index" class="btn btn-outline-primary" >Regresar</a>
		
	</div>
	
</body>

<script src = js/javascript.js type="text/javascript" ></script>

</html>