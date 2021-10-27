 package services;

import java.util.ArrayList;
import java.util.List;

import beanDTO.CampanaDTO;
import interfaces.CampanaDAO;
import dao.DAOFactory;

public class CampanaServicio {

	DAOFactory fabrica = DAOFactory.getDaoFactory(1);
	// instanciar las rutinas usando la fuente
	CampanaDAO objCampanaDAO = fabrica.getCampanaDAO();

	public List<CampanaDTO> ListarCampana() {
		List<CampanaDTO> cam = new ArrayList<CampanaDTO>();
		return objCampanaDAO.ListarCampana();
	}

}
