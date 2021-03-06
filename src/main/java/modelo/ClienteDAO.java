package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class ClienteDAO {
	// ---------------------------------------------------------------------
	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	int r;
	// ---------------------------------------------------------------------

	public Cliente buscarCliente(String dni) {

		Cliente c = new Cliente();

		// Crear consulta sql para la busqueda
		String sql = "SELECT * FROM cliente WHERE Dni =" + dni;

		try {
			// Crear la conexion
			con = cn.conexion();
			// Prepara la consulta
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				c.setIdCliente(rs.getInt(1));
				c.setDni(rs.getString(2));
				c.setNombre(rs.getString(3));
				c.setDireccion(rs.getString(4));
				c.setEstado(rs.getString(5));

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Algo no anda bien 'Consulta clientes'");
			e.getStackTrace();
		}
		return c;
	}
	// ---------------------------------------------Metodo Listar---------//

	public List listarCliente() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> listaCliente = new ArrayList<>();

		try {

			con = cn.conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt(1));
				cliente.setDni(rs.getString(2));
				cliente.setNombre(rs.getString(3));
				cliente.setDireccion(rs.getString(4));
				cliente.setEstado(rs.getString(5));

				listaCliente.add(cliente);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			System.out.println("No se ha podido Establecer la conexion");
		}
		return listaCliente;
	}

	// ---------------------------------------------Metodo Agregar---------//

	public int agregar(Cliente cliente) {

		// Consulta sql
		String sql = "INSERT INTO cliente (Dni, Nombres, Direccion, Estado) VALUES (?,?,?,?)";
		try {
			// pedir la conexion a la base de datos
			con = cn.conexion();
			ps = con.prepareStatement(sql);

			// Prepara la consulta
			ps.setString(1, cliente.getDni());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getDireccion());
			ps.setString(4, cliente.getEstado());

			// Ejecutar la consulta

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}

		return r;
	}

	// ------------------------------------------------------------------

	public Cliente listarId(int id) {
		Cliente cliente = new Cliente();
		String sql = "SELECT * FROM cliente WHERE IdCliente =" + id;

		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				cliente.setDni(rs.getString(2));
				cliente.setNombre(rs.getString(3));
				cliente.setDireccion(rs.getString(4));
				cliente.setEstado(rs.getString(5));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return cliente;
	}

	// ---------------------------------------------Metodo Actualizar---------//

	public int actualizar(Cliente cliente) {

		// Crear la consulta SQL
		String sql = "Update cliente SET Dni =?, Nombres =?, Direccion =?, Estado =? WHERE IdCliente =?";

		try {
			// Crear la conexion
			con = cn.conexion();

			// Preparar la consulta SQL
			ps = con.prepareStatement(sql);

			ps.setString(1, cliente.getDni());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getDireccion());
			ps.setString(4, cliente.getEstado());
			ps.setInt(5, cliente.getIdCliente());

			// Ejecutar la consulta SQL

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return r;
	}

	// ---------------------------------------------Metodo Eliminar---------//
	public void Eliminar(int id) {

		String sql = "DELETE FROM cliente WHERE IdCliente =" + id;

		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
}
