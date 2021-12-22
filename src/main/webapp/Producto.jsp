<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>Producto</h1>



	<div class="d-flex">
		<div class="card col-sm-4">
			<div class="card-body">
				<form action="">
				
					<div class="mb-2"><label>Descripcion</label> <input class="form-control" type="text" value="" name="txtDescripcion"></div>
					<div class="mb-2"><label>Precio</label><input class="form-control" type="text" value="" name="txtPrecio"></div>
					<div class="mb-2"><label>Stock</label><input class="form-control" type="text" value="" name="txtStock"></div>
					<div class="mb-2"><label>Estato</label><input class="form-control" type="text" value="" name="txtEstado"></div>
				
				<input type="submit" name="accion" value="Agregar" class="btn btn-info">
				<input type="submit" name="accion" value="Actualizar" class="btn btn-success">
				
				</form>

			</div>

		</div>

		<div class="col-sm-8">

			<table class="table table-hover">

				<thead >
				<tr>
				<th>Descripcion</th>
				<th>Precio</th>
				<th>Stock</th>
				<th>Estado</th>
				<th>Acciones</th>
				</tr>

				</thead>


				<tbody>
				<tr>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				</tr>

				</tbody>



			</table>

		</div>



	</div>




	<!-- =========================================================================================== -->

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