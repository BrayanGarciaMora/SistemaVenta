package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	Connection con;

	String url = "jdbc:mysql://localhost:3306/bd_ventas";
	String user = "BGM";
	String pass = "Pass2021*";

	public Connection conexion() throws ClassNotFoundException {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Se establecio la conexion Conexion");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no conexion");
		}
		return con;
	}

}
