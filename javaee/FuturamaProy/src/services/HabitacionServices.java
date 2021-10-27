package services;

import interfaces.EstadoDAO;
import interfaces.HabitacionDAO;

import java.util.List;

import dao.DAOFactory;
import beanDTO.HabitacionDTO;

public class HabitacionServices {
	
	//creacion de la fuente de datos usada
DAOFactory fabrica = DAOFactory.getDaoFactory(1);
// instanciar las rutinas usando la fuente
HabitacionDAO objHabitacionDAO=fabrica.getHabitacionDAO();
	List<HabitacionDTO> listaHabitacione(int cod_hab){
		
		return objHabitacionDAO.listaHabitacione(cod_hab);
		
	}
}
