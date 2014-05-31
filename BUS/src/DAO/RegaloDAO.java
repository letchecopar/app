package DAO;
import java.util.LinkedList;

import DaoImpl.RegaloDaoImpl;
import Entities.Regalo;

public interface RegaloDAO {

	//crea un regalo en la DB
	void crearRegalo(RegaloDaoImpl o);
		
	//devuelve los regalos de la DB para 
	LinkedList<Object> getRegalosPorEdad(int edad1, int edad2);
	
	LinkedList<Object> getRegalosPorIntereses(String interes);
	
	LinkedList<Object> getRegalosPorPrecio(int precio1, int precio2);
	
	LinkedList<Object> getRegalosPorEventos(String Evento);
	
	LinkedList<Object> getRegalosPopulares();


}
