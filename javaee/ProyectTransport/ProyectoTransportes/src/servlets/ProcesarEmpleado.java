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

import services.ChoferService;
import services.TerramozaService;
import beans.ChoferDTO;
import beans.TerramozaDTO;

@WebServlet("/ProcesarEmpleado")
public class ProcesarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	private void procesar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chof = request.getParameter("c");
		String terra = request.getParameter("t");
		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		String ubicacionEjec = getServletContext().getRealPath("/");
		
		int finalCadena = ubicacionEjec.indexOf(".metadata");
		String ubicacionProy = ubicacionEjec.substring(0, finalCadena);
		String guardarEn = ubicacionProy.toString()+"ProyectoTransportes"+File.separator+"WebContent"+File.separator+"images"+File.separator;
		
		TerramozaService servicioTerramoza = new TerramozaService();
		ChoferService servicioChofer = new ChoferService();
		ArrayList<TerramozaDTO> listaT = servicioTerramoza.listaTerramoza();
		ArrayList<ChoferDTO> listaC = servicioChofer.listaChofer();
		
		String codigoC="";				
		int ultimoCodC =	Integer.parseInt(listaC.get(listaC.size()-1).getCodigo().substring(2));				
		if(ultimoCodC<9) codigoC="CH00"+(ultimoCodC+1);				
		else if(ultimoCodC<99) codigoC="CH0"+(ultimoCodC+1);				
		else if(ultimoCodC<999) codigoC="CH"+(ultimoCodC+1);
		
		String codigoT="";				
		int ultimoCodT =	Integer.parseInt(listaT.get(listaT.size()-1).getCodigo().substring(2));				
		if(ultimoCodT<9) codigoT="TE00"+(ultimoCodT+1);				
		else if(ultimoCodT<99) codigoT="TE0"+(ultimoCodT+1);				
		else if(ultimoCodT<999) codigoT="TE"+(ultimoCodT+1);
			
		String nombre = null;
		String nroLic = null;
		String apePat = null;
		String apeMat = null;
		String sexo = null;
		String fecNac = null;
		String email = null;
		String telefono = null;
		String ciudad = null;
		String tipoDoc = null;
		String nroDoc = null;
		String comando = null;
		String itemName = null;
		String botonPresionado = null;
		
		if(!isMultiPart){
			System.out.println("Primera vez que arranca");
			if(chof!=null){
				int rs = servicioChofer.eliminarChofer(chof);		
				if (rs != 0){
					request.setAttribute("Mensaje", "Chofer Eliminado");
				}else{
					request.setAttribute("Mensaje", "El Chofer No fue Eliminado");
				}
			}
			
			if(terra!=null){
				int rss = servicioTerramoza.eliminarTerramoza(terra);
				if (rss != 0){
					request.setAttribute("Mensaje", "Terramoza Eliminada");
				}else{				
					request.setAttribute("Mensaje", "La Terramoza no fue Eliminada");
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
					if(nombreCampo.equalsIgnoreCase("txtCodigoC")){
						codigoC=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtCodigoT")){
						codigoT=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtNombre")){
						nombre=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtNroLicen")){
						nroLic=valorCampo;
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
						telefono=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("cboCiudad")){
						ciudad=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("cboTipoDocumento")){
						tipoDoc=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("txtNroDoc")){
						nroDoc=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("cboTipo")){
						comando=valorCampo;
					}
					else if(nombreCampo.equalsIgnoreCase("btnProcesar")){
						botonPresionado=valorCampo;
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
			if(comando.equals("Chofer")){
				if(botonPresionado.equalsIgnoreCase("Registrar")){
					int rs = servicioChofer.registrarChofer(codigoC, nroLic, nombre, apePat, apeMat, tipoDoc, nroDoc, sexo, fecNac, email, telefono, ciudad, fotoEnBytes, 0);
					if (rs != 0){
						int ultimoCodCR =	Integer.parseInt(codigoC.substring(2));				
						if(ultimoCodCR<9) codigoC="CH00"+(ultimoCodCR+1);				
						else if(ultimoCodCR<99) codigoC="CH0"+(ultimoCodCR+1);				
						else if(ultimoCodCR<999) codigoC="CH"+(ultimoCodCR+1);
						request.setAttribute("Mensaje", "Chofer registrado");
					}
					else{
						File deleteFile = new File(guardarEn, itemName);
						deleteFile.delete();
						request.setAttribute("Mensaje", "El Chofer no fue registrado");
					}
				}
				else if(botonPresionado.equalsIgnoreCase("Actualizar")){
					int rs = servicioChofer.actualizarChofer(codigoC, nroLic, nombre, apePat, apeMat, tipoDoc, nroDoc, sexo, fecNac, email, telefono, ciudad, fotoEnBytes, 0);
					
					if (rs != 0)request.setAttribute("Mensaje", "Chofer actualizado");
					else {
						File deleteFile = new File(guardarEn, itemName);
						deleteFile.delete();
						request.setAttribute("Mensaje", "El Chofer no fue actualizado");
					}
				}
			}else if(comando.equals("Terramoza")){
				if(botonPresionado.equalsIgnoreCase("Registrar")){
					int rs = servicioTerramoza.registrarTerramoza(codigoT, nombre, apePat, apeMat, tipoDoc, nroDoc, sexo, fecNac, email, telefono, ciudad, fotoEnBytes, 0);

					if (rs != 0){
						int ultimoCodTR =	Integer.parseInt(codigoT.substring(2));				
						if(ultimoCodTR<9) codigoT="CH00"+(ultimoCodTR+1);				
						else if(ultimoCodTR<99) codigoT="CH0"+(ultimoCodTR+1);				
						else if(ultimoCodTR<999) codigoT="CH"+(ultimoCodTR+1);
						request.setAttribute("Mensaje", "Terramoza registrado");
					}
					else {
						File deleteFile = new File(guardarEn, itemName);
						deleteFile.delete();
						request.setAttribute("Mensaje", "La Terramoza no fue registrado");
					}
				}
				else if(botonPresionado.equalsIgnoreCase("Actualizar")){
					int rs = servicioTerramoza.actualizaTerramoza(codigoT, nombre, apePat, apeMat, tipoDoc, nroDoc, sexo, fecNac, email, telefono, ciudad, fotoEnBytes, 0);
		
					if (rs != 0)request.setAttribute("Mensaje", "Terramoza actualizado");
					else {
						File deleteFile = new File(guardarEn, itemName);
						deleteFile.delete();
						request.setAttribute("Mensaje", "La Terramoza no fue Actualizada");
					}
				}
			}else{
				request.setAttribute("Mensaje", "Debe elegir un Tipo de Trabajador");
			}
				System.out.println("presione boton: "+botonPresionado);		
		}
				
		listaT = servicioTerramoza.listaTerramoza();
		listaC = servicioChofer.listaChofer();
		RequestDispatcher rd = request.getRequestDispatcher("/MantenerEmpleado.jsp?codigoC="+codigoC+"&codigoT="+codigoT);

		HttpSession misesion = request.getSession();
		misesion.setAttribute("lstTerra", listaT);
		misesion.setAttribute("lstChofer", listaC);
		
		rd.forward(request, response);
	}
}