package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.MySQLConexion;
import beanDTO.CampanaDTO;
import beanDTO.MotivoDTO;
import interfaces.MotivoDAO;

public class MysqlMotivoDAO implements MotivoDAO {

	public ArrayList<MotivoDTO> listaMotivo(){
		
	 ArrayList<MotivoDTO> lista = new ArrayList<MotivoDTO>();
	Connection conn = null;
	PreparedStatement ps = null;
	 ResultSet rs = null;
	try {
		conn = MySQLConexion.getConexion();
		String sql = "select * from tb_motivo";
		ps = conn.prepareStatement(sql);
		
		rs= ps.executeQuery();
		while (rs.next()) {
			MotivoDTO c = new  MotivoDTO(rs.getString(1), rs.getString(2));
			lista.add(c);
		}
	} catch (Exception e) {
	
		System.out.println("Error en la lista");
	}
	finally{
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn !=null) conn.close();
		} catch (Exception ex) {
			System.out.println("Error al cerrar");
		}		
	}
	
	
	
	
	return lista;
	

   }
}
