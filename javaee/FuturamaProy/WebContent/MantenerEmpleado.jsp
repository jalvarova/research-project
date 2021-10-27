<%@page import="beanDTO.AsesorDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.AsesorServicios"%>
<%@page import="sun.misc.CEStreamExhausted"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	alert("Mantenimiento de Empleados");
</script>
</head>
<body>

			<div id="cuerpoacordion">
				<h1 align="center" style="font-family: cursive; font: italic;">MANTENIMIENTO
					DE EMPLEADOS</h1>
				<div id="tabs">
					<ul>
						<li><a href="#tabs-1">Agregar</a></li>
						<li><a href="#tabs-2">Actualizar</a></li>
						<li><a href="#tabs-3">Anular</a></li>
						<li><a href="#tabs-4">Listar</a></li>
					</ul>
					<div id="tabs-1">
						<!-- Agregar -->

						<form action="GestionaEmpleado" method="get">
							<input type="hidden" name="opcion" value="registro">

							<table>


								<tr>
									<td><label>Documento</label></td>
									<td><input type="text" name="txtDNI"></td>
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
								</tr>
								<tr>
									<td><label>Nª Cleular</label></td>
									<td><input type="text" name="txtCelular"></td>
									<td><label>Nª Referencia</label></td>
									<td><input type="text" name="txtReferencia"></td>
									
								</tr>
								<tr>
									<td><input type="submit" name="btnAgregar" value="Agregar" onclick="alert('Empleado Agregado')">
									</td>
									<td></td>
									<td><input type="reset" name="btnLimpiar" value="Limpiar">
									</td>
								</tr>

							</table>

						</form>


					</div>
					<div id="tabs-2">
<!-- 	return "<a = href='MantenerEmpleado.jsp?cod="+cod+"&dni="+dni+"&nom="+nom+"&pat="+pat+"&mat="+mat+"&dir="+dir+"&fec="+fec+"&cor="+cor+"&ref="+ref+"&num="+num+"&dis="+dis+"&pro="+pro+"&dep="+dep+"&usu="+usu+"'>"
 -->				
                               <form action="GestionaEmpleado" method="get">
							<input type="hidden" name="opcion" value="actualizar">

							<table>
								<tr>

									<td><label>Codigo</label></td>
									<td><input type="text" name="txtCod" value="${param.cod}"></td>
									<td><a href="GestionaEmpleado?opcion=buscalista"><img
											src="img/lupa.png"></a></td>

								</tr>

								<tr>

									<td><label>Documento</label></td>
									<td><input type="text" name="txtDNI1" value="${param.dni}"></td>
									

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
									<td><input type="text" name="txtCorreo1"></td>
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
									<td><label>Nª Cleular</label></td>
									<td><input type="text" name="txtCelular1" value="${param.num}"></td>
									<td><label>Nª Referencia</label></td>
									<td><input type="text" name="txtReferencia1"></td>
								</tr>
								<tr>
									<td><input type="submit" name="btnActualizar"
										value="Actualizar" onclick="alert('Empleado Actualizado')"></td>
									<td></td>
									<td><input type="reset" name="btnLimpiar" value="Limpiar">
									</td>
								</tr>

							</table>

						</form>
					</div>
					<div id="tabs-3">
						<!--  Anular -->
						<form action="GestionaEmpleado" method="get">
						<input type="hidden" name="opcion" value="eliminar">
							<table>
								<tr>
									<td><label>Documento</label></td>
									<td><input type="text" name="txtCod2"></td>
									<td><input type="submit" name="btnEliminar"
										value="Eliminar"></td>
										
									<td><a  href="GestionaEmpleado?opcion=buscalista"><img src="img/lupa.png"></a></td>
								</tr>
							</table>
						</form>
					</div>
					<div id="tabs-4">
						<!--  lista de clientes -->
						
						<%
						AsesorServicios as = new AsesorServicios();
						 ArrayList<AsesorDTO> lista = as.ListarAsesor();
						 
						 session = request.getSession();
						session.setAttribute("listados", lista);
						
						%>
					
							<jsp:include page="ListaEmpleado.jsp" />
					
					</div>

				</div>


			</div>
		
</body>
</html>