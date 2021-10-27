<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/menu.css" rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<title>Insert title here</title>
</head>
<body style="width: 1200px;">
	<span style="text-align: center;">
		<h1>REGISTRO DE VENTA</h1>
	</span>
	<hr>
	<div>
	
				<div id="cuerpoacordion">

					<p>Codido :</p>
					<input type="text" name="txtCodigo" value=""
						pacholder="ingrese codigo" maxlength="15" /> <a
						href="RegistraClientes.jsp" target="popup"
						onClick="window.open(this.href, this.target, 'width=900,height=700'); return false;">
						<input type="button" name="btnAgregar" value="Agrega">
					</a> <input type="button" name="btnbuscar" value="Buscar CLiente">

					<div>
						<form action="">
							<table>


								<tr>
									<td><h3>DATOS PACK TURISTICO</h3></td>
								</tr>

								<tr>
									<td>CAMPAÑA</td>
									<td><select>
											<option value="0">SELECCIONE CAMPAÑA</option>
											<option value="1">CAMPAÑA 1</option>
											<option value="2">CAMPAÑA 2</option>
											<option value="3">CAMPAÑA 3</option>
									</select></td>

									<td>PACK</td>
									<td><select>
											<option value="0">SELECCIONE PACK</option>
											<option value="1">PACK 1</option>
											<option value="2">PACK 2</option>
											<option value="3">PACK 3</option>
									</select></td>


									<td>HOTEL</td>
									<td><select>
											<option value="0">SELECCIONE HOTEL</option>
											<option value="1">HOTEL 1</option>
											<option value="2">HOTEL 2</option>
											<option value="3">HOTEL 3</option>
									</select></td>
								</tr>

								<tr>
									<td></td>
									<td></td>
								</tr>



								<tr>
									<td><h3>DETALLE HABITACION</h3></td>
								</tr>

								<tr>
									<td>HABITACION</td>
									<td><select>
											<option value="0">SELECCIONE HABITACION</option>
											<option value="1">SGL</option>
											<option value="2">DBL</option>
											<option value="3">TRL</option>
											<option value="3">CTR</option>

									</select></td>
								</tr>

								<tr>

									<td>PRECIO S/.</td>
									<td><input type="text"></td>

									<td>NOCHE ADICIONAL S/.</td>
									<td><input type="text"></td>

									<td>Nº NOCHE ADICIONAL S/.</td>
									<td><input type="text"></td>

									<td>TOTAL S/.</td>
									<td><input type="text">
								</tr>

								<tr>
									<td>PRECIO $</td>
									<td><input type="text"></td>

									<td>NOCHE ADICIONAL $</td>
									<td><input type="text"></td>

									<td>&nbsp;</td>
									<td>&nbsp;</td>

									<td>TOTAL $</td>
									<td><input type="text">
								</tr>

								<tr>
									<td><input type="submit" value="CALCULAR"></td>
								</tr>

							</table>
						</form>

					</div>

					<form action="">
						<table>

							<tr>
								<td><h3>DETALLE DE HUESPEDES</h3></td>
							</tr>

							<tr>
								<td>TIPO</td>
								<td><select>
										<option value="0">SELECCIONE TIPO</option>
										<option value="1">ADULTO</option>
										<option value="2">MENOR</option>
								</select></td>


								<td>ROL</td>
								<td><select>
										<option value="0">SELECCIONE ROL</option>
										<option value="1">RESPONSABLE</option>
										<option value="2">HUESPED</option>
								</select></td>

							</tr>

							<tr>
								<td>TIPO DE IDENTIDAD :</td>
								<td><input type="text"></td>

								<td>NUMERO DE INDETIDAD :</td>
								<td><input type="text"></td>
							</tr>

							<tr>
								<td>NOMBRES :</td>
								<td><input type="text"></td>

								<td>APELLIDO PATERNO :</td>
								<td><input type="text"></td>

								<td>APELLIDO MATERNO :</td>
								<td><input type="text"></td>
							</tr>

							<tr>
								<td><input type="submit" value="AGREGAR HUESPED"></td>
							</tr>

							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>

							<tr style="border: solid; background: black; color: white;">
								<th>TIPO</th>
								<th>ROL</th>
								<th>DNI</th>
								<th>NOMBRES</th>
								<th>APE PAT</th>
								<th>APE MAT</th>
							</tr>

							<tr style="border: solid; background: #FFFFCC;">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>

						</table>

					</form>
					<br> <br> <br> <br> <br> <br>

					<div>
						<form action="">
							<table>
								<tr>
									<td>OBSERVACIONES</td>
									<td><textarea rows="3" cols="30"></textarea></td>
								</tr>

								<tr>
									<td></td>
									<td></td>
								</tr>

								<tr>

									<td><input type="button" onclick="history.back()"
										value="CANCELAR GESTION"></td>
									<td><input type="submit" value="REGISTRAR VENTAS"></td>
								</tr>

							</table>
						</form>
					</div>
				</div>

			</div>
	

</body>
</html>