package dao;

import beans.BusDTO;

import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import services.TipoServicioService;
import utils.MySQLConexion;
import beans.TipoServicioDTO;
import interfaces.BusDAO;

public class MySQLBusDAO implements BusDAO{
	TipoServicioService serv = new TipoServicioService();
	@Override
	public int registrarBus(String nroPlaca, String anioFabricacion,
			String marca, String numAsientos, String tipServi, int estado,
			byte[] foto) {
		Connection con = null;
		CallableStatement cst = null;
		int rs = 0;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{Call usp_ingresarBus(?,?,?,?,?,?,?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, nroPlaca);
			cst.setString(2, anioFabricacion);
			cst.setString(3, marca);
			cst.setString(4, numAsientos);
			cst.setString(5, tipServi);
			cst.setBytes(6, foto);
			cst.setInt(7, estado);
			
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al Ingresar Bus :"+e.getMessage());
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
	public int actualizarBus(String nroPlaca, String anioFabricacion,
			String marca, String numAsientos, String tipServi, int estado,
			byte[] foto) {
		Connection con = null;
		CallableStatement cst = null;
		int rs = 0;
		
		try {
			con = MySQLConexion.getConexion();
			String sql = "{Call usp_actualizarBus(?,?,?,?,?,?,?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, nroPlaca);
			cst.setString(2, anioFabricacion);
			cst.setString(3, marca);
			cst.setString(4, numAsientos);
			cst.setString(5, tipServi);
			cst.setBytes(6, foto);
			cst.setInt(7, estado);
			
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al Actualizar Bus :"+e.getMessage());
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
	public int eliminarBus(String nroPlaca) {
		Connection con = null;
		CallableStatement cst = null;
		int rs = 0;
		
		try {
			con = MySQLConexion.getConexion();
			String sql = "{Call usp_eliminarBus(?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, nroPlaca);
			
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al Eliminar Bus :"+e.getMessage());
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
	public ArrayList<BusDTO> listarBuses() {
		ArrayList<BusDTO> lista = new ArrayList<BusDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "Select * From tb_bus Where estado=0";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				File archivo = null;
				String nomArchivo=null;
				if(rs.getString("foto")!=null){
					archivo = new File(rs.getString("foto"));
					nomArchivo = archivo.getName();	
				}else{
					nomArchivo="busesPorDefecto.jpg";
				}	
				TipoServicioDTO tipoS = serv.getTipoServicio(rs.getString("tipoServicio"));
				lista.add(new BusDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), tipoS, rs.getInt(6),nomArchivo));
			}
			return lista;
		} catch (Exception e) {
			System.out.println("Error al Listar Buses : "+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (Exception ex) {
				System.out.println("Error al cerrar");
			}		
		}
		return lista;
	}
	//va a pasar a TipoServicio
	public ImageIcon obtenerFotoBus(String placa) {
		ImageIcon cimageicon = null;
		InputStream inputstream = null;
		try {
			Connection con = MySQLConexion.getConexion();
			PreparedStatement pst = con.prepareStatement("Select foto From tb_bus Where nroPlaca = ?");
			pst.setString(1, placa);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				inputstream = rs.getBinaryStream(1);
				if (inputstream != null) {	
					BufferedImage bufferimage = ImageIO.read(inputstream);			
					cimageicon = new ImageIcon(bufferimage);
				}
			}
			con.close();
			pst.close();
			rs.close();
		} catch (SQLException | IOException es) {
			JOptionPane.showMessageDialog(null, "Error al Obtener Foto del Bus:" + es.getMessage());
			es.printStackTrace();
		}
		return cimageicon;
	}

	@Override
	public BusDTO obtenerBus(String codigo) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		BusDTO x = null;
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select * from tb_bus where nroPlaca=?");
			pst.setString(1, codigo);
			rs = pst.executeQuery();
			
			if(rs.next()){
				File archivo = null;
				String nomArchivo=null;
				if(rs.getString("foto")!=null){
					archivo = new File(rs.getString("foto"));
					nomArchivo = archivo.getName();	
				}else{
					nomArchivo="busesPorDefecto.jpg";
				}	
				TipoServicioDTO tipoS = serv.getTipoServicio(rs.getString("tipoServicio"));
				x = new BusDTO(rs.getString("nroPlaca"),rs.getString("anioFabricacion"),rs.getString("marca"),rs.getString("numAsientos"),tipoS,
						rs.getInt("estado"),nomArchivo);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error al obtener Bus: " + e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				if(con!=null) con.close();
				if(pst!=null) con.close();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error2 al obtener Bus: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return x;
	}
}