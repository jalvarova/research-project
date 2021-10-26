package pe.edu.galaxy.training.ws.rest.persistencia.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.galaxy.training.ws.rest.entidad.Cliente;
import pe.edu.galaxy.training.ws.rest.entidad.User;
import pe.edu.galaxy.training.ws.rest.persistencia.exception.DAOException;
import pe.edu.galaxy.training.ws.rest.persistencia.inf.UserDAO;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	@PersistenceContext
	private EntityManager em;
	@Override
	public boolean insert(Cliente prmObject) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Cliente prmObject) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Cliente prmObject) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente findByObject(Cliente prmObject) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findByLikeObject(Cliente prmObject)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public User validateAccess(String user, String password) throws DAOException {
		User userValidate = null;
		try {
			StoredProcedureQuery sp = em
					.createNamedStoredProcedureQuery("user.validateaccess");
			sp.setParameter("P_USUARIO", user);
			sp.setParameter("P_CLAVE", password);
			
			if (sp.execute()) {


				List<User> users = (List<User>) sp
						.getOutputParameterValue("P_CURSOR");
				if (users != null) {
					if (users.size() > 0) {
						userValidate = users.get(0);
					}

				}
			}
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return userValidate;
	}

}
