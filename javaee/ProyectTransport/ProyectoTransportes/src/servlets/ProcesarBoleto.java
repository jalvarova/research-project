package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BoletoDTO;
import beans.ClienteDTO;
import beans.PersonaDTO;
import beans.RecursoDTO;

@WebServlet("/ProcesarBoleto")
public class ProcesarBoleto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String x = request.getParameter("x");
		
		if(x!=null){
			int i = Integer.parseInt(x);
			@SuppressWarnings("unchecked")
			ArrayList<BoletoDTO> lista = (ArrayList<BoletoDTO>) sesion.getAttribute("carrito");
			lista.remove(i);
			sesion.setAttribute("carrito", lista);
		}
		
		else{
		String nombre = request.getParameter("txtNombre");
		String apePater = request.getParameter("txtApePat");
		String apeMater = request.getParameter("txtApeMat");
		String tipoDocumento = request.getParameter("cboTipoDocumento");
		String nroDocumentoID = request.getParameter("txtNroDoc");
		String codigo = apePater.charAt(0)+apeMater.charAt(0)+nroDocumentoID;
		int asiento = Integer.parseInt(request.getParameter("txtAsiento"));
		double precioSol = Double.parseDouble(request.getParameter("txtPrecioSol"));
		double precioDolar = Double.parseDouble(request.getParameter("txtPrecioDolar"));
		
		PersonaDTO per = new PersonaDTO(codigo, nombre, apePater, apeMater, tipoDocumento, nroDocumentoID);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		RecursoDTO recurso = (RecursoDTO) sesion.getAttribute("recurso");
		String fechaViaje = (String) sesion.getAttribute("fecha");
		ClienteDTO cli = (ClienteDTO) sesion.getAttribute("sesioncliente");
		BoletoDTO boleto = new BoletoDTO(nroDocumentoID,sdf.format(d) , fechaViaje, per.getNroDocumentoID(),cli, recurso, asiento
				,precioSol,precioDolar);
		
		//RecursoDTO recurso = (RecursoDTO) sesion.getAttribute("recurso");
		@SuppressWarnings("unchecked")
		ArrayList<BoletoDTO> lista = (ArrayList<BoletoDTO>) sesion.getAttribute("carrito");
		lista.add(boleto);
		sesion.setAttribute("carrito", lista);
		
		sesion.setAttribute("persona", per);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/AdquirirBoleto.jsp");
		rd.forward(request, response);
	}

}
