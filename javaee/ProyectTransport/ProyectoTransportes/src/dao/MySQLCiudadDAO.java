package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utils.MySQLConexion;
import beans.CiudadDTO;
import interfaces.CiudadDAO;

public class MySQLCiudadDAO implements CiudadDAO{

	@Override
	public ArrayList<CiudadDTO> listarCiudad() {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		CiudadDTO x = null;
		ArrayList<CiudadDTO> lista = new ArrayList<CiudadDTO>();
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select*from tb_ciudad");
			rs = pst.executeQuery();
			while(rs.next()){
				x = new CiudadDTO(rs.getString("codCiudad"),rs.getString("nomCiudad"));
				lista.add(x);
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al listar Ciudad: " + e.getMessage());
		}finally{
			try{
				if(con!=null)con.close();
				if(pst!=null)pst.close();
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error2 al listar Ciudad: " + e.getMessage());
			}
		}
		return lista;
	}
}