<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="libreria" uri="WEB-INF/libreria.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  <link href="css/Contenedor.css" rel="stylesheet" type="text/css" />-->
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/resources/demos/style.css">
<title>Insert title here</title>
</head>
<body>
<body style="width: 1000px;">

	<span style="text-align: center;"><h1>PostVenta</h1></span>

	
			<div id="cuerpoacordion">
				<center>
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
					<form action="ReporteLLamadas"  method="get">
					
						<table>

							<tr>
								<td colspan="2"><h3>DATOS DEL CONTACTO</h3></td>
							</tr>


							<tr>
								<td>NUMERO DE INDETIDAD :</td>
								<td><input type="text" name="txtDniCli" value="${param.dni}"></td>
							</tr>

							<tr>
								<td>NOMBRES :</td>
								<td><input type="text" value="${param.nom}"></td>
							</tr>

							<tr>
								<td>APELLIDO PATERNO :</td>
								<td><input type="text"value="${param.pat}"></td>
							</tr>

							<tr>
								<td>APELLIDO MATERNO :</td>
								<td><input type="text"value="${param.mat}"></td>
							</tr>

							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>

							<tr>
								<td>PROVINCIA :</td>
								<td><input type="text"value="${param.pro}"></td>
							</tr>

							<tr>
								<td>DISTRITO :</td>
								<td><input type="text"value="${param.dis}"></td>
							</tr>

							<tr>
								<td>CORREO :</td>
								<td><input type="text" value="${param.cor}"></td>
							</tr>

							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>

							<tr>
								<td>Nº TELEFONO FIJO</td>
								<td><input type="text" value="${param.tel}"></td>
							</tr>

							<tr>
								<td>Nº CELULAR</td>
								<td><input type="text" value="${param.cel}"></td>
							</tr>

							<tr>
								<td>Nº TRABAJO</td>
								<td><input type="text" value="${param.ref}"></td>
							</tr>

							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>

							<tr>
								<td><input type="text" placeholder="CODIGO ASESOR"
									name="txtCodigo"></td>
								<td><textarea rows="3" cols="30" name="txtObservacion">OBSERVACIONES</textarea></td>


								<td><input type="text" placeholder="Nº DE CONTACTO"
									name="txtNumero"></td>
								<td><select name="cboMotivo">
										<libreria:ComboMotivo />
										<!-- <option value="0">MOTIVO</option>
									<option value="1">MOTIVO 1.1</option>
									<option value="2">MOTIVO 2.1</option>
									<option value="3">MOTIVO 3.1</option> -->
								</select></td>
								<td><select name=cboEstado>
										<libreria:ComboEstado />
										<!-- <option value="0">ESTADOS</option>
									<option value="1">ESTADO 1</option>
									<option value="2">ESTADO 2</option>
									<option value="3">ESTADO 3</option> -->
								</select></td>




							</tr>

							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>

							<tr>
								<td><a href="marcador.jsp"><input type="button" value="CANCELAR GESTION"  ></a></td>
								<td><a href="index.jsp"><input type="button" value="TERMINAR GESTION"  ></a></td>
								<td><a href="GestionaCliente?opcion=buscalista"><input type="button"    value="Siguiente Contacto"> </a></td>
								<td><a href="registroVentas.jsp"><input type="submit"  name="opcion"  value="Registra"></a></td>
							</tr>


						</table>


					</form>
				</center>

			</div>
	

</body>
</html>