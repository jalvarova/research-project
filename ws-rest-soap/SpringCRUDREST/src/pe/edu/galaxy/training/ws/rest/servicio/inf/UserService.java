package pe.edu.galaxy.training.ws.rest.servicio.inf;

import pe.edu.galaxy.training.ws.rest.entidad.User;
import pe.edu.galaxy.training.ws.rest.entidad.Vehiculo;
import pe.edu.galaxy.training.ws.rest.servicio.GenericService;
import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;

public interface UserService extends GenericService<Vehiculo> {
	public User validateAccess(String user, String password)
			throws ServiceException;

}