package pe.edu.galaxy.training.ws.rest.servicio.inf;

import java.util.List;
import pe.edu.galaxy.training.ws.rest.entidad.Cliente;
import pe.edu.galaxy.training.ws.rest.servicio.GenericService;
import pe.edu.galaxy.training.ws.rest.servicio.exception.ServiceException;

public interface ClienteService extends GenericService<Cliente> {
	
	public List<Cliente> listarXRazonSocial(String razonSocial) throws ServiceException; 
	
	public boolean validarRUC(Cliente cliente) throws ServiceException;
	
	public Cliente buscarXRuc(Cliente cliente) throws ServiceException;
	
}
