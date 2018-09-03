<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<title>Actualizar</title>
</head>
<body>
	<h1>Registro Actualizado</h1>
	
	
<div class="list-group">
  <a href="/RegistroUsuario/Index" class="list-group-item list-group-item-action active">Regresar</a>
</div>

<jsp:useBean id = "registro" class="pbas.ignacio.bean.Registro" scope="request"></jsp:useBean>

<form action="/RegistroUsuario/Actualizar" method="post">
  <div class="form-group">
    
    <input type="hidden" id = "txtId"  class="form-control" name="txtId" value = "<%=registro.getId() %>"  placeholder="id">
    
  </div>
  
  <div class="form-group">
    <label for="txtnombre">Nombre</label>
    <input type="text" class="form-control" id="txtnombre"  name = "txtnombre" value = "<%=registro.getNombre()%>">
  </div>
  
  <div class="form-group">
  
      <label  for="txtapellidoP">Apellido Paterno</label>
    <input type="text" class="form-control" id="txtapellidoP" name = "txtapellidoP" value = "<%=registro.getApellidoP()%>">

  </div>
  
  <div class="form-group">
  
      <label  for="txtapellidoP">Apellido Materno</label>
    <input type="text" class="form-control" id="txtapellidoM" name = "txtapellidoM" value = "<%=registro.getApellidoM()%>">

  </div>
  <button type="submit" class="btn btn-primary">Actualizar Registro</button>
</form>

</body>
</html>