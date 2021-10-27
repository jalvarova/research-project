package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.CiudadDTO;
import services.RutaService;

@WebServlet("/ProcesarIndex")
public class ProcesarIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		   RutaService servicio = new RutaService();
		   ArrayList<CiudadDTO> lista = servicio.getCiudadesOrigen();
		   
		   RequestDispatcher rd = request.getRequestDispatcher("/Principal.jsp");
		   HttpSession sesion = request.getSession();
		   sesion.setAttribute("listaCiudades",	lista);
		   
		   rd.forward(request,response);   
	}
}