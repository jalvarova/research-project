package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.RutaService;
import beans.CiudadDTO;

@WebServlet("/CargarDestinos")
public class CargarDestinos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		RutaService servicio = new RutaService();
		PrintWriter out = response.getWriter();
		String origen = request.getParameter("origen");
		System.out.println(origen);
		ArrayList<CiudadDTO> lista = servicio.getCiudadesDestino(origen);
		System.out.println(lista.size());
		try{
			if(origen.equalsIgnoreCase("Seleccione")){
				out.println("<option>Seleccione Origen</option>");
			}else{
				for(CiudadDTO c: lista){
					out.println("<option value='"+c.getCodciudad()+"'>"+c.getNomCiudad()+"</option>");
				}
			}
		}finally{
			out.close();
		}
	}
}