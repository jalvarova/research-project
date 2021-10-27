<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Detalle Pasajero</title>
</head>
<body>
	<div class="row">
		<div class="large-12large-centered columns">
			<h2>Listado de pedidos</h2>
			<fieldset style="background-color: silver;">
				
				<form action="GenerarPago" method="post">
				<!-- mostrar un display con los datos del pedido -->
				<display:table name="${sessionScope.carrito}" id="tablaPasajeros" varTotals="Total" decorator="decorator.Wrapper">
					<display:column title="Nro. Boleto" property="nroBoleto" />
					<display:column title="Fecha Emisión" property="fechaEmision" />
					<display:column title="Fecha Viaje" property="fechaViaje" />
					<display:column title="Cliente" property="cliente.nombreCompleto" />
					<display:column title="DNI Pasajero" property="idPasajero" />
					<display:column title="Origen"
						property="recurso.ruta.ciudadOrigen.nomCiudad" />
					<display:column title="Destino"
						property="recurso.ruta.ciudadDestino.nomCiudad" />
					<display:column title="Asiento" property="nroAsiento" />
					<display:column title="Precio S/." property="precioSol"   format="{0,number,0.00}" total="true"/>
					<display:column title="Precio $" property="precioDolar"   format="{0,number,0.00}" total="true"/>
					<display:column property="eliminarBoleto" />
					<display:footer>
					    <tr>
					      <td>Total:</td>
					      <fmt:setLocale value="es_PE"/>
					      <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${Total.column9}" /></td>

					      <fmt:setLocale value="en_US"/>
					      <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${Total.column10}"  /></td>
					   	  <td><input type="hidden" name="txtTotalSol" value="${Total.column9}"></td>
					   	  <td><input type="hidden" name="txtTotalDolar" value="${Total.column10}"></td>
					    </tr>
					    
					    
					  </display:footer> 
				</display:table>
					<table>
						<tr>
							<td><input type="submit" value="Comprar" name="btnComprar"></td>
						</tr>
					</table>
				</form>
			</fieldset>
			<!-- 	<table>
					<tr>
						<th>Codigo</th><th>Fecha Emision</th><th>Fecha Viaje</th>
						<th>Cliente</th><th>Ciudad Origen</th><th>Ciudad Destino</th>
					</tr>
					<tbody>
						<tr>
							<td>${sessionScope.persona.codigo}</td><td>123</td><td>123</td><td>123</td><td>123</td><td>123</td>
						</tr>
					</tbody>
			</table>
		-->
		</div>
	</div>
</body>
</html>