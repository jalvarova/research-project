<%@ page import="beans.AdministradorDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Menu</title>
	<link rel="stylesheet" type="text/css" href="CSS/EstilosAdministrador.css">
</head>
<body>
	<c:set var="usuario" value="${sessionScope.datosconsesion}"></c:set>
	<div class="row fullWidth">
		<nav class="top-bar fixed" data-topbar role="navigation">
			<ul class="title-area">
				<li class="name"><h1>
						<a href="InicioAdministrador">Amazing Peruvian Tours</a>
					</h1></li>
				<li class="toggle-topbar menu-icon"><a href="InicioAdministrador">Menu</a></li>
			</ul>
			<section class="top-bar-section">
				<ul class="right">
					<li class="has-active"><a href="ProcesarCliente">Manteniento Clientes</a></li>
					<li class="has-active"><a href="ProcesarEmpleado">Manteniento Empleados</a></li>
					<li class="has-active"><a href="ProcesarBus">Manteniento Buses</a></li>
					<li class="has-active"><a href="ProcesarRuta">Manteniento Rutas</a></li>
					<li class="has-active"><a href="ProcesarRecursos">Manteniento Servicios</a></li>
					<li class="has-active"><a href="RealizarReportes">Reportes</a></li>
					<li class="active"><a href="cerrandoSesion">Cerrar Sesión</a></li>
				</ul>
			</section>
		</nav>
		<header>
			<div id="logo">
				<img src="Imagenes/logo.png">
			</div>
			<h3>Usted se ha identificado como : ${usuario.nombre} ${usuario.apePater}</h3>
		</header>
	</div>
</body>
</html>