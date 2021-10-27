<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>La Empresa</title>
	<link type="text/css" rel="stylesheet" href="foundation/css/foundation.css">
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
	<script src="foundation/js/vendor/modernizr.js"></script>
	<script src="foundation/js/vendor/jquery.js"></script>
	<script src="foundation/js/foundation.min.js"></script>
</head>
<body class="cuerpoFondo">
	<div id="contenedorPrincipal">
		<jsp:include page="MenuCliente.jsp"></jsp:include>
		<br> <br> <br>
		<div class="large-6 columns">
			<img src="foundation/img/atencion.jpg" />
		</div>
		<div class="large-6 columns">
			<fieldset>
				<legend>
					<b>Vision</b>
				</legend>
				<p></p>
				<h4>
					<font color="#4277C1"> "Ser lider en el traslado de
						pasajeros y carga, con servicio diferenciado e innovador."</font>
				</h4>
				<p></p>
			</fieldset>
			<fieldset>
				<legend>
					<b>Mision</b>
				</legend>
				<p></p>
				<h4>
					<font color="#4277C1">"Brindar a nuestros clientes un
						servicio seguro de calidad y confiable; con personal capacitado y
						experimentado; utilizando la mejor tecnología."</font>
				</h4>
				<p></p>
			</fieldset>
			<fieldset>
				<legend>
					<b>Valores</b>
				</legend>
				<h4>
					<font color="#4277C1"> *Seguridad<br> *Innovación<br>
						*Trabajo en equipo<br> *Respeto y cordialidad
					</font>
				</h4>
				<br>
			</fieldset>
		</div>
		<br> <br>
		<div class="row fullWidth">
			<div class="large-12 text-center">
				<footer>
					<div class="top-bar">
						<h5>Amazing Peruvian Tours &copy; Todos los derechos reservados</h5>
					</div>
				</footer>
			</div>
		</div>
	</div>
	<script>
		$(document).foundation();
	</script>
</body>
</html>