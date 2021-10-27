package servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.BusDTO;
import services.BusService;

@WebServlet("/ProcesarBus")
public class ProcesarBus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bus = request.getParameter("b");
		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		
		BusService servicio = new BusService();
		String ubicacionEjec = getServletContext().getRealPath("/");
		
		int finalCadena = ubicacionEjec.indexOf(".metadata");
		String ubicacionProy = ubicacionEjec.substring(0, finalCadena);
		String guardarEn = ubicacionProy.toString()+"ProyectoTransportes"+File.separator+"WebContent"+File.separator+"images"+File.separator;
		
		String tipoBus = null;
		String placa = null;
		String anio = null;
		String marca = null;
		String asientos = null;
		String itemName = null;
		String isClicked = null;
		
		if(!isMultiPart){
			System.out.println("OK");
			ArrayList<BusDTO> lista = servicio.listarBuses();
			request.setAttribute("listaBuses", lista);
			System.out.println(!isMultiPart);
			if(bus!=null){
				int rs = servicio.eliminarBus(bus);
				if (rs != 0) {
					request.setAttribute("msj", "Bus Eliminado");
				}else {
					request.setAttribute("msj", "Error al Eliminar Bus");
				}
			}		
		}else{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024);
			factory.setRepository(new File(guardarEn));
			
			ServletFileUpload sfu = new ServletFileUpload(factory);
			@SuppressWarnings("rawtypes")
			List items = null;
			
			try{
				items = sfu.parseRequest(request);
			}catch(FileUploadException e){
				e.printStackTrace();
			}
			
			@SuppressWarnings("rawtypes")
			Iterator itr =items.iterator();
			while(itr.hasNext()){
				FileItem item = (FileItem)itr.next();
				if(item.isFormField()){
					String nombreCampo = item.getFieldName();
					String valorCampo = item.getString();
					if(nombreCampo.equalsIgnoreCase("cboTipoBus")){
						tipoBus=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtNumeroPlaca")){
						placa=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtAnioFabricacion")){
						anio=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtMarca")){
						marca=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtNumAsientos")){
						asientos=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("btnProcesar")){
						isClicked=valorCampo;
					}
				}
				else{
					try{
						itemName = item.getName();
						System.out.println();
						if(itemName.equalsIgnoreCase("")){
								System.out.println("Nada se debe guardar");
						}else{
							File savedFile = new File(guardarEn, itemName);
							item.write(savedFile);	
						}		
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			byte[] fotoEnBytes;
			if(itemName.isEmpty()){
				File defecto = new File(guardarEn,"busesPorDefecto.jpg");
				String fotoDefecto = defecto.getName();
				fotoEnBytes = fotoDefecto.getBytes();
			}else{
				fotoEnBytes = itemName.getBytes();
			}

			if(isClicked.equals("Registrar")){
				int rs = servicio.registrarBus(placa, anio, marca, asientos, tipoBus, 0, fotoEnBytes);	
				if (rs != 0) {
					request.setAttribute("msj", "Bus Registrado");
				} else {
					File deleteFile = new File(guardarEn, itemName);
					deleteFile.delete();
					request.setAttribute("msj", "Error al Registrar Bus");
				}
			}
			else if(isClicked.equals("Actualizar")){
				int rs = servicio.actualizarBus(placa, anio, marca, asientos, tipoBus,0, fotoEnBytes);
				
				if (rs != 0) {
					request.setAttribute("msj", "Bus Actualizado");
				} else {
					File deleteFile = new File(guardarEn, itemName);
					deleteFile.delete();
					request.setAttribute("msj", "Error al Actualizar Bus");
				}
			}
		}
		
		
		
		HttpSession sesion = request.getSession();
		ArrayList<BusDTO>lista=servicio.listarBuses();
		RequestDispatcher rd = request.getRequestDispatcher("/MantenerBus.jsp");
		sesion.setAttribute("listaBus", lista);
		rd.forward(request, response);	
	}
}