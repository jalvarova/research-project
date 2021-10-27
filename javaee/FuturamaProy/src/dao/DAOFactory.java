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

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int SQL = 2;
	
	public abstract AsesorDAO getAsesorDAO();
	public abstract CampanaDAO getCampanaDAO();
	public abstract ClientesDAO getClientesDAO();
	public abstract HabitacionDAO getHabitacionDAO() ;
	public abstract HotelDAO getHotelDAO();
	public abstract llamadaDAO getLlamadaDAO();
	public abstract MotivoDAO getMotivoDAO() ;
	public abstract PackDAO getPackDAO();
	public abstract VentasDAO getVentasDAO();
	public abstract EstadoDAO getEstadoDAO(); 
	public abstract DistritoDAO getDistritoDAO();
	public abstract ProvinciaDAO getProvinciaDAO();
	public abstract DepartamentoDAO getDepeartamentoDAO();
	public abstract TicketDAO getTicketDAO();
	public static DAOFactory getDaoFactory(int cambio){
		 
		switch (cambio) {
		case MYSQL:
			return new MySQLDAOFactory();
			

		default:
			return null;
		}
	
		 
	 }
}
