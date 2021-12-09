package modelo;

public class Empleado {

	public Empleado(int idEmpleado, String dni, String nombre, String telefono, String estado, String user) {
		super();
		this.idEmpleado = idEmpleado;
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.estado = estado;
		this.user = user;
	}

	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	int idEmpleado;
	String dni;
	String nombre;
	String telefono;
	String estado;
	String user;

}
