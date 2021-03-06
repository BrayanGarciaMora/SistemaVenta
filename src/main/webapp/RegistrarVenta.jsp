<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<h4 align="center">Registrar una venta</h4>

	<div class="d-flex">
		<div class="col-sm-4">
			<div class="card">
				<form action="Controlador?menu=RegistrarVenta" method="post">
					<div class="card-body">
						<div class="form-group">
							<label>Datos del cliente</label>
						</div>

						<div class="form-group d-flex">
							<div class="col-sm-6 d-flex">
								<input type="text" name="codigoCliente" value="${c.getDni() }"
									class="form-control" placeholder="Codigo"> <input
									type="submit" name="accion" value="Cliente"
									class="btn btn-outline-info">
							</div>

							<div class="col-sm-6">
								<input type="text" name="nombreCliente"
									value="${c.getNombre() }" class="form-control"
									placeholder="Cliente">
							</div>
						</div>
						<div class="form-group">

							<label>Datos Productos</label>
						</div>
						<div class="form-group d-flex">
							<div class="col-sm-6 d-flex">
								<input type="text" name="codigoProducto" class="form-control"
									placeholder="Codigo"> <input type="submit"
									name="accion" value="Producto" class="btn btn-outline-info">
							</div>

							<div class="col-sm-6">
								<input type="text" name="nombreProducto"
									value="${producto.getNombre() }" class="form-control"
									placeholder="Datos Producto">
							</div>
						</div>
						<div class="form-group d-flex">
							<div class="col-sm-6 d-flex">
								<input type="text" name="precio"
									value="${producto.getPrecio() }" class="form-control"
									placeholder="$/0.00">
							</div>

							<div class="col-sm-3">
								<input type="number" name="cantidad" value="1"
									class="form-control" placeholder="cantidad">
							</div>

							<div class="col-sm-3">
								<input type="text" name="stock" value="${producto.getStock() }"
									class="form-control" placeholder="stock">
							</div>
						</div>

						<div class="form-group">
							<input type="submit" name="accion" value="Agregar"
								class="btn btn-outline-info">
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="col-sm-8">
			<div>
				<div class="card">
					<div class="card-body">
						<div class="d-flex col-sm-4 ml-auto">
							<label>Numero de serie:</label> <input type="text"
								name="numeroSerie" class="form-control">
						</div>
					</div>

					<table class="table table-hover">
						<tr>
						<thead>
							<th>No.</th>
							<th>Codigo</th>
							<th>Descripcion</th>
							<th>Precio</th>
							<th>Cantidad</th>
							<th>Total</th>
							<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
							<core:forEach var="lista" items="${listaVenta}">
								<tr>
									<td>${lista.getItem() }</td>
									<td>${lista.getId()}</td>
									<td>${lista.getDescripcionProducto()}</td>
									<td>${lista.getPrecio() }</td>
									<td>${lista.getCantidad() }</td>
									<td>${lista.getSubTotal	() }</td>
									<td><a href="#" class="btn btn-warning">Editar</a> <a
										href="#" class="btn btn-danger">Eliminar</a></td>

								</tr>
							</core:forEach>
						</tbody>
					</table>
				</div>

				<div class="card-footer d-flex">
					<div class="col-sm-6">
						<input type="submit" name="accion" value="Generar Venta"
							class="btn btn-success">
						 <input type="submit"
							name="accion" value="Cancelar" class="btn btn-danger">
					</div>
					<div class="col-sm-4 ml-auto">
					<input type="text" name="txtTotal" value="RD$ ${totalpago }" class="form-control">
					
					</div>
				</div>

			</div>
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