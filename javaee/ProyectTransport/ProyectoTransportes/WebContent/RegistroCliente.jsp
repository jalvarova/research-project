<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/libreria.tld" prefix="libreria"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registro de Cliente</title>
	<link type="text/css" rel="stylesheet"	href="foundation/css/foundation.css">
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
</head>
<body>
		<jsp:include page="MenuCliente.jsp"></jsp:include>
			<div class="row fullWidth">
				<div class="large-6 large-centered columns">
				<form action="RegistroCliente" method="post" enctype="multipart/form-data">
					<fieldset>
						<legend>Formulario de Registro</legend>
						<div class="row">
							<div class="large-4 columns">
								<label>Usuario:</label> <input type="text" name="txtUsuario"
									size="20" maxlength="20" placeholder="Usuario" required>
							</div>
							<div class="large-4 columns">
								<label>Contraseña:</label> <input type="password"
									name="txtClave" size="20" maxlength="20"
									placeholder="Contraseña" required>
							</div>
							<div class="large-4 columns">
								<label>Confirmar contraseña:</label> <input type="password"
									name="txtClave2" size="20" maxlength="20"
									placeholder="Confirmar contraseña" required>
							</div>
						</div>
						<div class="row">
							<div class="large-4 columns">
								<label>Nombre:</label> <input type="text" name="txtNombre"
									size="20" maxlength="20" placeholder="Nombre" required>
							</div>
							<div class="large-4 columns">
								<label>Apellido P.:</label> <input type="text"
									name="txtApellidoP" size="20" maxlength="20"
									placeholder="Apellido Paterno" required>
							</div>
							<div class="large-4 columns">
								<label>Apellido M.:</label> <input type="text"
									name="txtApellidoM" size="20" maxlength="20"
									placeholder="Apellido Materno" required>
							</div>
						</div>
						<div class="row">
							<div class="large-4 columns">
								<label>Tipo Documento</label>
								<libreria:combodocumento />
							</div>
							<div class="large-4 columns">
								<label>Nro Documento:</label> <input type="text"
									name="txtNroDoc" size="20"  maxlength="11"
									placeholder="Número de Documento" required>
							</div>
							<div class="large-4 columns">
								<label>Sexo:</label> <select name="cboSexo" required>
									<option>M</option>
									<option>F</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="large-4 columns">
								<label>Email:</label> <input type="text" name="txtEmail"
									size="20" maxlength="40" placeholder="Email" required>
							</div>
							<div class="large-4 columns">
								<label>Telefono:</label> <input type="text" name="txtTelefono"
									size="20" maxlength="9" placeholder="Telefono" required>
							</div>
							<div class="large-4 columns">
								<label>Ciudad:</label>
								<libreria:combociudad />
							</div>
						</div>
						<div class="row">
							<div class="large-4 columns">
								<label>Fecha de Nacimiento:</label> <input type="text"
									id="datepicker" name="txtFechaNac" size="20" maxlength="11">
							</div>
							<div class="large-8 columns">
								<label>Foto</label> <input type="file" name="imgFoto">
							</div>
						</div>
						<div class="row">
							<div class="large-7 large-centered columns">
								<p ><c:out value="${requestScope.msj }"></c:out>
							</div>
							<div class="large-10 large-centered columns">
								<ul class="centered button-group even-4">
									<li><input type="submit" value="Registrar"
										name="btnProcesar" class="small button"></li>
								</ul>
							</div>
						</div>

					</fieldset>
				</form>
				</div>
			</div>	
			<jsp:include page="Pie.jsp"></jsp:include>
	<script>
		$(document).foundation();
	</script>
</body>
</html>