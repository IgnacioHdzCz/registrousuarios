package pbas.ignacio.control;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pbas.ignacio.conexionaBD.Conexion;

/**
 * Servlet implementation class Insertar
 */
public class Insertar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertar() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("insertar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Conexion conexion = new Conexion();
		try {
			
			String sql = "INSERT INTO registro(nombre,apellidoP,apellidoM) values(?,?,?)";
			
			PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
			ps.setString(1, request.getParameter("txtnombre"));
			ps.setString(2, request.getParameter("txtapellidoP"));
			ps.setString(3, request.getParameter("txtapellidoM"));
			
			ps.execute();
			ps.close();
			
			request.setAttribute("mensaje", "Registro Correcto");
			request.getRequestDispatcher("insertar.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}finally {
			conexion.devolverConexionPool();
		}
		
	}

}
