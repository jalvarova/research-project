<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es" class="no-js">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ingreso al Sistema</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel="stylesheet" href="CSS/EstilosLogueo.css">
    <script src="JS/jquery-1.9.1.min.js"></script>
    <script src="JS/supersized.3.2.7.min.js"></script>
    <script src="JS/supersized-init.js"></script>
    <script src="JS/scriptLogueo.js"></script>
</head>
<body>
	<div class="ContenedorLogueo">
        <h1>Logueo</h1>
        <form action="logueando" method="post" target="_parent">
            <input type="text" name="txtUsuario" class="usuario" placeholder="Usuario" maxlength="10">
            <input type="password" name="txtContrasena" class="contrasena" placeholder="Contraseña" maxlength="4">
            <input type="submit" name="btnIngresar" value="Iniciar Sesión" class="boton">
            <div class="error"><span>+</span></div>
        </form>
    </div>
    <%
		String mensaje = (String) request.getAttribute("mensaje");
		if (mensaje != null)
			out.println("<center>" + mensaje + "</center>");
	%>
</body>
</html>