package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.MySQLConexion;
import beanDTO.VentaDTO;
import beanDTO.VentasADTO;
import beanDTO.VentasRDTO;
import interfaces.VentasDAO;

public class MysqlVentasDAO implements VentasDAO {

	
	public ArrayList<VentasRDTO> ReporteVentas(){
		
		ArrayList<VentasRDTO> reporte = new ArrayList<VentasRDTO>();
		Connection conn = null;
		PreparedStatement ps  = null; 
		ResultSet rs = null;
		try {
			
			conn = MySQLConexion.getConexion();
			String sql = "select * from v_reporteventas";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				VentasRDTO v = new VentasRDTO(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7));
				reporte.add(v);
			}
			
			
			
			conn.close();
			ps.close();
		} catch (Exception e) {
			System.out.println("error de Consulta");
		}
		
			return reporte;
		
		
		
	}

	@Override
	public ArrayList<VentasADTO> VentasxAsesor(String  nom) {
		
		ArrayList<VentasADTO> ventas = new ArrayList<VentasADTO>();
		Connection conn = null;
		PreparedStatement ps  = null; 
		ResultSet rs = null;
		try {
			
			conn = MySQLConexion.getConexion();
			String sql = "{Call pr_VentasxAsesor(?)}";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nom);;
			
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				VentasADTO v = new VentasADTO(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7),
						rs.getString(8));
				ventas.add(v);
			}
			
			
			
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("error de Consulta");
		}
		
		return ventas;
	}

	@Override
	public void registrarVenta(VentaDTO v) {
		
		
		
		
		Connection conn = null;
		CallableStatement ps = null;
        int rs = 0;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "{Call RegistraVenta(?,?,?,?,?,?,?)}";
              ps = conn.prepareCall(sql);  
             
            ps.setInt(1,v.getCod_ases());
			ps.setInt(2, v.getCod_hotel());
			ps.setInt(3,v.getCod_hab());
			ps.setInt(4,v.getnAdicionales());
			ps.setDouble(5,v.getPretotal_hab());
			ps.setString(6, v.getObser_venta());
			ps.setString(7, v.getNumIdentificacion_clie());
			
			
            
            rs =  ps.executeUpdate();
            
       
        }catch(Exception ex){
        	System.out.println("error en consulta "+ ex.toString());
        	
        }finally{
			
			try {
				
					if(ps!=null) ps.close();
					if(conn!=null) conn.close();
				
			} catch (Exception e2) {
				System.out.println("Error en cierre");
			}
        }
		
		
	}
}
