<%@page import="beanDTO.ClientesDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.ClientesServices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="libreria" uri="WEB-INF/libreria.tld"%> 
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="css/menu.css" rel="stylesheet" type="text/css">
<link href="css/MenuProcesos.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();

	});
	alert("Mantenimiento de Clientes");
</script>
</head>
<body>

			<div id="cuerpoacordion">
				<h1 align="center" style="font-family: cursive; font: italic;">MANTENIMIENTO
					DE CLIENTES</h1>
				<div id="tabs">
					<ul>
						<li><a href="#tabs-1">Agregar</a></li>
						<li><a href="#tabs-2">Actualizar</a></li>
						<li><a href="#tabs-3">Anular</a></li>
						<li><a href="#tabs-4" hreflang="GestionaCliente?opcion=lista">Listar</a></li>
					</ul>
					<div id="tabs-1">
						<!-- Agregar -->
						<form action="GestionaCliente" method="get">
							<input type="hidden" name="opcion" value="registro">
							<table>


								<tr>

									<td><label>Documento</label></td>
									<td><input type="text" name="txtDNI"></td>
									<td><label>Nª Documento</label></td>
									<td><input type="text" name="txtNumeroDni"></td>
									<td><label>Nombre </label></td>
									<td><input type="text" name="txtNombre1"></td>
									<td><label>Apellido Paterno</label></td>
									<td><input type="text" name="txtApePat"></td>
								</tr>
								<tr>
									<td><label></label>Apellido Materno</td>
									<td><input type="text" name="txtApeMAt"></td>
									<td><label></label>Direccion :</td>
									<td><input type="text" name="txtDireccion"></td>
									<td><label>Correo</label></td>
									<td><input type="text" name="txtCorreo"></td>
									<td><label>fehca</label></td>
									<td><input type="date" name="dtFecha" step="1" max="">
									</td>
								</tr>
								<tr>
									<td><label>Distrito</label></td>
									<td><input type="text" name="txtDistrito"></td>
									<td><label>Provincia</label></td>
									<td><input type="text" name="txtProvincia"></td>
									<td><label>Departamento</label></td>
									<td><input type="text" name="txtDepartamento"></td>
									<td><label>Nª Telefono Fijo</label></td>
									<td><input type="text" name="txtFijo"></td>

								</tr>
								<tr>
									<td><label>Nª Cleular</label></td>
									<td><input type="text" name="txtCelular"></td>
									<td><label>Nª Referencia</label></td>
									<td><input type="text" name="txtReferencia"></td>


								</tr>

								<tr>

									<td><input type="submit" name="btnAgregar" value="Agregar"
										src="imagenes/agregar.png" onclick="alert('Cliente Agregado')">
									</td>
									<td></td>
									<td><input type="reset" name="btnLimpiar" value="Limpiar"
										src="imagenes/eliminar.png"></td>
								</tr>

							</table>
							<p style="border-color: red;">${error}</p>
						</form>
<!-- 	String dni= cli.getNumIdentidad_clie();
		String nom= cli.getNom_clie();
		String pat= cli.getApePat_clie();
		String mat = cli.getApeMat_clie();
		String dir = cli.getDirecc_clie();
		String fec= cli.getFechNac_clie();
		String cor = cli.getCorreo_clie();
		int     ref = cli.getNumTrabajo_clie();
		int     cel = cli.getNumCel_clie();
		int  tel = cli.getNumTelfijo_clie(); -->

					</div>
					<div id="tabs-2">
						<form action="GestionaCliente" method="get">
							<input type="hidden" name="opcion" value="actualizar">
							<table>


								<tr>
									<td><label>Documento</label></td>
									<td><input type="text" name="txtDNI1" value="${param.dni}"></td>
									<td><td><a href="GestionaCliente?opcion=buscalista"><img
											src="img/lupa.png"></a></td>



								</tr>
								<tr>
									<td><label>Nombre </label></td>
									<td><input type="text" name="txtNombre2" value="${param.nom}"></td>
									<td><label>Apellido Paterno</label></td>
									<td><input type="text" name="txtApePat1" value="${param.pat}"></td>
									<td><label></label>Apellido Materno</td>
									<td><input type="text" name="txtApeMAt1" value="${param.mat}"></td>
									<td><label></label>Direccion :</td>
									<td><input type="text" name="txtDireccion1" value="${param.dir}"></td>

								</tr>
								<tr>
									<td><label>Correo</label></td>
									<td><input type="text" name="txtCorreo1"value="${param.cor}"></td>
									<td><label>fehca</label></td>
									<td><input type="date" name="dtFecha1" step="1" max="" value="${param.fec}">
									</td>
									<td><label>Distrito</label></td>
									<td><input type="text" name="txtDistrito1" value="${param.dis}"></td>
									<td><label>Provincia</label></td>
									<td><input type="text" name="txtProvincia1" value="${param.pro}"></td>


								</tr>
								<tr>
									<td><label>Departamento</label></td>
									<td><input type="text" name="txtDepartamento1" value="${param.dep}"></td>
									<td><label>Nª Telefono Fijo</label></td>
									<td><input type="text" name="txtFijo1" value="${param.tel}"></td>
									<td><label>Nª Cleular</label></td>
									<td><input type="text" name="txtCelular1" value="${param.cel}"></td>
									<td><label>Nª Referencia</label></td>
									<td><input type="text" name="txtReferencia1" value="${param.ref}"></td>
								</tr>
								<tr>
									<td><input type="submit" name="btnActualizar"
										value="Actualizar"
										style='background:url("imagens/actualizar.png");'
										onclick="alert('Cliente Actualizado')"></td>
									<td></td>
									<td><input type="reset" name="btnLimpiar" value="Limpiar"
										src="imagenes/eliminar.png">
									</td>
								</tr>

							</table>

						</form>
					</div>
					<div id="tabs-3">
						<!--  Anular -->
					<form action="GestionaCliente" method="get">
                 <input type="hidden" name="opcion" value="eliminar">
					
							<table>
								<tr>
									<td><label>Documento</label></td>
									<td><input type="text" name="txtDNI2" value="${param.dni}"></td>
									<td><input type="submit" name="btnEliminar"
										value="Eliminar"></td>
									<td><a href="GestionaCliente?opcion=buscalista"><img
											src="img/lupa.png"></a></td>
								</tr>
							</table>
						</form>
					</div>
					<div id="tabs-4">
					
						<!--  lista de clientes -->
						
						<% 
						
						ClientesServices cs = new ClientesServices();
						
						 ArrayList<ClientesDTO> lista = cs.ListarClientes();
						 

						session = request.getSession();
						session.setAttribute("listado", lista);
						
						%>
						
						<jsp:include page="ListaClientes.jsp" />
						<p style="border-bottom-color: red"> ${error} </p>
					</div>


				</div>
			</div>
			
	
</body>
</html>