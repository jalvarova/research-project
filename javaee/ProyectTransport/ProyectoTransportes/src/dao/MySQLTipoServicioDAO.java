package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.MySQLConexion;
import beans.TipoServicioDTO;
import interfaces.TipoServicioDAO;

public class MySQLTipoServicioDAO implements TipoServicioDAO{

	@Override
	public ArrayList<TipoServicioDTO> getTipoServicio() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<TipoServicioDTO> lista = new ArrayList<TipoServicioDTO>();
		TipoServicioDTO x = null;

		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select * from tb_tipoServicio");
			rs = pst.executeQuery();
			while(rs.next()){
				x = new TipoServicioDTO(rs.getString("idTipoServicio"), rs.getString("nombreTipoServicio"), 
						rs.getDouble("tarifa"), rs.getString("descripcion"));
				
				lista.add(x);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al listar Tipo Servicio: " + e.getMessage());
		}finally{
			try{
				if(con!=null)con.close();
				if(pst!=null)pst.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Error2 al listar Tipo Servicio: " + e.getMessage());
			}
		}
		return lista;
	}

	@Override
	public TipoServicioDTO getTipoServicio(String id) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		TipoServicioDTO x = null;
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select * from tb_tipoServicio where idTipoServicio=?");
			pst.setString(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				x = new TipoServicioDTO(rs.getString("idTipoServicio"), rs.getString("nombreTipoServicio"), 
						rs.getDouble("tarifaBase"), rs.getString("descripcion"));
			}
		}catch(Exception e){
			System.out.println("Error al obtener Tipo de Servicio: " + e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				if(con!=null) con.close();
				if(pst!=null) pst.close();
			}catch(Exception e){
				System.out.println("Error2 al obtener Tipo de Servicio: " + e.getMessage());
				e.printStackTrace();
			}	
		}
		return x;
	}
}