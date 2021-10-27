package dao;

import interfaces.*;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	
	public abstract RutaDAO getRutaDAO(); 
	public abstract RecursoDAO getRecursoDAO();
	public abstract AdministradorDAO getAdministradorDAO();
	public abstract BusDAO getBusDAO();
	public abstract ChoferDAO getChoferDAO();
	public abstract TerramozaDAO getTerramozaDAO();
	public abstract CiudadDAO getCiudadDAO();
	public abstract TipoDocumentoDAO getTipoDocumentoDAO();
	public abstract ClienteDAO getClienteDAO();
	public abstract TipoServicioDAO getTipoServicioDAO();
	public abstract ApoyoDAO getApoyoDAO();
	public abstract BoletoDAO getBoletoDAO();
	
	public static DAOFactory getDAOFactory(int qFactory) {
		switch (qFactory) {
		case MYSQL:
			return new MySQLDAOFactory();
		default:
			return null;
		}
	}
}