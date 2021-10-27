package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexion() {
		Connection conn = null;
		try {

			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost/db_futurama";
			String user = "root";
			String psw = "mysql";

			conn = DriverManager.getConnection(url, user, psw);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error de driver");
		} catch (SQLException e) {
			System.out.println("Ocurre Error Database " + e.getMessage());
		}

		return conn;
	}
}
