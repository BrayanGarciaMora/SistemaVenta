<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

	<div class="d-flex">
		<div class="card col-sm-4">
			<div class="card-body">
				<form action="Controlador?menu=Empleado" method="POST">
					<div class="mb-3">
						<label class="form-label">Dni</label> <input type="text"
							value="${empleado.getDni() }" name="txtDni" class="form-control">
					</div>
					<div class="mb-3">
						<label class="form-label">Nombre</label> <input type="text"
							value="${empleado.getNombre()}" name="txtNombre"
							class="form-control">
					</div>
					<div class="mb-3">
						<label class="form-label">Telefono</label> <input type="text"
							value="${empleado.getTelefono() }" name="txtTelefono"
							class="form-control">
					</div>
					<div class="mb-3">
						<label class="form-label">Estado</label> <input type="text"
							value="${empleado.getEstado() }" name="txtEstado"
							class="form-control">
					</div>
					<div class="mb-3">
						<label class="form-label">Usuario</label> <input type="text"
							value="${empleado.getUser() }" name="txtUsuario"
							class="form-control">
					</div>

					<input type="submit" name="accion" value="Agregar"
						class="btn btn-info">
						
					 <input type="submit" name="accion"
						value="Actualizar" class="btn btn-success">
				</form>
			</div>
		</div>


		<div class="col-sm-8">
			<table class="table table-hover">

				<thead>
					<tr>
						<th>DNI</th>
						<th>NOMBRE</th>
						<th>TELEFONO</th>
						<th>ESTADO</th>
						<th>USER</th>
						<th>ACCIONES</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="emp" items="${empleados}">
						<tr>
							
							<td>${emp.getDni()}</td>
							<td>${emp.getNombre()}</td>
							<td>${emp.getTelefono()}</td>
							<td>${emp.getEstado()}</td>
							<td>${emp.getUser()}</td>
							<td><a class="btn btn-warning"
								href="Controlador?menu=Empleado&accion=Editar&id=${emp.getIdEmpleado()}">
									Editar </a> <a class="btn btn-danger"
								href="Controlador?menu=Empleado&accion=Eliminar&id=${emp.getIdEmpleado()}">
									Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>