package pbas.ignacio.conexionaBD;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;
import javax.sql.DataSource;

public class Conexion {
	private DataSource dataSource = null;
	private BasicDataSource basicDataSource = null;
	private Connection connection = null;

	public Conexion() {
		try {
			basicDataSource = new BasicDataSource();
			
			basicDataSource.setDriverClassName("com.ibm.db2.jcc.DB2Driver");

		
			basicDataSource.setUsername("naxxh00");

			
			basicDataSource.setPassword("M0T0RHEAD9907");

			basicDataSource.setUrl("jdbc:db2://localhost:50000/DATO");

			
			basicDataSource.setMaxActive(10);

			
			basicDataSource.setMaxIdle(10);

			basicDataSource.setRemoveAbandoned(true);

			
			basicDataSource.setMaxWait(5000);

			dataSource = basicDataSource;

			connection = dataSource.getConnection();

			
		} catch (SQLException ex) {
			System.out.println("Error" + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Exception" + ex.getMessage());
		}
	}

	//
	public void devolverConexionPool() {
		if (connection != null) {
			try {
				
				connection.close();
				connection = null;

			} catch (Exception ex) {
				System.out.println("Error al cerrar la conexion" + ex.getMessage());

			}
		}

	}

	public Connection getConnection() {
		return connection;
	}

}
