<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmaci�n de Operaci�n</title>
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
				<legend>Operaci�n Exitosa:</legend>
					<h3>El monto Total a Pagar es: S/.${requestScope.totalSol}  ($${requestScope.totalDolar })</h3>
					<h5>Su C�digo de Identificaci�n de Pago (CIP) es : ${requestScope.CIP }</h5>
					<hr>
					<p><b>PAGAR CON PAGOEFECTIVO</b></p>
					<p><b>�Qu� es PagoEfectivo?</b></p>
								<p>PagoEfectivo es una forma f�cil y segura de comprar a trav�s de Internet. Es c�modo y efectivo pues no necesita tarjeta de cr�dito. Solo tienes que acercarte a los establecimientos autorizados y realizar el pago a la cuenta de Pago Efectivo indicando el c�digo de CIP.</p>
								
								<p><b>�D�NDE PUEDO ENCONTRAR MI C�DIGO CIP (C�digo de Identificaci�n de Pagos)?</b></p>
								<p>Puedes copiar el c�digo mostrado aqui arriba,o revisar el correo asociado a su cuenta, adonde se le ha enviado la confirmaci�n.</p>
								<ul>
									<li><b>INTERBANK</b>: Cualquier Agente Interbank, en Tiendas y Money Market de Interbank, Cajeros Global Net y Banca por Internet Interbank.</li>
									<li><b>KASNET</b>: Cualquier Agente Kasnet a nivel nacional.</li>
									<li><b>BBVA</b>: Agencias del BBVA, Agentes Express o por banca por internet del BBVA.</li>
									<li><b>BCP</b>: Agencias del BCP, Agentes BCP o por banca por internet BCP. Se cobra S/. 1 por comisi�n.</li>
									<li><b>Scotiabank</b>: Agencias de Scotiabank, Cajeros Express o por V�a Scotia en l�nea.</li>
									<li><b>Western Union</b>: Cualquier agencia de Pago de Servicio de Western Union a nivel nacional.</li>
									<li><b>Full Carga</b>: Cualquier establecimiento autorizado (Bodegas, Farmacias, Cabinas, Locutorios, etc.) con el logo de PagoEfectivo y/o Fullcarga.</li>
								</ul>
								
								<p><b>�CU�NTO TIEMPO TENGO PARA PAGAR?</b></p>
								<p>Tienes <b>12 horas h�biles</b> para realizar el pago ya que si no lo realizas la orden se cancelar� de manera autom�tica.</p>
								
								<p><b>PAGU� CON PAGOEFECTIVO PERO MI PEDIDO FUE CANCELADO, �QU� HAGO?</b></p>
								<p>Si tu orden se cancel� pero has realizado el pago a la cuenta de Pago Efectivo, comun�cate a nuestra central (51) - 555-5555 Opci�n 1 para poder ayudarte.</p>
							
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