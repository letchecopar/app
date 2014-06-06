package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import DAO.RegaloDAO;

import com.mysql.jdbc.Statement;

public class RegaloDaoDB implements RegaloDAO{
	
	SQLConnection pool = new SQLConnection();
	private static RegaloDaoDB instance = null;

	public static RegaloDaoDB getInstance() {
		if (instance == null) {
			instance = new RegaloDaoDB();
		}
		return instance;
	}

	@Override
	public void crearRegalo(RegaloDaoImpl o){
		
		int id_regalo = o.getId_producto();
		int id_local = o.getId_local();
		String name = o.getNombre();
		String description = o.getDescripcion();
		double price = o.getPrecio();
		int edad_min = o.getEdad_min();
		int edad_max = o.getEdad_max();
		String foto = o.getFoto();
		int puntaje = o.getPuntaje();
		
		try {
			 Connection con = SQLConnection.getConnection();
			 String sql = "INSERT INTO producto VALUES(null,"+ id_local+","+price+","+puntaje+","+description+","+name+","+foto+","+edad_max+","+edad_min+")";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet res = ps.executeQuery();
			 res.close();
			 ps.close();
			 con.close();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

	@Override
	public LinkedList<Object> getRegalosPorEdad(int edad1, int edad2) {
		LinkedList<Object> regalos = new LinkedList<Object>();
		Connection con=null;

		try {
			 con = SQLConnection.getConnection();
			 String sql = ("SELECT * FROM producto WHERE edad_minima >=" +edad1+ "AND edad_maxima <=" +edad2);
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet res = ps.executeQuery();
			 while (res.next()) {
				int id_Regalo = (res.getInt(1));
				RegaloDaoImpl c = (RegaloDaoImpl) this.getById(id_Regalo);
				regalos.add(c);
			 }
			 res.close();
			 ps.close();
			 con.close();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regalos;
}
	
	
	public Object getById(int o) throws Exception {
		RegaloDaoImpl c = null;
		Connection con=null;
		
		try {
			
			 con = SQLConnection.getConnection();
			 String sql = ("select * from producto where id_producto=");
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet res = ps.executeQuery();
			 
			 while (res.next()) {
				int id_producto = (res.getInt(1));
				int id_local = (res.getInt(2));
				double price = res.getDouble(3);
				int puntaje = res.getInt(4);
				String descripcion = res.getString(5);
				String nombre = res.getString(6);
				int edad_min = res.getInt(8);
				int edad_max=res.getInt(9);
				c = new RegaloDaoImpl(id_producto,id_local,price, puntaje, descripcion, nombre, edad_min, edad_max);
			 }
			 res.close();
			 ps.close();
			 con.close();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}
	

	@Override
	public LinkedList<Object> getRegalosPorIntereses(String interes) {
		LinkedList<Object> regalos = new LinkedList<Object>();
		Connection con=null;

		try {
			 con = SQLConnection.getConnection();
			 String sql = ("SELECT * FROM intereses_productos WHERE interes IN"+interes);
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet res = ps.executeQuery();
			 while (res.next()) {
				int id_Regalo = (res.getInt(1));
				RegaloDaoImpl c = (RegaloDaoImpl) this.getById(id_Regalo);
				regalos.add(c);
			 }
			 res.close();
			 ps.close();
			 con.close();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regalos;
		
	}

	@Override
	public LinkedList<Object> getRegalosPorPrecio(int precio1, int precio2) {
		LinkedList<Object> regalos = new LinkedList<Object>();
		Connection con=null;

		try {
			 con = SQLConnection.getConnection();
			 String sql = ("SELECT * FROM producto WHERE precio >=" +precio1+ " AND precio <=" +precio2);
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet res = ps.executeQuery();
			 while (res.next()) {
				int id_Regalo = (res.getInt(1));
				RegaloDaoImpl c = (RegaloDaoImpl) this.getById(id_Regalo);
				regalos.add(c);
			 }
			 res.close();
			 ps.close();
			 con.close();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regalos;
		
	}

	@Override
	public LinkedList<Object> getRegalosPorEventos(String Evento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Object> getRegalosPopulares() {
		// TODO Auto-generated method stub
		return null;
	}

}
