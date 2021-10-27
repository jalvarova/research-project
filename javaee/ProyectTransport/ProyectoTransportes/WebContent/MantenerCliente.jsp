<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/libreria.tld" prefix="libreria"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Mantener Cliente</title>
	<link rel="stylesheet" type="text/css" href="foundation/css/dataTables.foundation.css" />
	<link type="text/css" rel="stylesheet"	href="foundation/css/foundation.css">
	<script src="foundation/js/vendor/modernizr.js"></script>
	<script src="foundation/js/foundation.min.js"></script>
	<script src="foundation/js/foundation/dataTables.foundation.js"	type="text/javascript"></script>
	<script src="foundation/js/foundation/dataTables.foundation.min.js"	type="text/javascript"></script>
	<script src="foundation/js/vendor/jquery.js"></script>
	<!-- date picker -->
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
	<script src="JS/scriptClientes.js" type="text/javascript"></script>
	<script src="JS/jquery-datatable.js" type="text/javascript"></script>
	<script src="JS/validaciones.js" type="text/javascript"></script>
</head>
<body class="cuerpoFondo">
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="row fullWidth">
		<div class="large-5 columns">
			<form action="ProcesarCliente" method="post" enctype="multipart/form-data">
				<fieldset>
					<legend>Mantenimiento de Clientes</legend>
					<div class="row">
						<div class="large-4 columns">
							<label>Nombre</label> <input type="Text" name="nombre"
								value="${param.nom}" maxlength="18" required="required"
								placeholder="Ingrese nombre"
								onkeypress="return soloLetra(event)">
						</div>
						<div class="large-4 columns">
							<label>Apellido Paterno</label> <input type="text"
								name="apellido_paterno" value="${param.apep}" maxlength="50"
								required="required" placeholder="Ingrese apellido"
								onkeypress="return soloLetra(event)">
						</div>
						<div class="large-4 columns">
							<label>Apellido Materno</label> <input type="text"
								name="apellido_materno" value="${param.apem}" maxlength="50"
								required="required" placeholder="Ingrese apellido"
								onkeypress="return soloLetra(event)">
						</div>
					</div>
					<div class="row">
						<div class="large-4 columns">
							<label>Codigo</label> <input name="codigo" type="Text"
								maxlength="5" required="required" placeholder="Ingrese codigo"
								value="${param.cod}" onkeypress="return soloNumLetras(event)"
								readonly="readonly">
						</div>
						<div class="large-4 columns">
							<label>Usuario </label> <input name="usuario" type="Text"
								value="${param.usuario}" maxlength="18"
								placeholder="Ingrese usuario"
								onkeypress="return soloNumLetras(event)">
						</div>
						<div class="large-4 columns">
							<label>Contraseña</label> <input name="contraseña"
								type="password" value="${param.clave}" maxlength="5"
								required="required" placeholder="Ingrese clave"
								onkeypress="return soloNumLetras(event)">
						</div>
					</div>
					<div class="row">
						<div class="large-4 columns">
							<label>F. Nacimiento</label> <input type="text" id="datepicker"
								value="${param.fecha}" name="f_n" required
								placeholder="Ingrese fecha">
						</div>
						<div class="large-4 columns">
							<label>Sexo</label> <select name="sexo">
								<option value="M">Masculino</option>
								<option value="F">Femenino</option>
							</select>
						</div>
						<div class="large-4 columns">
							<label>E-mail</label> <input type="text" name="e-mail"
								value="${param.em}" size="20" maxlength="50" required="required"
								placeholder="Ingrese E-mail" id='id_mail'
								onKeyUp="validarMail('id_mail')">
						</div>
					</div>
					<div class="row">
						<div class="large-4 columns">
							<label>Telefono</label> <input type="text" name="telefono"
								value="${param.tel}" size="9" maxlength="9" required
								placeholder="Ingrese telefono"
								onkeypress="return soloNumero(event)">
						</div>
						<div class="large-4 columns">
							<label>Ciudad</label>
							<libreria:combociudad />
						</div>
						<div class="large-4 columns">
							<label>Tipo Documento</label>
							<libreria:combodocumento />
						</div>
					</div>
					<div class="row">
						<div class="large-4 columns">
							<label>Nro Documento</label> <input type="text"
								name="nro_documento" value="${param.nrodoc}" maxlength="10"
								required="required" placeholder="Ingrese nro documento"
								onkeypress="return soloNumero(event)">
						</div>
						<div class="large-4 columns">
							<label>Estado</label> <select name="estado"
								value="${param.estado}">
								<option value="0">Activo</option>
								<option value="1">Inactivo</option>
							</select>
						</div>
						<div class="large-4 columns">
							<label>Escoger Foto</label> <input type="file" name="ImgFile"
								id="file1">
						</div>
						<div class="row">
							<img alt="" src="${param.imgFoto}">
						</div>
					</div>
					<div class="row">
						<div class="large-6 large-centered columns">
							<p class="centered">
								<%
									String mensaje = (String) request.getAttribute("mensaje");
									if (mensaje != null)
										out.println(mensaje);
								%>
							</p>
						</div>
						<div class="large-12 large-centered columns">
							<ul class="centered button-group even-3">
								<li><input type="submit" class="small button"
									id="btnProcesar" name="btnProcesar" value="Registrar">
								</li>
								<li><input type="submit" class="small button"
									id="btnProcesar" name="btnProcesar" value="Actualizar">
								</li>
								<li><input type="reset" class="small button"
									id="btnLimpiar" name="btnLimpiar" value="Limpiar"></li>
							</ul>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="row">
			<div class="large-6 columns">
				<display:table name="${sessionScope.listacli}" export="true" defaultorder="descending" id="tablaClientes"
					class="table table-bordered table-hover" decorator="decorator.Wrapper">
					<display:column title="Codigo" property="codigo"></display:column>
					<display:column title="Nombre" property="nombre"></display:column>
					<display:column title="A.Paterno" property="apePater"></display:column>
					<display:column title="A.Materno" property="apeMater"></display:column>
					<display:column title="Tipo Doc." property="tipoDocumento"></display:column>
					<display:column title="Nro.Doc" property="nroDocumentoID"></display:column>
					<display:column title="Eliminar" property="eliminarCliente"></display:column> 
					<display:column property="seleccionarCliente"></display:column>
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