<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
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
							name="txtDni" class="form-control">
					</div>
					<div class="mb-2">
						<label class="form-label">Nombre</label> <input type="text"
							name="txtNombre" class="form-control">
					</div>
					<div class="mb-2">
						<label class="form-label">Telefono</label> <input type="text"
							name="txtTelefono" class="form-control">
					</div>
					<div class="mb-2">
						<label class="form-label">Estado</label> <input type="text"
							name="txtEstado" class="form-control">
					</div>
					<div class="mb-2">
						<label class="form-label">Usuario</label> <input type="text"
							name="txtUsuario" class="form-control">
					</div>

					<input type="submit" name="accion" value="Agregar"
						class="btn btn-primary">
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
							<td><a> Editar </a> <a>Eliminar</a></td>
						<tr>
					</c:forEach>
				</tbody>

			</table>

		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>
</html>