package modelo;

public class Venta {

	Integer id;
	Integer item;
	Integer idCliente;
	Integer idEmpleado;
	Integer idProdcuto;
	Integer cantidad;

	String numeroSerie;
	String descripcionProducto;
	String fecah;
	String estado;

	double precio;
	double subTotal;
	double monto;

	public Venta() {

	}

	public Venta(Integer id, Integer intem, Integer idCliente, Integer idEmpleado, Integer idProdcuto, Integer cantidad,
			String numeroSerie, String descripcionProducto, String fecah, String estado, double precio, double subTotal,
			double monto) {

		this.id = id;
		this.item = item;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
		this.idProdcuto = idProdcuto;
		this.cantidad = cantidad;
		this.numeroSerie = numeroSerie;
		this.descripcionProducto = descripcionProducto;
		this.fecah = fecah;
		this.estado = estado;
		this.precio = precio;
		this.subTotal = subTotal;
		this.monto = monto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Integer getIdProdcuto() {
		return idProdcuto;
	}

	public void setIdProdcuto(Integer idProdcuto) {
		this.idProdcuto = idProdcuto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getFecah() {
		return fecah;
	}

	public void setFecah(String fecah) {
		this.fecah = fecah;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
