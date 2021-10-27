package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.RecursoDTO;
import beans.RutaDTO;
import services.ApoyoService;
import services.RecursoService;
import services.RutaService;

@WebServlet("/BuscaViajes")
public class BuscaViajes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RutaService servicio=new RutaService();
		RecursoService servcioRec = new RecursoService();
		ApoyoService servicioApo = new ApoyoService();
		//para probar conla fecha de hoy
		@SuppressWarnings("unused")
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaIda = request.getParameter("dtIda");
		
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		
		if(origen.equals("Seleccione")||destino.startsWith("Seleccione")){
			request.setAttribute("msj", "Debe seleccionar bien los destinos");
			RequestDispatcher rd = request.getRequestDispatcher("/Principal.jsp");
			rd.forward(request, response);
		}
		else{
		RutaDTO r = servicio.getRuta(origen, destino);
		System.out.println(origen+" "+destino);
		RecursoDTO recurso = servcioRec.getRecurso(r.getCodRuta());
		if(recurso!=null) System.out.println("existe recurso");
		
		ArrayList<Integer> asientosOcupados = servicioApo.getAsientosOcupados(fechaIda, recurso.getBus().getNroPlaca());
		int asientosLibres = 40-asientosOcupados.size();
		System.out.println(origen+" "+destino);
		System.out.println(r.getCodRuta());
		
		//precalcular tarifa
		double precio = r.getTarifa()+recurso.getBus().getTipServi().getTarifa();
		System.out.println(precio);
		
		HttpSession sesion = request.getSession();
		//habra arraylist de recursos,mas adelante
		sesion.setAttribute("recurso", recurso);
		sesion.setAttribute("fecha", fechaIda);//aqui poner la fecha que se busca
		request.setAttribute("horaSalida", r.getHoraSalida());
		request.setAttribute("precio", precio);
		sesion.setAttribute("lstAsientosOcupados", asientosOcupados);
		request.setAttribute("asientosLibres", asientosLibres); //por ahora
		RequestDispatcher rd = request.getRequestDispatcher("/ResultadoBusqueda.jsp");
		rd.forward(request, response);
		}
	}
}