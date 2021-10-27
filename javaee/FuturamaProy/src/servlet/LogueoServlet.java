package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.MySQLConexion;
import beanDTO.UsuarioDTO;

/**
 * Servlet implementation class LogueoServlet
 */
@WebServlet("/LogueoServlet")
public class LogueoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogueoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logueo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logueo(request, response);
	}

	private void logueo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("txtUsuario");
		String contrasena = request.getParameter("txtContraseña");

		UsuarioDTO x = validarUsuario(usuario, contrasena);

		if (x != null) {
			HttpSession session = request.getSession();
			session.setAttribute("sesionUsuario", x.getNombre());
			RequestDispatcher rd = request.getRequestDispatcher("/principal.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/Logueo.jsp");
			request.setAttribute("msg", "Usuario no Existe!!!!!");
			rd.forward(request, response);
		}

	}

	private UsuarioDTO validarUsuario(String usuario, String contrasena) {

		UsuarioDTO x = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = MySQLConexion.getConexion();
			String sql = "select usuario,clave from tb_usuario where usuario=? and clave=?;";
			ps = conn.prepareStatement(sql);

			ps.setString(1, usuario);
			ps.setString(2, contrasena);

			rs = ps.executeQuery();
			if (rs.next()) {
				x = new UsuarioDTO(usuario, contrasena);
			}

		} catch (Exception e) {
			System.out.println("error en sentencia ");
		} finally {

			try {
				if (ps != null && conn != null) {
					ps.close();
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("error al cierre");

			}
		}
		return x;
	}

}
