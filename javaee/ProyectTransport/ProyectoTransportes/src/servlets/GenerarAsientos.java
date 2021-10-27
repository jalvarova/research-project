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

@WebServlet("/GenerarAsientos")
public class GenerarAsientos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pre = request.getParameter("txtPrecio");
		double precio = Double.parseDouble(pre);
		System.out.println("Al generar asiento" +precio);
		
		HttpSession sesion = request.getSession();
		sesion.setAttribute("precioBase", precio);
		@SuppressWarnings("unchecked")
		ArrayList<Integer> listadoAsientosO = (ArrayList<Integer>) sesion.getAttribute("lstAsientosOcupados");
		System.out.println("en generar asiento" + listadoAsientosO.size());
				
		RequestDispatcher rd = request.getRequestDispatcher("/AdquirirBoleto.jsp");
		rd.forward(request, response);
	}
}