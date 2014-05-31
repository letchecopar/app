package DaoImpl;

public class RegaloDaoImpl {
	
	public int id_producto;
	public int id_local;
	public double precio;
	public String descripcion;
	public String nombre;
	public String foto;
	public int edad_min;
	public int edad_max;
	int puntaje;
	
	
	public RegaloDaoImpl(int id_producto2, int id_local2, double price,
			int puntaje2, String descripcion2, String nombre2, int edad_min2,
			int edad_max2) {
		this.id_producto=id_producto2;
		this.id_local=id_local2;
		this.precio=price;
		this.puntaje=puntaje2;
		this.descripcion=descripcion2;
		this.nombre=nombre2;
		this.edad_min=edad_min2;
		this.edad_max=edad_max2;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getId_local() {
		return id_local;
	}
	public void setId_local(int id_local) {
		this.id_local = id_local;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getEdad_min() {
		return edad_min;
	}
	public void setEdad_min(int edad_min) {
		this.edad_min = edad_min;
	}
	public int getEdad_max() {
		return edad_max;
	}
	public void setEdad_max(int edad_max) {
		this.edad_max = edad_max;
	}
	
	

}
