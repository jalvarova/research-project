package services;

import interfaces.TipoServicioDAO;

import java.util.ArrayList;

import dao.DAOFactory;
import beans.TipoServicioDTO;

public class TipoServicioService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	TipoServicioDAO objDAO = fabrica.getTipoServicioDAO();
	
	public ArrayList<TipoServicioDTO> getTipoServicio(){
		return objDAO.getTipoServicio();
	}
	
	public TipoServicioDTO getTipoServicio(String id){
		return objDAO.getTipoServicio(id);
	}

}
