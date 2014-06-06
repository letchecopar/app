package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLConnection {
		
	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql:///app";
		Connection con = DriverManager.getConnection(url,"root",""); 
		return con;
	}


	public static void main(String[] args) {
		SQLConnection pool = new SQLConnection();
		try {
			 Connection con = SQLConnection.getConnection();
			 /*
			 RegaloDaoImpl o = new RegaloDaoImpl(123, 1, 100, 5, "un regalo", "Nuevo regalo", 10, 100); 
			 int id_regalo = o.getId_producto();
			 int id_local = o.getId_local();
			 String name = o.getNombre();
			 String description = o.getDescripcion();
			 double price = o.getPrecio();
			 int edad_min = o.getEdad_min();
			 int edad_max = o.getEdad_max();
			 String foto = o.getFoto();
			 int puntaje = o.getPuntaje();*/
			 
			 //String sql = "INSERT INTO producto VALUES(null,"+ id_local+","+price+","+puntaje+","+description+","+name+","+foto+","+edad_max+","+edad_min+")";
			 //String sql = "INSERT INTO producto VALUES(null, 1,100,5,description,name,foto,6,20";
			 int edad_min = 1;
			 int edad_max=100;
			 
			 String sql = ("SELECT * FROM producto WHERE edad_minima >=" +edad_min+ " AND edad_maxima <=" +edad_max);
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet res = ps.executeQuery();
			 
			 while (res.next()) {
					System.out.println(res.getInt("precio"));
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
		
	}

}