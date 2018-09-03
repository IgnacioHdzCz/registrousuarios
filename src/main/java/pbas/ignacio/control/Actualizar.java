package pbas.ignacio.control;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pbas.ignacio.bean.Registro;
import pbas.ignacio.conexionaBD.Conexion;

/**
 * Servlet implementation class Actualizar
 */
public class Actualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Actualizar() {
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
			String sql = "SELECT * FROM registro WHERE id = ? ";

			PreparedStatement ps = (PreparedStatement) conexion.getConnection().prepareStatement(sql);
			ps.setString(1, request.getParameter("id"));

			ResultSet rs = ps.executeQuery();

			Registro registro = null;

			while (rs.next()) {
				registro = new Registro();

				registro.setId(rs.getInt("id"));
				registro.setNombre(rs.getString("nombre"));
				registro.setApellidoP(rs.getString("apellidoP"));
				registro.setApellidoM(rs.getString("apellidoM"));

			}

			ps.close();
			rs.close();

			request.setAttribute("registro", registro);
			request.getRequestDispatcher("actualizar.jsp").forward(request, response);

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
		// doGet(request, response);

		Conexion conexion = new Conexion();

		try {
			String sql = "UPDATE registro SET nombre = ?,apellidoP = ?, apellidoM = ? WHERE id = ?";
			PreparedStatement ps = (PreparedStatement) conexion.getConnection().prepareStatement(sql);
			ps.setString(1, request.getParameter("txtnombre"));
			ps.setString(2, request.getParameter("txtapellidoP"));
			ps.setString(3, request.getParameter("txtapellidoM"));
			ps.setString(4, request.getParameter("txtId"));

			ps.executeUpdate();
			ps.close();

			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			conexion.devolverConexionPool();
		}

	}

}
