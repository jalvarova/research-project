package services;

import java.util.ArrayList;
import java.util.List;

import beans.CiudadDTO;
import beans.RutaDTO;
import interfaces.RutaDAO;
import dao.DAOFactory;

public class RutaService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	RutaDAO objRutaDAO = fabrica.getRutaDAO();
	
	public boolean validaRuta(String codRuta){
		return objRutaDAO.validaRuta(codRuta);
	}
	
	public List<RutaDTO> getListadoRutas(){
		return objRutaDAO.getListadoRutas();
	}
	
	public ArrayList<CiudadDTO> getCiudadesOrigen(){
		return objRutaDAO.getCiudadesOrigen();
	}
	public ArrayList<CiudadDTO> getCiudadesDestino(String codCiudad){
		return objRutaDAO.getCiudadesDestino(codCiudad);
	}
	public RutaDTO getRuta(String origen, String destino){
		return objRutaDAO.getRuta(origen, destino);
	}
	
	public RutaDTO getRuta(String codigo){
		return objRutaDAO.getRuta(codigo);
	}
	
	public CiudadDTO getCiudad(String codigo){
		return objRutaDAO.getCiudad(codigo);
	}
	public int agregarRuta(RutaDTO r){
		return objRutaDAO.agregarRuta(r);
	}
	
	public int modificarRuta(RutaDTO r){
		return objRutaDAO.modificarRuta(r);
	}
	
	public int eliminarRuta(String r){
		return objRutaDAO.eliminarRuta(r);
	}
}