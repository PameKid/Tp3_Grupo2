package main;

import java.util.ArrayList;

import dao.Conexion;
import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {

		DaoCategoria daoCategoria = new DaoCategoria();
		// Punto de entrada base de la aplicacion.

		// Pamela Vizcarra: prueba de lectura del ArrayList

		ArrayList<Categoria> lCategoria = daoCategoria.obtenerCategorias();

		for (Categoria categoria : lCategoria) {

			System.out.println(categoria.toString());
		}
		
		// prueba del listado de productos
		
             DaoProducto daoProducto = new DaoProducto();
		
		     ArrayList<Producto> lProducto = daoProducto.obtenerProductos();
		
		          for(Producto producto : lProducto) {
			      System.out.println(producto.toString());
			
		}
		      
		          DaoCategoria daoCat = new DaoCategoria();
		          DaoProducto daoProd = new DaoProducto();

		          // CARGAR CATEGORIAS
		          daoCat.agregarCategoria(new Categoria("Periféricos"));
		          daoCat.agregarCategoria(new Categoria("Monitores"));
		          daoCat.agregarCategoria(new Categoria("Notebooks"));
		          daoCat.agregarCategoria(new Categoria("Audio"));
		          daoCat.agregarCategoria(new Categoria("Almacenamiento"));

		          // OBJETOS CATEGORIA PARA ASOCIAR
		          Categoria c1 = new Categoria();
		          c1.setIdCategoria(1);
		          c1.setNombre("Periféricos");

		          Categoria c2 = new Categoria();
		          c2.setIdCategoria(2);
		          c2.setNombre("Monitores");

		          Categoria c3 = new Categoria();
		          c3.setIdCategoria(3);
		          c3.setNombre("Notebooks");

		          Categoria c4 = new Categoria();
		          c4.setIdCategoria(4);
		          c4.setNombre("Audio");

		          Categoria c5 = new Categoria();
		          c5.setIdCategoria(5);
		          c5.setNombre("Almacenamiento");

		          // CARGAR 10 PRODUCTOS
		          daoProd.agregarProducto(new Producto("P001", "Mouse Logitech", 18500, 10, c1));
		          daoProd.agregarProducto(new Producto("P002", "Teclado Redragon", 32000, 8, c1));
		          daoProd.agregarProducto(new Producto("P003", "Monitor Samsung 24", 145000, 5, c2));
		          daoProd.agregarProducto(new Producto("P004", "Monitor LG 27", 198000, 3, c2));
		          daoProd.agregarProducto(new Producto("P005", "Notebook Lenovo i5", 650000, 4, c3));
		          daoProd.agregarProducto(new Producto("P006", "Notebook HP Ryzen 7", 780000, 2, c3));
		          daoProd.agregarProducto(new Producto("P007", "Auriculares HyperX", 55000, 7, c4));
		          daoProd.agregarProducto(new Producto("P008", "Parlante JBL Go", 48000, 6, c4));
		          daoProd.agregarProducto(new Producto("P009", "SSD Kingston 480GB", 62000, 9, c5));
		          daoProd.agregarProducto(new Producto("P010", "Disco Externo WD 1TB", 99000, 4, c5));

		          // PRUEBA HARD CODEADA: MODIFICAR PRODUCTO
		          int filasMod = daoProd.modificarProducto(new Producto("P001", "Mouse Logitech MOD", 19999, 15, c1));
		          System.out.println("Filas modificadas producto P001: " + filasMod);

		          // PRUEBA HARD CODEADA: ELIMINAR PRODUCTO
		          int filasDel = daoProd.eliminarProducto("P010");
		          System.out.println("Filas eliminadas producto P010: " + filasDel);

		          // MOSTRAR PRODUCTOS
		          for (Producto p : daoProd.obtenerProductos()) {
		              System.out.println(p);
		          }
     
		          
		
		

		// Cerrar la conexión al finalizar el programa
		Conexion.getInstancia().cerrarConexion();
	}
}
