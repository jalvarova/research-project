package services;

import interfaces.DistritoDAO;

import java.util.List;

import dao.DAOFactory;
import beanDTO.DistritoDTO;


public class DistritoService {
	
	DAOFactory  fabrica = DAOFactory.getDaoFactory(1);
	DistritoDAO  ObjDistritoDAO = fabrica.getDistritoDAO();
	public List<DistritoDTO> listadoDistrito(String cod_prov){
		
		
		
		return ObjDistritoDAO.listadoDistrito(cod_prov);
		
		
		
	}
}
