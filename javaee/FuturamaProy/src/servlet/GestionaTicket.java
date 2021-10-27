package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanDTO.TicketDTO;
import services.ServiceTicket;
import services.ServicioLlamada;

/**
 * Servlet implementation class GestionaTicket
 */
@WebServlet("/GestionaTicket")
public class GestionaTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionaTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		procesar(request,response );
		
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) {
		String opcion = request.getParameter("opcion");
		switch ("opcion") {
		case "Ticket":
			MostrarTicketAtencion(request,response);
			break;

		}
	}

	private void MostrarTicketAtencion(HttpServletRequest request,
			HttpServletResponse response) {
		ServiceTicket st = new ServiceTicket();
		
		TicketDTO ti = null;
			ti =st.MostrarTicket(ti);
		
			//response.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
