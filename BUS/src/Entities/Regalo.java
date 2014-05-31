package Entities;

public class Regalo {

	int id;
	int id_local;
	String name;
	String description;
	//String picture;
	double price;
	int puntaje;
	int edad_min;
	
	public Regalo(int id, int id_local, String name, String description,
			double price, int puntaje, int edad_min, int edad_max) {
		super();
		this.id = id;
		this.id_local = id_local;
		this.name = name;
		this.description = description;
		this.price = price;
		this.puntaje = puntaje;
		this.edad_min = edad_min;
		this.edad_max = edad_max;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
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

	int edad_max;
	
	
	
	
	public boolean equals(Regalo regalo){
			return(this.getId()==regalo.getId() && this.getName()==regalo.getName() && this.getDescription()==regalo.getDescription() && this.getPrice()==regalo.getPrice());
		}
	
	public Regalo() {
		super();
	}

	public Regalo(int id, String name, String description,
			double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		//this.picture = picture;
		this.price = price;
		
	}

	public Regalo(int id_producto, int id_local2, double price2, int puntaje2,
			String descripcion, String nombre, int edad_min2, int edad_max2) {
		this.id=id_producto;
		this.id_local=id_local2;
		this.price=price2;
		this.puntaje=puntaje2;
		this.description=descripcion;
		this.name=nombre;
		this.edad_min=edad_min2;
		this.edad_max=edad_max2;
	}

	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price=price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId_local() {
		return id_local;
	}

	public void setId_local(int id_local) {
		this.id_local = id_local;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}*/

	
	
}
