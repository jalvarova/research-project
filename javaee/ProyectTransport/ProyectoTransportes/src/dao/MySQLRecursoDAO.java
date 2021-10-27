package dao;

import java.sql.*;
import java.util.ArrayList;

import services.*;
import utils.MySQLConexion;
import beans.BusDTO;
import beans.ChoferDTO;
import beans.RecursoDTO;
import beans.RutaDTO;
import beans.TerramozaDTO;
import interfaces.RecursoDAO;

public class MySQLRecursoDAO implements RecursoDAO{
	ChoferService	servChof = new ChoferService();
	TerramozaService servTer = new TerramozaService();
	BusService servBus = new BusService();
	RutaService servRuta = new RutaService();
	
	@Override
	public RecursoDTO getRecurso(String codRuta) {
		String sql = "select * from tb_recurso where codRuta=?";
		RecursoDTO rec = null;
		try(Connection con = MySQLConexion.getConexion();
				PreparedStatement pst=con.prepareStatement(sql);
				){
			pst.setString(1, codRuta);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				ChoferDTO chofer = servChof.obtenerChofer(rs.getString("codChofer"));
				TerramozaDTO terramoza = servTer.obtenerTerramoza(rs.getString("codTerramoza"));
				System.out.println("hasta aqui");
				BusDTO bus = servBus.obtenerBus(rs.getString("nroPlaca"));
				RutaDTO ruta = servRuta.getRuta(codRuta);
				rec=new RecursoDTO(rs.getString("codRecurso"), chofer, terramoza, bus, ruta, rs.getInt("estado"));
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rec;
	}
	@Override
	public RecursoDTO obtenerRecurso(String cod) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		RecursoDTO x = null;
		ChoferService servicioC = new ChoferService();
		TerramozaService servicioT = new TerramozaService();
		BusService servicioB = new BusService();
		RutaService servicioR = new RutaService();
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select * From tb_recurso where codRecurso=?");
			pst.setString(1, cod);
			rs = pst.executeQuery();
			if(rs.next()){
				x = new RecursoDTO(rs.getString("codRecurso"),
								   servicioC.obtenerChofer(rs.getString("codChofer")),
								   servicioT.obtenerTerramoza(rs.getString("codTerramoza")),
								   servicioB.obtenerBus(rs.getString("nroPlaca")),
								   servicioR.getRuta(rs.getString("codRuta")),
								   rs.getInt("estado"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(con!=null) con.close();
				if(pst!=null) pst.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return x;
	}
	@Override
	public ArrayList<RecursoDTO> getRecursos() {
		ArrayList<RecursoDTO> lista = new ArrayList<RecursoDTO>();
		String sql = "select * from tb_recurso Where estado = 0";
		RecursoDTO rec = null;
		try(Connection con = MySQLConexion.getConexion();
				PreparedStatement pst=con.prepareStatement(sql);
				){
		
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				ChoferDTO chofer = servChof.obtenerChofer(rs.getString("codChofer"));
				TerramozaDTO terramoza = servTer.obtenerTerramoza(rs.getString("codTerramoza"));
				BusDTO bus = servBus.obtenerBus(rs.getString("nroPlaca"));
				RutaDTO ruta = servRuta.getRuta(rs.getString("codRuta"));
				rec=new RecursoDTO(rs.getString("codRecurso"), chofer, terramoza, bus, ruta, rs.getInt("estado"));
				lista.add(rec);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	@Override
	public int eliminarRecurso(String cod) {
		Connection con = null;
		CallableStatement cst = null;
		int rs = 0;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{Call usp_eliminarRecurso(?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, cod);
			
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al Eliminar Recurso :"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(cst!=null) cst.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar desde el Servlet");
			}
		}	
		return rs;
	}
	
	@Override
	public int registrarRecurso(String codRec, String codChofer,
			String codTerra, String codBus, String codRuta, int estado) {
		Connection con = null;
		CallableStatement cst = null;
		int rs = 0;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{Call usp_ingresarRecurso(?,?,?,?,?,?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, codRec);
			cst.setString(2, codChofer);
			cst.setString(3, codTerra);
			cst.setString(4, codBus);
			cst.setString(5, codRuta);
			cst.setInt(6, estado);
			
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al Ingresar Recurso :"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(cst!=null) cst.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar desde el Servlet");
			}
		}	
		return rs;
	}
	
	@Override
	public int actualizarRecurso(String codRec, String codChofer,
			String codTerra, String codBus, String codRuta, int estado) {
		Connection con = null;
		CallableStatement cst = null;
		int rs = 0;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{Call usp_modificarRecurso(?,?,?,?,?,?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, codRec);
			cst.setString(2, codChofer);
			cst.setString(3, codTerra);
			cst.setString(4, codBus);
			cst.setString(5, codRuta);
			cst.setInt(6, estado);
			
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al Actualizar Recurso :"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(cst!=null) cst.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar desde el Servlet");
			}
		}	
		return rs;
	}
}