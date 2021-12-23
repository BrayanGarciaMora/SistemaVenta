package modelo;

public class Producto {
	private int IdProducto;
	private String Nombre;
	private double Precio;
	private int Stock;
	private String Estado;

	public Producto(int idProducto, String nombre, double precio, int stock, String estado) {
		super();
		IdProducto = idProducto;
		Nombre = nombre;
		Precio = precio;
		Stock = stock;
		Estado = estado;
	}

	public Producto() {

	}

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}
	
	

}
