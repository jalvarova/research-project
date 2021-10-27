package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.BoletoDTO;
import services.BoletoService;

@WebServlet("/GenerarPago")
public class GenerarPago extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BoletoService servicio = new BoletoService();
		HttpSession sesion = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<BoletoDTO> lista = (ArrayList<BoletoDTO>) sesion.getAttribute("carrito");
		int registros = 0;
		for(BoletoDTO bol : lista){
			int rs = servicio.registrarBoleto(bol);
			registros+=rs;
		}
		System.out.println("Se registraron "+registros+ "boletos");
		
		lista.removeAll(lista);
		sesion.setAttribute("carrito", lista);
		
		String totalSol = request.getParameter("txtTotalSol");
		String totalDolar = request.getParameter("txtTotalDolar");
		
		request.setAttribute("totalSol", totalSol);
		request.setAttribute("totalDolar", totalDolar);
		Random r = new Random();
		int x = r.nextInt(999999)+1000;
		request.setAttribute("CIP", x);
		RequestDispatcher rd = request.getRequestDispatcher("/Pago.jsp");
		rd.forward(request, response);
	}
}