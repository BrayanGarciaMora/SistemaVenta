package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.*;

public class EmpleadoDAO {

	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	int r;

	public Empleado validar(String user, String dni) {

		Empleado empleado = new Empleado();

		String sql = "SELECT * FROM empleado WHERE User=? and Dni=?";
		try {

			con = cn.conexion();

			ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, dni);

			rs = ps.executeQuery();

			while (rs.next()) {

				empleado.setUser(rs.getString("User"));
				empleado.setDni(rs.getString("Dni"));
				empleado.setNombre(rs.getString("Nombres"));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return empleado;
	}

	// Operaciones de tipo CRUD

	//Metodo par realizar la parete del [Read] Del CRUD
	public List listar() {

		String sql = "SELECT * FROM empleado";

		List<Empleado> lista = new ArrayList<>();

		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Empleado em = new Empleado();
				em.setIdEmpleado(rs.getInt(1));
				em.setDni(rs.getString(2));
				em.setNombre(rs.getString(3));
				em.setTelefono(rs.getString(4));
				em.setEstado(rs.getString(5));
				em.setUser(rs.getString(6));

				lista.add(em);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	//Metodo agregar Para formar la parte De [Create] del CRUP
	public int agregar(Empleado em) {
		String sql = "INSERT INTO empleado (Dni,Nombres,Telefono,Estado,User) VALUES(?,?,?,?,?)";
		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);

			ps.setString(1, em.getDni());
			ps.setString(2, em.getNombre());
			ps.setString(3, em.getTelefono());
			ps.setString(4, em.getEstado());
			ps.setString(5, em.getUser());

			ps.executeUpdate();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return r;

	}

	public Empleado listarId(int id) {
		Empleado emp = new Empleado();
		String sql = "SELECT * FROM empleado WHERE IdEmpleado =" + id;
		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				emp.setDni(rs.getString(2));
				emp.setNombre(rs.getString(3));
				emp.setTelefono(rs.getString(4));
				emp.setEstado(rs.getString(5));
				emp.setUser(rs.getString(6));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return emp;
	}

	public int actualizar(Empleado em) {

		String sql = "UPDATE  empleado SET Dni=?, Nombres=?, Telefono=?, Estado=?, User=? WHERE IdEmpleado=?";
		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);

			ps.setString(1, em.getDni());
			ps.setString(2, em.getNombre());
			ps.setString(3, em.getTelefono());
			ps.setString(4, em.getEstado());
			ps.setString(5, em.getUser());
			ps.setInt(6, em.getIdEmpleado());
			ps.executeQuery();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return r;
	}

	public void delete(int id) {

		String sql = "DELETE FROM empleado WHERE IdEmpleado=" + id;

		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);
			ps.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
