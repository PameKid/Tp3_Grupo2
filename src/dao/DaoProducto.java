package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Categoria;
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

	public int modificarProducto(Producto p) {

		int filas = 0;
		String sql = "UPDATE Productos SET Nombre=?, Precio=?, Stock=?, IdCategoria=? WHERE Codigo=?";
		PreparedStatement pst = null;

		try {
			Connection conexion = Conexion.getInstancia().getConnection();
			pst = conexion.prepareStatement(sql);

			pst.setString(1, p.getNombre());
			pst.setDouble(2, p.getPrecio());
			pst.setInt(3, p.getStock());
			pst.setInt(4, p.getCategoria().getIdCategoria());
			pst.setString(5, p.getCodigo());

			filas = pst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return filas;
	}
	
	public ArrayList<Producto> obtenerProductos(){
		ArrayList<Producto> lProducto = new ArrayList<Producto>();
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.getInstancia().getConnection();
			String query = "Select * from Productos";
			st = cn.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				Producto producto = new Producto();
				producto.setCodigo(rs.getString("Codigo"));
				producto.setNombre(rs.getString("Nombre"));
				producto.setPrecio(rs.getDouble("Precio"));
				producto.setStock(rs.getInt("Stock"));

				lProducto.add(producto);
			}

		}

		catch (Exception e) {

			e.printStackTrace();
		} finally {
		
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lProducto;
	}
	
	
	
	
	
	
}
