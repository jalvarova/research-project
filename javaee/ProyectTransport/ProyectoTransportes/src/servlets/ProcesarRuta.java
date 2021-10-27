package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CiudadDTO;
import beans.RutaDTO;
import services.RutaService;

@WebServlet("/ProcesarRuta")
public class ProcesarRuta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RutaService serv  = new RutaService();
		String isClicked = request.getParameter("btnProcesar");
		String ruta = request.getParameter("r");
		List<RutaDTO>lista=serv.getListadoRutas();
		
		String codRuta="";
		int ultimoCod =	Integer.parseInt(lista.get(lista.size()-1).getCodRuta().substring(2));
		if(ultimoCod<9) codRuta="RU00"+(ultimoCod+1);
		else if(ultimoCod<99) codRuta="RU0"+(ultimoCod+1);
		else if(ultimoCod<999) codRuta="RU"+(ultimoCod+1);
		
		if(isClicked==null){
			System.out.println("OK");
			ArrayList<CiudadDTO> listaC = serv.getCiudadesOrigen();
			request.setAttribute("listaCiudades", listaC);
			if(ruta!=null){
				int rs = serv.eliminarRuta(ruta);
				if(rs != 0){
					request.setAttribute("msj", "Ruta Eliminada");
				}else{
					request.setAttribute("msj", "Error al Eliminar Ruta");
				}
			}		
		}else{
			String orig = request.getParameter("cboOrigen");
			String dest  = request.getParameter("cboDestino");
			CiudadDTO origen = serv.getCiudad(orig);
			CiudadDTO destino = serv.getCiudad(dest);
			String horasalida = request.getParameter("txtHoraSalida");
			String tarif = request.getParameter("txtTarifa");
			System.out.println(orig+codRuta+dest+horasalida+tarif);
			double tarifa = Double.parseDouble(tarif);
			codRuta = request.getParameter("txtRuta");

			RutaDTO r = new RutaDTO(codRuta, origen, destino, tarifa,horasalida, 0);
			
			if(isClicked.equals("Registrar")){
				int rs = serv.agregarRuta(r);
				if (rs != 0) {
					request.setAttribute("msj", "Ruta Registrada");
				} 
				else {
					request.setAttribute("msj", "Error al Registrar Ruta");
				}
			}
			else if(isClicked.equals("Actualizar")){
				int rs = serv.modificarRuta(r);
				
				if (rs != 0) {
					request.setAttribute("msj", "Ruta Registrada");
				} else {
					request.setAttribute("msj", "Error al Registrar Ruta");
				}
			}
		}		
		lista = serv.getListadoRutas();
		HttpSession sesion=request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/MantenerRuta.jsp?codRuta="+codRuta);
		sesion.setAttribute("listaRuta", lista);
		rd.forward(request, response);
	}
}