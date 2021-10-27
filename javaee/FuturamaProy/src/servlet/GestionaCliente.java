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

import beanDTO.ClientesDTO;
import services.ClientesServices;

/**
 * Servlet implementation class GestionaCliente
 */
@WebServlet("/GestionaCliente")
public class GestionaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClientesServices gs = new ClientesServices();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionaCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		procesar(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);

	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		switch (opcion) {
		case "registro":
			RegistraCLiente(request, response);
			break;
		case "lista":
			ListaClientes(request, response);
			break;
		case "actualizar":
			ActualizarCliente(request, response);
			break;
		case "eliminar":
			EliminarCliente(request, response);
			break;
		case "busca":
			BuscaCliente(request, response);
			break;
		case "buscalista":
			BuscarListaClientes(request, response);
			break;
		}

	}

	private void BuscarListaClientes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ClientesServices cs = new ClientesServices();

		ArrayList<ClientesDTO> lis = cs.ListarClientes();

		HttpSession session = request.getSession();
		session.setAttribute("lis", lis);

		if (lis != null) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/BuscarCliente.jsp");
			

			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/BuscarCliente.jsp");
			session.setAttribute("Error de Listado", "error");
			rd.forward(request, response);
		}
	}

	private void BuscaCliente(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String dni = request.getParameter("txtDni2");
		ClientesDTO cli = gs.buscarCliente(dni);

		request.setAttribute("numDocumento", cli.getNumIdentidad_clie());
		request.setAttribute("nombre", cli.getNom_clie());
		request.setAttribute("apePat", cli.getApePat_clie());
		request.setAttribute("apeMat", cli.getApeMat_clie());
		request.setAttribute("direcc", cli.getDirecc_clie());
		request.setAttribute("fecNac", cli.getFechNac_clie());
		request.setAttribute("correo", cli.getCorreo_clie());
		request.setAttribute("tel", cli.getNumTrabajo_clie());
		request.setAttribute("cel", cli.getNumCel_clie());
		request.setAttribute("fijo", cli.getNumTelfijo_clie());
		request.setAttribute("dis", cli.getDistrito_clie());
		request.setAttribute("pro", cli.getProvincia_clie());
		request.setAttribute("dep", cli.getDepartamento_clie());

		request.getRequestDispatcher("/MantenerCliente.jsp").forward(request,
				response);

	}

	private void EliminarCliente(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		String doc = request.getParameter("txtDNI2");
		gs.Eliminar(doc);

		RequestDispatcher rd = request
				.getRequestDispatcher("/MantenerCliente.jsp");

		HttpSession session = request.getSession();

		rd.forward(request, response);
	}

	private void ActualizarCliente(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String DNI = request.getParameter("txtDNI1");
		String Nombre = request.getParameter("txtNombre2");
		String Apellido1 = request.getParameter("txtApePat1");
		String Apellido2 = request.getParameter("txtApeMAt1");
		String Direccion = request.getParameter("txtDireccion1");
		String Correo = request.getParameter("txtCorreo1");
		String Fecha = request.getParameter("dtFecha1");
		int fijo = Integer.parseInt(request.getParameter("txtFijo1"));
		int Celular = Integer.parseInt(request.getParameter("txtCelular1"));
		int Referencia = Integer.parseInt(request
				.getParameter("txtReferencia1"));
		String Distrito = request.getParameter("txtDistrito1");
		String Provincia = request.getParameter("txtProvincia1");
		String Departamento = request.getParameter("txtDepartamento1");
		String fecReg = sdf.format(fecha);
		
		ClientesDTO c = new ClientesDTO(DNI, Nombre, Apellido1, Apellido2, Direccion, Fecha, Correo, Referencia, Celular, fijo,Distrito,Provincia,Departamento);
		
		int cli = gs.ActuaizarCliente(DNI, Nombre, Apellido1, Apellido2, Direccion, Fecha, Correo, Referencia, Celular, fijo, Distrito, Provincia, Departamento);
		
		
	
		
		if (cli != 0) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/MantenerCliente.jsp");

			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/MantenerCliente.jsp");

			rd.forward(request, response);
		}

	}

	private void ListaClientes(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ClientesServices cs = new ClientesServices();

		ArrayList<ClientesDTO> lista = cs.ListarClientes();

		RequestDispatcher rd = request
				.getRequestDispatcher("/ListaClientes.jsp");

		HttpSession session = request.getSession();
		session.setAttribute("listado", lista);

		rd.forward(request, response);

	}

	private void RegistraCLiente(HttpServletRequest request,

	HttpServletResponse response) throws ServletException, IOException {

		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String DNI = request.getParameter("txtDNI");
		String Nombre = request.getParameter("txtNombre1");
		String Apellido1 = request.getParameter("txtApePat");
		String Apellido2 = request.getParameter("txtApeMAt");
		String Direccion = request.getParameter("txtDireccion");
		String Correo = request.getParameter("txtCorreo");
		String Fecha = request.getParameter("dtFecha");
		String Distrito = request.getParameter("txtDistrito");
		String Provincia = request.getParameter("txtProvincia");
		String Departamento = request.getParameter("txtDepartamento");
		int fijo = Integer.parseInt(request.getParameter("txtFijo"));
		int Celular = Integer.parseInt(request.getParameter("txtCelular"));
		int Referencia = Integer.parseInt(request.getParameter("txtReferencia"));

		String fecReg = sdf.format(fecha);

		int cli = gs.registarCLientes(DNI, Nombre, Apellido1, Apellido2,
				Direccion, Fecha, Correo, Referencia, Celular, fijo, Distrito,
				Provincia, Departamento);
		if (cli != 0) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/MantenerCliente.jsp");

			HttpSession session = request.getSession();
			session.setAttribute("Cliente", cli);
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/MantenerCliente.jsp");

			HttpSession session = request.getSession();
			session.setAttribute("Error DE insercion ", "error");
			rd.forward(request, response);
		}

		/*
		 * } else {
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher("/Logueo.jsp");
		 * HttpSession session = request.getSession();
		 * session.setAttribute("Error de Session", "error");
		 * rd.forward(request, response);
		 * 
		 * }
		 */

		/*
		 * 
		 * RequestDispatcher rd =request.getRequestDispatcher("/index.jsp");
		 * HttpSession session = request.getSession();
		 * session.setAttribute("Contacto", x); rd.forward(request, response);
		 * 
		 * RequestDispatcher rd =request.getRequestDispatcher("/index.jsp");
		 * HttpSession session = request.getSession();
		 * session.setAttribute("Error", "Error al ingresar Datos");
		 * rd.forward(request, response);
		 */

	}

	/**
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param correo
	 * @param numero1
	 * @param numero2
	 * @param numero3
	 * @return
	 */

}
