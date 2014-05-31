package DaoImpl;

import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import DAO.LocalDAO;
import Entities.Local;

public class LocalDaoDB implements LocalDAO {

	private PoolManager m = PoolManager.getInstance();
	private static LocalDaoDB instance = null;

	public static LocalDaoDB getInstance() {
		if (instance == null) {
			instance = new LocalDaoDB();
		}
		return instance;
	}

	@Override
	public LinkedList<Local> getLocalesFavoritos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList <Local> getLocales() {
		LinkedList<Local> locales = new LinkedList<Local>();
		Statement stm=null;
		Connection con=null;
		ResultSet rst=null;

		try {
			con=(Connection) m.getConnection();
			stm= (Statement) con.createStatement();

			rst = stm.executeQuery("SELECT * FROM locale;");

			while (rst.next()) {

				int id_local = (rst.getInt(1));

				Local c = (Local) this.getById(id_local,con);

				locales.add(c);
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
		return locales;
	}
	
	
	public Object getById(int o, Connection con) throws Exception {
		Local c = null;
		Statement stm=null;
		ResultSet rst=null;
		try {
			stm = (Statement) con.createStatement();
			rst = stm.executeQuery("select * from Local where id_local="+ o);

			while (rst.next()) {

				int id_local = (rst.getInt(1));
				String nombre = rst.getString(2);
				String direccion = rst.getString(3);
				int telefono = rst.getInt(4);

				c = new Local(id_local,nombre,direccion, telefono);

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

}