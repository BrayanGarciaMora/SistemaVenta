<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-info">
		<div class="container-fluid">

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					</li>

					<li class="nav-item"><a
						style="margen-left: 10px; border: none;"
						class="btn btn-outline-light" href="Controlador?menu=Home" target="myFrame">Home</a></li>

					<li class="nav-item"><a
						style="margen-left: 10px; border: none;"
						class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a></li>

					<li class="nav-item"><a
						style="margen-left: 10px; border: none;"
						class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a></li>

					<li class="nav-item"><a
						style="margen-left: 10px; border: none;"
						class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Cliente</a></li>

					<li class="nav-item"><a
						style="margen-left: 10px; border: none;"
						class="btn btn-outline-light" href="Controlador?menu=RegistrarVenta&accion=default" target="myFrame">Nueva Venta</a></li>
				</ul>

				<div class="dropdown">

					<button style="border: none;"
						class="btn btn-outline-light dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">${usuario.getNombre() }</button>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="#"><img alt="60"
								height="60" src="img/user.png"></a></li>
						<li><a class="dropdown-item" href="#">${usuario.getUser() }</a></li>
						<li><a class="dropdown-item" href="#">usuario@gmail.com</a></li>
						<div class="dropdown-divider"></div>
						<form action="Validar" method="POST"><button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button></form>
					</ul>

				</div>
				<form class="d-flex"></form>
			</div>
		</div>
		
	</nav>
	
	
	<div class="mb-2"  style="height: 500px;">
	<iframe name="myFrame" style="height: 100%; width: 100%; border: 3;"></iframe>
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