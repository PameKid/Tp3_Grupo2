package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import entidad.Producto;

public class DaoProducto {

	public DaoProducto() {

	}

	public void agregarProducto(Producto p) {

		String sql = "{CALL sp_AgregarProducto(?, ?, ?, ?, ?)}";
		Connection conexion = null;
		CallableStatement cs = null;

		try {
			conexion = Conexion.getInstancia().getConnection();
			cs = conexion.prepareCall(sql);

			cs.setString(1, p.getCodigo());
			cs.setString(2, p.getNombre());
			cs.setDouble(3, p.getPrecio());
			cs.setInt(4, p.getStock());
			cs.setInt(5, p.getCategoria().getIdCategoria());

			cs.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
