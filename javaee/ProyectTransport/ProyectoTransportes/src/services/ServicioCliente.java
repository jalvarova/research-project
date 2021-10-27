package services;

import java.util.ArrayList;

import beans.ClienteDTO;
import dao.DAOFactory;
import interfaces.ClienteDAO;

public class ServicioCliente {
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	ClienteDAO objClienteDAO = fabrica.getClienteDAO();


	public ArrayList<ClienteDTO> getlistadoclientes() {
		return objClienteDAO.getlistadoclientes();
	}

	public int eliminarCliente(String cod) {
		return objClienteDAO.eliminarCliente(cod);
	}

	public int registrarCliente(String codigo, String nombre,
			String apePaterno, String apeMaterno, String tipoDocID,
			int nroDocID, String sexo, String email, int telefono,
			String fecha, String codciudad, byte[] foto, int estado,
			String usuario, String clave) {
		return objClienteDAO.registrarCliente(codigo, nombre, apePaterno,
				apeMaterno, tipoDocID, nroDocID, sexo, email, telefono, fecha,
				codciudad, foto, estado, usuario, clave);
	}

	public int actualizarCliente(String codigo, String nombre,
			String apePaterno, String apeMaterno, String tipoDocID,
			int nroDocID, String sexo, String email, int telefono,
			String fecha, String codciudad, byte[] foto, int estado,
			String clave) {
		return objClienteDAO.actualizarCliente(codigo, nombre, apePaterno,
				apeMaterno, tipoDocID, nroDocID, sexo, email, telefono, fecha,
				codciudad, foto, estado, clave);
	}
	public ClienteDTO obtenerCliente(String cod){
		return objClienteDAO.obtenerCliente(cod);
	}
	
	public boolean validaRegistroCliente(String codCliente){
		
		return objClienteDAO.validaRegistroCliente(codCliente);
	}
}