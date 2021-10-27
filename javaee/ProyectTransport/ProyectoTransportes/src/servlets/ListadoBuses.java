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
import beans.BusDTO;
import services.BusService;

@WebServlet("/ListadoBuses")
public class ListadoBuses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	public void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		BusService servicio = new BusService();
		ArrayList<BusDTO> listado = servicio.listarBuses();
		
		RequestDispatcher rd = request.getRequestDispatcher("/BuscarBus.jsp");
		HttpSession misesion = request.getSession();
		misesion.setAttribute("listadoBuses", listado);
		rd.forward(request, response);
	}
}