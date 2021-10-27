package dao;

import java.sql.PreparedStatement;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utils.MySQLConexion;
import beans.AdministradorDTO;
import interfaces.AdministradorDAO;

public class MySQLAdministradorDAO implements AdministradorDAO {

	public AdministradorDTO validaAdministrador(String admin, String clave) {
		AdministradorDTO adminis = null;
		Connection con = null;    	
		PreparedStatement pst=null;		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "Select * From tb_admin Where usuario=? And clave=?";  
			pst=con.prepareStatement(sql);
			pst.setString(1, admin);			
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
				adminis = new AdministradorDTO(codigo, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), nomArchivo, rs.getInt(15));
			}	
		} catch (Exception e) {
			System.out.println("Error validando Administrador");
			e.printStackTrace();
		} finally {
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar -- desde el Servlet");
			}
		}
		return adminis;
	}
	
	public static ImageIcon obtenerFotoAdmin(String codigo) {
		ImageIcon imagen = null;
		InputStream inputstream = null;
		try {
			Connection con = MySQLConexion.getConexion();
			String sql = "Select Foto From tb_admin Where codAdmin = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				inputstream = rs.getBinaryStream(1);
				if (inputstream != null) {
					BufferedImage bufferimage = ImageIO.read(inputstream);
					imagen = new ImageIcon(bufferimage);
				}
			}
			con.close();
			pst.close();
			rs.close();
		} catch (SQLException | IOException ex) {
			JOptionPane.showMessageDialog(null, "Error al obtenerFotoAdmin:" + ex.getMessage());
			ex.printStackTrace();
		}
		return imagen;
	}
}