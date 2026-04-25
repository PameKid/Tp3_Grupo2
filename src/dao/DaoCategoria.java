package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Categoria;

public class DaoCategoria {

	public int agregarCategoria(Categoria c) {

		int filas = 0;
		String query = "INSERT INTO categorias (Nombre) VALUES (?)";
		PreparedStatement pst = null;

		try {
			pst = Conexion.getInstancia().getConnection().prepareStatement(query);
			pst.setString(1, c.getNombre());
			filas = pst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return filas;
	}

	public int eliminarCategoria(int idCategoria) {
		if (idCategoria <= 0) {
			throw new IllegalArgumentException("ID de categoria invalido");
		}

		int filas = 0;
		String query = "DELETE FROM Categorias WHERE IdCategoria = ?";
		PreparedStatement pst = null;

		try {
			pst = Conexion.getInstancia().getConnection().prepareStatement(query);
			pst.setInt(1, idCategoria);
			filas = pst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return filas;
	}

	
	// Sebastian Flores
	
	public int modificarCategoria(Categoria c) {
		
		int filas = 0;
		String query = "UPDATE Categorias SET Nombre = ? WHERE IdCategoria = ?";
		PreparedStatement pst = null;

		try
		{
			pst = Conexion.getInstancia().getConnection().prepareStatement(query);
			pst.setString(1, c.getNombre());
			pst.setInt(2, c.getIdCategoria());
			filas = pst.executeUpdate();
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(pst != null) pst.close();
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}

		return filas;
	}
	
	
	
	//Pamela Vizcarra 

	public ArrayList<Categoria> obtenerCategorias() {

		ArrayList<Categoria> lCategoria = new ArrayList<Categoria>();
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			cn = Conexion.getInstancia().getConnection();
			String query = "Select * from Categorias";
			st = cn.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				Categoria categoria = new Categoria();
				categoria.setIdCategoria(rs.getInt("IdCategoria"));
				categoria.setNombre(rs.getString("Nombre"));

				lCategoria.add(categoria);
			}

		}

		catch (Exception e) {

			e.printStackTrace();
		} finally {
			// agrego cierre de resulset y statement para que no queden conexiones abiertas
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lCategoria;
	}
}
