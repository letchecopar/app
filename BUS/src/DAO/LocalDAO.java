package DAO;

import java.util.LinkedList;

import Entities.Local;

public interface LocalDAO {
	
	LinkedList <Local> getLocalesFavoritos();
	
	LinkedList <Local> getLocales();

}
