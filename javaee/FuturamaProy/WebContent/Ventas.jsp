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

<form action="ReporteVentas" method="get">
<input  type="hidden" name="opcion" value="reporteventas">
<display:table name= "${sessionScope.listado}" export="true" >

<display:column  title="Cantidad" property="cod_ases" sortable="true"/>
<display:column  title="Nombre" property="nom_ases" sortable="true"/>
<display:column  title="Observacion" property="obser_venta" sortable="true"/>
<display:column  title="Fecha Venta" property="fecha_venta" sortable="true"/>
<display:column  title="Pack" property="nom_pack" sortable="true"/>
<display:column  title="Campaña" property="nom_camp" sortable="true"/>
<display:column  title="Hotel" property="nom_hotel" sortable="true"/>

</display:table> 
</form>

</body>
</html>