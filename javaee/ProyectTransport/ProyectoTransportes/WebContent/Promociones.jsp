<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Promociones</title>
	<link type="text/css" rel="stylesheet" href="foundation/css/foundation.css">
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
	<script src="foundation/js/vendor/modernizr.js"></script>
	<script src="foundation/js/vendor/jquery.js"></script>
	<script src="foundation/js/foundation.min.js"></script>
</head>
<body class="cuerpoFondo">
	<div id="contenedorPrincipal">
		<jsp:include page="MenuCliente.jsp"></jsp:include>
		<br>
		<div class="row fullWidth">
			<div class="large-15 columns">
				<ul class="orbit-container" data-orbit
					data-options="animation:fade;animation_speed:50;pause_on_hover:false;">
					<li><img src="foundation/img/cusco_banner.jpg" alt="foto1" />
						<div class="orbit-caption"></div></li>
					<li><img src="foundation/img/ica_banner.jpg" alt="foto 2" />
						<div class="orbit-caption"></div></li>
					<li><img src="foundation/img/huaraz_banner.jpg" alt="foto 3" />
						<div class="orbit-caption"></div></li>
					<li><img src="foundation/img/arequipa_banner.jpg" alt="foto 4" />
						<div class="orbit-caption"></div></li>
					<li><img src="foundation/img/tacna_banner.jpg" alt="foto 5" />
						<div class="orbit-caption"></div></li>
				</ul>
			</div>
		</div>
		<br> <br>
		<div class="row">
			<div class="large-4 columns">
				<img src="foundation/img/abancay_p.png"> <br> <br> <br>
				<img src="foundation/img/arequipa_p.png">
			</div>
			<div class="large-4 columns">
				<img src="foundation/img/mancora_p.png"> <br> <br> <br>
				<img src="foundation/img/Tacna_p.png">
			</div>
			<div class="large-4 columns">
				<img src="foundation/img/Ica_p.png"> <br> <br> <br>
				<img src="foundation/img/Huaraz.png">
			</div>
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