package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	Connection con;

	String url = "jdbc:mysql://localhost:3306/bd_ventas";
	String user = "root";
	String pass = "1234561996BGM";

	public Connection conexion() throws ClassNotFoundException {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pass);
			System.out.println("establecio la conexion");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no conexion");
		}
		return con;
	}

}
