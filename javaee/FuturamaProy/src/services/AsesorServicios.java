package services;

import interfaces.AsesorDAO;
import interfaces.ClientesDAO;

import java.util.ArrayList;

import dao.DAOFactory;
import beanDTO.AsesorDTO;

public class AsesorServicios {
	
	//creacion de la fuente de datos usada
private DAOFactory fabrica = DAOFactory.getDaoFactory(1);
// instanciar las rutinas usando la fuente
private AsesorDAO objAsesorDAO=fabrica.getAsesorDAO();


public int registarAsesor(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,String Distrito,String Provincia,String Departamento){
		
		
		return objAsesorDAO.registarAsesor(DNI, Nombre, Apellido1, Apellido2, Direccion, Fecha, Correo, Referencia, Celular, Distrito, Provincia, Departamento);
		
		
	}
	public ArrayList<AsesorDTO> ListarAsesor(){
		
		return objAsesorDAO.ListarAsesor();
	}
	public int Eliminar(int cod){
		
		return objAsesorDAO.EliminarAsesor(cod);
		
	}
	public int ActuaizarEmpleado(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,String Distrito,String Provincia,String Departamento,int Cod){
		return objAsesorDAO.ActuaizarEmpleado(DNI, Nombre, Apellido1, Apellido2, Direccion, Fecha, Correo, Referencia, Celular, Distrito, Provincia, Departamento,Cod);
		
		
	}
}
