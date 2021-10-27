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
import beans.ClienteDTO;
import services.ServicioCliente;

@WebServlet("/ListadoClientes")
public class ListadoClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ServicioCliente ser = new ServicioCliente();
		ArrayList<ClienteDTO>lista=ser.getlistadoclientes();
		
		HttpSession sesion=request.getSession();
		RequestDispatcher rd=request.getRequestDispatcher("/BuscarCliente.jsp");
		sesion.setAttribute("listacli", lista);
		rd.forward(request, response);
	}
}