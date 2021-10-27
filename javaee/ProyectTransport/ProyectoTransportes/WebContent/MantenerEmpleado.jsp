<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/libreria.tld" prefix="libreria"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Mantener Empleado</title>
	<link rel="stylesheet" type="text/css" href="foundation/css/dataTables.foundation.css" />
	<link type="text/css" rel="stylesheet" href="foundation/css/foundation.css">
	<script src="foundation/js/vendor/modernizr.js"></script>
	<script src="foundation/js/foundation.min.js"></script>
	<script src="foundation/js/foundation/dataTables.foundation.js"	type="text/javascript"></script>
	<script src="foundation/js/foundation/dataTables.foundation.min.js"	type="text/javascript"></script>
	<script src="foundation/js/vendor/jquery.js"></script>
	<!-- date picker -->
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
	<!-- date picker -->
	<script>
		$(document).ready(function() {
			var hoy = new Date();
			$("#datepicker").datepicker({
				maxDate: hoy,
				dateFormat: "yy/mm/dd" 
			});
		});
	</script>
	<script src="JS/scriptEmpleados.js" type="text/javascript"></script>
	<script src="JS/jquery-datatable.js" type="text/javascript"></script>
</head>
<body class="cuerpoFondo">
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="row fullWidth">
		<div class="large-5 columns">
			<form action="ProcesarEmpleado" method="post" enctype="multipart/form-data">
				<fieldset>
					<legend>Mantenimiento de Empleados</legend>
					<div class="row">
						<div class="large-5 large-centered columns">
							<select name="cboTipo" id="cboTipo" value="}">
								<option value="Seleccione"
									${param.tipo == 'Seleccione' ? 'selected' : ''}>Seleccione</option>
								<option value="Chofer"
									${param.tipo == 'Chofer' ? 'selected' : ''}>Chofer</option>
								<option value="Terramoza"
									${param.tipo == 'Terramoza' ? 'selected' : ''}>Terramoza</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="large-6 columns">
							<label id="lblCodigoC">Código</label> <input type="text"
								id="txtCodigoC" name="txtCodigoC" size="20" maxlength="20"
								placeholder="Código" required="required"
								value="${param.codigoC}" readonly="readonly">
						</div>
						<div class="large-6 columns">
							<label id="lblCodigoT">Código</label> <input type="text"
								id="txtCodigoT" name="txtCodigoT" size="20" maxlength="20"
								placeholder="Código" required="required"
								value="${param.codigoT}" readonly="readonly">
						</div>
						<div class="large-6 columns">
							<label>Ciudad</label>
							<libreria:combociudad />
						</div>
					</div>
					<div class="row">
						<div class="large-4 columns">
							<label>Nombre</label> <input type="text" id="txtNombre"
								name="txtNombre" size="20" maxlength="20" placeholder="Nombre"
								required="required" value="${param.nombre}">
						</div>
						<div class="large-4 columns">
							<label>Apellido Paterno</label> <input type="text"
								id="txtApellidoP" name="txtApellidoP" size="20" maxlength="20"
								placeholder="Apellido Paterno" required="required"
								value="${param.apePater}">
						</div>
						<div class="large-4 columns">
							<label>Apellido Materno</label> <input type="text"
								id="txtApellidoM" name="txtApellidoM" size="20" maxlength="20"
								placeholder="Apellido Materno" required="required"
								value="${param.apeMater}">
						</div>
					</div>
					<div class="row">
						<div class="large-4 columns">
							<label>Tipo Documento</label>
							<libreria:combodocumento />
						</div>
						<div class="large-4 columns">
							<label>Número Documento</label> <input type="text" id="txtNroDoc"
								name="txtNroDoc" size="20" maxlength="11"
								placeholder="Nro Documento" required="required"
								value="${param.nroDoc}">
						</div>
						<div class="large-4 columns">
							<label>Sexo</label> <select name="cboSexo" id="cboSexo">
								<option>M</option>
								<option>F</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="large-4 columns">
							<label>Fecha Nacimiento</label> <input type="text"
								id="datepicker" name="txtFechaNac" size="20" maxlength="11"
								value="${param.fechaNac}">
						</div>
						<div class="large-4 columns">
							<label>Email</label> <input type="text" id="txtEmail"
								name="txtEmail" size="20" maxlength="40" placeholder="Email"
								value="${param.email}">
						</div>
						<div class="large-4 columns">
							<label>Teléfono</label> <input type="text" id="txtTelefono"
								name="txtTelefono" size="20" maxlength="9"
								placeholder="Telefono" value="${param.tel}">
						</div>
					</div>
					<div class="row">
						<div class="large-4 columns" id="licencia">
							<label>Número Licencia</label> <input type="text"
								id="txtNroLicen" name="txtNroLicen" size="20" maxlength="11"
								placeholder="Nro Licencia" value="${param.licencia}"><br>
						</div>
						<div class="large-8 columns">
							<label>Foto</label> <input type="file" name="imgFoto">
						</div>
					</div>
					<div class="row">
						<img alt="" src="${param.imgFoto}">
					</div>
					<div class="row">
						<div class="large-6 large-centered columns">
							<p class="centered">
								<%
									String mensaje = (String) request.getAttribute("Mensaje");
									if (mensaje != null)
										out.println(mensaje);
								%>
							</p>
						</div>
						<div class="large-12 large-centered columns">
							<ul class="centered button-group even-3">
								<li><input type="submit" value="Registrar"
									name="btnProcesar" class="small button"></li>
								<li><input type="submit" value="Actualizar"
									name="btnProcesar" class="small button"></li>
								<li><input type="reset" value="Limpiar" name="btnLimpiar"
									class="small button"></li>
							</ul>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="large-7 columns">
			<div class="row">
				<div class="large-12 columns">
					<display:table name="${sessionScope.lstTerra}" export="false"
						defaultorder="descending" id="tablaTerramoza"
						class="table table-bordered table-hover"
						decorator="decorator.Wrapper">
						<display:column title="Codigo" property="codigo"></display:column>
						<display:column title="Nombre" property="nombre"></display:column>
						<display:column title="A.Paterno" property="apePater"></display:column>
						<display:column title="A.Materno" property="apeMater"></display:column>
						<display:column title="Telefono" property="telefono"></display:column>
						<display:column title="Ciudad" property="ciudad"></display:column>
						<display:column title="Eliminar" property="eliminarTerramoza"></display:column>
						<display:column property="seleccionarTerramoza"></display:column>
					</display:table>
				</div>
			</div>
			<div class="row">
				<display:table name="${sessionScope.lstChofer}" export="false"
					defaultorder="descending" id="tablaChofer"
					class="table table-bordered table-hover"
					decorator="decorator.Wrapper">
					<display:column title="Codigo" property="codigo"></display:column>
					<display:column title="Nombre" property="nombre"></display:column>
					<display:column title="A.Paterno" property="apePater"></display:column>
					<display:column title="A.Materno" property="apeMater"></display:column>
					<display:column title="Telefono" property="telefono"></display:column>
					<display:column title="Ciudad" property="ciudad"></display:column>
					<display:column title="Eliminar" property="eliminarChofer"></display:column>
					<display:column property="seleccionarChofer"></display:column>
				</display:table>
			</div>
		</div>
	</div>
	<jsp:include page="Pie.jsp"></jsp:include>
	<script>
		$(document).foundation();
	</script>
</body>
</html>