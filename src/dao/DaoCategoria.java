package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import entidad.Categoria;

public class DaoCategoria {

	public int agregarCategoria(Categoria c) {
		
	    int filas = 0;
	    String query = "INSERT INTO categorias (Nombre) VALUES (?)";
	    PreparedStatement pst = null;
	    
	    try
	    {
	    	pst = Conexion.getInstancia().getConnection().prepareStatement(query);
	        pst.setString(1, c.getNombre());
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
				if(pst!=null) pst.close();
			} 
			catch (SQLException ex) 
			{
				ex.printStackTrace();
			}
		}
	    
	    return filas;
	}
}
