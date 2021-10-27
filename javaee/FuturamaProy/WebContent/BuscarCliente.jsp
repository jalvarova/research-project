<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="display" uri="http://displaytag.sf.net"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/displaytag.css"> 
<link rel="stylesheet" type="text/css" media="screen"href="css/screen.css" />
<title>Insert title here</title>
</head>
<body>
 <form action="GestionaCliente" method="post">
<input type="hidden" name="opcion" value="buscalista">
<display:table name= "${sessionScope.lis}" export="true" decorator="decorator.DevolverCli">

<display:column  title="DNI" property="numIdentidad_clie" sortable="true"/>
<display:column  title="Nombre" property="nom_clie" sortable="true"/>
<display:column  title="Apellido Paterno" property="apePat_clie" sortable="true"/>
<display:column  title="Apellido Materno" property="apeMat_clie" sortable="true"/>
<display:column  title="Correo" property="correo_clie" sortable="true"/>
<display:column  title="Celular" property="numCel_clie" sortable="true"/>
<display:column  title="Telefono Fijo" property="numTelfijo_clie" sortable="true"/>
<display:column  title= "Selecionar" property="devolverCliente"/>
<display:column  title= "Selecionar" property="devolverMarcador"/>
</display:table> 
</form> 
</body>
</html>
