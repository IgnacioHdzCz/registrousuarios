package pbas.ignacio.control;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import pbas.ignacio.bean.Registro;
import pbas.ignacio.conexionaBD.Conexion;

/**
 * Servlet implementation class Leer
 */
public class Leer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Leer() {
        super();
        
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Conexion conexion = new Conexion ();
		try {
			
			String sql = "SELECT * FROM registro";
			
			PreparedStatement ps = (PreparedStatement)conexion.getConnection().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List <Registro> list = new ArrayList<Registro>();
			
			
			while (rs.next()) {
			Registro registro = new Registro();
			registro.setId(rs.getInt("id"));
			registro.setNombre(rs.getString("nombre"));
			registro.setApellidoP(rs.getString("apellidoP"));
			registro.setApellidoM(rs.getString("apellidoM"));
			list.add(registro);
				
			}
			
			
			ps.close();
			rs.close();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("leer.jsp").forward(request, response);
			
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
		}
		finally {
	
			conexion.devolverConexionPool();

		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
