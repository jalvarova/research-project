<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Panel Reportes</title>
	<link rel ="stylesheet" type="text/css" href="foundation/css/dataTables.foundation.css"/>
	<link type="text/css" rel="stylesheet"	href="foundation/css/foundation.css">
	<script src="foundation/js/vendor/modernizr.js"></script>
	<script src="foundation/js/foundation.min.js"></script>
	<script src="foundation/js/foundation/dataTables.foundation.js" type="text/javascript" ></script> 
	<script src="foundation/js/foundation/dataTables.foundation.min.js" type="text/javascript" ></script> 
	<script src="foundation/js/vendor/jquery.js"></script>
	<script src="JS/scriptReportes.js" type="text/javascript"></script>
	<script src="JS/jquery-datatable.js" type="text/javascript"></script>
</head>
<body class="cuerpoFondo">
	<jsp:include page="Menu.jsp"></jsp:include>
	<div id="contenedor">
		<form action="" method="post">
			<div class="row">
				<div class="large-8 large-centered columns">
					<div class="row">
						<fieldset>
							<legend>Reportes</legend>
								<div class="row"> 
									<div class="large-12 large-centered columns">
										<div class="large-8 large-centered columns">
											<select name="cboReporte" id="cboReporte">
												<option value="Seleccione">Seleccione</option>
												<option value="Reporte de clientes próximos">Reporte de clientes próximos</option>
												<option value="Reporte de viajes programados">Reporte de viajes programados</option>
												<option value="Reporte de recorrido de buses">Reporte de recorrido de buses</option>
												<option value="Reporte empleados con viaje programado">Reporte empleados con viaje programado</option>
												<option value="Reporte de asientos por bus">Reporte de asientos por bus</option>
											</select>
										</div>
									</div>
								</div>
						</fieldset>
					</div>
				</div>
				<div class="large-9 large-centered columns">
					<div class="row">
						<display:table name="${sessionScope.listadoProximos}" export="false"
										defaultorder="descending" id="reporteClientes" class="table table-bordered table-hover">
							<display:column title="Nombre" property="cliente.nombre"/>
							<display:column title="Apellido P." property="cliente.apePater"/>
							<display:column title="Apellido M." property="cliente.apeMater"/>
							<display:column title="Ciudad Origen" property="recurso.ruta.ciudadOrigen.nomCiudad"/>
							<display:column title="Ciudad Destino" property="recurso.ruta.ciudadDestino.nomCiudad"/>
							<display:column title="Fecha" property="fechaViaje"/>
						</display:table>
					</div>
				</div>
				<div class="large-9 large-centered columns">
					<div class="row">
						<display:table name="${sessionScope.listadoProximos}" export="false"
										defaultorder="descending" id="reporteViajes" class="table table-bordered table-hover">
							<display:column title="Bus" property="recurso.bus.nroPlaca"/>
							<display:column title="Ciudad Origen" property="recurso.ruta.ciudadOrigen"/>
							<display:column title="Ciudad Destino" property="recurso.ruta.ciudadDestino"/>
							<display:column title="Fecha" property="fechaViaje"/>
							<display:column title="Hora de Salida" property="recurso.ruta.horaSalida"/>
						</display:table>
					</div>
				</div>
				<div class="large-9 large-centered columns">
					<div class="row">
						<display:table name="${sessionScope.listadoAnteriores}" export="false"
										defaultorder="descending" id="reporteRecorrido" class="table table-bordered table-hover">
							<display:column title="Bus" property="recurso.bus.nroPlaca"/>
							<display:column title="Ciudad Origen" property="recurso.ruta.ciudadOrigen"/>
							<display:column title="Ciudad Destino" property="recurso.ruta.ciudadDestino"/>
							<display:column title="Fecha" property="fechaViaje"/>
						</display:table>
					</div>
				</div>
				<div class="large-9 large-centered columns">
					<div class="row">
						<display:table name="${sessionScope.listadoProximos}" export="false"
										defaultorder="descending" id="reporteEmpleados" class="table table-bordered table-hover">
							<display:column title="Nombre Chofer" property="recurso.chofer.nombre"/>
							<display:column title="Apellido Chofer" property="recurso.chofer.apePater"/>
							<display:column title="Nombre Terramoza" property="recurso.terramoza.nombre"/>
							<display:column title="Apellido Terramoza" property="recurso.terramoza.apePater"/>
							<display:column title="Fecha" property="fechaViaje"/>
							<display:column title="Hora de Salida" property="recurso.ruta.horaSalida"/>
						</display:table>
					</div>
				</div>
				<div class="large-9 large-centered columns">
					<div class="row">
						<display:table name="${sessionScope.listadoProximos}" export="false"
										defaultorder="descending" id="reporteAsientos" class="table table-bordered table-hover">
							<display:column title="Bus" property="recurso.bus.nroPlaca"/>
							<display:column title="Tipo bus" property="recurso.bus.tipServi.nombreTipoServicio"/>
							<display:column title="Asiento" property="nroAsiento"/>
							<display:column title="Costo" property="precioSol"/>
							<display:column title="Cliente" property="idPasajero"/>
						</display:table>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script>
		$(document).foundation();
	</script>
</body>
</html>