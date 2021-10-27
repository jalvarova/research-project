package servlet;

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

import services.AsesorServicios;
import services.ClientesServices;
import beanDTO.AsesorDTO;
import beanDTO.ClientesDTO;

/**
 * Servlet implementation class GestionaEmpleado
 */
@WebServlet("/GestionaEmpleado")
public class GestionaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
      AsesorServicios as = new AsesorServicios();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionaEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String opcion =request.getParameter("opcion");
		switch (opcion) {
		case "registro":
			registraEmpleado(request, response);
			break;
		case "lista":
			listaEmpleado(request, response);
			break;
		case "actualizar":
			actualizaEmpleado(request, response);
			break;
		case "eliminar":
			eliminaEmpleado(request,response);
			break;
		case "buscar":
			buscarEmpleado(request, response);
			break;
		case "buscalista":
			BuscarListaEmpleado(request, response);
			break;
		}
		
		
	}



	private void BuscarListaEmpleado(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		 ArrayList<AsesorDTO> lis = as.ListarAsesor();
		 
			HttpSession  session = request.getSession();
			session.setAttribute("lis", lis);
			
		
			
			if (lis != null) {
				   RequestDispatcher rd = request.getRequestDispatcher("/BuscarEmpleado.jsp");

					rd.forward(request, response);
			}else {
				  RequestDispatcher rd = request.getRequestDispatcher("/BuscarEmpleado.jsp");
	             session.setAttribute("Error de Listado", "error");
			rd.forward(request, response);
		 }
	}

	private void buscarEmpleado(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 
	
		
	}

	private void eliminaEmpleado(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		int cod = Integer.parseInt( request.getParameter("txtCod2"));
		
		int ases = as.Eliminar(cod);
		
		 if (ases != 0) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/MantenerEmpleado.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("Asesor", ases);
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/MantenerEmpleado.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("Error De insercion ", "error");
				rd.forward(request, response);
			}
		
		//response.sendRedirect("MantenerEmpleado.jsp");
		
	}

	private void actualizaEmpleado(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		
	        
		
		String DNI = request.getParameter("txtDNI1");
		String Nombre = request.getParameter("txtNombre2");
		String Apellido1 = request.getParameter("txtApePat1");
		String Apellido2 = request.getParameter("txtApeMAt1");
		String Direccion = request.getParameter("txtDireccion1");
		String Correo =  request.getParameter("txtCorreo1");
		String Fecha = request.getParameter("dtFecha1");
        String Distrito = request.getParameter("txtDistrito1");
        String Provincia = request.getParameter("txtProvincia1");
        String Departamento = request.getParameter("txtDepartamento1");
        int Celular = Integer.parseInt(request.getParameter("txtCelular1"));
        int Referencia = Integer.parseInt(request.getParameter("txtReferencia1"));
        int Cod = Integer.parseInt(request.getParameter("txtCod"));
       
        String fecReg = sdf.format(fecha);
        int ases = 0;
        
        ases = as.ActuaizarEmpleado(DNI, Nombre, Apellido1, Apellido2, Direccion, Fecha, Correo, Referencia, Celular, Distrito, Provincia, Departamento, Cod);
    	if (ases != 0) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/MantenerEmpleado.jsp");

			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/MantenerEmpleado.jsp");

			rd.forward(request, response);
		}

	}

	private void listaEmpleado(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		 ArrayList<AsesorDTO> lista = as.ListarAsesor();
		 
		RequestDispatcher rd = request.getRequestDispatcher("/ListaEmpleado.jsp");
			
		HttpSession  session = request.getSession();
		session.setAttribute("listados", lista);
		
	
		rd.forward(request, response);
	}

		
	

	private void registraEmpleado(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String DNI = request.getParameter("txtDNI");
		String Nombre = request.getParameter("txtNombre1");
		String Apellido1 = request.getParameter("txtApePat");
		String Apellido2 = request.getParameter("txtApeMAt");
		String Direccion = request.getParameter("txtDireccion");
		String Correo =  request.getParameter("txtCorreo");
		String Fecha = request.getParameter("dtFecha");
        String Distrito = request.getParameter("txtDistrito");
        String Provincia = request.getParameter("txtProvincia");
        String Departamento = request.getParameter("txtDepartamento");
        int Celular = Integer.parseInt(request.getParameter("txtCelular"));
        int Referencia = Integer.parseInt(request.getParameter("txtReferencia"));
       
        
        String fecReg = sdf.format(fecha);
        int ases = 0;
        ases = as.registarAsesor(DNI, Nombre, Apellido1, Apellido2, Direccion, Fecha, Correo, Referencia, Celular, Distrito, Provincia, Departamento);
        
        if (ases != 0) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/MantenerEmpleado.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("Asesor", ases);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/MantenerEmpleado.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("Error De insercion ", "error");
			rd.forward(request, response);
		}

	}

}
