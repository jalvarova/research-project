package pe.edu.galaxy.training.ws.rest.persistencia.inf;

import java.util.List;

import pe.edu.galaxy.training.ws.rest.entidad.Cliente;
import pe.edu.galaxy.training.ws.rest.persistencia.GenericDAO;
import pe.edu.galaxy.training.ws.rest.persistencia.exception.DAOException;

public interface ClienteDAO extends GenericDAO<Cliente> {
	
	public List<Cliente> listarXRazonSocial(String razonSocial) throws DAOException;
	
	public boolean validarRUC(Cliente cliente) throws DAOException;
	
	public List<Cliente> findByRUC(String ruc)throws DAOException;
	
}
