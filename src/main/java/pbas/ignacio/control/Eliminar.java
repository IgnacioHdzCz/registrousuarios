package pbas.ignacio.control;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pbas.ignacio.conexionaBD.Conexion;

/**
 * Servlet implementation class Eliminar
 */
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Eliminar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Conexion conexion = new Conexion();

		try {

			String sql = "DELETE FROM registro WHERE id = ?";

			PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
			ps.setString(1, request.getParameter("id"));
			ps.execute();
			ps.close();


			request.getRequestDispatcher("eliminar.jsp").forward(request, response);

		} catch (Exception e) {
		
			System.out.println(e.getMessage());

		} finally {
			conexion.devolverConexionPool();
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
