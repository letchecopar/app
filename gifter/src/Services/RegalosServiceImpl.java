package Services;


import java.util.LinkedList;

import DAO.RegaloDAO;
import DaoImpl.RegaloDaoDB;
import DaoImpl.RegaloDaoImpl;
import Entities.Regalo;

public class RegalosServiceImpl {

	//llama al metodo que agrega el regalo a la DB
	public void crearRegalo(Regalo reg){
		RegaloDaoImpl dao = new RegaloDaoImpl(reg.getId(), reg.getId_local(), reg.getPrice(), reg.getPuntaje(), reg.getDescription(), reg.getName(), reg.getEdad_min(), reg.getEdad_max());
		RegaloDaoDB.getInstance().crearRegalo(dao);
	}
	
	public LinkedList getRegalosPorEdad(int e1, int e2) {
		 LinkedList<Object> regalo= RegaloDaoDB.getInstance().getRegalosPorEdad(e1, e2);
			LinkedList <Regalo> l = new LinkedList();
			for(int i=0;i<regalo.size();i++){
				RegaloDaoImpl temp = (RegaloDaoImpl)regalo.get(i);
				Regalo aux = new Regalo(temp.getId_producto(), temp.getId_local(), temp.getPrecio(), temp.getPuntaje(), temp.getDescripcion(), temp.getNombre(), temp.getEdad_min(), temp.getEdad_max());
				l.add(aux);
			}
			return l;
	}
	
	public LinkedList getRegalosPorInteres(String interes) {
		 LinkedList<Object> regalo= RegaloDaoDB.getInstance().getRegalosPorIntereses(interes);
			LinkedList <Regalo> l = new LinkedList();
			for(int i=0;i<regalo.size();i++){
				RegaloDaoImpl temp = (RegaloDaoImpl)regalo.get(i);
				Regalo aux = new Regalo(temp.getId_producto(), temp.getId_local(), temp.getPrecio(), temp.getPuntaje(), temp.getDescripcion(), temp.getNombre(), temp.getEdad_min(), temp.getEdad_max());
				l.add(aux);
			}
			return l;
	}
	
	public Regalo getRegaloById(int id){
		RegaloDaoImpl temp;
		Regalo reg;
		try {
			temp = (RegaloDaoImpl) RegaloDaoDB.getInstance().getById(id);
			reg = new Regalo(temp.getId_producto(), temp.getNombre(), temp.getDescripcion(), temp.getPrecio());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reg = null;
		}
		return reg;
	}
	
	
}
