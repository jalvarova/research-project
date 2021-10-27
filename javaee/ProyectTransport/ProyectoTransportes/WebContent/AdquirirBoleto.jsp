<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="WEB-INF/libreria.tld" prefix="libreria"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.libreria.com/miTLD" prefix="mt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Somos tu mejor opción</title>
<link type="text/css" rel="stylesheet" href="foundation/css/foundation.css">
<link type="text/css" rel="stylesheet" href="CSS/EstilosPrincipal.css">
<script src="foundation/js/vendor/modernizr.js"></script>
<script src="foundation/js/vendor/jquery.js"></script>
<script src="foundation/js/foundation.min.js"></script>
<script type="text/javascript" src="JS/scriptTransacciones.js"></script>
</head>
<body>
	<jsp:include page="MenuCliente.jsp"></jsp:include>
	<div class="row fullWidth">
		<div class="large-5 columns">
			<form action="ProcesarBoleto" method="post" class="panel">
				<div class="row">
					<div class="large-6 columns">
						<div id="piso1"
							class="large-12 large-centered columns pisos piso1">
							<div class="row">
								<div class="large-8 large-centered columns">
									<h3 class="tituloPisos">Piso 1</h3>
								</div>
							</div>
							<div class="row">
								<div class="large-9 large-centered columns">
									<table class="tablaAsientos">
										<c:forEach var="i" begin="1" end="12" step="3">
											<tr>
												<c:forEach var="j" begin="1" end="3">
													<c:if test="${j %3== 0 }">
														<td class="aVacio"></td>
													</c:if>
													<c:choose>
														<c:when	test="${mt:contains(sessionScope.lstAsientosOcupados,(i+j)-1)||mt:tieneAsientosOcupados(sessionScope.carrito,(i+j)-1)}">
															<td title="Ocupado" class="asientoOcupado">
															<c:out value="${(i+j)-1}"></c:out></td>
														</c:when>
														<c:otherwise>
															<td title="Asiento ${(i+j)-1}" class="asientoLibre">
																<c:out value="${(i+j)-1}"></c:out>
															</td>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>
					<div class="large-6 columns">
						<div id="piso2"
							class="large-12 large-centered columns pisos piso2">
							<div class="row">
								<div class="large-8 large-centered columns">
									<h3 class="tituloPisos">Piso 2</h3>
								</div>
							</div>
							<div class="row">
								<div class="large-9 large-centered columns">
									<table class="tablaAsientos">
										<c:forEach var="i" begin="13" end="36" step="3">
											<tr>
												<c:forEach var="j" begin="1" end="3">
													<%-- <c:forEach var="elemento" items="${sessionScope.lstAsientosOcupados}">
															</c:forEach> --%>
													<c:if test="${j %3== 0 }">
														<td class="aVacio"></td>
													</c:if>
													<c:choose>
														<c:when
															test="${mt:contains(sessionScope.lstAsientosOcupados,(i+j)-1)||mt:tieneAsientosOcupados(sessionScope.carrito,(i+j)-1)}">
															<td title="Ocupado" class="asientoOcupado"><c:out
																	value="${(i+j)-1}"></c:out></td>
														</c:when>
														<c:otherwise>
															<td title="Asiento ${(i+j)-1}" class="asientoLibre">
																<c:out value="${(i+j)-1}"></c:out>
															</td>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="large-7 columns">
			<div id="pnlPasajero" class="panel">
				<div class="row">
					<div class="large-10 large-centered columns">
						<form action="ProcesarBoleto" method="post" name="frmPasajero" id="frmPasajero">
							<fieldset>
								<legend>Datos de Pasajero</legend>
								<div class="row">
									<div class="large-6 columns">
										<label>Tipo de Documento<span class="obligatorio">
												* </span></label>
										<libreria:combodocumento />
									</div>
									<div class="large-6 columns">
										<label>Nro. Documento<span class="obligatorio">* </span></label> 
										<input type="text" name="txtNroDoc" id="txtNroDoc"
											placeholder="Nro. Doc." required="required">
									</div>
								</div>
								<div class="row">
									<div class="large-4 columns">
										<label>Nombres<span class="obligatorio"> * </span></label> <input
											type="text" name="txtNombre" id="txtNombre"
											placeholder="Nombre" required="required">
									</div>
									<div class="large-4 columns">
										<label>A. Paterno<span class="obligatorio"> * </span></label>
										<input type="text" name="txtApePat" id="txtApePat"
											placeholder="A. Paterno" required="required">
									</div>
									<div class="large-4 columns">
										<label>A. Materno<span class="obligatorio"> * </span></label>
										<input type="text" name="txtApeMat" id="txtApeMat"
											placeholder="A. Materno" required="required">
									</div>
								</div>
								<div class="row">
									<div class="large-4 columns">
										<label>Email<span class="obligatorio"> * </span></label> <input
											type="text" name="txtEmail" id="txtEmail" placeholder="Email"
											required="required">
									</div>
									<div class="large-4 columns">
										<label>Telefono Fijo</label> <input type="text"
											name="txtTelFijo" id="txtTelFijo" placeholder="Telefono Fijo">
									</div>
									<div class="large-4 columns">
										<label>Telefono Movil<span class="obligatorio">
												* </span></label> <input type="text" name="txtTelMovil" id="txtTelMovil"
											placeholder="Telefono Movil" required="required">
									</div>
								</div>
								<div class="row">
									<div class="large-12 columns">
										<p>
											(<span class="obligatorio">*</span>) Datos obligatorios.
										</p>
									</div>
								</div>
								<div class="row">
									<div class="large-8 columns">
										<p>
											Tarifa Base S/ <span id="preSol">${sessionScope.precioBase}</span>
											/ $ <span id="preDolar">${sessionScope.precioBase/2.5}</span>
										</p>
									</div>
								</div>
								<div class="row">
									<div class="large-7 columns">
										<div class="row">
											<div class="large-4 columns">
												<label class="total">Total S/ : </label>
											</div>
											<div class="large-4 columns left">
												<input type="text" name="txtPrecioSol" id="txtPrecioSol"
													value="" readonly="readonly">

											</div>
											<div class="large-4 columns">
												<input type="text" readonly="readonly" id="txtAsiento" name="txtAsiento">
											</div>
										</div>
										<div class="row">
											<div class="large-4 columns">
												<label class="total">Total $ :</label>
											</div>
											<div class="large-4 columns left">
												<input type="text" name="txtPrecioDolar" id="txtPrecioDolar"
													value="" readonly="readonly">
											</div>
										</div>
									</div>
									<div class="large-3 columns">
										<button name="btnContinuar" id="btnContinuar">Continuar</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${fn:length(sessionScope.carrito)>0}">
		<div class="row" id="datosBoleto">
			<div class="large-12 columns">
				<jsp:include page="DetallePasajero.jsp"></jsp:include>
			</div>
		</div>
	</c:if>
	
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