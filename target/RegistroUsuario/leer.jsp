<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<title>Ver</title>
</head>
<body>

	<h1>Ver Lista</h1>

	<div class="list-group">
		<a href="/RegistroUsuario/Index"
			class="list-group-item list-group-item-action active">Regresar</a>


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
					<th><input class="btn btn-primary" type="button" value="Eliminar" onclick="eliminar('${item.getId()}');"></th>
					<th><input class="btn btn-primary" type="button" value="Editar" onclick="editar('${item.getId()}');"></th>
				</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>




</body>

<script type="text/javascript">

	function eliminar(id) {
		window.location.href = "/RegistroUsuario/Eliminar?id="+ id;
		
	}
	
	function editar(id) {
	window.location.href = "/RegistroUsuario/Actualizar?id=" + id;		
	}


</script>

</html>