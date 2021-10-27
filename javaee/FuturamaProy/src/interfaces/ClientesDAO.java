package interfaces;

import java.util.ArrayList;

import beanDTO.ClientesDTO;

public interface ClientesDAO {
	public int registarCLientes(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,int fijo,String Distrito,String Provincia,String Departamento);
	
	public ArrayList<ClientesDTO> ListarClientes();
	public int Eliminar(String cod);
	public int ActuaizarCliente(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,int fijo,String Distrito,String Provincia,String Departamento);;
	public ClientesDTO buscarCliente(String dni);	
	public int RegistrarContacto(String DNI, String Nombre, String Apellido1, String Apellido2, String Correo, int Numero1, int Numero2);

}
