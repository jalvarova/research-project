<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%--  <%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>  --%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/displaytag.css"> 
<link rel="stylesheet" type="text/css" media="screen"href="css/screen.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--  <display:table name= "${sessionScope.listado}" export="true" >

<display:column  title="DNI" property="numIdentidad_clie" sortable="true"/>
<display:column  title="Nombre" property="nom_clie" sortable="true"/>
<display:column  title="Apellido Paterno" property="apePat_clie" sortable="true"/>
<display:column  title="Apellido Materno" property="apeMat_clie" sortable="true"/>
<display:column  title="Correo" property="correo_clie" sortable="true"/>
<display:column  title="Celular" property="numCel_clie" sortable="true"/>
<display:column  title="Telefono Fijo" property="numTelfijo_clie" sortable="true"/>

</display:table> --%> 

<table border="1" bordercolor="red">
	
		<tr>
		         <td>Codigo</td>		
				<td>Nª Indentidad</td>
				<td>Nombre</td>
				<td>Apellido Paterno</td>
				<td>Apellido materno</td>
				<td>Correo</td>
				<td>Nª Celular</td>
				<td>Nª Referencia</td>
				<td>Direccion</td>
				<td>Fecha Nacimiento</td>
				<td>Distrito</td>
				<td>Provincia</td>
				<td>Depratamento</td>
				<td>Estado</td>
				
			</tr>
		<c:forEach var="listas" items="${sessionScope.listados}">
			
		
			<tr>
			    <td>${listas.cod_ases}</td>
				<td>${listas.numIdentidad_ases}</td>
				<td>${listas.nom_ases}</td>
				<td>${listas.apePat_ases}</td>
				<td>${listas.apeMat_ases}</td>
				<td>${listas.correo_ases}</td>
				<td>${listas.num_telefono_ases}</td>
				<td>${listas.ref_telefono_ases}</td>
				<td>${listas.dirrec_ases}</td>
				<td>${listas.fechaNac_ases}</td>
				<td>${listas.distrito_ases}</td>
				<td>${listas.provincia_ases}</td>
				<td>${listas.departamento_ases}</td>
				<td>${listas.estado_ases}</td>
				
			</tr>
			
		</c:forEach>
		</table>
</body>
</html>