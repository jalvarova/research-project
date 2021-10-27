package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.RecursoDTO;
import services.RecursoService;

@WebServlet("/ProcesarRecursos")
public class ProcesarRecursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RecursoService serv = new RecursoService();
		String rec = request.getParameter("s");
		
		String isClicked = request.getParameter("btnProcesar");
		ArrayList<RecursoDTO> lista = serv.getRecursos();
		
		String codServicio="";
		int ultimoCod =	Integer.parseInt(lista.get(lista.size()-1).getCodRecurso().substring(2));
		if(ultimoCod<9) codServicio = "RC00"+(ultimoCod+1);
		else if(ultimoCod<99) codServicio = "RC0"+(ultimoCod+1);
		else if(ultimoCod<999) codServicio = "RC"+(ultimoCod+1);
		
		if(isClicked==null){
			System.out.println("OK");
			if(rec!=null){
				int rs = serv.eliminarRecurso(rec);
				if(rs != 0){	
					request.setAttribute("mensaje", "Recurso Eliminado");	
				}else{	
					request.setAttribute("mensaje", "Error al Eliminar Recurso");	
				}
			}
			
		}else{
			String codRec = request.getParameter("txtCodigoR");
			String codChofer = request.getParameter("cboChofer");
			String codTerra  = request.getParameter("cboTerramoza");
			String codBus  = request.getParameter("cboBus");
			String codRuta  = request.getParameter("cboRuta");
			int estado  = Integer.parseInt(request.getParameter("cboEstadoR"));
			
			if(isClicked.equals("Registrar")){
				int rs = serv.registrarRecurso(codRec, codChofer, codTerra, codBus, codRuta, estado);
				if (rs != 0) {
					request.setAttribute("mensaje", "Recurso Registrado");
				} 
				else {
					request.setAttribute("mensaje", "Error al Registrar Recurso");
				}
			}
			else if(isClicked.equals("Actualizar")){
				int rs = serv.actualizarRecurso(codRec, codChofer, codTerra, codBus, codRuta, estado);
			
				if (rs != 0) {
					request.setAttribute("mensaje", "Recurso Actualizado");
				} else {
					request.setAttribute("mensaje", "Error al Actualizar Recurso");
				}
			}
		}
		lista = serv.getRecursos();
		//HttpSession sesion=request.getSession();
		request.setAttribute("listaRecursos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/MantenerServicio.jsp?codServicio="+codServicio);
		rd.forward(request, response);
	}
}