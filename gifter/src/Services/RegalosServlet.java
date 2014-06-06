package Services;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Entities.Regalo;

/**
 * Servlet implementation class RegalosServlet
 */
@WebServlet("/RegalosServlet")
public class RegalosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegalosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @javax.inject.Inject
    private RegalosServiceImpl regalosService = new RegalosServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
		final java.io.Writer writer = response.getWriter();

		if(request.getParameter("ws").equals("1")){
			//ws: 1 crearRegalo		
			
			
		}else if(request.getParameter("ws").equals("2")){
			//ws: 2 getRegalosPorEdad -------------------------------- devuelve lista de regalos
			
			
			LinkedList<Regalo> lista = (LinkedList<Regalo>) regalosService.getRegalosPorEdad(50,58);
			JSONArray wrapper = new JSONArray();
			Regalo regaloInventado = new Regalo(54, "Exprimidor", "Exprime tus jugos",
					25.0); 
			
			JSONObject regalo1 = new JSONObject();
			regalo1.put("id", regaloInventado.getId());
			regalo1.put("name", regaloInventado.getName());
			regalo1.put("description", regaloInventado.getDescription());
			regalo1.put("price", regaloInventado.getPrice());
			wrapper.add(regalo1);
			
			for (int i = 0; i < lista.size(); i++) {
				JSONObject regalo = new JSONObject();
				regalo.put("id", lista.get(i).getId());
				regalo.put("name", lista.get(i).getName());
				regalo.put("description", lista.get(i).getDescription());
				regalo.put("price", lista.get(i).getPrice());
				wrapper.add(regalo);
			}
			writer.append(wrapper.toJSONString());
		}else if(request.getParameter("ws").equals("3")){
			
			//ws: 3 getRegalosPorInteres -------------------------------- devuelve lista de regalos
			
 
		}else if (request.getParameter("ws").equals("13")){
			//ws: 13 getRegaloPorId -------------------------------- devuelve Regalo
			
			//Ojo; esto puede tener problemas porque idRegalo es un String
			//Regalo regalo = <Regalo> regalosService.getRegalosPorId(request.getParameter("idRegalo"));
			JSONArray wrapper = new JSONArray();
			Regalo regaloInventado = new Regalo(54, "Exprimidor", "Exprime tus jugos",
					25.0); 
			
			JSONObject regalo1 = new JSONObject();
			regalo1.put("id", regaloInventado.getId());
			regalo1.put("name", regaloInventado.getName());
			regalo1.put("description", regaloInventado.getDescription());
			regalo1.put("price", regaloInventado.getPrice());
			wrapper.add(regalo1);
			writer.append(wrapper.toJSONString());

			
		}
		
		
		
		
		//ws: 4 getRegalosPorPrecio -------------------------------- devuelve lista de regalos
		//ws: 5 getRegalosPorEventosEspeciales -------------------------------- devuelve lista de regalos

		//ws: 6 getRegalosPopulares -------------------------------- devuelve lista de regalos

		//ws: 7 getRegalosHechos -------------------------------- devuelve lista de regalos
		//ws: 8 getRegalosPendientes -------------------------------- devuelve lista de regalos
		//ws: 9 getRegalosMarcados -------------------------------- devuelve lista de regalos

		//ws: 10 getLocales -------------------------------- devuelve lista de locales
		//ws: 11 getLocalesPreferidos -------------------------------- devuelve lista de locales


		//ws: 12 getUsuario -------------------------------- devuelve Usuario
		//ws: 13 getRegaloPorId -------------------------------- devuelve Regalo
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
