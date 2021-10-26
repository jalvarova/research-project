package pe.edu.galaxy.training.ws.rest.persistencia.inf;

import pe.edu.galaxy.training.ws.rest.entidad.Cliente;
import pe.edu.galaxy.training.ws.rest.entidad.User;
import pe.edu.galaxy.training.ws.rest.persistencia.GenericDAO;
import pe.edu.galaxy.training.ws.rest.persistencia.exception.DAOException;

public interface UserDAO extends GenericDAO<Cliente> {

	public User validateAccess(String user, String password)
			throws DAOException;
}
