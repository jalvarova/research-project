package pe.edu.galaxy.training.ws.rest.persistencia;

import java.util.List;

import pe.edu.galaxy.training.ws.rest.persistencia.exception.DAOException;

public interface GenericDAO<T> {
	
	public boolean 	insert(T prmObject) throws DAOException;

	public boolean 	update(T prmObject) throws DAOException;

	public boolean 	delete(T prmObject) throws DAOException;
	
	public T 	findByObject(T prmObject) throws DAOException;
	
	public List<T>  findByLikeObject(T prmObject) throws DAOException;

}
