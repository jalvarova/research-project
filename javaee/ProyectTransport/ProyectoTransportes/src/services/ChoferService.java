package services;

import interfaces.ChoferDAO;

import java.util.ArrayList;

import beans.ChoferDTO;
import dao.DAOFactory;

public class ChoferService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	ChoferDAO objChofer = fabrica.getChoferDAO();
	
	public int registrarChofer(String codigo, String nroLicencia, String nombre, String apePater,
			String apeMater, String tipoDocumento, String nroDocumentoID,
			String sexo, String fecNac, String email, String telefono,
			String ciudad, byte[] foto, int estado){
		return objChofer.registrarChofer(codigo, nroLicencia, nombre, apePater, apeMater, tipoDocumento, nroDocumentoID, sexo, fecNac, email, telefono, ciudad, foto, estado);
	}
	
	public int actualizarChofer(String codigo, String nroLicencia, String nombre, String apePater,
			String apeMater, String tipoDocumento, String nroDocumentoID,
			String sexo, String fecNac, String email, String telefono,
			String ciudad, byte[] foto, int estado){
		return objChofer.actualizaChofer(codigo, nroLicencia, nombre, apePater, apeMater, tipoDocumento, nroDocumentoID, sexo, fecNac, email, telefono, ciudad, foto, estado);
	}
	
	public int eliminarChofer(String codigo){
		return objChofer.eliminarChofer(codigo);
	}
	public ChoferDTO obtenerChofer(String codigo){
		return objChofer.obtenerChofer(codigo);
	}
	public ArrayList<ChoferDTO> listaChofer(){
		return objChofer.listaChofer();
	}
}