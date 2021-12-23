package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class ProductoDAO {

	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	int r;

	// Operaciones de tipo CRUD

	// Metodo par realizar la parete del [Read] Del CRUD

	// ---------------------------------------------Metodo Listar---------//
	public List listarProducto() {

		String sql = "SELECT * FROM producto";

		List<Producto> listaProducto = new ArrayList<>();

		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Producto producto = new Producto();
				producto.setIdProducto(rs.getInt(1));
				producto.setNombre(rs.getString(2));
				producto.setPrecio(rs.getDouble(3));
				producto.setStock(rs.getInt(4));
				producto.setEstado(rs.getString(5));

				listaProducto.add(producto);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaProducto;
	}

	// Metodo agregar Para formar la parte De [Create] del CRUP

	// ---------------------------------------------Metodo Agregar---------//
	public int agregarProducto(Producto pro) {
		String sql = "INSERT INTO producto (Nombres,Precio,Stock,Estado) VALUES(?,?,?,?)";
		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);

			ps.setString(1, pro.getNombre());
			ps.setDouble(2, pro.getPrecio());
			ps.setInt(3, pro.getStock());
			ps.setString(4, pro.getEstado());

			ps.executeUpdate();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return r;

	}

	// -----------------------------------------------------------------------------

	public Producto listarId(int id) {
		Producto producto = new Producto();
		String sql = "SELECT * FROM producto WHERE IdProducto =" + id;
		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				producto.setNombre(rs.getString(2));
				producto.setPrecio(rs.getDouble(3));
				producto.setStock(rs.getInt(4));
				producto.setEstado(rs.getString(5));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return producto;
	}

	// ---------------------------------------------Metodo Actualizar---------//

	public int actualizarProducto(Producto pro) {

		String sql = "UPDATE  producto SET Nombres=?, Precio=?, Stock=?, Estado=? WHERE IdProducto=?";
		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);

			ps.setString(1, pro.getNombre());
			ps.setDouble(2, pro.getPrecio());
			ps.setInt(3, pro.getStock());
			ps.setString(4, pro.getEstado());
			ps.setInt(5, pro.getIdProducto());
			ps.executeUpdate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return r;
	}

	// ---------------------------------------------Metodo Eliminar---------//
	public void EliminarProducto(int id) {
		System.out.println("El id es " + id);
		String sql = "DELETE FROM producto WHERE IdProducto =" + id;

		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
