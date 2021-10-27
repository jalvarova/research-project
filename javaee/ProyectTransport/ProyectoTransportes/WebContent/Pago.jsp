<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmación de Operación</title>
<link type="text/css" rel="stylesheet" href="foundation/css/foundation.css">
<link type="text/css" rel="stylesheet" href="CSS/EstilosPrincipal.css">
<script src="foundation/js/vendor/modernizr.js"></script>
<script src="foundation/js/vendor/jquery.js"></script>
<script src="foundation/js/foundation.min.js"></script>
<script type="text/javascript" src="JS/scriptTransacciones.js"></script>
</head>
<body>
	<jsp:include page="MenuCliente.jsp"></jsp:include>
	<div class="row">
		<div class="large-8 large-centered columns">
			<fieldset>
				<legend>Operación Exitosa:</legend>
					<h3>El monto Total a Pagar es: S/.${requestScope.totalSol}  ($${requestScope.totalDolar })</h3>
					<h5>Su Código de Identificación de Pago (CIP) es : ${requestScope.CIP }</h5>
					<hr>
					<p><b>PAGAR CON PAGOEFECTIVO</b></p>
					<p><b>¿Qué es PagoEfectivo?</b></p>
								<p>PagoEfectivo es una forma fácil y segura de comprar a través de Internet. Es cómodo y efectivo pues no necesita tarjeta de crédito. Solo tienes que acercarte a los establecimientos autorizados y realizar el pago a la cuenta de Pago Efectivo indicando el código de CIP.</p>
								
								<p><b>¿DÓNDE PUEDO ENCONTRAR MI CÓDIGO CIP (Código de Identificación de Pagos)?</b></p>
								<p>Puedes copiar el código mostrado aqui arriba,o revisar el correo asociado a su cuenta, adonde se le ha enviado la confirmación.</p>
								<ul>
									<li><b>INTERBANK</b>: Cualquier Agente Interbank, en Tiendas y Money Market de Interbank, Cajeros Global Net y Banca por Internet Interbank.</li>
									<li><b>KASNET</b>: Cualquier Agente Kasnet a nivel nacional.</li>
									<li><b>BBVA</b>: Agencias del BBVA, Agentes Express o por banca por internet del BBVA.</li>
									<li><b>BCP</b>: Agencias del BCP, Agentes BCP o por banca por internet BCP. Se cobra S/. 1 por comisión.</li>
									<li><b>Scotiabank</b>: Agencias de Scotiabank, Cajeros Express o por Vía Scotia en línea.</li>
									<li><b>Western Union</b>: Cualquier agencia de Pago de Servicio de Western Union a nivel nacional.</li>
									<li><b>Full Carga</b>: Cualquier establecimiento autorizado (Bodegas, Farmacias, Cabinas, Locutorios, etc.) con el logo de PagoEfectivo y/o Fullcarga.</li>
								</ul>
								
								<p><b>¿CUÁNTO TIEMPO TENGO PARA PAGAR?</b></p>
								<p>Tienes <b>12 horas hábiles</b> para realizar el pago ya que si no lo realizas la orden se cancelará de manera automática.</p>
								
								<p><b>PAGUÉ CON PAGOEFECTIVO PERO MI PEDIDO FUE CANCELADO, ¿QUÉ HAGO?</b></p>
								<p>Si tu orden se canceló pero has realizado el pago a la cuenta de Pago Efectivo, comunícate a nuestra central (51) - 555-5555 Opción 1 para poder ayudarte.</p>
							
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
</body>
</html>