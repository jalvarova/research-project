<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/menu.css" rel="stylesheet" type="text/css">
<link href="css/MenuProcesos.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link >
<title>Insert title here</title>
</head>
<body>

			<div id="cuerpoacordion">
				<h1 align="center" style="font-family: cursive; font: italic;">Reporte
					de Ventas por Asesor</h1>
				
				<form action="ReporteVentas" method="post">
				<input type="hidden" name="opcion" value="ventasxasesor" >
				<center>
				<table>
				<tr>
				<td> <label>Codigo </label></td>
				<td> <input type="text" name=txtNombre ></td>
				<td><a href="ReporteVentas?opcion=ventasxasesor" > <input type="submit" name="btnReporte" value="reporte" ></a></td>
				 </tr>
				</table>
				</center>
				</form>
                       

			</div>
		
</body>
</html>