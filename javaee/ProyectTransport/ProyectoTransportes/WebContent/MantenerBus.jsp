<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Mantener Bus</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link type="text/css" rel="stylesheet"	href="foundation/css/foundation.css">
	<link rel="stylesheet" type="text/css"	href="foundation/css/dataTables.foundation.css" />
	<script type="text/javascript" src="JS/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="JS/jquery.maskedinput.js"></script>
	<script src="foundation/js/foundation/dataTables.foundation.js"	type="text/javascript"></script>
	<script src="foundation/js/foundation/dataTables.foundation.min.js"	type="text/javascript"></script>
	<script src="JS/scriptBus.js" type="text/javascript"></script>
	<script src="JS/jquery-datatable.js" type="text/javascript"></script>
</head>
<body class="cuerpoFondo">
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="row">
		<div class="large-5 columns">
			<form action="ProcesarBus"   method="post" enctype="multipart/form-data">
				<fieldset>
					<legend>Mantenimiento de Buses</legend>
					<div class="row">
						<div class="large-6 columns">
							<label>Tipo de Bus</label> <select name="cboTipoBus">
								<option value="N">Normal</option>
								<option value="V">VIP</option>
								<option value="P">Premier</option>
							</select>
						</div>
						<div class="large-6 columns">
							<label>Número de Placa </label> <input type="text"
								name="txtNumeroPlaca" class="gui-input"
								placeholder="Ingrese Placa" maxlength="7" value="${param.placa}" required>
						</div>
					</div>
					<div class="row">
						<div class="large-6 columns">
							<label class="field-label">Año de Fabricación</label> <label
								class="field"> <input type="text"
								name="txtAnioFabricacion" class="gui-input"
								PlaceHolder="Ingrese Año" maxlength="4" value="${param.fabri}" required>
							</label>
						</div>
						<div class="large-6 columns">
							<label>Marca</label> <input type="text" name="txtMarca"
								class="gui-input" placeholder="Ingrese Marca" value="${param.marca}" required>
						</div>
					</div>
					<div class="row">
						<div class="large-4 columns">
							<label>Nro. Asientos</label> <input type="text"
								name="txtNumAsientos" class="gui-input" maxlength="2" value="${param.asientos}" required>
						</div>
						<div class="large-8 columns">
							<label>Foto</label> <label for="file1"> <input
								type="file" name="upload1" required>
							</label>
						</div>
					</div>
					<div class="row">
						<img alt="" src="${param.imgFoto}">
					</div>
					<div class="row">
						<div class="large-6 large-centered columns">
							<p class="centered">
								<%
									String mensaje = (String) request.getAttribute("msj");
									if (mensaje != null){
										out.println(mensaje);
									}
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
									type="reset" value="Limpiar"></li>
							</ul>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="large-7 columns">
			<div class="row">
				<div class="large-12 columns">
					<display:table name="${sessionScope.listaBus}" export="true"
						defaultorder="descending" id="tablaBus"
						class="table table-bordered table-hover"
						decorator="decorator.Wrapper">
						<display:column title="Placa" property="nroPlaca"></display:column>
						<display:column title="Año Fabricacion" property="anioFabricacion"></display:column>
						<display:column title="Marca" property="marca"></display:column>
						<display:column title="Asientos" property="numAsientos"></display:column>
						<display:column title="Tipo Servicio" property="tipServi.nombreTipoServicio"></display:column>
						<display:column title="Estado" property="estado"></display:column>
						<display:column title="Eliminar" property="eliminarBus"></display:column>
						<display:column property="seleccionarBus"></display:column>
					</display:table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="Pie.jsp"></jsp:include>
</body>
</html>