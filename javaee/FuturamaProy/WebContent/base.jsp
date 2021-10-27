<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/Contenedor.css" rel="stylesheet" type="text/css">
<link href="css/MenuProcesos.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<div id="contenedorP">
		<div id="cabeceraP"></div>
		<div id="menuP">
			<jsp:include page="Cabecera.jsp"></jsp:include><br>
		</div>
		<div id="cuerpoP">
			<div id="menuacordion" align="center">
				<jsp:include page="menu.jsp"/>
			</div>
			<div id="cuerpoacordion"></div>
		</div>
		<div id="pieP"></div>
	</div>
</body>
</html>