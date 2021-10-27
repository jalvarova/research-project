<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/libreria.tld" prefix="libreria"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Mantener Ruta</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css"	href="foundation/css/dataTables.foundation.css" />
	<link type="text/css" rel="stylesheet"	href="foundation/css/foundation.css">
	<script src="foundation/js/vendor/modernizr.js"></script>
	<script src="foundation/js/foundation.min.js"></script>
	<script src="foundation/js/foundation/dataTables.foundation.js"	type="text/javascript"></script>
	<script src="foundation/js/foundation/dataTables.foundation.min.js"	type="text/javascript"></script>
	<script src="foundation/js/vendor/jquery.js"></script>
	<script src="JS/scriptRuta.js" type="text/javascript"></script>
	<script src="JS/jquery-datatable.js" type="text/javascript"></script>
</head>
<body class="cuerpoFondo">
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="row">
		<div class="large-6 columns">
			<form action="ProcesarRuta" method="post">
				<fieldset>
					<legend>Mantenimiento de Rutas</legend>
					<div class="row">
						<div class="large-4 columns">
							<label>Código de Ruta</label> <input type="text" name="txtRuta"
								placeholder="Ingrese Código" maxlength="5" required
								value="${param.codRuta}" readonly="readonly">
						</div>
						<div class="large-4 columns">
							<label>Tarifa</label> <input type="text" name="txtTarifa"
								class="gui-input" placeholder="Ingrese Tarifa" maxlength="5"
								required value="${param.tarifa}">

						</div>
						<div class="large-4 columns">
							<label>Hora de Salida</label> <input type="text"
								name="txtHoraSalida" class="gui-input"
								placeholder="Ingrese Hora de Salida" maxlength="5" required
								value="${param.horaSalida}">
						</div>
					</div>
					<div class="row">
						<div class="large-4 columns">
							<label>Ciudad de Origen</label> <select id="cboOrigen"
								name="cboOrigen">
								<option>Seleccione</option>
								<c:forEach items="${requestScope.listaCiudades}" var="ciudad">
									<option value='${ciudad.codciudad}'>${ciudad.nomCiudad}</option>
								</c:forEach>
							</select>
						</div>
						<div class="large-4 columns">
							<label>Ciudad de Destino</label> <select id="cboDestino"
								name="cboDestino">
								<option>Seleccione</option>
								<c:forEach items="${requestScope.listaCiudades}" var="ciudad">
									<option value='${ciudad.codciudad}'>${ciudad.nomCiudad}</option>
								</c:forEach>
							</select>
						</div>
						<div class="large-4 columns">
							<label>Estado</label> <select name="cboEstadoRuta">
								<option value="0">Activa</option>
								<option value="1">Inactiva</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="large-6 large-centered columns">
							<p class="centered">
								<%
									String mensaje = (String) request.getAttribute("msj");
									if (mensaje != null)
										out.println(mensaje);
								%>
							</p>
						</div>
						<div class="large-12 large-centered columns">
							<ul class="centered button-group even-3">
								<li><input class="small button" id="btnProcesar"
									type="submit" name="btnProcesar" value="Registrar"></li>
								<li><input class="small button" id="btnProcesar"
									type="submit" name="btnProcesar" value="Actualizar"></li>
								<li><input class="small button" id="btnLimpiar"
									type="reset" name="btnProcesar" value="Limpiar"></li>
							</ul>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="large-6 columns">
			<div class="row">
				<div class="large-12 columns">
					<display:table name="${sessionScope.listaRuta}" export="false"
						defaultorder="descending" id="tablaRuta"
						class="table table-bordered table-hover"
						decorator="decorator.Wrapper">
						<display:column title="Codigo" property="codRuta"></display:column>
						<display:column title="Origen" property="ciudadOrigen"></display:column>
						<display:column title="Destino" property="ciudadDestino"></display:column>
						<display:column title="H. Salida" property="horaSalida"></display:column>
						<display:column title="Tarifa." property="tarifa"></display:column>
						<display:column title="Estado" property="estado"></display:column>
						<display:column title="Eliminar" property="eliminarRuta"></display:column>
						<display:column property="seleccionarRuta"></display:column>
					</display:table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="Pie.jsp"></jsp:include>
	<script>
		$(document).foundation();
	</script>
</body>
</html>