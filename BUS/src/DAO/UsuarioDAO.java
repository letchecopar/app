package DAO;

import java.util.LinkedList;

import Entities.Usuario;
import Entities.Regalo;

public interface UsuarioDAO {
	
	//obtiene el usuario de la DB desde un id
	Usuario getUsuario(int id);
	
	//crea un usuario en la BD
	void crearUsuario(String nombre, int edad);
	
	//obtiene los regalos hechos por el usuario
	LinkedList<Regalo> getRegalosHechos();
	
	LinkedList<Regalo> getRegalosPendientes();
	LinkedList<Regalo> getRegalosMarcados();
	
}
