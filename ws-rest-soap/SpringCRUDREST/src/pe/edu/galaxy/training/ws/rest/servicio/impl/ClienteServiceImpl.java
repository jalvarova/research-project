package pe.edu.galaxy.training.ws.rest.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.ws.rest.entidad.Cliente;
import pe.edu.galaxy.training.ws.rest.persistencia.exception.DAOException;
import pe.edu.galaxy.training.ws.rest.persistencia.inf.ClienteDAO;
import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.servicio.inf.ClienteService;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {
	
	
	@Autowired
	private ClienteDAO clienteDAO; 

	public ClienteServiceImpl() {
	}



	@Override
	public boolean insert(Cliente cliente) throws ServiceException {
		try {
			return this.getClienteDAO().insert(cliente);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public boolean update(Cliente cliente) throws ServiceException {
		try {
			return this.getClienteDAO().update(cliente);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public boolean delete(Cliente cliente) throws ServiceException {
		try {
			return this.getClienteDAO().delete(cliente);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public Cliente findByObject(Cliente prmObject) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findByLikeObject(Cliente cliente)throws ServiceException {
		List<Cliente> lstUsuario=null;
		try {
			lstUsuario=this.getClienteDAO().findByLikeObject(cliente);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstUsuario;
	}
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}



	@Override
	public List<Cliente> listarXRazonSocial(String razonSocial)
			throws ServiceException {
		List<Cliente> lstUsuario=null;
		try {
			lstUsuario=this.getClienteDAO().listarXRazonSocial(razonSocial);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstUsuario;
	}



	@Override
	public boolean validarRUC(Cliente cliente) throws ServiceException {
		try {
			return this.getClienteDAO().validarRUC(cliente);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Cliente buscarXRuc(Cliente cliente) throws ServiceException {
		try {
			return this.getClienteDAO().buscarXRuc(cliente);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
