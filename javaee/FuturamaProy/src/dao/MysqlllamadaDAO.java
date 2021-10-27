package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.MySQLConexion;
import beanDTO.LLamaditas;
import interfaces.llamadaDAO;

public class MysqlllamadaDAO implements llamadaDAO {

	@Override
	public ArrayList<LLamaditas> ListaLlamada() {
		
		Connection conn = null;
		ArrayList<LLamaditas> llamada = new  ArrayList<LLamaditas>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		LLamaditas l = null;
		try {
			
			conn = MySQLConexion.getConexion();
			String sql = "select * from v_LamadasResalizadas";
			ps = conn.prepareStatement(sql);
			
			
			
			rs =ps.executeQuery();
			
			while (rs.next()) {
				 l = new  LLamaditas(
						 rs.getString(1),
						 rs.getString(2),
						 rs.getString(3),
						 rs.getString(4),
						 rs.getInt(5),
				        rs.getInt(6));
				llamada.add(l);
			}
			
			conn.close();
			ps.close();
		} catch (Exception e) {
			System.out.println("Error en Consulta");
		}finally{
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	
		return llamada;
	}
	public int Llamadaregistrada( int num , String obs , int cod2 ,String dni,int cod3){
		
		Connection conn = null;
		CallableStatement ps = null;
		int rs = 0;
		
		
		try {
		
			conn = MySQLConexion.getConexion();
			String sql = "{Call pr_InsertLlamada(?,?,?,?,?)}";
			ps=conn.prepareCall(sql);
			
			
			ps.setInt(1, num);
			ps.setString(2, obs);
			ps.setInt(3, cod2);
			ps.setString(4, dni);
			ps.setInt(5,cod3);
			
			rs=ps.executeUpdate();
			
			
			ps.close();
			conn.close();
		} catch (Exception e) {
		System.out.println("error en consulta"+"\n" +e.toString());
		}
		return rs;
		
		
		
	}

}
