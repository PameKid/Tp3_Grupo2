package main;

import java.util.ArrayList;

import dao.Conexion;
import dao.DaoCategoria;
import entidad.Categoria;

public class Principal {

	public static void main(String[] args) {

		DaoCategoria daoCategoria = new DaoCategoria();
		// Punto de entrada base de la aplicacion.

		// Pamela Vizcarra: prueba de lectura del ArrayList

		ArrayList<Categoria> lCategoria = daoCategoria.obtenerCategorias();

		for (Categoria categoria : lCategoria) {

			System.out.println(categoria.toString());
		}

		// Cerrar la conexión al finalizar el programa
		Conexion.getInstancia().cerrarConexion();
	}
}
