package pe.edu.galaxy.training.ws.rest.persistencia.inf;

import java.util.List;

import pe.edu.galaxy.training.ws.rest.entidad.Vehiculo;
import pe.edu.galaxy.training.ws.rest.persistencia.GenericDAO;
import pe.edu.galaxy.training.ws.rest.persistencia.exception.DAOException;

public interface VehiculoDAO extends GenericDAO<Vehiculo> {

	public Vehiculo findByLicensePlate(String licensePlate)throws DAOException;
	
	public List<Vehiculo> findByYear(String year) throws DAOException;
}
