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
			setCodigo(codigo);
			setNombre(nombre);
			setPrecio(precio);
			setStock(stock);
			setCategoria(categoria);
			
		}
		
		//getters y setters

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			if(codigo == null || codigo.trim().isEmpty()) {
			
				throw  new IllegalArgumentException("El código no debe ser un campo vacío"); 
			}
			String codigoNormalizado = codigo.trim();
			if (codigoNormalizado.length() > 20) {
				throw new IllegalArgumentException("El codigo no puede superar 20 caracteres");
			}
			this.codigo = codigoNormalizado;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			
			if(nombre == null || nombre.trim().isEmpty()) {
				
				throw  new IllegalArgumentException("El nombre no debe ser un campo vacío"); 
			}
			String nombreNormalizado = nombre.trim();
			if (nombreNormalizado.length() > 45) {
				throw new IllegalArgumentException("El nombre no puede superar 45 caracteres");
			}
			this.nombre = nombreNormalizado;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			if(precio <= 0 ) {
				throw  new IllegalArgumentException("No se ingresar un valor menor o igual a cero");
			}
			if (precio > 99999999.99) {
				throw new IllegalArgumentException("El precio no puede superar 99999999.99");
			}
			double precioEscalado = precio * 100;
			if (Math.abs(precioEscalado - Math.round(precioEscalado)) > 1e-9) {
				throw new IllegalArgumentException("El precio no puede tener mas de 2 decimales");
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
