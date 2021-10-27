package services;

import interfaces.EstadoDAO;

import java.util.ArrayList;

import dao.DAOFactory;
import beanDTO.EstadoDTO;

public class EstadoServices {
	
	//creacion de la fuente de datos usada
private DAOFactory fabrica = DAOFactory.getDaoFactory(1);
// instanciar las rutinas usando la fuente
private EstadoDAO objEstadoDAO=fabrica.getEstadoDAO();
	public ArrayList<EstadoDTO> ListaEstado(){
		return objEstadoDAO.ListaEstado();
		
		
		
	}
}
