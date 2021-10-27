<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="WEB-INF/libreria.tld" prefix= "libreria" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Mantener Servicio</title>
	<link rel="stylesheet" type="text/css" href="foundation/css/dataTables.foundation.css" />
	<link type="text/css" rel="stylesheet"	href="foundation/css/foundation.css">
	<script src="foundation/js/vendor/modernizr.js"></script>
	<script src="foundation/js/foundation.min.js"></script>
	<script src="foundation/js/vendor/jquery.js"></script>
	<script src="foundation/js/foundation/dataTables.foundation.js"	type="text/javascript"></script>
	<script src="foundation/js/foundation/dataTables.foundation.min.js"	type="text/javascript"></script>
	<script src="JS/ScriptMantenerServicio.js" type="text/javascript"></script>
	<script src="JS/jquery-datatable.js" type="text/javascript"></script>
</head>
<body class="cuerpoFondo">
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="row">
		<div class="large-5 columns">
			<form class="form" action="ProcesarRecursos" method="post">
				<fieldset>
					<legend>Mantenimiento de Recursos</legend>
					<div class="row">
						<div class="large-6 columns">
							<label>Codigo</label> <input type="text" maxlength="10" name="txtCodigoR"
								required="required" value="${param.codServicio}"
								readonly="readonly">
						</div>
						<div class="large-6 columns">
							<label>Bus</label>
							<libreria:combobus/>
						</div>
					</div>
					<div class="row">
						<div class="large-6 columns">
							<label>Chofer</label> 
							<libreria:combochofer/>
						</div>
						<div class="large-6 columns">
							<label>Ruta</label> 
							<libreria:comboruta/>
						</div>
					</div>
					<div class="row">
						<div class="large-6 columns">
							<label>Terramoza</label> 
							<libreria:comboterramoza/>
						</div>
						<div class="large-6 columns">
							<label>Estado</label> 
							<select name="cboEstadoR">
								<option value="0">Activo</option>
								<option value="1">Inactivo</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="large-8 large-centered columns">
							<p>${requestScope.mensaje}</p>
						</div>
						<div class="large-12 large-centered columns">
							<ul class="centered button-group even-3">
								<li><input class="small button" id="btnRegistrar"
									type="submit" name="btnProcesar" value="Registrar"></li>
								<li><input class="small button" id="btnActualizar"
									type="submit" name="btnProcesar" value="Actualizar">
								</li>								
								<li><input  class="small button" id="btnLimpiar"
									type="reset" name="btnLimpiar" value="Limpiar"></li>
							</ul>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="large-7 columns">
			<div class="row">
				<div class="large-12 columns">
					<display:table name="${requestScope.listaRecursos}" defaultorder="descending" id="tablaRecursos"
						class="table table-bordered table-hover" decorator="decorator.Wrapper">
						<display:column title="Codigo" property="codRecurso"></display:column>
						<display:column title="Chofer" property="chofer.nombreCompleto"></display:column>
						<display:column title="Terramoza" property="terramoza.nombreCompleto"></display:column>
						<display:column title="Bus" property="bus.nroPlaca"></display:column>
						<display:column title="Ruta" property="ruta.codRuta"></display:column>
						<display:column title="Origen" property="ruta.ciudadOrigen.nomCiudad"></display:column>
						<display:column title="Destino"	property="ruta.ciudadDestino.nomCiudad"></display:column>
						<display:column title="Eliminar" property="eliminarServicio"></display:column>
						<display:column title="Recurso" property="seleccionarRecurso"></display:column>
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