package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import utils.MySQLConexion;
import beans.ChoferDTO;
import interfaces.ChoferDAO;

public class MySQLChoferDAO implements ChoferDAO{

	@Override
	public int registrarChofer(String codigo, String nroLicencia, String nombre, String apePater,
			String apeMater, String tipoDocumento, String nroDocumentoID,
			String sexo, String fecNac, String email, String telefono,
			String ciudad, byte[] foto, int estado) {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("insert into tb_chofer (codChofer,nroLicencia,nomChofer,apePaterChofer,apeMaterChofer,TipoDocumento,nroDocumentoId,sexo,fechaNac,email,telefono,codCiudad,foto,estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, codigo);
			pst.setString(2, nroLicencia);
			pst.setString(3, nombre);
			pst.setString(4, apePater);
			pst.setString(5, apeMater);
			pst.setString(6, tipoDocumento);
			pst.setString(7, nroDocumentoID);
			pst.setString(8, sexo);
			pst.setString(9, fecNac);
			pst.setString(10, email);
			pst.setString(11, telefono);
			pst.setString(12, ciudad);
			pst.setBytes(13, foto);
			pst.setInt(14, estado);
			rs = pst.executeUpdate();
		}catch(Exception e){
			System.out.println("Error al registrar Chofer: " + e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				if(con!=null) con.close();
				if(pst!=null) con.close();
			}catch(Exception e){
				System.out.println("Error2 al registrar Chofer: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public int actualizaChofer(String codigo, String nroLicencia, String nombre, String apePater,
			String apeMater, String tipoDocumento, String nroDocumentoID,
			String sexo, String fecNac, String email, String telefono,
			String ciudad, byte[] foto, int estado) {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{			
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Update tb_chofer set nroLicencia=?,nomChofer=?,apePaterChofer=?,apeMaterChofer=?,TipoDocumento=?,nroDocumentoId=?,sexo=?,fechaNac=?,email=?,telefono=?,codCiudad=?,foto=?,estado=? where codChofer=?;");
			pst.setString(1, nroLicencia);
			pst.setString(2, nombre);
			pst.setString(3, apePater);
			pst.setString(4, apeMater);
			pst.setString(5, tipoDocumento);
			pst.setString(6, nroDocumentoID);
			pst.setString(7, sexo);
			pst.setString(8, fecNac);
			pst.setString(9, email);
			pst.setString(10, telefono);
			pst.setString(11, ciudad);
			pst.setBytes(12, foto);
			pst.setInt(13, estado);
			pst.setString(14, codigo);
			rs = pst.executeUpdate();
		}catch(Exception e){
			System.out.println("Error al actualizar Chofer: " + e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				if(con!=null) con.close();
				if(pst!=null) con.close();
			}catch(Exception e){
				System.out.println("Error2 al actualizar Chofer: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public int eliminarChofer(String codigo) {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("update tb_chofer set estado=1 where codChofer=?");
			pst.setString(1, codigo);
			rs = pst.executeUpdate();
		}catch(Exception e){
			System.out.println("Error al eliminar Chofer: " + e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				if(con!=null) con.close();
				if(pst!=null) con.close();
			}catch(Exception e){
				System.out.println("Error2 al eliminar Chofer: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public ArrayList<ChoferDTO> listaChofer() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<ChoferDTO> lista = new ArrayList<ChoferDTO>();
		ChoferDTO x = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select*from tb_chofer where estado=?");
			pst.setInt(1, 0);
			rs = pst.executeQuery();
			while(rs.next()){
				File archivo = null;
				String nomArchivo=null;
				if(rs.getString("foto")!=null){
					archivo = new File(rs.getString("foto"));
					nomArchivo = archivo.getName();	
				}else{
					nomArchivo="personaPorDefecto.jpg";
				}	
				x = new ChoferDTO(rs.getString("codChofer"),rs.getString("nroLicencia"),rs.getString("nomChofer"),rs.getString("apePaterChofer"),rs.getString("apeMaterChofer"),
						rs.getString("TipoDocumento"),rs.getString("nroDocumentoID"),rs.getString("Sexo"),sdf.format(rs.getDate("fechaNac")),rs.getString("email"),
						rs.getString("telefono"),rs.getString("codCiudad"),nomArchivo,rs.getInt("estado"));
				
				lista.add(x);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al listar Chofer: " + e.getMessage());
		}finally{
			try{
				if(con!=null)con.close();
				if(pst!=null)pst.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Error2 al listar Chofer: " + e.getMessage());
			}
		}
		return lista;
	}

	@Override
	public ChoferDTO obtenerChofer(String codigo) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ChoferDTO x = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select * from tb_chofer where codChofer=?");
			pst.setString(1, codigo);
			rs = pst.executeQuery();
			
			if(rs.next()){
				File archivo = null;
				@SuppressWarnings("unused")
				String nomArchivo=null;
				if(rs.getString("foto")!=null){
					archivo = new File(rs.getString("foto"));
					nomArchivo = archivo.getName();	
				}else{
					nomArchivo="personaPorDefecto.jpg";
				}	
				x = new ChoferDTO(rs.getString("codChofer"),rs.getString("nroLicencia"),rs.getString("nomChofer"),rs.getString("apePaterChofer"),rs.getString("apeMaterChofer"),
						rs.getString("TipoDocumento"),rs.getString("nroDocumentoID"),rs.getString("Sexo"),sdf.format(rs.getDate("fechaNac")),rs.getString("email"),
						rs.getString("telefono"),rs.getString("codCiudad"),null,rs.getInt("estado") );
			}
		}catch(Exception e){
			System.out.println("Error al obtener Chofer: " + e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				if(con!=null) con.close();
				if(pst!=null) con.close();
			}catch(Exception e){
				System.out.println("Error2 al obtener Chofer: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return x;
	}
}