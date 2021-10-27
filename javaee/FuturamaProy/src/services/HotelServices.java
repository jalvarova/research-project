package services;

import interfaces.ClientesDAO;
import interfaces.HotelDAO;

import java.util.List;

import dao.DAOFactory;
import beanDTO.HotelDTO;

public class HotelServices {
	DAOFactory fabrica = DAOFactory.getDaoFactory(1);
	// instanciar las rutinas usando la fuente
	HotelDAO objHotelesDAO=fabrica.getHotelDAO();

	
	public List<HotelDTO> listaHotel(int cod_Hotel){
		
		return objHotelesDAO.listaHotele(cod_Hotel);
		
	}
}
