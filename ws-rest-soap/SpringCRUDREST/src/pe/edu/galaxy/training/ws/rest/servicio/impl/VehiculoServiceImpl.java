package pe.edu.galaxy.training.ws.rest.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.ws.rest.entidad.Vehiculo;
import pe.edu.galaxy.training.ws.rest.persistencia.inf.VehiculoDAO;
import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.servicio.inf.VehiculoService;

@Service("vehiculoService")
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	private VehiculoDAO vehiculoDAO;

	@Override
	public Vehiculo findByLicensePlate(String licensePlate)
			throws ServiceException {
		try {
			return vehiculoDAO.findByLicensePlate(licensePlate);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean insert(Vehiculo prmObject) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vehiculo prmObject) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Vehiculo prmObject) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vehiculo findByObject(Vehiculo prmObject) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehiculo> findByLikeObject(Vehiculo prmObject)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehiculo> findByYear(String year) throws ServiceException {

		try {
			return vehiculoDAO.findByYear(year);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
