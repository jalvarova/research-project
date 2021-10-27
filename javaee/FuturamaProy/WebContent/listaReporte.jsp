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
<display:table name= "${sessionScope.listado}" export="true">

<display:column  title="Nombre Asesor" property="nom_ases" sortable="true"/>
<display:column  title="Estado Llamada" property="tipo_estado" sortable="true"/>
<display:column  title="Motivo" property="nom_motivo" sortable="true"/>
<display:column  title="Observaciones" property="obs_llamda" sortable="true"/>
<display:column  title="Numero de Llamda" property="num_llamda" sortable="true"/>
<display:column  title="Cantidad" property="cod_ases" sortable="true"/>



</display:table>
</body>
</html>