package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import utils.MySQLConexion;
import beans.BoletoDTO;
import interfaces.BoletoDAO;

public class MySQLBoletoDAO implements BoletoDAO {

	@Override
	public int registrarBoleto(BoletoDTO boleto) {
		int rs = 0;

		PreparedStatement pst = null;
		try(Connection con = MySQLConexion.getConexion();){
				
			String sql = "Insert into tb_boleto values(?,?,?,?,?,?,?,?,?)";
			 pst = con.prepareStatement(sql);
			pst.setString(1, boleto.getNroBoleto());
			pst.setString(2,boleto.getFechaEmision());
			pst.setString(3, boleto.getIdPasajero());
			pst.setString(4, boleto.getCliente().getCodigo());
			pst.setString(5,boleto.getFechaViaje());
			pst.setString(6,boleto.getRecurso().getCodRecurso());
			pst.setInt(7, boleto.getNroAsiento());
			pst.setDouble(8, boleto.getPrecioSol());
			pst.setDouble(9,boleto.getPrecioDolar());
			rs = pst.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pst!=null) pst.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return rs;
	}
}