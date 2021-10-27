package services;

import java.util.ArrayList;

import beans.RecursoDTO;
import interfaces.RecursoDAO;
import dao.DAOFactory;

public class RecursoService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	RecursoDAO objDAO = fabrica.getRecursoDAO();
	
	public RecursoDTO getRecurso(String codRuta) {
		return objDAO.getRecurso(codRuta);
		
	}
	public ArrayList<RecursoDTO> getRecursos(){
		return objDAO.getRecursos();
	}
	
	public RecursoDTO obtenerRecurso(String cod){
		return objDAO.obtenerRecurso(cod);
	}
	
	public int registrarRecurso(String codRec, String codChofer, String codTerra,
			String codBus, String codRuta, int estado){
		return objDAO.registrarRecurso(codRec, codChofer, codTerra, codBus, codRuta, estado);
	}
	
	public int actualizarRecurso(String codRec, String codChofer, String codTerra,
			String codBus, String codRuta, int estado){
		return objDAO.actualizarRecurso(codRec, codChofer, codTerra, codBus, codRuta, estado);
	}
	
	public int eliminarRecurso(String cod){
		return objDAO.eliminarRecurso(cod);
	}
}