package dao;

import interfaces.AsesorDAO;
import interfaces.CampanaDAO;
import interfaces.ClientesDAO;
import interfaces.DepartamentoDAO;
import interfaces.DistritoDAO;
import interfaces.EstadoDAO;
import interfaces.HabitacionDAO;
import interfaces.HotelDAO;
import interfaces.MotivoDAO;
import interfaces.PackDAO;
import interfaces.ProvinciaDAO;
import interfaces.TicketDAO;
import interfaces.VentasDAO;
import interfaces.llamadaDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public AsesorDAO getAsesorDAO() {
		// TODO Auto-generated method stub
		return new MysqlAsesorDAO();
	}

	@Override
	public CampanaDAO getCampanaDAO() {
		// TODO Auto-generated method stub
		return new MysqlCampanaDAO();
	}

	@Override
	public ClientesDAO getClientesDAO() {
		// TODO Auto-generated method stub
		return new MysqlClientesDAO();
	}

	@Override
	public HabitacionDAO getHabitacionDAO() {
		// TODO Auto-generated method stub
		return new MysqlHabitacionDAO();
	}

	@Override
	public HotelDAO getHotelDAO() {
		// TODO Auto-generated method stub
		return new MysqlHotelDAO();
	}

	

	@Override
	public llamadaDAO getLlamadaDAO() {
		// TODO Auto-generated method stub
		return new MysqlllamadaDAO();
	}

	@Override
	public MotivoDAO getMotivoDAO() {
		// TODO Auto-generated method stub
		return new MysqlMotivoDAO();
	}

	@Override
	public PackDAO getPackDAO() {
		// TODO Auto-generated method stub
		return new MysqlPackDAO();
	}

	@Override
	public VentasDAO getVentasDAO() {
		// TODO Auto-generated method stub
		return new MysqlVentasDAO();
	}

	@Override
	public EstadoDAO getEstadoDAO() {
		// TODO Auto-generated method stub
		return new MysqlEstadoDAO();
	}

	@Override
	public DistritoDAO getDistritoDAO() {
		// TODO Auto-generated method stub
		return new MysqlDistritoDAO();
	}

	@Override
	public ProvinciaDAO getProvinciaDAO() {
		// TODO Auto-generated method stub
		return new MysqlProvinciaDAO();
	}

	@Override
	public DepartamentoDAO getDepeartamentoDAO() {
		
		return new MysqlDepartamentoDAO();
	}

	@Override
	public TicketDAO getTicketDAO() {
		// TODO Auto-generated method stub
		return new MysqlTicketDAO();
	}

}
