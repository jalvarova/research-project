package dao;

import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import utils.MySQLConexion;
import beans.TerramozaDTO;
import interfaces.TerramozaDAO;

public class MySQLTerramozaDAO implements TerramozaDAO{

	@Override
	public int registrarTerramoza(String codigo, String nombre, String apePater, String apeMater,
			String tipoDocumento, String nroDocumentoID, String sexo,
			String fecNac, String email, String telefono,
			String ciudad,byte[] foto,int estado) {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			
			String sql="Insert Into tb_terramoza (codTerramoza,nomTerramoza,apePaterTerramoza,apeMaterTerramoza,TipoDocumento,nroDocumentoId,sexo,fechaNac,email,telefono,codCiudad,foto,estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			System.out.println("probando");
			pst.setString(1, codigo);
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
			rs = pst.executeUpdate();
			System.out.println("por que  no");
		}catch(Exception e){
			System.out.println("Error al registrar Terramoza: " + e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				if(con!=null) con.close();
				if(pst!=null) pst.close();
			}catch(Exception e){
				System.out.println("Error2 al registrar Terramoza: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public int actualizaTerramoza(String codigo, String nombre, String apePater, String apeMater,
			String tipoDocumento, String nroDocumentoID, String sexo,
			String fecNac, String email, String telefono,
			String ciudad,byte[] foto,int estado) {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareCall("update tb_terramoza set nomTerramoza=?,apePaterTerramoza=?,apeMaterTerramoza=?,TipoDocumento=?,nroDocumentoId=?,sexo=?,fechaNac=?,email=?,telefono=?,codCiudad=?,foto=?,estado=? where codTerramoza=?;");
			pst.setString(1, nombre);
			pst.setString(2, apePater);
			pst.setString(3, apeMater);
			pst.setString(4, tipoDocumento);
			pst.setString(5, nroDocumentoID);
			pst.setString(6, sexo);
			pst.setString(7, fecNac);
			pst.setString(8, email);
			pst.setString(9, telefono);
			pst.setString(10, ciudad);
			pst.setBytes(11, foto);
			pst.setInt(12, estado);
			pst.setString(13, codigo);
			rs = pst.executeUpdate();
		}catch(Exception e){
			System.out.println("Error al actualizar Terramoza: " + e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				if(con!=null) con.close();
				if(pst!=null) pst.close();
			}catch(Exception e){
				System.out.println("Error2 al actualizar Terramoza: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public int eliminarTerramoza(String codigo) {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			String sql = "update tb_terramoza set estado=1 where codTerramoza=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			
			rs = pst.executeUpdate();
		}catch(Exception e){
			System.out.println("Error al eliminar Terramoza: " + e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				if(con!=null) con.close();
				if(pst!=null) pst.close();
			}catch(Exception e){
				System.out.println("Error2 al eliminar Terramoza: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public ArrayList<TerramozaDTO> listaTerramoza() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<TerramozaDTO> lista = new ArrayList<TerramozaDTO>();
		TerramozaDTO x = null;

		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select * from tb_terramoza where estado=?");
			pst.setInt(1, 0);
			rs = pst.executeQuery();
			while(rs.next()){
				File archivo = null;
				String nomArchivo=null;
				if(rs.getString("foto")!=nomArchivo){
					archivo = new File(rs.getString("foto"));
					nomArchivo = archivo.getName();	
				}else{
					nomArchivo="personaPorDefecto.jpg";
				}	
				x = new TerramozaDTO(rs.getString("codTerramoza"),rs.getString("nomTerramoza"),rs.getString("apePaterTerramoza"),rs.getString("apeMaterTerramoza"),
						rs.getString("TipoDocumento"),rs.getString("nroDocumentoID"),rs.getString("Sexo"),rs.getString("fechaNac"),rs.getString("email"),
						rs.getString("telefono"),rs.getString("codCiudad"),null,rs.getInt("estado"));
				
				lista.add(x);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al listar Terramoza: " + e.getMessage());
		}finally{
			try{
				if(con!=null)con.close();
				if(pst!=null)pst.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Error2 al listar Terramoza: " + e.getMessage());
			}
		}
		return lista;
	}

	@Override
	public TerramozaDTO obtenerTerramoza(String codigo) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		TerramozaDTO x = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select * from tb_terramoza where codTerramoza=?");
			pst.setString(1, codigo);
			rs = pst.executeQuery();
			if(rs.next()){
				File archivo = null;
				String nomArchivo=null;
				if(rs.getString("foto")!=null){
					archivo = new File(rs.getString("foto"));
					nomArchivo = archivo.getName();	
				}else{
					nomArchivo="personaPorDefecto.jpg";
				}	
				x = new TerramozaDTO(rs.getString("codTerramoza"),rs.getString("nomTerramoza"),rs.getString("apePaterTerramoza"),rs.getString("apeMaterTerramoza"),
						rs.getString("TipoDocumento"),rs.getString("nroDocumentoID"),rs.getString("Sexo"),sdf.format(rs.getDate("fechaNac")),rs.getString("email"),
						rs.getString("telefono"),rs.getString("codCiudad"),nomArchivo,rs.getInt("estado"));
			}
		}catch(Exception e){
			System.out.println("Error al obtener Terramoza: " + e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				if(con!=null) con.close();
				if(pst!=null) pst.close();
			}catch(Exception e){
				System.out.println("Error2 al obtener Terramoza: " + e.getMessage());
				e.printStackTrace();
			}	
		}
		return x;
	}
}