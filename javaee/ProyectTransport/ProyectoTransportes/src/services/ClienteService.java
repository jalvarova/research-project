package services;

import interfaces.ClienteDAO;
import beans.ClienteDTO;
import dao.DAOFactory;

public class ClienteService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	ClienteDAO objUsuarioDao = fabrica.getClienteDAO();
	
	public ClienteDTO validaCliente(String usuario, String clave){
		return objUsuarioDao.validaCliente(usuario, clave);
	}
}
