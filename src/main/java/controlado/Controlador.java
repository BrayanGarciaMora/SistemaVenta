package controlado;

import java.io.IOException;
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

	int ide, idc;

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
		if (menu.equals("Empleado")) {

			switch (accion) {

			case "Listar":
				List lista = edao.listar();
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
				System.out.println(ide);
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
				System.out.println("eliminar el id: " + ide);
				edao.delete(ide);
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
				break;

			default:

				throw new AssertionError();
			}
			request.getRequestDispatcher("Empleado.jsp").forward(request, response);

		}

		// --------------------------------------------------------------------------------------------
		if (menu.equals("Producto")) {
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
				System.out.println(idc);
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

			default:

				throw new AssertionError();

			}
			request.getRequestDispatcher("Cliente.jsp").forward(request, response);
		}
		if (menu.equals("CrearVenta")) {
			request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
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
