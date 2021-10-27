package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.MySQLConexion;
import beans.ClienteDTO;
import beans.PersonaDTO;
import beans.RutaDTO;
import interfaces.ClienteDAO;

public class MySQLClienteDAO implements ClienteDAO {

	@Override
	public ArrayList<ClienteDTO> getlistadoclientes() {
		ArrayList<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		ClienteDTO cli=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			con=MySQLConexion.getConexion();
			String sql="Select * from tb_cliente where estado = ? ";
			pst=con.prepareStatement(sql);
			pst.setInt(1, 0);
			rs=pst.executeQuery();
			while(rs.next()){
				File archivo = null;
				String nomArchivo=null;
				if(rs.getString("foto")!=null){
					archivo = new File(rs.getString("foto"));
					nomArchivo = archivo.getName();	
				}else{
					nomArchivo="personaPorDefecto.jpg";
				}	
				cli=new ClienteDTO(rs.getString("usuario"),rs.getString("clave"),rs.getString("codCliente"), rs.getString("nomCliente"),
								   rs.getString("apePaterCliente"),rs.getString("apeMaterCliente"),rs.getString("TipoDocumento"),
								   rs.getString("nroDocumentoId"),rs.getString("sexo"),rs.getString("fechaNac"), rs.getString("email"),
								   rs.getString("telef"),rs.getString("codCiudad"),nomArchivo, rs.getInt("estado"));
				lista.add(cli);
			}
			return lista;
		} catch (Exception e) {
			System.out.println("Error :"+e.getLocalizedMessage());
		}finally{
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close(); 
				if(rs!=null)  rs.close();
			} catch (Exception e2) {
				System.out.println("Error :"+e2.getLocalizedMessage());
			}
		}
		return lista;
	}

	@Override
	public int eliminarCliente(String cod) {
		Connection con=null;
		PreparedStatement pst=null;
		int rs=0;
		try {
			con=MySQLConexion.getConexion();
			String sql="Update tb_cliente set estado=1 where codCliente=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,cod);
			
			rs = pst.executeUpdate();	
		} catch (Exception e) {
			System.out.println("Error"+e.getLocalizedMessage());
		}finally{
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				System.out.println("Error"+e2.getLocalizedMessage());
			}
		}
		return rs;
	}

	@Override
	public int registrarCliente(String codigo, String nombre,
			String apePaterno, String apeMaterno, String tipoDocID,
			int nroDocID, String sexo, String email, int telefono, String fecha,
			String codciudad,byte[] foto, int estado, String usuario, String clave) {

		Connection con=null;
		PreparedStatement pst=null;
		int rs=0;
		try {
			con=MySQLConexion.getConexion();
			String sql="Insert Into tb_cliente(codCliente,nomCliente,apePaterCliente,apeMaterCliente,TipoDocumento,"
					+ "nroDocumentoId,sexo,email,telef,fechaNac,codCiudad,foto,estado,usuario,clave) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1,codigo );
			pst.setString(2, nombre);
			pst.setString(3, apePaterno);
			pst.setString(4, apeMaterno);
			pst.setString(5, tipoDocID);
			pst.setInt(6, nroDocID);
			pst.setString(7, sexo);
			pst.setString(8, email);
			pst.setInt(9, telefono);
			pst.setString(10, fecha);
			pst.setString(11, codciudad);
			pst.setBytes(12, foto);
			pst.setInt(13, estado);
			pst.setString(14, usuario);
			pst.setString(15, clave);
			
			rs = pst.executeUpdate();		
		} catch (Exception e) {
			System.out.println("Error"+e.getLocalizedMessage());
		}finally{
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				System.out.println("Error"+e2.getLocalizedMessage());
			}
		}
		return rs;
	}

	@Override
	public int actualizarCliente(String codigo, String nombre,
			String apePaterno, String apeMaterno, String tipoDocID,
			int nroDocID, String sexo, String email, int telefono,
			String fecha, String codciudad, byte[] foto, int estado,
			String clave) {
		Connection con=null;
		PreparedStatement pst=null;
		int rs=0;
		try {
			con=MySQLConexion.getConexion();
			String sql="Update tb_cliente set nomCliente=?,apePaterCliente=?,apeMaterCliente=?,"
					+ "TipoDocumento=?,nroDocumentoId=?,sexo=?,email=?,telef=?,fechaNac=?,"
					+ "codCiudad=?,foto=?,estado=?,clave=? where codCliente=?";
			pst=con.prepareStatement(sql);
			
			pst.setString(1, nombre);
			pst.setString(2, apePaterno);
			pst.setString(3, apeMaterno);
			pst.setString(4, tipoDocID);
			pst.setInt(5, nroDocID);
			pst.setString(6, sexo);
			pst.setString(7, email);
			pst.setInt(8, telefono);
			pst.setString(9, fecha);
			pst.setString(10, codciudad);
			pst.setBytes(11, foto);
			pst.setInt(12, estado);
			pst.setString(13, clave);
			pst.setString(14, codigo);
			
			rs = pst.executeUpdate();	
		} catch (Exception e) {
			System.out.println("Error"+e.getLocalizedMessage());
		}finally{
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				System.out.println("Error"+e2.getLocalizedMessage());
			}
		}
		return rs;
	}
	
	public ClienteDTO validaCliente(String user, String clave) {
		ClienteDTO clien = null;
		Connection con = null;    	
		PreparedStatement pst=null;		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "Select * From tb_cliente Where usuario=? And clave=?";  
			pst=con.prepareStatement(sql);
			pst.setString(1, user);			
			pst.setString(2, clave);
			ResultSet rs = pst.executeQuery(); 
		
			if (rs.next()){
				File archivo = null;
				String nomArchivo=null;
				if(rs.getString("foto")!=null){
					archivo = new File(rs.getString("foto"));
					nomArchivo = archivo.getName();	
				}else{
					nomArchivo="personaPorDefecto.jpg";
				}	   	
				String codigo = rs.getString(1);
				clien = new ClienteDTO(rs.getString("usuario"), rs.getString("clave"),codigo, rs.getString("nomCliente"), rs.getString("apePaterCliente"), 
						rs.getString("apeMaterCliente"), rs.getString("TipoDocumento"), rs.getString("nroDocumentoId"), rs.getString("sexo"), 
						rs.getString("fechaNac"), rs.getString("email"), rs.getString("telef"), rs.getString("codCiudad"), nomArchivo, rs.getInt("estado"));
			}	
		} catch (Exception e) {
			System.out.println("Error en la conexion -- desde el Servlet");
			e.printStackTrace();
		} finally {
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar -- desde el Servlet");
			}
		}
		return clien;
	}
	
	public ClienteDTO obtenerCliente(String cod) {
		ClienteDTO clien = null;
		Connection con = null;    	
		PreparedStatement pst=null;		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "Select * From tb_cliente Where codCliente=?";  
			pst=con.prepareStatement(sql);
			pst.setString(1, cod);	
			ResultSet rs = pst.executeQuery(); 
		
			if (rs.next()){
				File archivo = null;
				String nomArchivo=null;
				if(rs.getString("foto")!=null){
					archivo = new File(rs.getString("foto"));
					nomArchivo = archivo.getName();	
				}else{
					nomArchivo="personaPorDefecto.jpg";
				}	
				@SuppressWarnings("unused")
				String codigo = rs.getString(1);
				clien = new ClienteDTO(rs.getString("usuario"), rs.getString("clave"), rs.getString("codCliente"), rs.getString("nomCliente"), rs.getString("apePaterCliente"), 
						rs.getString("apeMaterCliente"), rs.getString("TipoDocumento"), rs.getString("nroDocumentoId"), rs.getString("sexo"), 
						rs.getString("email"), rs.getString("telef"), rs.getString("fechaNac"), rs.getString("codCiudad"), nomArchivo, rs.getInt("estado"));
			}
		} catch (Exception e) {
			System.out.println("Error en la conexion -- desde el Servlet");
			e.printStackTrace();
		} finally {
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar -- desde el Servlet");
			}
		}
		return clien;
	}
	@Override
	public boolean validaRegistroCliente(String codCliente) {

		List<RutaDTO> lista = new ArrayList<RutaDTO>();
		String sql = "Select  codCliente From tb_cliente Where codCliente = '" + codCliente + "'";

		try  {
			Connection con = MySQLConexion.getConexion();
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				PersonaDTO r = new PersonaDTO(rs.getString("codCliente"));
			
				if (codCliente.equals(r.getCodigo())) {
					System.out.println("Este codigo ya existe");
					return false;
				}
				else {
					
					System.out.println("NO  existe ingreselo");
				
				
				}
			

			}
			 rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error en la BD - getListado");
			
		}
		return true;
	}
}