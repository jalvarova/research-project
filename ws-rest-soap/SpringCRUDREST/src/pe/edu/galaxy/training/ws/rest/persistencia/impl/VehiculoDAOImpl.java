package pe.edu.galaxy.training.ws.rest.persistencia.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.galaxy.training.ws.rest.entidad.Vehiculo;
import pe.edu.galaxy.training.ws.rest.persistencia.exception.DAOException;
import pe.edu.galaxy.training.ws.rest.persistencia.inf.VehiculoDAO;

@Transactional
@Repository("vehiculoDAO")
public class VehiculoDAOImpl implements VehiculoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insert(Vehiculo prmObject) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vehiculo prmObject) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Vehiculo prmObject) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vehiculo findByObject(Vehiculo prmObject) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehiculo> findByLikeObject(Vehiculo prmObject)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vehiculo findByLicensePlate(String licensePlate) throws DAOException {

		Vehiculo vehiculo = null;
		try {
			StoredProcedureQuery sp = em
					.createNamedStoredProcedureQuery("vehiculo.findByPlaca");
			sp.setParameter("P_PLACA", licensePlate);

			if (sp.execute()) {

				List<Vehiculo> vehiculos = (List<Vehiculo>) sp
						.getOutputParameterValue("P_CURSOR");
				if (vehiculos != null) {
					if (vehiculos.size() > 0) {
						vehiculo = vehiculos.get(0);
					}

				}
			}
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return vehiculo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> findByYear(String year) throws DAOException {
		List<Vehiculo> vehiculos = null;
		try {
			StoredProcedureQuery sp = em
					.createNamedStoredProcedureQuery("vehiculo.findByYear");
			sp.setParameter("P_ANIO", year);

			if (sp.execute()) {

				vehiculos = (List<Vehiculo>) sp.getOutputParameterValue("P_CURSOR");
		
			}
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return vehiculos;
	}

}
