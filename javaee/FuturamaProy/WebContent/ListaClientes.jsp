<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/displaytag.css"> 
<link rel="stylesheet" type="text/css" media="screen"href="css/screen.css" />
<title>Insert title here</title>
</head>
<body>
	<a href="GestionaCliente?opcion=lista"><img src="img/lupa.png"></a>
					

<table  border="1" bordercolor="red" >
	
			<tr>
				<td>DNI</td>
				<td>Nombre</td>
				<td>Apellido Paterno</td>
				<td>Apellido materno</td>
				<td>Direccion</td>
				<td>Fecha de nacimiento</td>
				<td>Correo</td>
				<td>NªTrabajo</td>
				<td>Nª Celular</td>
				<td>Nª Fijo</td>
				
			</tr>
		<c:forEach var="lista" items="${sessionScope.listado}">
			
			<tr>
				<td>${lista.numIdentidad_clie}</td>
				<td>${lista.nom_clie}</td>
				<td>${lista.apePat_clie}</td>
				<td>${lista.apeMat_clie}</td>
				<td>${lista.direcc_clie}</td>
				<td>${lista.fechNac_clie}</td>
				<td>${lista.correo_clie}</td>
				<td>${lista.numTrabajo_clie}</td>
				<td>${lista.numCel_clie}</td>
				<td>${lista.numTelfijo_clie}</td>
				
				
			</tr>
			
			
		</c:forEach>
		
	</table>
	
</body>
</html>