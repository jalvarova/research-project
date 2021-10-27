package services;

import interfaces.MotivoDAO;
import interfaces.VentasDAO;

import java.util.ArrayList;

import dao.DAOFactory;
import beanDTO.MotivoDTO;

public class MotivoService {

	private DAOFactory fabrica = DAOFactory.getDaoFactory(1);
	// instanciar las rutinas usando la fuente
	private MotivoDAO objMotivoDAO=fabrica.getMotivoDAO();
	
	public ArrayList<MotivoDTO> listaMotivo(){
		
		return objMotivoDAO.listaMotivo();
	}
}
