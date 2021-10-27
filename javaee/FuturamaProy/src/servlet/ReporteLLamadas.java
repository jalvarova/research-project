package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import beanDTO.LLamaditas;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import services.ServicioLlamada;
import util.MySQLConexion;

/**
 * Servlet implementation class ReporteLLamadas
 */
@WebServlet("/ReporteLLamadas")
public class ReporteLLamadas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReporteLLamadas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws ServletException
	 * @throws IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		procesar(request, response);

	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String opcion = request.getParameter("opcion"); // viene del hidden

		switch (opcion) {
		case "Reporte":
			ReporteLlamadita(request, response);
			break;
		case "Registra":
			RegistraLLamada(request, response);
			break;
			
			
		}

	}

	private void RegistraLLamada(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServicioLlamada sl = new  ServicioLlamada();
		int num=Integer.parseInt(request.getParameter("txtNumero"));
		String obs=request.getParameter("txtObservacion");
		int cod2=Integer.parseInt(request.getParameter("cboMotivo"));
		String dni=request.getParameter("txtDniCli");
		int cod3 =Integer.parseInt(request.getParameter("txtCodigo"));
		
		
	//response.getOutputStream():
		int llamada  = sl.Llamadaregistrada( num, obs, cod2, dni, cod3);
		
		if (llamada != 0) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/registroVentas.jsp");

			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/marcador.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("listado", llamada);
			session.setAttribute("Error de Listado", "error");
			rd.forward(request, response);
		}

	}

	private void ReporteLlamadita(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServicioLlamada sl = new ServicioLlamada();

		ArrayList<LLamaditas> llamada = sl.ListaLlamada();

		HttpSession session = request.getSession();
		session.setAttribute("listado", llamada);
		if (llamada != null) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/listaReporte.jsp");

			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/listaReporte.jsp");
			session.setAttribute("Error de Listado", "error");
			rd.forward(request, response);
		}

		/*
		 * Connection conn = MySQLConexion.getConexion();
		 * 
		 * 
		 * /* String sql = "select * from v_LamadasResalizadas";
		 * PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs =
		 * ps.executeQuery();
		 * 
		 * if (rs.next()) {
		 */

		// try {
		// //JasperReport reporte = (JasperReport)
		// JRLoader.loadObject("reporte2.jasper");
		//
		// File report = new File("D:/Report/RLlamadas.jasper");
		// System.out.println("Hola1");
		// HashMap<String, Object> param = new HashMap<String, Object>();
		//
		// System.out.println("Hola2");
		//
		// byte [] bytes =
		// JasperRunManager.runReportToPdf("D:/Report/RLlamadas.jasper",
		// param,new JREmptyDataSource());
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		//
		// } catch (Exception e) {
		// System.out.println ("FalloReport"+e.toString());
		// }
		//

		/*
		 * response.setContentType("application/pdf");
		 * 
		 * ServletOutputStream out = response.getOutputStream();
		 * 
		 * try { JasperReport reporte = (JasperReport)
		 * JRLoader.loadObject(getServletContext
		 * ().getRealPath("Report/RLlamadas.jasper"));
		 * 
		 * Map parametros = new HashMap(); parametros.put("autor", "Juan");
		 * parametros.put("titulo", "Reporte");
		 * 
		 * JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,
		 * parametros);
		 * 
		 * JRExporter exporter = new JRPdfExporter();
		 * exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		 * exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
		 * exporter.exportReport(); } catch (Exception e) { e.printStackTrace();
		 * }
		 */

	}

	/**
	 * @throws ServletException
	 * @throws IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		procesar(request, response);

	}

}
