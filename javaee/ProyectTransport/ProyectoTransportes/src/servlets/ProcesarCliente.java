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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.ClienteDTO;
import services.ServicioCliente;

@WebServlet("/ProcesarCliente")
public class ProcesarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		String ubicacionEjec = getServletContext().getRealPath("/");
		String cli = request.getParameter("c");
		int finalCadena = ubicacionEjec.indexOf(".metadata");
		String ubicacionProy = ubicacionEjec.substring(0, finalCadena);
		String guardarEn = ubicacionProy.toString()+"ProyectoTransportes"+File.separator+"WebContent"+File.separator+"images"+File.separator;
		ServicioCliente ser = new ServicioCliente();
		@SuppressWarnings("unused")
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String isClicked=null;
		String usu=null;
		String contra=null;
		String nom=null;
		String apep=null;
		String apem=null;
		String fecha =null;
		String sexo=null;
		String email=null;
		int estado=0;
		int tel=0;
		String ciudad=null;
		String tipoDoc=null;
		int nroDoc=0;
		String itemName = null;
		
		ArrayList<ClienteDTO>lista=ser.getlistadoclientes();
		String cod="";
		int ultimoCod =	Integer.parseInt(lista.get(lista.size()-1).getCodigo().substring(2));
		if(ultimoCod<9) cod="CL00"+(ultimoCod+1);
		else if(ultimoCod<99) cod="CL0"+(ultimoCod+1);
		else if(ultimoCod<999) cod="CL"+(ultimoCod+1);
		
		if(!isMultiPart){
			System.out.println("No se presiono boton");
			if(cli!=null){
				int rs = ser.eliminarCliente(cli);
				if(rs != 0){	
					request.setAttribute("mensaje", "Cliente Eliminado");	
				}
				else{	
					request.setAttribute("mensaje", "Error al Eliminar Cliente");	
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
					if(nombreCampo.equalsIgnoreCase("codigo")){
						cod=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("nombre")){
						nom=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("apellido_paterno")){
						apep=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("apellido_materno")){
						apem=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("sexo")){
						sexo=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("f_n")){
						fecha=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("e-mail")){
						email=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("telefono")){
						tel=Integer.parseInt(valorCampo);
					}
					else if(nombreCampo.equalsIgnoreCase("cboCiudad")){
						ciudad=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("cboTipoDocumento")){
						tipoDoc=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("nro_documento")){
						nroDoc=Integer.parseInt(valorCampo);
					}
					else if(nombreCampo.equalsIgnoreCase("usuario")){
						usu=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("contraseña")){
						contra=valorCampo;
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
			byte[] fotito; 
			if(itemName.isEmpty()){
				File defecto = new File(guardarEn,"personaPorDefecto.jpg");
				String fotoDefecto = defecto.getName();
				fotito = fotoDefecto.getBytes();
			}else{
				fotito=itemName.getBytes();
			}
			
			if(isClicked.equals("Registrar")){
				int rs=ser.registrarCliente(cod, nom, apep, apem, tipoDoc, nroDoc, sexo, email, tel, fecha, ciudad,fotito, 0, usu, contra);
				if(rs!=0){
					int ultimoCodR =Integer.parseInt(cod.substring(2));
					if(ultimoCodR<9) cod="CL00"+(ultimoCodR+1);
					else if(ultimoCodR<99) cod="CL0"+(ultimoCodR+1);		
					else if(ultimoCodR<999) cod="CL"+(ultimoCodR+1);
					request.setAttribute("mensaje", "Cliente Registrado");
				}else{
					File deleteFile = new File(guardarEn, itemName);
					deleteFile.delete();
					request.setAttribute("mensaje", "Error al Ingresar Cliente");
				}
			}
			else if(isClicked.equals("Actualizar")){
				int rs=ser.actualizarCliente(cod, nom, apep, apem, tipoDoc, nroDoc, sexo, email, tel, fecha, ciudad,fotito, estado,contra);
				if(rs!=0){
					request.setAttribute("mensaje", "Cliente Actualizado");
				}else{
					File deleteFile = new File(guardarEn, itemName);
					deleteFile.delete();
					request.setAttribute("mensaje", "Error al actualizar");
				}
			}
		}
		lista=ser.getlistadoclientes();
		HttpSession sesion=request.getSession();
		RequestDispatcher rd=request.getRequestDispatcher("/MantenerCliente.jsp?cod="+cod);
		sesion.setAttribute("listacli", lista);
		rd.forward(request, response);
	}
}