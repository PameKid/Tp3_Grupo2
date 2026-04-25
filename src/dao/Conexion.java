package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para crear una conexión única a la bbdd para toda la app.
 * <p>
 * Evita repetir código y mantener múltiples conexiones abiertas
 * </p>
 *
 * <p>
 * Ejemplo de uso:
 * </p>
 *
 * <pre>{@code
 * Connection conn = Conexion.getInstancia().getConnection();
 * PreparedStatement ps = Conexion.getInstancia().getConnection().prepareStatement("INSERT INTO...");
 * }</pre>
 */
public class Conexion {

	private static final String HOST = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME = "bdInventario";
	private static final String USER = "";
	private static final String PASS = "";

	private static Conexion instancia;
	private Connection connection;

	private Conexion() {
		String cadenaConexion = HOST + DB_NAME;
		try {
			this.connection = DriverManager.getConnection(cadenaConexion, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** método estático para obtener la instancia única. **/
	public static Conexion getInstancia() {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}

	/** método para obtener la conexión desde la instancia **/
	public Connection getConnection() {
		if (connection == null) {
			throw new IllegalStateException("No se pudo establecer la conexion con la base de datos.");
		}
		return connection;
	}
	
	
	
	/** método para cerrar la conexión **/
	public void cerrarConexion() {
	    try {
	        if (connection != null && !connection.isClosed()) {
	            connection.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	} 

}
