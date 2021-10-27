package interfaces;

import java.util.ArrayList;

import beanDTO.AsesorDTO;

public interface AsesorDAO {
	
public int registarAsesor(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,String Distrito,String Provincia,String Departamento);
	public ArrayList<AsesorDTO> ListarAsesor();
	public int EliminarAsesor(int cod);
	public int ActuaizarEmpleado(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,String Distrito,String Provincia,String Departamento,int Cod);
		
	

}
