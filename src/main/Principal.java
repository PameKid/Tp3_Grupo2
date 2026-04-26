package main;

import java.util.ArrayList;

import dao.Conexion;
import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {

	//	DaoCategoria daoCategoria = new DaoCategoria();
		// Punto de entrada base de la aplicacion.


	//	ArrayList<Categoria> lCategoria = daoCategoria.obtenerCategorias();

	//	for (Categoria categoria : lCategoria) {

		//	System.out.println(categoria.toString());
		//}
		
		// prueba de listar de productos
		
		DaoProducto daoProducto = new DaoProducto();
		
		ArrayList<Producto> lProducto = daoProducto.obtenerProductos();
		
		for(Producto producto : lProducto) {
			System.out.println(producto.toString());
			
		}

		// Cerrar la conexión al finalizar el programa
		Conexion.getInstancia().cerrarConexion();
	}
	
	
	
}
