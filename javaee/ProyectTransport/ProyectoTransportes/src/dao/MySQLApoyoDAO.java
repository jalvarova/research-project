package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.BoletoDTO;
import utils.MySQLConexion;
import interfaces.ApoyoDAO;
import services.RecursoService;
import services.ServicioCliente;

public class MySQLApoyoDAO implements ApoyoDAO {

	@Override
	public ArrayList<BoletoDTO> reportesBoletosAnteriores() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		BoletoDTO x = null;
		ArrayList<BoletoDTO> reporteBoleto = new ArrayList<BoletoDTO>();
		ServicioCliente servicioC = new ServicioCliente();
		RecursoService servicioR = new RecursoService();
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select*from tb_boleto where fechaViaje<curdate()");
			rs = pst.executeQuery();
			while(rs.next()){
				x = new BoletoDTO(rs.getString("nroBoleto"), rs.getString("fechaEmision"), rs.getString("fechaViaje"), 
						rs.getString("idPasajero"),servicioC.obtenerCliente(rs.getString("codCliente")), servicioR.obtenerRecurso(rs.getString("codRecurso")), rs.getInt("nroAsiento"),
						rs.getDouble("precioSol"),rs.getDouble("precioDolar"));
				 reporteBoleto.add(x);
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

		return reporteBoleto;
	}

	@Override
	public ArrayList<BoletoDTO> reportesBoletosProximos() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		BoletoDTO x = null;
		ArrayList<BoletoDTO> reporteBoleto = new ArrayList<BoletoDTO>();
		ServicioCliente servicioC = new ServicioCliente();
		RecursoService servicioR = new RecursoService();
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select*from tb_boleto where fechaViaje>curdate()");
			rs = pst.executeQuery();
			while(rs.next()){
				x = new BoletoDTO(rs.getString("nroBoleto"), rs.getString("fechaEmision"), rs.getString("fechaViaje"), 
						rs.getString("idPasajero"),servicioC.obtenerCliente(rs.getString("codCliente")), servicioR.obtenerRecurso(rs.getString("codRecurso")), rs.getInt("nroAsiento"),
						rs.getDouble("precioSol"),rs.getDouble("precioDolar"));
				 reporteBoleto.add(x);
				 System.out.println(rs.getString("codRecurso"));
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

		return reporteBoleto;
	}

	@Override
	public ArrayList<Integer> getAsientosOcupados(String fecha, String nroPlaca) {
		// TODO Auto-generated method stub
		ArrayList<Integer> asientos = new ArrayList<Integer>();
		System.out.println(fecha);
		String sql = "Select nroAsiento from tb_asientosOcupados where date_format(fecha,'%d/%m/%Y')=? and nroPlaca=?";
		
		try(Connection con =MySQLConexion.getConexion();
				PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, fecha);
			pst.setString(2, nroPlaca);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Integer i = new Integer(rs.getInt("nroAsiento"));
				asientos.add(i);
			}
			
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return asientos;
	}
	
	

}
