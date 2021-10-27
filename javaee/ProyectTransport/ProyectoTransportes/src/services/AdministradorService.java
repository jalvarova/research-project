package services;

import beans.AdministradorDTO;
import interfaces.AdministradorDAO;
import dao.DAOFactory;

public class AdministradorService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	AdministradorDAO objUsuarioDao = fabrica.getAdministradorDAO();
	
	public AdministradorDTO validaAdministrador(String usuario, String clave){
		return objUsuarioDao.validaAdministrador(usuario, clave);
	}
}