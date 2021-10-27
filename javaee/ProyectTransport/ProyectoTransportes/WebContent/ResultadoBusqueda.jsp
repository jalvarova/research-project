<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultado</title>
<link type="text/css" rel="stylesheet"
	href="foundation/css/foundation.css">
<link type="text/css" rel="stylesheet" href="CSS/EstilosPrincipal.css">
<script src="foundation/js/vendor/modernizr.js"></script>
<script src="foundation/js/vendor/jquery.js"></script>
<script src="foundation/js/foundation.min.js"></script>
</head>
<body>
<jsp:include page="MenuCliente.jsp"></jsp:include>
	<div class="row">
		<div id="resultados" class="large-12 large-centered columns">
			<fieldset>
				<legend>Resultados</legend>

				<h5>
					Para la fecha : <input id="txtFechaViaje" name="txtFechaViaje"
						type="text" readonly="readonly" value="${sessionScope.fecha }" />
				</h5>
				<hr />
				<div id="filaResultado" class="row">
					<div class="large-12 columns">
						<h6><c:out value="SERVICIO - ${sessionScope.recurso.bus.tipServi.nombreTipoServicio}"></c:out> </p></h6>
						<div class="large-3 columns">
							<img alt="" src="">
						</div>
						<div id="descripcion" class="large-6 columns">
							<p> <c:out value="${sessionScope.recurso.bus.tipServi.descripcion}"></c:out> </p>
						</div>
						<div id="datosViaje" class="large-3 columns">
							<form name="datosViaje" action="GenerarAsientos" method="post">
								<table>
									<tr>
										<td><label>Salida</label></td>
										<td><input type="text" name="txtSalida"
											readonly="readonly" value="${requestScope.horaSalida}"></td>
									</tr>
									<tr>
										<td><label>Precio S/.</label></td>
										<td><input type="text" name="txtPrecio"
											readonly="readonly" value="${requestScope.precio}"></td>
									</tr>
									<tr>
										<td><label>Asientos Libres</label></td>
										<td><input type="text" name="txtAsientosL"
											readonly="readonly" value="${requestScope.asientosLibres}"></td>
									</tr>
									<tr>
										<td colspan="2"><input class="small button" type="submit"
											value="Seleccionar" name="btnSeleccionar"></td>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
			</fieldset>
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
	<script>
		$(document).foundation();
	</script>
</body>
</html>