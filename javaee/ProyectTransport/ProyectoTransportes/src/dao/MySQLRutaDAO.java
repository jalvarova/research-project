package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import utils.MySQLConexion;
import beans.CiudadDTO;
import beans.RutaDTO;
import interfaces.RutaDAO;

public class MySQLRutaDAO implements RutaDAO {

	@Override
	public List<RutaDTO> getListadoRutas() {
		List<RutaDTO> lista = new ArrayList<RutaDTO>();
		String sql = "Select * From tb_ruta Where estado = 0";
		try (Connection con = MySQLConexion.getConexion();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				CiudadDTO origen = getCiudad(rs.getString("codCiuOrig"));
				CiudadDTO destino = getCiudad(rs.getString("codCiuDest"));
				RutaDTO r = new RutaDTO(rs.getString("codRuta"), origen,
						destino,
						rs.getDouble("tarifa"),rs.getString("horaSalida"), rs.getInt("estado"));
				lista.add(r);
				System.out.println("" + origen + destino);
				System.out.println(lista);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en la BD - getListado");
		}
		return lista;
	}

	@Override
	public RutaDTO getRuta(String codigo) {

		RutaDTO r = null;
		String sql = "Select * From tb_ruta Where codRuta=?";
		try (Connection con = MySQLConexion.getConexion();
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				CiudadDTO ciuOrig = getCiudad(rs.getString("codCiuOrig"));
				CiudadDTO ciuDest = getCiudad(rs.getString("codCiuDest"));
				r = new RutaDTO(rs.getString("codRuta"), ciuOrig, ciuDest,
						 rs.getDouble("tarifa"),rs.getString("horaSalida"),
						rs.getInt("estado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en la BD");
		}
		return r;
	}

	@Override
	public int agregarRuta(RutaDTO x) {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			con = MySQLConexion.getConexion();
			pst = con
					.prepareStatement("Insert Into tb_ruta Values (?,?,?,?,?,?)");
			String destino = x.getCiudadDestino().getCodciudad();
			String origen = x.getCiudadOrigen().getCodciudad();
			pst.setString(1, x.getCodRuta());
			pst.setString(2, origen);
			pst.setString(3, destino);
			pst.setDouble(4, x.getTarifa());
			pst.setString(5, x.getHoraSalida());
			pst.setInt(6, x.getEstado());

			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al Registrar Ruta: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pst != null)
					pst.close();
			} catch (Exception e) {
				System.out.println("Error2 al registrar Ruta: "
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public int modificarRuta(RutaDTO x) {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			con = MySQLConexion.getConexion();
			pst = con
					.prepareStatement("Update tb_ruta Set codCiuOrig=?,codCiuDest=?,tarifa=?,horaSalida=?,estado=? Where codRuta=?");
			
			
			String destino = x.getCiudadDestino().getCodciudad();
			String origen = x.getCiudadOrigen().getCodciudad();
			pst.setString(1, origen);
			pst.setString(2, destino);
			pst.setDouble(3, x.getTarifa());
			pst.setString(4, x.getHoraSalida());
			pst.setInt(5, x.getEstado());
			pst.setString(6, x.getCodRuta());

			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al Actualizar Ruta: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pst != null)
					pst.close();
			} catch (Exception e) {
				System.out.println("Error2 al Actualizar Ruta: "
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public int eliminarRuta(String cod) {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement("Delete From tb_ruta Where codRuta=?");
			pst.setString(1, cod);

			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al Eliminar Ruta: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pst != null)
					pst.close();
			} catch (Exception e) {
				System.out
						.println("Error2 al Eliminar Ruta: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public ArrayList<RutaDTO> getListadoRutas(CiudadDTO origen) {

		return null;
	}

	@Override
	public RutaDTO getRuta(String origen, String destino) {
		RutaDTO r = null;
		String sql = "Select * From tb_ruta Where codCiuOrig=? And codCiuDest=? And estado=?";
		try (Connection con = MySQLConexion.getConexion();
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, origen);
			pst.setString(2, destino);
			pst.setInt(3, 0);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				CiudadDTO ciuOrig = getCiudad(rs.getString("codCiuOrig"));
				CiudadDTO ciuDest = getCiudad(rs.getString("codCiuDest"));
				r = new RutaDTO(rs.getString("codRuta"), ciuOrig, ciuDest,
						 rs.getDouble("tarifa"),rs.getString("horaSalida"),
						rs.getInt("estado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en la BD");
		}
		return r;
	}

	@Override
	public ArrayList<CiudadDTO> getCiudadesOrigen() {
		ArrayList<CiudadDTO> lista = new ArrayList<CiudadDTO>();
		String sql = "Select r.codCiuOrig,c.nomCiudad From tb_ruta r Inner Join tb_ciudad c on r.codCiuOrig=c.codCiudad "
				+ "Group By r.codCiuOrig";
		try (Connection con = MySQLConexion.getConexion();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				CiudadDTO c = new CiudadDTO(rs.getString("codCiuOrig"),
						rs.getString("nomCiudad"));
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en la BD");
		}
		return lista;
	}

	@Override
	public ArrayList<CiudadDTO> getCiudadesDestino(String codCiudad) {
		ArrayList<CiudadDTO> lista = new ArrayList<CiudadDTO>();

		String sql = "Select r.codCiuDest,c.nomCiudad From tb_ruta r Inner Join tb_ciudad c on r.codCiuDest=c.codCiudad "
				+ "Where r.codCiuOrig=?";
		try (Connection con = MySQLConexion.getConexion();
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, codCiudad);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				CiudadDTO c = new CiudadDTO(rs.getString("codCiuDest"),
						rs.getString("nomCiudad"));
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en la BD");
		}
		return lista;
	}

	@Override
	public CiudadDTO getCiudad(String codigo) {
		CiudadDTO c = null;

		String sql = "Select * From tb_ciudad Where codCiudad=?";
		Connection con = MySQLConexion.getConexion();
		PreparedStatement pst = null;
		try {

			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				c = new CiudadDTO(rs.getString("codCiudad"),
						rs.getString("nomCiudad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en la BD - getCiudad");
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;
	}

	@Override
	public boolean validaRuta(String codRuta) {

		List<RutaDTO> lista = new ArrayList<RutaDTO>();
		String sql = "Select codRuta From tb_ruta Where codRuta = '" + codRuta + "'";

		try  {
			Connection con = MySQLConexion.getConexion();
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				RutaDTO r = new RutaDTO(rs.getString("codRuta"));
			
				if (codRuta.equals(r.getCodRuta())) {
					System.out.println("Este codigo ya existe Desea Actualizarlo");
					return true;
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
		return false;
	}
}