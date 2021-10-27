<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  -->
	<title>Edición de Perfil</title>
	<link type="text/css" rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body class="cuerpoFondo">

		<jsp:include page="MenuCliente.jsp"></jsp:include>
		<div class="row fullWidth">
		<div class="large-6 large-centered columns">
			
				<form class="form" action="" method="post">
					<fieldset>
						<legend>Editar Perfil</legend>
					
					<h2></h2>					<hr>
					<div class="row">
						<div class="large-4 columns">
							<label>Nombre <input type="text" name="txtNombre"
								id="txtNombre" placeholder="Nombre" required="required">
							</label>
						</div>
						<div class="large-4 columns">
							<label>A. Paterno</label> <input type="text" name="txtApePaterno"
								id="txtApePaterno" placeholder="Apellido Paterno"
								required="required">
						</div>
						<div class="large-4 columns">
							<label>A. Materno</label> <input type="text" name="txtApeMaterno"
								id="txtApeMaterno" placeholder="Apellido Materno">
						</div>
					</div>
					<div class="row">
						<div class="large-6 columns">
							<label>Tipo Documento</label> <select>
								<option>Seleccione</option>
							</select>
						</div>
						<div class="large-6 columns">
							<label class="">Nro Documento</label> <input type="text"
								name="txtNroDoc" id="txtNroDoc" placeholder="Nro Documento"
								required="required">
						</div>
					</div>
					<div class="row">
						<div class="large-12 columns">
							<label>Sexo</label>
						</div>
						<div class="large-6 columns">
							<input type="radio" id="rdSexo" name="rdSexo" value="M"
								required="required"> Masculino
						</div>
						<div class="large-6 columns">
							<input type="radio" id="rdSexo" name="rdSexo" value="F">
							Femenino<br>
						</div>
					</div>
					<div class="row">
						<div class="large-6 columns">
							<label>Telefono</label> <input type="tel" name="txtTelefono"
								id="txtTelefono" placeholder="Ingrese telefono">
						</div>
						<div class="large-6 columns">
							<label>Ciudad</label> <select>
								<option>Seleccione</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="large-12 columns">
							<label>Email</label> <input type="email" name="txtEmail"
								id="txtEmail" placeholder="Correo electronico"
								required="required">
						</div>
					</div>
					<div class="row">
						<div class="large-12 columns">
							<div class="large-6 large-push-2 columns">
								<input type="submit" name="btnGuardar" id="btnGuardar"
									value="Guardar" class="radius button">
							</div>
							<div class="large-6 columns">
								<input type="reset" name="btnCancelar" id="btnCancelar"
									value="Cancelar" class="radius button ">
							</div>
						</div>
					</div>
				</fieldset>
				</form>
			</div>
		</div>
		
	<div class="row fullWidth">
		<div class="large-12 text-center">
			<footer>
				<div class="top-bar">
					<h5>Amazing Peruvian Tours &copy; Todos los derechos reservados</h5>
				</div>
			</footer>
		</div>
	</div>
</body>
</html>