package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanDTO.ClientesDTO;
import services.ClientesServices;
import util.MySQLConexion;

/**
 * Servlet implementation class RegistraContactos
 */
@WebServlet("/RegistraContactos")
public class RegistraContactos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientesServices cs  = new  ClientesServices(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraContactos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Procesar(request,response);
		
	}

	

		//AgragaContacto();
		
	
	/*private void AgragaContacto() {

		ClientesDTO c = null;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "insert  into tb_clientes (cod_clie,nom_clie,apePat_clie,apeMat_clie,numTelfijo_clie,numCel_clie,correo_clie) values (?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, c.getCod_clie());
			ps.setString(2, nombre);
			ps.setString(3, apellido1);
			ps.setString(4, apellido2);
			ps.setString(5, numero1);
			ps.setString(6, numero2);
			ps.setString(7, correo);

			rs = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("erros de Consulta ");
		} finally {
			try {
				if (ps != null && conn != null) {
					ps.close();
					conn.close();

				}
			} catch (Exception e2) {
				System.out.println("Error al Cerrar");
			}

		}
		return rs;
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Procesar(request,response);
	}

		private void Procesar(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			String opcion  = request.getParameter("opcion");
			
			switch (opcion) {
			case "registra":
				registraContacto(request,response);
				break;

			}
			
		}
		private void registraContacto(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
			
			
			
			
			String DNI = request.getParameter("txtDni");
			String Nombre = request.getParameter("txtNombre");
			String Apellido1 = request.getParameter("txtApellido_Paterno");
			String Apellido2 = request.getParameter("txtApellido_Materno");
			int Numero1 = Integer.parseInt(request.getParameter("txtTelefono"));
			int Numero2 = Integer.parseInt(request.getParameter("txtReferencia"));
			String Correo = request.getParameter("txtEmail");
	      
		
			int	clie =	cs.RegistrarContacto(DNI, Nombre, Apellido1, Apellido2, Correo, Numero1, Numero2);
			
			if(clie != 0){
				RequestDispatcher rd =request.getRequestDispatcher("/index.jsp");
			
				rd.forward(request, response);
				
			}else {
				RequestDispatcher rd =request.getRequestDispatcher("/index.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("Error", "Error al ingresar Datos");
				rd.forward(request, response);
			}
		}

}
