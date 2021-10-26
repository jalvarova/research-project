package pe.edu.galaxy.training.ws.rest.servicio.inf;

import java.util.List;

import pe.edu.galaxy.training.ws.rest.entidad.Vehiculo;
import pe.edu.galaxy.training.ws.rest.servicio.GenericService;
import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;

public interface VehiculoService extends GenericService<Vehiculo> {
	public Vehiculo findByLicensePlate(String licensePlate)
			throws ServiceException;

	public List<Vehiculo> findByYear(String year) throws ServiceException;
}