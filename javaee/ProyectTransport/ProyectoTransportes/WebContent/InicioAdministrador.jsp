<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Panel Administrador</title>
	<link type="text/css" rel="stylesheet" href="foundation/css/foundation.css">
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
	<script src="foundation/js/vendor/modernizr.js"></script>
	<script src="foundation/js/vendor/jquery.js"></script>
	<script src="foundation/js/foundation.min.js"></script>
</head>
<body class="cuerpoFondo">
	<c:set var="admin" value="${sessionScope.datosconsesion}"></c:set>
	<div id="contenedorPrincipal">
		<jsp:include page="Menu.jsp"></jsp:include> 
	    <div class="row">
			<div class="large-8 columns">
				<ul class="orbit-container" data-orbit
					data-options="animation:fade;animation_speed:30;pause_on_hover:false;">
					<li><img src="Imagenes/logo.png" alt="foto1" />
						<div class="orbit-caption"></div></li>
					<li><img src="Imagenes/fondo2.jpg" alt="foto 2" />
						<div class="orbit-caption"> </div></li>
					<li><img src="Imagenes/fondoContenedor.jpg" alt="foto 3" />
						<div class="orbit-caption"></div></li>
				</ul>
			</div>
			<%HttpSession sesion = request.getSession();
				Date fecha = new Date(sesion.getLastAccessedTime());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
				String fech = sdf.format(fecha);
			%>
			<div class="large-4 columns">
				<fieldset>
					<legend>Bienvenido</legend>
					<p>Usted se ha identificado como: </p>
					<p>${admin.nombre} ${admin.apePater} ${admin.apeMater}</p>
					<p>Perú - ${admin.ciudad}</p>
					<p>DNI: ${admin.nroDocumentoID}</p>			
					<p>La &uacute;ltima vez que ingres&oacute; fue:</p>
					<p></p>
					<p><%=fech%></p>
					<p></p>
				</fieldset>
			</div>
		</div>
	    <jsp:include page="Pie.jsp"></jsp:include>
	</div>
	<script>
		$(document).foundation();
	</script>
</body>
</html>