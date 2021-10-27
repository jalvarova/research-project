package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CerrarSesion")
public class CerrarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	public void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession misesion = request.getSession();
		System.out.println("Cerrando la Sesion : " + misesion.getId());
		misesion.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("/ProcesarIndex");
		rd.forward(request, response);
	}
}