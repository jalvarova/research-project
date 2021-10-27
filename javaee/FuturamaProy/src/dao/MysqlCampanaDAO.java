package dao;

import interfaces.CampanaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

import util.MySQLConexion;
import beanDTO.CampanaDTO;
import beanDTO.EstadoDTO;

public class MysqlCampanaDAO implements CampanaDAO {

	public List<CampanaDTO> ListarCampana() {

		ArrayList<CampanaDTO> lista = new ArrayList<CampanaDTO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_campaña";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				CampanaDTO c = new CampanaDTO(rs.getString(1), rs.getString(2));
				lista.add(c);
			}
		} catch (Exception e) {

			System.out.println("Error en la lista");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				System.out.println("Error al cerrar");
			}
		}

		return lista;

	}
}
