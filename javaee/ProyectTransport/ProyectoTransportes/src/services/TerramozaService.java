package services;

import java.util.ArrayList;

import beans.TerramozaDTO;
import dao.DAOFactory;
import interfaces.TerramozaDAO;

public class TerramozaService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	TerramozaDAO objTerra = fabrica.getTerramozaDAO();
	
	public int registrarTerramoza(String codigo, String nombre, String apePater, String apeMater,
			String tipoDocumento, String nroDocumentoID, String sexo,
			String fecNac, String email, String telefono,
			String ciudad,byte[] foto,int estado){
		return objTerra.registrarTerramoza(codigo, nombre, apePater, apeMater, tipoDocumento, nroDocumentoID, sexo, fecNac, email, telefono, ciudad, foto, estado);
	}
	
	public int actualizaTerramoza(String codigo, String nombre, String apePater, String apeMater,
			String tipoDocumento, String nroDocumentoID, String sexo,
			String fecNac, String email, String telefono,
			String ciudad,byte[] foto,int estado){
		return objTerra.actualizaTerramoza(codigo, nombre, apePater, apeMater, tipoDocumento, nroDocumentoID, sexo, fecNac, email, telefono, ciudad, foto, estado);
	}
	
	public int eliminarTerramoza(String codigo){
		return objTerra.eliminarTerramoza(codigo);
	}
	public TerramozaDTO obtenerTerramoza(String codigo){
		return objTerra.obtenerTerramoza(codigo);
	}
	public ArrayList<TerramozaDTO> listaTerramoza(){
		return objTerra.listaTerramoza();
	}
}