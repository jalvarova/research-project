package services;

import beans.BoletoDTO;
import interfaces.BoletoDAO;
import dao.DAOFactory;

public class BoletoService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	BoletoDAO objBoletoDao = fabrica.getBoletoDAO();
	
	public int registrarBoleto(BoletoDTO boleto){
		return objBoletoDao.registrarBoleto(boleto);
	}
	
	
	
}
