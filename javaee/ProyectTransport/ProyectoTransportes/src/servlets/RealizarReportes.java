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

import beans.BoletoDTO;
import services.ApoyoService;

@WebServlet("/RealizarReportes")
public class RealizarReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ApoyoService servicio = new ApoyoService();
		
		ArrayList<BoletoDTO> reporteProximos = servicio.reportesBoletosProximos();
		ArrayList<BoletoDTO> reporteAnteriores = servicio.reportesBoletosAnteriores();
		
		RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");
		
		HttpSession misesion = request.getSession();
		
		misesion.setAttribute("listadoProximos", reporteProximos);
		misesion.setAttribute("listadoAnteriores", reporteAnteriores);
		
		rd.forward(request, response);
		
	}
}