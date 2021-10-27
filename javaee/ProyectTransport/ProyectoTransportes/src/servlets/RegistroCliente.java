package servlets;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import services.ServicioCliente;
import beans.ClienteDTO;

@WebServlet("/RegistroCliente")
public class RegistroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		
		String ubicacionEjec = getServletContext().getRealPath("/");
		
		int finalCadena = ubicacionEjec.indexOf(".metadata");
		String ubicacionProy = ubicacionEjec.substring(0, finalCadena);
		String guardarEn = ubicacionProy.toString()+"ProyectoTransportes"+File.separator+"WebContent"+File.separator+"images"+File.separator;
		@SuppressWarnings("unused")
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String usuario = null;
		String clave = null;
		@SuppressWarnings("unused")
		String clave2 = null;
		String nombre = null;
		String apePat = null;
		String apeMat = null;
		String sexo = null;
		String fecNac = null;
		String email = null;
		int telefono = 0;
		String ciudad = null;
		String tipoDoc = null;
		int nroDoc = 0;
		String itemName = null;
		String codigo = "";
		ServicioCliente servicio = new ServicioCliente();
		
		ArrayList<ClienteDTO> cli = servicio.getlistadoclientes();
		int ultimoCod =	Integer.parseInt(cli.get(cli.size()-1).getCodigo().substring(2));
		if(ultimoCod<9) codigo="CL00"+(ultimoCod+1);
		else if(ultimoCod<99) codigo="CL0"+(ultimoCod+1);
		else if(ultimoCod<999) codigo="CL"+(ultimoCod+1);
		
		if(isMultiPart){
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
					if(nombreCampo.equalsIgnoreCase("txtUsuario")){
						usuario=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtClave")){
						clave=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtClave2")){
						clave2=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtNombre")){
						nombre=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtApellidoP")){
						apePat=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtApellidoM")){
						apeMat=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("cboSexo")){
						sexo=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtFechaNac")){
						fecNac=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtEmail")){
						email=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtTelefono")){
						telefono=Integer.parseInt(valorCampo);
					}
					else if(nombreCampo.equalsIgnoreCase("cboCiudad")){
						ciudad=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("cboTipoDocumento")){
						tipoDoc=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtNroDoc")){
						nroDoc=Integer.parseInt(valorCampo);
					}
					System.out.println(nombreCampo+" "+valorCampo);
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
				File defecto = new File(guardarEn,"personaPorDefecto.jpg");
				String fotoDefecto = defecto.getName();
				fotoEnBytes = fotoDefecto.getBytes();
			}else{
				fotoEnBytes = itemName.getBytes();
			}
			
			int rs= servicio.registrarCliente(codigo, nombre, apePat, apeMat, tipoDoc, nroDoc, sexo, email, telefono, fecNac, ciudad, fotoEnBytes, 0, usuario, clave);

			if (rs != 0) {
				request.setAttribute("msj", "Su cuenta se ha registrado correctamente");
			}
			else {
				File deleteFile = new File(guardarEn, itemName);
				deleteFile.delete();
				request.setAttribute("msj", "Uno de los campos no es válido");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/RegistroCliente.jsp");
		rd.forward(request, response);
	}
}