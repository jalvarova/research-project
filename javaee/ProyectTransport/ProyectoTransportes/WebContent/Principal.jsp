<%@ page import="services.RutaService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Pagina Principal</title>
	<link type="text/css" rel="stylesheet" href="foundation/css/foundation.css">
	<link type="text/css" rel="stylesheet" href="CSS/EstilosPrincipal.css">
	<script src="foundation/js/vendor/modernizr.js"></script>
	<script src="foundation/js/vendor/jquery.js"></script>
	<script src="foundation/js/foundation.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
	
	<script>
		$(document).ready(function() {
			var hoy = new Date();
			$("#datepicker").datepicker({
				maxDate: hoy,
				dateFormat: "yy/mm/dd" 
			});
		});
	</script>
	<script type="text/javascript" src="JS/ScriptPpal.js"></script>
	<script type="text/javascript" src="JS/fancybox.js"></script>
	<link rel="stylesheet" type="text/css" href="CSS/fancybox.css" media="screen" />
</head>
<body>
	<jsp:include page="MenuCliente.jsp"></jsp:include>
	<div class="row fullWidth">
		<div class="large-4 columns">
			<form action="BuscaViajes" method="post" class="panel">
				<div class="row">
					<div class="large-12 large-centered columns">
						<h5>Buscar Viajes</h5>
						<hr />
					</div>
				</div>
				<div class="row">
					<div class="large-10 columns">
						<label>Origen <select id="origen" name="origen" required="required">
								<option>Seleccione</option>
								<c:forEach items="${sessionScope.listaCiudades}" var="ciudad">
									<option value='${ciudad.codciudad}'>${ciudad.nomCiudad}</option>
								</c:forEach>
						</select>
						</label>
					</div>
				</div>
				<div class="row">
					<div class="large-10 columns">
						<label>Destino <select id="destino" name="destino" required="required">
								<option>Seleccione</option>
						</select>
						</label>
					</div>
				</div>
				<div class="row">
					<div class="large-10 columns" id="ida">
						<label>Fecha de Viaje </label>
						<input type="text" id="dtIda" name="dtIda"	class="datepicker" required="required">
					</div>

				</div>
				<div class="row">
					<div class="large-10 large-centered columns">
						<p>${requestScope.msj}</p>
					
					</div>
				</div>

				<div class="row">
					<div class="large-10 columns">
						<ul class="centered button-group even-2">
							<li><input class="small button" id="btnBuscar" type="submit"
								name="btnBuscar" value="Buscar"></li>
							<li><input class="small button" id="btnLimpiar" type="reset"
								name="btnLimpiar" value="Cancelar"></li>
						</ul>
					</div>
				</div>
			</form>
		</div>
		<div class="large-8 columns">
			<ul class="orbit-container" data-orbit
				data-options="animation:fade;animation_speed:50;pause_on_hover:false;">
				<li><img src="foundation/img/cusco_3.jpg" alt="Machu Picchu" />
					<div class="orbit-caption">Machu Picchu.</div></li>
				<li><img src="foundation/img/ancash_1.jpg" alt="slide 2" />
					<div class="orbit-caption">Huaraz.</div></li>
				<li><img src="foundation/img/ica_3.jpg" alt="slide 2" />
					<div class="orbit-caption">Paracas</div></li>
			</ul>
		</div>
	</div>
		<div class="row">
		<div class="large-8 large-centered columns">
			<ul id="destinos" class="large-block-grid-3">
				<li><a href="http://huaraz.com"> <img alt="Machu Picchu"
						src="foundation/img/huaraz.jpg">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<b>Huaraz</b>
				</a></li>
				<li><a href="http://www.trujilloperu.com/"> <img alt="Machu Picchu"
						src="foundation/img/trujillo.jpg">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<b>Trujillo</b>
				</a></li>
				<li><a href="http://www.turismomoquegua.com.pe/"> <img alt="Machu Picchu"
						src="foundation/img/moquegua.jpg">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<b>Moquegua</b>
				</a></li>
				<li><a href="http://www.huancayoperu.com/"> <img alt="Machu Picchu"
						src="foundation/img/huancayo.jpg">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<b>Huancayo</b>
				</a></li>
				<li><a href="http://cuzco.com/"> <img alt="Machu Picchu"
						src="foundation/img/Machu-Picchu.jpg">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<b>Cuzco</b>
				</a></li>
				<li><a href="http://www.icaperu.com/"> <img alt="Machu Picchu"
						src="foundation/img/ica.jpg">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<b>Ica</b>
				</a></li>
				<li><a href="http://www.perumancora.com/es/"> <img alt="Machu Picchu"
						src="foundation/img/mancora.jpg">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<b>Mancora</b>
				</a></li>
			
				<li><a href="http://www.i-nazca.info/"> <img alt="Machu Picchu"
						src="foundation/img/nazca.jpg">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<b>Nazca</b>
				</a></li>
				<li><a href="http://www.turismoabancay.com/"> <img alt="Machu Picchu"
						src="foundation/img/abancay.jpg">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<b>Abancay</b>
				</a></li>
			</ul>
		</div>
	</div>
	<div class="row fullWidth">
		<div class="large-12 text-center">
			<footer>
				<div class="top-bar">
					<h5>Amazing Peruvian Tours &copy; Todos los derechos reservados</h5>
				</div>
			</footer>
		</div>
	</div>
	<script>
		$(document).foundation();
	</script>
</body>
</html>