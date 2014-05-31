package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import DAO.RegaloDAO;
import Entities.Local;
import Entities.Regalo;
import Entities.Regalo;

public class RegaloDaoDB implements RegaloDAO{
	
	private PoolManager m = PoolManager.getInstance();
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
		
		Connection con= null;
		Statement stm=null;
		PreparedStatement pst=null;
		
		try {
			 con=(Connection) m.getConnection();
			 stm = (Statement) con.createStatement();
			 pst = con.prepareStatement("INSERT INTO Producto VALUES(null,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

			 //pst.setInt(1,id_regalo);
			 pst.setInt(2, id_local);
			 pst.setInt(4, puntaje);
			 pst.setString(6,name);
			 pst.setDouble(3,price);
			 pst.setString(5, description);
			 pst.setString(7, foto);
			 pst.setInt(8, edad_min);
			 pst.setInt(9, edad_max);

			 pst.executeUpdate();
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if ( stm != null)
					try {
						stm.close( );
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				if ( pst != null)
					try {
						pst.close( );
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				 try {
					m.returnConnection(con);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try{
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}

	@Override
	public LinkedList<Object> getRegalosPorEdad(int edad1, int edad2) {
		LinkedList<Object> regalos = new LinkedList<Object>();
		Statement stm=null;
		Connection con=null;
		ResultSet rst=null;

		try {
			con=(Connection) m.getConnection();
			stm= (Statement) con.createStatement();

			rst = stm.executeQuery("SELECT * FROM producto WHERE edad_minima >=" +edad1+ "AND edad_maxima <=" +edad2);

			while (rst.next()) {

				int id_Regalo = (rst.getInt(1));
				RegaloDaoImpl c = (RegaloDaoImpl) this.getById(id_Regalo,con);
				regalos.add(c);
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{

				try {
					if(rst!=null){
					rst.close();
					}if(stm!=null){
						stm.close();
					}
					m.returnConnection(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return regalos;
	}

	
	public Object getById(int o) throws Exception {
		RegaloDaoImpl c = null;
		Statement stm=null;
		Connection con=null;
		ResultSet rst=null;
		try {
			con=(Connection) m.getConnection();
			stm = (Statement) con.createStatement();

			c= (RegaloDaoImpl) this.getById(o, con);


		} catch (SQLException e) {
			throw new RuntimeException(e);

		}finally{

			try {
				if(rst!=null)
					rst.close();
				if(stm!=null)
					stm.close();

				m.returnConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return c;
	}
	
	private Object getById(int o, Connection con) throws Exception {
		RegaloDaoImpl c = null;
		Statement stm=null;
		ResultSet rst=null;
		try {
			stm = (Statement) con.createStatement();
			rst = stm.executeQuery("select * from producto where id_producto="+ o);

			while (rst.next()) {

				int id_producto = (rst.getInt(1));
				int id_local = (rst.getInt(2));
				double price = rst.getDouble(3);
				int puntaje = rst.getInt(4);
				String descripcion = rst.getString(5);
				String nombre = rst.getString(6);
				int edad_min = rst.getInt(8);
				int edad_max=rst.getInt(9);
				c = new RegaloDaoImpl(id_producto,id_local,price, puntaje, descripcion, nombre, edad_min, edad_max);
			}
		}finally{

			try {
				if(rst!=null)
					rst.close();
				if(stm!=null)
					stm.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return c;
	}

	@Override
	public LinkedList<Object> getRegalosPorIntereses(String interes) {
		LinkedList<Object> regalos = new LinkedList<Object>();
		Statement stm=null;
		Connection con=null;
		ResultSet rst=null;

		try {
			con=(Connection) m.getConnection();
			stm= (Statement) con.createStatement();

			rst = stm.executeQuery("SELECT * FROM intereses_productos WHERE interes IN"+interes);

			while (rst.next()) {

				int id_Regalo = (rst.getInt(1));
				RegaloDaoImpl c = (RegaloDaoImpl) this.getById(id_Regalo,con);
				regalos.add(c);
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{

				try {
					if(rst!=null){
					rst.close();
					}if(stm!=null){
						stm.close();
					}
					m.returnConnection(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return regalos;
	}

	@Override
	public LinkedList<Object> getRegalosPorPrecio(int precio1, int precio2) {
		LinkedList<Object> regalos = new LinkedList<Object>();
		Statement stm=null;
		Connection con=null;
		ResultSet rst=null;

		try {
			con=(Connection) m.getConnection();
			stm= (Statement) con.createStatement();

			rst = stm.executeQuery("SELECT * FROM producto WHERE precio >=" +precio1+ "AND precio <=" +precio2);

			while (rst.next()) {

				int id_Regalo = (rst.getInt(1));
				RegaloDaoImpl c = (RegaloDaoImpl) this.getById(id_Regalo,con);
				regalos.add(c);
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{

				try {
					if(rst!=null){
					rst.close();
					}if(stm!=null){
						stm.close();
					}
					m.returnConnection(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
