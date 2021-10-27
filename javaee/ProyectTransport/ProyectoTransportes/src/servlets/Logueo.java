package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.AdministradorDTO;
import beans.ClienteDTO;
import services.AdministradorService;
import services.ClienteService;

@WebServlet("/Logueo")
public class Logueo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	public void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtContrasena");
				
		AdministradorService servicio = new AdministradorService();
		AdministradorDTO admin = servicio.validaAdministrador(usuario, clave);
		
		ClienteService servCliente = new ClienteService();
		ClienteDTO cli = servCliente.validaCliente(usuario, clave);
		
		RequestDispatcher rd = null;
		if (admin != null) {
			rd = request.getRequestDispatcher("/InicioAdministrador.jsp");
			HttpSession misesion = request.getSession();
			misesion.setAttribute("datosconsesion", admin);
		}else if (cli != null) {
			rd = request.getRequestDispatcher("/ProcesarIndex");
			HttpSession misesion = request.getSession();
			misesion.setAttribute("sesioncliente", cli);
			System.out.println("Se logueo : "+cli.getNombre()+" "+cli.getApePater());
		}else {
			rd = request.getRequestDispatcher("/Logueo.jsp"); 
			request.setAttribute("mensaje", "Usuario o contraseña incorrectos");
		}
		rd.forward(request, response);
	}
}