package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanDTO.VentaDTO;
import beanDTO.VentasADTO;
import beanDTO.VentasRDTO;
import services.ServicesVentas;

/**
 * Servlet implementation class ReporteVentas
 */
@WebServlet("/ReporteVentas")
public class ReporteVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ServicesVentas servicio = new ServicesVentas();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteVentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
	
		
		switch (opcion) {
		case "reporteventas":
			ReporteVenta(request,response);
			break;
			
		case "ventasxasesor":
			VentasxAsesor(request,response);
			break;
			
		case "registrar":
			RegistrarVenta(request,response);
			break;
		}
	}

	private void RegistrarVenta(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int codAse = Integer.parseInt(request.getParameter(""));
		int codHotel = Integer.parseInt(request.getParameter("cboHotel"));
		int codHab = Integer.parseInt(request.getParameter("cboHabit"));
		int nAdi = Integer.parseInt(request.getParameter("txtNocheAdd"));
		double preTotal = Double.parseDouble(request.getParameter("pretotal_hab"));
		String obs = request.getParameter("txtObser");
		String numIden = request.getParameter("txtCodigo");
		
		
		VentaDTO ventaDTO = new VentaDTO( 1, codHotel, codHab, nAdi, preTotal, obs, numIden);
		
		ServicesVentas ss = new ServicesVentas();
		
		ss.registrarVenta(ventaDTO);
		
		 if (ventaDTO != null) {
				RequestDispatcher rd = request.getRequestDispatcher("/RegistraVenta.jsp");
			
				rd.forward(request, response);

				
			} 
		
	}

	private void VentasxAsesor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 
		String nom = request.getParameter("txtNombre");
		
		ArrayList<VentasADTO> ventas = new ArrayList<VentasADTO>();
		
		ventas = servicio.VentasxAsesor(nom);
		HttpSession session = request.getSession();
		session.setAttribute("listado", ventas);
		 if (ventas != null) {
				RequestDispatcher rd = request.getRequestDispatcher("/VentasxAsesor.jsp");
			
				rd.forward(request, response);

				
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/VentasxAsesor.jsp");
				session.setAttribute("Error de Listado", "error");
				rd.forward(request, response);
			} 
	}

	private void ReporteVenta(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

      ArrayList<VentasRDTO> lista = new ArrayList<VentasRDTO>();
      
      lista = servicio.ReporteVentas();
		

		HttpSession session = request.getSession();
		session.setAttribute("listado", lista);
      if (lista != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Ventas.jsp");
		
			rd.forward(request, response);

			
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/Ventas.jsp");
			session.setAttribute("Error de Listado", "error");
			rd.forward(request, response);
		} 
	}

}
