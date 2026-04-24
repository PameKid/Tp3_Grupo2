package entidad;

public class Categoria {
	
	private int idCategoria;
	private String nombre; 
	
	
	//constructores
	public Categoria() {
	}
	
	public Categoria (String nombre) {
		setNombre(nombre);
	}
	
	//getters y setters

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		if(idCategoria <= 0) {
			throw new IllegalArgumentException("ID debe ser mayor a 0");
			
		}
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
	        throw new IllegalArgumentException("El nombre no puede ser vacío");
	    }
		String nombreNormalizado = nombre.trim();
		if (nombreNormalizado.length() > 45) {
			throw new IllegalArgumentException("El nombre no puede superar 45 caracteres");
		}
	    this.nombre = nombreNormalizado;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + "]";
	}
	

}
