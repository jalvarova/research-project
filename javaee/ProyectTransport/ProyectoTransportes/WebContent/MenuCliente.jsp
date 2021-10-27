<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Menu Cliente</title>
</head>
<body>
	<c:set var="cli" value="${sessionScope.sesioncliente}"></c:set>
	<c:choose>
		<c:when test="${cli == null}">
			<div class="fixed">
				<nav class="top-bar" data-topbar role="navigation">
					<ul class="title-area">
						<li class="name">
							<h1>
								<a href="ProcesarIndex">Amazing Peruvian Tours</a>
							</h1>
						</li>
					</ul>
					<section class="top-bar-section">
						<ul class="right">
							<li><a id="login" class="fancybox-effects-a" href="Logueo.jsp">Iniciar Sesion</a></li>
							<li class="active"><a href="RegistroCliente.jsp">Registrarse</a></li>
							<li class="has-dropdown"><a href="#">Servicios</a>
								<ul class="dropdown">
									<li class="active"><a href="Promociones.jsp">Promociones</a></li>
									<li><a href="Destinos.jsp">Destinos</a></li>
									<li><a href="LaEmpresa.jsp">La Empresa</a></li>
								</ul></li>
						</ul>
						<ul class="left">
							<li><a href="Promociones.jsp">Promociones</a></li>
						</ul>
					</section>
				</nav>
			</div>
		</c:when>
		<c:otherwise>
			<div class="fixed">
				<nav class="top-bar" data-topbar role="navigation">
					<ul class="title-area">
						<li class="name">
							<h1>
								<a href="Principal.jsp">Amazing Peruvian Tours</a>
							</h1>
						</li>
					</ul>
					<section class="top-bar-section">
						<ul class="right">
							<li><a href="#">Bienvenido, ${cli.getNombre()} ${cli.getApePater()}</a></li>
							<li class="active"><a href="cerrandoSesion">Cerrar Sesión</a></li>
							<li class="has-dropdown"><a href="#">Servicios</a>
								<ul class="dropdown">
									<li class="active"><a href="Promociones.jsp">Promociones</a></li>
									<li><a href="Destinos.jsp">Destinos</a></li>
									<li><a href="LaEmpresa.jsp">La Empresa</a></li>
								</ul></li>
						</ul>
						<ul class="left">
							<li><a href="Promociones.jsp">Promociones</a></li>
						</ul>
					</section>
				</nav>
			</div>
		</c:otherwise>
	</c:choose> 
	<script>
		$(document).foundation();
	</script>
</body>
</html>