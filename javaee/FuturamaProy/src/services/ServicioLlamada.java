package services;

import java.util.ArrayList;

import beanDTO.LLamaditas;
import interfaces.AsesorDAO;
import interfaces.llamadaDAO;
import dao.DAOFactory;

public class ServicioLlamada {

	// creacion de la fuente de datos usada
	private DAOFactory fabrica = DAOFactory.getDaoFactory(1);
	// instanciar las rutinas usando la fuente
	private llamadaDAO objLlamada = fabrica.getLlamadaDAO();

	public ArrayList<LLamaditas> ListaLlamada() {

		return objLlamada.ListaLlamada();

	}
	public int Llamadaregistrada( int num , String obs , int cod2 ,String dni, int cod3){
		
		return objLlamada.Llamadaregistrada( num, obs, cod2, dni,cod3);
	}
}
