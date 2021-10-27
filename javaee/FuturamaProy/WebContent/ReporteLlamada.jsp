<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="net.sf.jasperreports.engine.*" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/menu.css" rel="stylesheet" type="text/css">
<link href="css/MenuProcesos.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<div id="cuerpoacordion">
				<h1 align="center" style="font-family: cursive; font: italic;">Reporte Llamadas Realizadas</h1>
					
				<form action="ReporteLLamadas" method="get">
				<input type="hidden" value="Reporte" name="opcion" >
				  <Center> 
        Generate Report
      </Center>
						<Center><a href="ReporteLLamadas?opcion=Reporte"  onClick="window.open(this.href, this.target, 'width=800,height=200'); return false;"><input type="submit" value="GENERAR" name="btnBuscar" ></a></Center>
		</form>

			</div>
	
</body>
</html>