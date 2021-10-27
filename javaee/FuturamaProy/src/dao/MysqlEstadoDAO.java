package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.MySQLConexion;
import beanDTO.EstadoDTO;
import interfaces.EstadoDAO;

public class MysqlEstadoDAO implements EstadoDAO {

	public ArrayList<EstadoDTO> ListaEstado(){
		
		ArrayList<EstadoDTO>  lista = new ArrayList<EstadoDTO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_estado";
			ps = conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			while (rs.next()) {
				EstadoDTO e = new  EstadoDTO(rs.getInt(1), rs.getString(2));
				lista.add(e);
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
