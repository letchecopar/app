package DaoImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;




public class PoolManager {

		private static DataSource dataSource;
		//private static ObjectPool connectionPool;

		private static PoolManager instance = null;


		public static PoolManager getInstance() {
			if (instance == null) {

				instance = new PoolManager();

			}

			return instance;
		}

		private PoolManager() {

			dataSource = setupDataSource();
		}

		//Inicializa el Pool de objetos con las conexiones

		private DataSource setupDataSource() {

			try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			}catch(Exception ex){
				ex.printStackTrace();
			}

			// Creamos un ObjectPool que sera el actual pool de conexiones
			// e Instanciamos un ObjectPool que permitira 5 conexiones como maximo

			Properties propiedades = new Properties();

					try {
						propiedades.load(new FileInputStream("datasource.properties"));


					} catch (FileNotFoundException e) {

						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}



//			//int max=5;
//			//log.info("Configurando Pool de Conexiones con "+max+" conexiones maximas");
//			//connectionPool = new GenericObjectPool(null,max);
//
//			// Creamos el ConnectionFactory que el pool usara para crear las
//			// conexiones
//			String url="jdbc:mysql://localhost:3306/Restaurant";
//			String user="root";
//			String passw="tarzan";
//			log.info("Conectando a "+url+"/user:"+user+"/password:"+passw);
//
//			ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(url,user,passw);
//
//			// Creamos el PoolableConnectionFactory que creara las conexiones e
//			// implementara las
//			// funciones necesarias para la funcionalidad de Pooling
//
//			PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(
//					connectionFactory, connectionPool, null, null, false, true);
//
//			// Crearemos el PoolingDriver y crearemos el dataSource
//
//			PoolingDataSource dataSource = new PoolingDataSource(connectionPool);


			return dataSource;
		}

		/**
		 * Obtiene una conexion del pool
		 *
		 * @return Conenction
		 * @throws SQLException
		 *             Si existe error de conexion con la base de datos
		 *
		 */
		public synchronized Connection getConnection() throws Exception,
				SQLException {

			return dataSource.getConnection();
//			Object obj = null;
//			try {
//				obj = connectionPool.borrowObject();
//				return (Connection) obj;
//			} catch (Exception exception) {
//
//				if (exception instanceof SQLException) {
//					SQLException er = (SQLException) exception;
//					log.error("No hay conexion con la BD: "
//							+ exception.getMessage(), er);
//					throw er;
//				}
//				if (exception instanceof NoSuchElementException) {
//					log.error("No existe disponibilidad en el pool: "
//							+ exception.getMessage());
//					throw new Exception(exception.getMessage(), exception
//							.getCause());
//				}
//				if (exception instanceof IllegalStateException) {
//					log.error("El objeto del pool esta cerrado: "
//							+ exception.getMessage());
//					throw new Exception(exception.getMessage(), exception
//							.getCause());
//				}
//
//				log.error("No se ha podido crear el objeto: "
//						+ exception.getMessage());
//				throw new Exception(exception.getMessage(), exception
//						.getCause());
//
//			}

		}

		/**
		 * Retorna el Objeto al Pool de conexiones
		 *
		 * @param obj
		 *            conexion a devolver al pool
		 */
		public synchronized void returnConnection(Connection obj)
				throws Exception {

			try {
				obj.close();
			} catch (Exception exception) {
				
				throw new Exception(exception.getMessage(), exception.getCause());
			}
		}
}

