package interfaces;

import java.util.ArrayList;

import beanDTO.LLamaditas;

public interface llamadaDAO {
public ArrayList<LLamaditas> ListaLlamada();
public int Llamadaregistrada( int num , String obs , int cod2 ,String dni,int cod3);
}
