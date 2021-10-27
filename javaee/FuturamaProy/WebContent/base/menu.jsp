<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

<link href="css/styles_AreaUsuario.css" rel="stylesheet" type="text/css">
<link href="css/styles_Formularios.css" rel="stylesheet" type="text/css">

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/AreaUsario.js"></script>


</head>
<body>

	<header>
		<nav>
			<img class="logo" src="img/AreaUsuario/Logo_Corhyfar.png" width="106"
				height="128">
			<ul>
				<li class="submenu">
				<a href="#">Marcador<span class="Desplegar">▽</span></a>
					<ul class="children">
						<li><a href="/FuturamaProy/marcador.jsp" target="cuerpo">PostVentas</a></li>


					</ul>
				</li>
				
				<li class="submenu">
				<a href="#">Mantenimiento<span class="Desplegar">▽</span></a>
					<ul class="children">
						<li><a href="/FuturamaProy/MantenerCliente.jsp" target="cuerpo">Cliente</a></li>
						<li><a href="/FuturamaProy/MantenerEmpleado.jsp" target="cuerpo">Empleado</a></li>


					</ul>
				</li>
				
				<li class="submenu">
				<a href="#">Registro de Ventas<span class="Desplegar">▽</span></a>
					<ul class="children">
						<li><a href="/FuturamaProy/registroVentas.jsp" target="cuerpo">Registrar de Ventas</a></li>
						

					</ul>
				</li>
				
				<li class="submenu">
				<a href="#">Generar Contrato<span class="Desplegar">▽</span></a>
					<ul class="children">
						<li><a href="/FuturamaProy/ReporteTicket.jsp" target="cuerpo">Reporte de Ticket de atencion</a></li>
						

					</ul>
				</li>
				
				<li class="submenu">
				<a href="#">Reportes Generales<span class="Desplegar">▽</span></a>
					<ul class="children">
						<li><a href="/FuturamaProy/ReporteVentas.jsp" target="cuerpo">ReporteVentas</a></li>
						<li><a href="/FuturamaProy/ReporteLlamada.jsp" target="cuerpo">Reportes de LLamadas</a></li>
						<li><a href="/FuturamaProy/ReporteVentasxAsesor.jsp" target="cuerpo">Ventas x Asesor</a></li>


					</ul>
				</li>






			</ul>
		</nav>
	</header>

</body>
</html>