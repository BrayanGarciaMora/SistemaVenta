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

	Empleado em = new Empleado();
	EmpleadoDAO edao = new EmpleadoDAO();

	// -------------------------------------------
	Cliente cliente = new Cliente();
	ClienteDAO clienteDAO = new ClienteDAO();
	// -------------------------------------------
	Producto producto = new Producto();
	ProductoDAO productoDAO = new ProductoDAO();

	int ide, idc, idp;

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
				List lista = edao.listarEmpleado();
				request.setAttribute("empleados", lista);

				break;

			case "Agregar":

				String dni = request.getParameter("txtDni");
				String nombre = request.getParameter("txtNombre");
				String telefono = request.getParameter("txtTelefono");
				String estado = request.getParameter("txtEstado");
				String user = request.getParameter("txtUsuario");
				em.setDni(dni);
				em.setNombre(nombre);
				em.setTelefono(telefono);
				em.setEstado(estado);
				em.setUser(user);

				edao.agregar(em);
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
				break;

			case "Editar":
				ide = Integer.parseInt(request.getParameter("id"));

				Empleado e = edao.listarId(ide);
				request.setAttribute("empleado", e);
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
				break;
			case "Actualizar":

				String dniUp = request.getParameter("txtDni");
				String nombreUp = request.getParameter("txtNombre");
				String telefonoUp = request.getParameter("txtTelefono");
				String estadoUp = request.getParameter("txtEstado");
				String userUp = request.getParameter("txtUsuario");
				em.setDni(dniUp);
				em.setNombre(nombreUp);
				em.setTelefono(telefonoUp);
				em.setEstado(estadoUp);
				em.setUser(userUp);

				em.setIdEmpleado(ide);
				edao.actualizar(em);
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
				break;

			case "Eliminar":

				ide = Integer.parseInt(request.getParameter("id"));

				edao.Eliminar(ide);
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

				producto.setNombre(descripcion);
				producto.setPrecio(pre);
				producto.setStock(stock);
				producto.setEstado(estado);

				productoDAO.agregarProducto(producto);
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
				break;

			case "Editar":
				idp = Integer.parseInt(request.getParameter("id"));

				Producto p = productoDAO.listarId(idp);
				request.setAttribute("productos", p);
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

				break;

			case "Actualizar":

				String descripcionUp = request.getParameter("txtDescripcion");
				double precioUp = Double.parseDouble(request.getParameter("txtPrecio"));
				int stockUp = Integer.parseInt(request.getParameter("txtStock"));
				String estadoUp = request.getParameter("txtEstado");

				producto.setNombre(descripcionUp);
				producto.setPrecio(precioUp);
				producto.setStock(stockUp);
				producto.setEstado(estadoUp);

				producto.setIdProducto(idp);
				productoDAO.actualizarProducto(producto);
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

				break;

			case "Eliminar":

				idp = Integer.parseInt(request.getParameter("id"));

				productoDAO.EliminarProducto(idp);
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

				cliente.setDni(dni);
				cliente.setNombre(nombre);
				cliente.setDireccion(direccion);
				cliente.setEstado(estado);

				clienteDAO.agregar(cliente);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;
			case "Editar":
				idc = Integer.parseInt(request.getParameter("id"));

				Cliente c = clienteDAO.listarId(idc);
				request.setAttribute("cliente", c);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

				break;

			case "Actualizar":

				String dniUp = request.getParameter("txtDni");
				String nombreUp = request.getParameter("txtNombre");
				String direccionUp = request.getParameter("txtDireccion");
				String estadoUp = request.getParameter("txtEstado");

				cliente.setDni(dniUp);
				cliente.setNombre(nombreUp);
				cliente.setDireccion(direccionUp);
				cliente.setEstado(estadoUp);

				cliente.setIdCliente(idc);
				clienteDAO.actualizar(cliente);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

				break;

			case "Eliminar":

				idc = Integer.parseInt(request.getParameter("id"));

				clienteDAO.Eliminar(idc);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;

			default:

				throw new AssertionError();

			}
			request.getRequestDispatcher("Cliente.jsp").forward(request, response);
		}

		// -------------------------------------------------------------------------------------------------------
		if (menu.equals("CrearVenta")) {
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
