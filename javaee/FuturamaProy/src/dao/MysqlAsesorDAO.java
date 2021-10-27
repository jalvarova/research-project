package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.MySQLConexion;
import beanDTO.AsesorDTO;
import interfaces.AsesorDAO;

public class MysqlAsesorDAO implements AsesorDAO {



	public int registarAsesor(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,String Distrito,String Provincia,String Departamento){
		Connection        conn = null;
		PreparedStatement ps = null;
		int         rs = 0;
		
		
		try{
			conn = MySQLConexion.getConexion();
			String sql = "{Call pr_InsertarAsesor(?,?,?,?,?,?,?,?,?,?,?,?)}";			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,DNI);
			ps.setString(2, Nombre);
			ps.setString(3,Apellido1);
			ps.setString(4,Apellido2);
			ps.setString(5, Correo);
			ps.setInt(6, Referencia);
			ps.setInt(7, Celular);
			ps.setString(8,Direccion);
			ps.setString(9, Fecha);
			ps.setString(10, Distrito);
			ps.setString(11,Provincia);
			ps.setString(12,Departamento);
			
			rs =  ps.executeUpdate();
			
	             ps.close();		
	    		conn.close();
		}catch(Exception e){
			System.out.println("Error de Consulta");
		}
		return rs;
		
		
	}
	public ArrayList<AsesorDTO> ListarAsesor(){
		AsesorDTO ases = null; 
		ArrayList<AsesorDTO> lista = new  ArrayList<AsesorDTO>();
        PreparedStatement ps  = null;
    	ResultSet rs = null;
    	Connection conn = null;
    	try {
    		conn = MySQLConexion.getConexion();
			String sql="select * from tb_asesor";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
           while (rs.next()) {
	             ases= new AsesorDTO(
	            		 rs.getInt(1), 
	            		 rs.getString(2),
	            		 rs.getString(3),
	            		 rs.getString(4), 
	            		 rs.getString(5),
	            		 rs.getString(6),
	            		 rs.getInt(7), 
	            		 rs.getInt(8),
	            		 rs.getString(9),
	            		 rs.getString(10),
	            		 rs.getString(11),
	            		 rs.getString(12),
	            		 rs.getString(13),
	            		 rs.getString(14));
	             lista.add(ases);
}			
		} catch (Exception e) {
			System.out.println("Error en Consulta");
		}finally{
			
			try {
				if (conn != null && ps !=  null) {
					conn.close();
					ps.close();
				}
			} catch (Exception e2) {
				System.out.println("Error en cierre");
			}
		}
		return lista;
	}
	public int EliminarAsesor(int cod){
		
		Connection conn = null;
		
		CallableStatement ps = null;
		int rs = 0 ;
		try {
			conn = MySQLConexion.getConexion();
			String sql  = "{Call pr_EliminarAsesor(?)}";
			ps = conn.prepareCall(sql);
			ps.setInt(1, cod);
			
			rs=ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error de Consulta");
		}finally{
			
			try {
				if (conn != null && ps !=  null) {
					conn.close();
					ps.close();
				}
			} catch (Exception e2) {
				System.out.println("Error en cierre");
			}
		}
		return rs;
		
	}
	public int ActuaizarEmpleado(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,String Distrito,String Provincia,String Departamento,int Cod){
		
		Connection        conn = null;
		CallableStatement ps = null;
		int    rs = 0;
		
		try {
			conn = MySQLConexion.getConexion();
			String sql = "{Call pr_ActualizarAsesor(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			ps = conn.prepareCall(sql);
			
		
			
		
			ps.setInt(1, Cod);
			ps.setString(2,DNI);
			ps.setString(3, Nombre);
			ps.setString(4,Apellido1);
			ps.setString(5,Apellido2);
			ps.setString(6, Fecha);
			ps.setString(7, Correo);
			ps.setInt(8, Celular);
			ps.setInt(9, Referencia);
			ps.setString(10,Direccion);
			ps.setString(11, Distrito);
			ps.setString(12,Provincia);
			ps.setString(13,Departamento);
			
  			
		    
			rs  = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("error En consulta");
		}finally{
			
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println("Error en cierre");
			}
		}
        		
		
		
		return rs;
	}
	public AsesorDTO BuscarEmpleado(int cod_ases){
		Connection        conn = null;
		PreparedStatement ps = null;
		ResultSet         rs = null;
		AsesorDTO       ases = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tb_clientes WHERE cod_ases ='"+cod_ases+"'";
			ps = conn.prepareStatement(sql);
			rs  = ps.executeQuery();
			while(rs.next()){
				ases= new AsesorDTO(
			    rs.getInt("cod_ases"),
				rs.getString("numIdentidad_ases"),
				rs.getString("nom_ases"),
				rs.getString("apePat_ases"),
				rs.getString("apeMat_ases"),
			    rs.getString("correo_ases"),
				rs.getInt("num_telefono_ases"),
				rs.getInt("ref_telefono_ases"),
				rs.getString("dirrec_ases"),
				rs.getString("fechaNac_ases"),
				rs.getString("distrito_ases"),
				rs.getString("provincia_ases"),
				rs.getString("departamento_ases"),
				rs.getString("estado_ases")
				
				);
			}
		}catch(SQLException e){
			
			e.printStackTrace();
		}
		 catch ( Exception e) {
			System.out.println("Error de Consulta");
		}finally{
			
			try {
				if (conn != null && ps !=  null) {
					conn.close();
					ps.close();
				}
			} catch (Exception e2) {
				System.out.println("Error en cierre");
			}
		}
			
		return ases;
		
			
		}
	}
	

