package services;

import java.util.ArrayList;

import beans.CiudadDTO;
import interfaces.CiudadDAO;
import dao.DAOFactory;

public class CiudadService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	CiudadDAO objCiudad = fabrica.getCiudadDAO();
	
	public ArrayList<CiudadDTO> listarCiudad(){
		return objCiudad.listarCiudad();
	}
}
