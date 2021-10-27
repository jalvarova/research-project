<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <center><table width="1500" border="0" cellpadding="0" cellspacing="1" height="80px">
	<tr align="center" bgcolor="#666666">
		<td height="30">
			<font size="2" color="#F0F0F0">
		<p>	Ud se ha identificado como : <%= session.getAttribute("sesionUsuario") %> </p>
			</font>
		</td>
		<td height="30">
			<font size="2" color="#F0F0F0">
			<% Date fecha = new Date(session.getCreationTime()); %>
			Su último acceso fue : <%=fecha%>
			</font>
		</td>
	</tr>
</table>
</center>
</body>
</html>