package pe.edu.galaxy.training.ws.rest.servicio;
import java.util.List;

import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;

public interface GenericService<T> {
	
	public boolean 	insert(T prmObject) throws ServiceException;

	public boolean 	update(T prmObject) throws ServiceException;

	public boolean 	delete(T prmObject)throws ServiceException;
	
	public T findByObject(T prmObject)throws ServiceException;
	
	public List<T> findByLikeObject(T prmObject)throws ServiceException;

}
