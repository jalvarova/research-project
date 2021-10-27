package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.MySQLConexion;
import beanDTO.TicketDTO;
import interfaces.TicketDAO;

public class MysqlTicketDAO implements TicketDAO {

	public TicketDTO MostrarTicket(TicketDTO ti){
       
		Connection conn = null; 
		PreparedStatement  ps = null;
		ResultSet  rs  = null; 
		
		try {
			conn = MySQLConexion.getConexion();
			String sql =  "v_TicketAtencion";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
			ti = new  TicketDTO(
					
					rs.getString(1), 
					rs.getString(2),
					rs.getString(3), 
					rs.getString(4), 
					rs.getInt(5), 
					rs.getString(6), 
					rs.getString(7), 
					rs.getString(8), 
					rs.getString(9), 
					rs.getInt(10), 
					rs.getString(11));
			
			}
		
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Error Al traer Ticket");
		}
		
		
		
		
		
		return ti;
		
		
		
	}
	
	
}
