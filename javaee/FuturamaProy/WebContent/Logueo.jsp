<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link href="css/Presentacion.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="css/style3.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />

<!--  -->
</head>

<body>
	<div id="contenedor">
		<div id="cabecera"></div>

	</div>
	<div id="cuerpo">
		<div class="container">
			<header>
			<h1>
				Bienvenido a <span>Futurama</span>
			</h1>
			<nav class="codrops-demos"> <span><strong>Ingrese
					su usuario y contraseña</strong></span> <br>
			</nav> </header>
			<section>
			<div id="container_demo">
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
			</div>
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="LogueoServlet" autocomplete="on" method="post">
						<h1>Logueo</h1>
						<p>
							<label for="username" class="uname" data-icon="u">Nombre
								de Usario</label> <input id="username" name="txtUsuario"
								required="required" type="text" placeholder="Usuario"
								maxlength="15" />
						</p>
						<p>
							<label for="password" class="youpasswd" data-icon="p">Contraseña</label>
							<input id="password" name="txtContraseña" required="required"
								type="password" placeholder="Contraseña" maxlength="15" />
						</p>
						<center>
							<p style="color: red">${msg}</p>
						</center>
						<p class="login button">
						<p class="keeplogin">
							<input type="checkbox" name="loginkeeping" id="loginkeeping"
								value="loginkeeping" /> <label for="loginkeeping">Recordar
								contraseña</label>
						</p>
						<p class="login button">
							<input type="submit" name="operacion" value="Login" id="logueo" />
						</p>
						<p class="change_link">

							<a href="#toregister" class="to_register">Click aquí</a>
						</p>
					</form>


				</div>

			</div>
			</section>
		</div>
	</div>

	<div id="pie"></div>
	</div>
	<script src="js/jquery.js" type="text/javascript" ></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#logueo").click(function() {
				alert("Logueado");
			});
		});
		
	//	$(document).ready
	</script>
</body>
</html>