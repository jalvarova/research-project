package pe.edu.galaxy.training.ws.rest.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.ws.rest.entidad.User;
import pe.edu.galaxy.training.ws.rest.entidad.Vehiculo;
import pe.edu.galaxy.training.ws.rest.persistencia.exception.DAOException;
import pe.edu.galaxy.training.ws.rest.persistencia.inf.UserDAO;
import pe.edu.galaxy.training.ws.rest.persistencia.inf.VehiculoDAO;
import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.servicio.inf.UserService;
import pe.edu.galaxy.training.ws.rest.servicio.inf.VehiculoService;
import pe.edu.galaxy.training.ws.rest.util.UtilEncrypt;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
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
	public User validateAccess(String user, String password)
			throws ServiceException {
		
		try {
			return userDAO.validateAccess(user, UtilEncrypt.decrypt(password));
		} catch (Exception e) {
			throw new ServiceException();
		}
	}

}
