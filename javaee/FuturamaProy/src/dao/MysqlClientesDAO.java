package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




import util.MySQLConexion;
import beanDTO.ClientesDTO;
import interfaces.ClientesDAO;

public class MysqlClientesDAO implements ClientesDAO {
	@Override
	
	public int registarCLientes(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,int fijo,String Distrito,String Provincia,String Departamento){
		
		Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "INSERT INTO tb_clientes(numIdentificacion_clie,nom_clie,apePat_clie, apeMat_clie,dirrec_clie,fechaNac_clie, correo_clie,numTrabajo_clie,numCel_clie,numTelfijo_clie,distrito_clie,provincia_clie,departamento_clie) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);  
    		  
            ps.setString(1,DNI);
			ps.setString(2, Nombre);
			ps.setString(3,Apellido1);
			ps.setString(4,Apellido2);
			ps.setString(5,Direccion);
			ps.setString(6, Fecha);
			ps.setString(7, Correo);
			ps.setInt(8, Referencia);
			ps.setInt(9, Celular);
			ps.setInt(10,fijo);
			ps.setString(11, Distrito);
			ps.setString(12,Provincia);
			ps.setString(13,Departamento);
          
            
            rs = ps.executeUpdate();
    		
            ps.close();
			conn.close();
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
        		

        
        
		return rs ;
		
		
	}
	@Override
	public ArrayList<ClientesDTO> ListarClientes(){

		ArrayList<ClientesDTO> lista = new  ArrayList<ClientesDTO>();
        PreparedStatement ps  = null;
    	ResultSet rs = null;
    	Connection conn = null;


    	try {
    		conn = MySQLConexion.getConexion();
			String sql="select * from tb_clientes where estado_clie = 'Disponible'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
           while (rs.next()) {
        	   ClientesDTO   c= new ClientesDTO( 
        			      rs.getString(1), 
	            		  rs.getString(2), 
	            		  rs.getString(3), 
	            		  rs.getString(4), 
	            		  rs.getString(5),
	            		  rs.getString(6),
	            		  rs.getString(7),
	            		  rs.getInt(8), 
	            		  rs.getInt(9),
	            		  rs.getInt(10),
	            		  rs.getString(11),
	            		  rs.getString(12),
	            		  rs.getString(13));

	             lista.add(c);
}			
              ps.close();
			conn.close();
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
	@Override
	public int Eliminar(String cod){
		Connection conn = null;
		String sql = null;
		CallableStatement ps = null;
		ClientesDTO c = null;
		int  rs = 0;
		try {
			conn = MySQLConexion.getConexion();
			sql = "{Call pr_EliminarClientes(?)}";
			ps = conn.prepareCall(sql);
		
			
			ps.setString(1, cod);
			
			rs = ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error de Consulta");
			e.printStackTrace();
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
	@Override
	public int ActuaizarCliente(String DNI,String Nombre,String Apellido1,String Apellido2,String Direccion,String Fecha,String Correo,int Referencia,int Celular,int fijo,String Distrito,String Provincia,String Departamento){
		
		
		Connection conn = null;
		CallableStatement ps = null;
        int rs = 0;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "{Call pr_actualizarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
              ps = conn.prepareCall(sql);  
           
            ps.setString(1,DNI);
			ps.setString(2, Nombre);
			ps.setString(3,Apellido1);
			ps.setString(4,Apellido2);
			ps.setString(5,Direccion);
			ps.setString(6, Fecha);
			ps.setString(7, Correo);
			ps.setInt(8, Referencia);
			ps.setInt(9, Celular);
			ps.setInt(10,fijo);
			ps.setString(11, Distrito);
			ps.setString(12,Provincia);
			ps.setString(13,Departamento);
			
            
            rs =  ps.executeUpdate();
            
       
        }catch(Exception ex){
        	System.out.println("error en consulta actualizar"+ ex.toString());
        	
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
	@Override
	public ClientesDTO buscarCliente(String dni){
		Connection        conn = null;
		PreparedStatement ps = null;
		ResultSet         rs = null;
		ClientesDTO       clie = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_cliente where numIdentificacion_clie = ? ";
			ps =conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				clie  = new ClientesDTO(
						rs.getString(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8),
						rs.getInt(9),
	            		  rs.getInt(10),
	            		  rs.getString(11),
	            		  rs.getString(12),
	            		  rs.getString(13));
				
			}
		} catch (Exception e) {
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
		
		
		
		return null;
		
	}
	
	@Override
	public int RegistrarContacto(String DNI, String Nombre, String Apellido1, String Apellido2, String Correo, int Numero1, int Numero2) {
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "insert  into tb_clientes(numIdentificacion_clie,nom_clie,apePat_clie,apeMat_clie,numTrabajo_clie,numCel_clie,correo_clie) values (?,?,?,?,?,?,?);";
			ps = conn.prepareStatement(sql);

			ps.setString(1, DNI);
			ps.setString(2, Nombre);
			ps.setString(3, Apellido1);
			ps.setString(4, Apellido2);
			ps.setInt(5, Numero1);
			ps.setInt(6, Numero2);
			ps.setString(7, Correo);

			rs =  ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("erros de Consulta ");
		} finally {
			try {
				if (ps != null && conn != null) {
					ps.close();
					conn.close();

				}
			} catch (Exception e2) {
				System.out.println("Error al Cerrar");
			}

		}
	

		return rs;
	}
	
	
	
}
