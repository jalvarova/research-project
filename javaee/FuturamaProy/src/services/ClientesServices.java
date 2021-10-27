package services;

import java.util.ArrayList;

import interfaces.ClientesDAO;
import beanDTO.ClientesDTO;
import dao.DAOFactory;

public class ClientesServices {
	
	//creacion de la fuente de datos usada
private DAOFactory fabrica = DAOFactory.getDaoFactory(1);
// instanciar las rutinas usando la fuente
private ClientesDAO objClientesDAO=fabrica.getClientesDAO();
public int registarCLientes(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,int fijo,String Distrito,String Provincia,String Departamento){
	return objClientesDAO.registarCLientes(DNI, Nombre, Apellido1, Apellido2, Direccion, Fecha, Correo, Referencia, Celular, fijo, Distrito, Provincia, Departamento);
}
public ArrayList<ClientesDTO> ListarClientes(){
	return objClientesDAO.ListarClientes();
	
}
public int Eliminar(String cod){
	
	
	return objClientesDAO.Eliminar( cod);
}
public int ActuaizarCliente(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,int fijo,String Distrito,String Provincia,String Departamento){
	
	return objClientesDAO.ActuaizarCliente(DNI, Nombre, Apellido1, Apellido2, Direccion, Fecha, Correo, Referencia, Celular, fijo, Distrito, Provincia, Departamento);
}
	
	
public ClientesDTO buscarCliente(String dni){
	return objClientesDAO.buscarCliente(dni);
	
	
}
	
public int RegistrarContacto(String DNI, String Nombre, String Apellido1, String Apellido2, String Correo, int Numero1, int Numero2){
	return objClientesDAO.RegistrarContacto(DNI, Nombre, Apellido1, Apellido2, Correo, Numero1, Numero2);
}
}
