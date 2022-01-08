package controlado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Empleado objetoEmpleado = new Empleado();
	EmpleadoDAO empleadoDAO = new EmpleadoDAO();

	// -------------------------------------------
	Cliente objetoCliente = new Cliente();
	ClienteDAO clienteDAO = new ClienteDAO();
	// -------------------------------------------
	Producto objetoProducto = new Producto();
	ProductoDAO productoDAO = new ProductoDAO();

	int idEmpleado, idCliente, idProducto;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		String menu = request.getParameter("menu");

		if (menu.equals("Principal")) {

			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		}

		// -------------------------------------------------------------------------------------------------------
		if (menu.equals("Empleado")) {

			switch (accion) {

			case "Listar":
				List lista = empleadoDAO.listarEmpleado();
				request.setAttribute("empleados", lista);

				break;

			case "Agregar":

				String dni = request.getParameter("txtDni");
				String nombre = request.getParameter("txtNombre");
				String telefono = request.getParameter("txtTelefono");
				String estado = request.getParameter("txtEstado");
				String user = request.getParameter("txtUsuario");
				objetoEmpleado.setDni(dni);
				objetoEmpleado.setNombre(nombre);
				objetoEmpleado.setTelefono(telefono);
				objetoEmpleado.setEstado(estado);
				objetoEmpleado.setUser(user);

				empleadoDAO.agregar(objetoEmpleado);
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
				break;

			case "Editar":
				idEmpleado = Integer.parseInt(request.getParameter("id"));

				Empleado e = empleadoDAO.listarId(idEmpleado);
				request.setAttribute("empleado", e);
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
				break;
			case "Actualizar":

				String dniUp = request.getParameter("txtDni");
				String nombreUp = request.getParameter("txtNombre");
				String telefonoUp = request.getParameter("txtTelefono");
				String estadoUp = request.getParameter("txtEstado");
				String userUp = request.getParameter("txtUsuario");
				objetoEmpleado.setDni(dniUp);
				objetoEmpleado.setNombre(nombreUp);
				objetoEmpleado.setTelefono(telefonoUp);
				objetoEmpleado.setEstado(estadoUp);
				objetoEmpleado.setUser(userUp);

				objetoEmpleado.setIdEmpleado(idEmpleado);
				empleadoDAO.actualizar(objetoEmpleado);
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
				break;

			case "Eliminar":

				idEmpleado = Integer.parseInt(request.getParameter("id"));

				empleadoDAO.Eliminar(idEmpleado);
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
				break;

			default:

				throw new AssertionError();
			}
			request.getRequestDispatcher("Empleado.jsp").forward(request, response);

		}

		// --------------------------------------------------------------------------------------------
		if (menu.equals("Producto")) {

			switch (accion) {

			case "Listar":

				List listaProducto = productoDAO.listarProducto();
				request.setAttribute("producto", listaProducto);
				break;

			case "Agregar":
				double pre;
				double precio;

				String descripcion = request.getParameter("txtDescripcion");
				precio = Double.parseDouble(request.getParameter("txtPrecio"));
				pre = precio;
				int stock = Integer.parseInt(request.getParameter("txtStock"));
				String estado = request.getParameter("txtEstado");

				objetoProducto.setNombre(descripcion);
				objetoProducto.setPrecio(pre);
				objetoProducto.setStock(stock);
				objetoProducto.setEstado(estado);

				productoDAO.agregarProducto(objetoProducto);
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
				break;

			case "Editar":
				idProducto = Integer.parseInt(request.getParameter("id"));

				Producto producto = productoDAO.listarId(idProducto);
				request.setAttribute("productos", producto);
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

				break;

			case "Actualizar":

				String descripcionUp = request.getParameter("txtDescripcion");
				double precioUp = Double.parseDouble(request.getParameter("txtPrecio"));
				int stockUp = Integer.parseInt(request.getParameter("txtStock"));
				String estadoUp = request.getParameter("txtEstado");

				objetoProducto.setNombre(descripcionUp);
				objetoProducto.setPrecio(precioUp);
				objetoProducto.setStock(stockUp);
				objetoProducto.setEstado(estadoUp);

				objetoProducto.setIdProducto(idProducto);
				productoDAO.actualizarProducto(objetoProducto);
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

				break;

			case "Eliminar":

				idProducto = Integer.parseInt(request.getParameter("id"));

				productoDAO.EliminarProducto(idProducto);
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
				break;

			default:
				throw new AssertionError();

			}
			request.getRequestDispatcher("Producto.jsp").forward(request, response);

		}

		// ------------------------------------------------------------------------------------------
		if (menu.equals("Cliente")) {

			switch (accion) {

			case "Listar":
				List listaClinte = clienteDAO.listarCliente();

				request.setAttribute("clientes", listaClinte);

				break;
			case "Agregar":

				String dni = request.getParameter("txtDni");
				String nombre = request.getParameter("txtNombre");
				String direccion = request.getParameter("txtDireccion");
				String estado = request.getParameter("txtEstado");

				objetoCliente.setDni(dni);
				objetoCliente.setNombre(nombre);
				objetoCliente.setDireccion(direccion);
				objetoCliente.setEstado(estado);

				clienteDAO.agregar(objetoCliente);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;
			case "Editar":
				idCliente = Integer.parseInt(request.getParameter("id"));

				Cliente cliente = clienteDAO.listarId(idCliente);
				request.setAttribute("cliente", cliente);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

				break;

			case "Actualizar":

				String dniUp = request.getParameter("txtDni");
				String nombreUp = request.getParameter("txtNombre");
				String direccionUp = request.getParameter("txtDireccion");
				String estadoUp = request.getParameter("txtEstado");

				objetoCliente.setDni(dniUp);
				objetoCliente.setNombre(nombreUp);
				objetoCliente.setDireccion(direccionUp);
				objetoCliente.setEstado(estadoUp);

				objetoCliente.setIdCliente(idCliente);
				clienteDAO.actualizar(objetoCliente);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

				break;

			case "Eliminar":

				idCliente = Integer.parseInt(request.getParameter("id"));

				clienteDAO.Eliminar(idCliente);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;

			default:

				throw new AssertionError();

			}
			request.getRequestDispatcher("Cliente.jsp").forward(request, response);
		}

		// -------------------------------------------------------------------------------------------------------
		if (menu.equals("RegistrarVenta")) {

			switch (accion) {

			case "Buscar":
				System.out.print("hola");
				String dni = request.getParameter("codigoCliente");
				objetoCliente.setDni(dni);
				objetoCliente = clienteDAO.buscarCliente(dni);
				request.setAttribute("c", objetoCliente);
				break;
			}
			request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
		}

		if (menu.equals("Home")) {

			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
