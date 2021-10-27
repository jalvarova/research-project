package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.MySQLConexion;
import beans.TipoDocumentoDTO;
import interfaces.TipoDocumentoDAO;

public class MySQLTipoDocumentoDAO implements TipoDocumentoDAO{

	@Override
	public ArrayList<TipoDocumentoDTO> listarTipoDocumento() {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		TipoDocumentoDTO x = null;
		ArrayList<TipoDocumentoDTO> lista = new ArrayList<TipoDocumentoDTO>();
		try{
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Select * from tb_tipoDocumento");
			rs = pst.executeQuery();
			while(rs.next()){
				x = new TipoDocumentoDTO(rs.getInt("idTipoDocumento"),rs.getString("nombreTipoDocumento"));
				lista.add(x);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al listar Documento: " + e.getMessage());
		}finally{
			try{
				if(con!=null)con.close();
				if(pst!=null)pst.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Error2 al listar Documento: " + e.getMessage());
			}
		}
		return lista;
	}
}