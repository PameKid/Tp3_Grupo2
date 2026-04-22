package entidad;

public class Producto {

	//Atributos 
	
		private String codigo;
		private String nombre;
		private double precio;
		private int stock;
		private Categoria categoria;

		//constructores 
		
		public Producto(){
		
		}
		
		public Producto(String codigo, String nombre, double precio, int stock, Categoria categoria) {
			this.codigo = codigo; 
			this.nombre = nombre;
			this.precio = precio; 
			this.stock = stock; 
			this.categoria = categoria;
			
		}
		
		//getters y setters

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			if(codigo == null || codigo.trim().isEmpty()) {
			
				throw  new IllegalArgumentException("El código no debe ser un campo vacío"); 
			}
			this.codigo = codigo;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			
			if(nombre == null || nombre.trim().isEmpty()) {
				
				throw  new IllegalArgumentException("El nombre no debe ser un campo vacío"); 
			}
			this.nombre = nombre;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			if(precio <= 0 ) {
				throw  new IllegalArgumentException("No se ingresar un valor menor o igual a cero");
			}
			this.precio = precio;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			if(stock < 0) {
				throw new IllegalArgumentException("No se puede ingresar un número negativo");
			}
			this.stock = stock;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			
			if (categoria == null) {
		        throw new IllegalArgumentException("La categoría no puede ser nula");
		    }
			this.categoria = categoria;
		}

		@Override
		public String toString() {
			 return "Producto [codigo=" + codigo + 
			           ", nombre=" + nombre + 
			           ", precio=" + precio + 
			           ", stock=" + stock + 
			           ", categoria=" + categoria.getNombre() + "]";
		}
		
}
