package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.RutaDTO;
import services.RutaService;

@WebServlet("/ListadoRutas")
public class ListadoRutas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	public void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		RutaService serv = new RutaService();
		List<RutaDTO> lista = serv.getListadoRutas();
		
		RequestDispatcher rd = request.getRequestDispatcher("/BuscarRuta.jsp");
		HttpSession misesion = request.getSession();
		misesion.setAttribute("listadoRutas", lista);
		rd.forward(request, response);
	}
}