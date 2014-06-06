package DaoImpl;

public class LocalDaoImpl {

	public int id_local;
	public String nombre;
	public String direccion;
	public int telefono;
	
	public LocalDaoImpl(int id_local2, String nombre2, String direccion2,
			int telefono2) {
		this.id_local=id_local2;
		this.nombre=nombre2;
		this.direccion=direccion2;
		this.telefono=telefono2;
	}
	public int getId_local() {
		return id_local;
	}
	public void setId_local(int id_local) {
		this.id_local = id_local;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
}
