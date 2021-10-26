package pe.edu.galaxy.training.ws.rest.persistencia.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.galaxy.training.ws.rest.entidad.Cliente;
import pe.edu.galaxy.training.ws.rest.persistencia.exception.DAOException;
import pe.edu.galaxy.training.ws.rest.persistencia.inf.ClienteDAO;

@Transactional
@Repository("clienteDAO")
public class ClienteDAOImpl implements ClienteDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findByLikeObject(Cliente Cliente)
			throws DAOException {
		List<Cliente> lstCliente = null;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.listar");
			if (spq.execute()) {
				lstCliente = (List<Cliente>)spq.getOutputParameterValue("P_CURSOR");
			}
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return lstCliente;
	}


	@Override
	public boolean insert(Cliente cliente) throws DAOException {
		boolean sw=false;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.insertar");
			
			spq.setParameter("P_RAZON_SOCIAL",cliente.getRazonSocial());
			spq.setParameter("P_RUC",cliente.getRuc());
			spq.setParameter("P_DIRECCION",cliente.getDireccion());
			
			spq.execute();
			
			Object idObject = spq.getOutputParameterValue(1); //P_CLIENTE_ID
			if (idObject!=null) {
				cliente.setIdCliente(Long.valueOf(idObject.toString()));
				sw=true;
			}
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}


	@Override
	public boolean update(Cliente cliente) throws DAOException {
		boolean sw=false;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.actualizar");
			
			spq.setParameter("P_CLIENTE_ID",cliente.getIdCliente());
			spq.setParameter("P_RAZON_SOCIAL",cliente.getRazonSocial());
			spq.setParameter("P_RUC",cliente.getRuc());
			spq.setParameter("P_DIRECCION",cliente.getDireccion());
			
			spq.execute();

			em.close();
			sw=true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}


	@Override
	public boolean delete(Cliente cliente) throws DAOException {
		boolean sw=false;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.eliminar");
			
			spq.setParameter("P_CLIENTE_ID",cliente.getIdCliente());
			
			spq.execute();

			em.close();
			sw=true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}


	@Override
	public Cliente findByObject(Cliente prmObject) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listarXRazonSocial(String razonSocial)
			throws DAOException {
		List<Cliente> lstCliente = null;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.listarXRazonSocial");
			spq.setParameter("P_RAZON_SOCIAL",razonSocial);
			
			if (spq.execute()) {
				lstCliente = (List<Cliente>)spq.getOutputParameterValue("P_CURSOR");
			}
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return lstCliente;
	}


	@Override
	public List<Cliente> findByRUC(String ruc) throws DAOException {
        
//		List<Cliente> clientes =null;
//		
//		StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("cliente.listarXRazonSocial");
        
		
		return null;
	}

	@Override
	public boolean validarRUC(Cliente cliente) throws DAOException {
		boolean sw=false;	
		try {
			System.out.println("cliente "+cliente);
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.validarRUC");
			
			spq.setParameter("P_CLIENTE_ID",cliente.getIdCliente());
			spq.setParameter("P_RUC",cliente.getRuc());
			
			spq.execute();
			
			Object ret = spq.getOutputParameterValue(1); //P_RET
			System.out.println("ret "+ret);
			if (ret!=null) {
				if (Integer.valueOf(ret.toString())>0){
					sw=true;
				}
			}
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return sw;
	}



}
