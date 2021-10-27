<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>Página No Encontrada - Error 404</title>
	<link type="text/css" rel="stylesheet" href="CSS/EstiloError1.css">
	<style type="text/css">    
		html, body {
		    margin: 0;
		    padding: 0;
		    width: 100%;
		    height: 100%;
		}
		
		body {
		    background: #D6E1D1;
		    display: table;
		}
		
		#contenido-wrap {
		    max-width: 600px;
		    margin: 0 auto;
		    padding-top: 10%;
		    position: relative;
		    border-bottom: 1px solid #E8EFE6;
		}
		
		#contenido {
		    padding: 50px 0 10px 333px;
		    background-repeat: no-repeat;
		    min-height: 290px;
		    border-bottom: 1px solid #BBC7B5;
		    color: #666;
		    font: 12px/1.5 Tahoma, sans-serif;
		    text-shadow: 0 1px 0 #f1f5ef;
		}
		
		a {
		    color: #0084B0;
		    text-decoration: none;
		    text-shadow: none;
		}
		
		a:hover {
		    text-decoration: underline;
		}
		
		#titulo {
		    width: 257px;
		    overflow: hidden;
		    background-repeat: no-repeat;
		}
		
		#descripcion {
		    margin-top: 10px;
		}
		
		#destino {
		    display: block;
		    margin-top: 10px;
		    background: #C9E967 url(http://st.deviantart.net/minish/main/errors/button-back-green-sprite.png) no-repeat;
		    padding-left: 65px;
		    width: 192px;
		    height: 32px;
		    color: #222;
		    text-shadow: 0 1px 0 #fff;
		    text-decoration: none;
		    line-height: 32px;
		}
		
		#destino:hover {
		    background-position: 0 -32px;
		}
		
		#destino:active {
		    background-position: 0 -64px;
		}
		
		.error-404 #contenido {
		    background-image: url(http://st.deviantart.net/minish/main/errors/fella-not-found.png);
		    background-position: 0 48px; }
		.error-404 #titulo {
		    background-image: url(http://st.deviantart.net/minish/main/errors/error-title-oops.png);
		    height: 102px; }
		    
		 @media screen and (max-width: 630px) {
		    #contenido {
		        margin: 0 auto;
		        min-height: 0;
		        padding: 20px 0 300px 0;
		        width: 309px;
		        background-position: 50% 99%!important;
		    }
		}
	</style>
</head>
<body class="error-404">
	<div id="contenido-wrap">
		<div id="contenido">
			<div id="titulo"></div>
			<div id="descripcion">La página que buscabas no existe o no se encuentra disponible. Puedes intentar regresar para seguir buscando..</div>
			<a id="destino" href="/ProyectoTransportes/ProcesarIndex">Ir a la Página de Inicio</a>
		</div>
	</div>
</body>
</html>