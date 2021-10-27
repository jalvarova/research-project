package dao;

import interfaces.*;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public AdministradorDAO getAdministradorDAO() {
		return new MySQLAdministradorDAO();
	}

	@Override
	public BusDAO getBusDAO() {
		return new MySQLBusDAO();
	}

	@Override
	public RutaDAO getRutaDAO() {
		return new MySQLRutaDAO();
	}

	@Override
	public RecursoDAO getRecursoDAO() {
		return new MySQLRecursoDAO();
	}

	@Override
	public ChoferDAO getChoferDAO() {
		return new MySQLChoferDAO();
	}

	@Override
	public TerramozaDAO getTerramozaDAO() {
		return new MySQLTerramozaDAO();
	}

	@Override
	public CiudadDAO getCiudadDAO() {
		return new MySQLCiudadDAO();
	}

	@Override
	public TipoDocumentoDAO getTipoDocumentoDAO() {
		return new MySQLTipoDocumentoDAO();
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new MySQLClienteDAO();
	}

	@Override
	public TipoServicioDAO getTipoServicioDAO() {
		return new MySQLTipoServicioDAO();
	}
	@Override
	public ApoyoDAO getApoyoDAO() {
		return new MySQLApoyoDAO();
	}

	@Override
	public BoletoDAO getBoletoDAO() {
		return new MySQLBoletoDAO();
	}
}