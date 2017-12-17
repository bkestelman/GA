package map;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import singleton.Singleton;
import dao.StateDAO;
import model.JoinedState;

/**
 * Servlet implementation class SelectState
 */
@WebServlet(
		description = "Returns all info (JoinedState object) and districts geojson for a given state", 
		urlPatterns = { 
				"/SelectState", 
				"/selectState",
		})
public class SelectState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("NO_WRITE", true);
		request.getRequestDispatcher("/districtsGeojson").include(request, response);
		request.getRequestDispatcher("/districtsInfo").include(request, response);
		//request.getRequestDispatcher("/stateInfo").include(request, response);
		
		JSONObject districts = new JSONObject();
		System.out.println(request.getAttribute("districtsInfo"));
		//System.out.println(request.getAttribute("districtsGeojson"));
		districts.put("info", new JSONArray((String)request.getAttribute("districtsInfo")));
		districts.put("geojson", new JSONObject((String)request.getAttribute("districtsGeojson")));
		//districts.put("stateInfo", new JSONObject((String)request.getAttribute("stateInfo")));
		
		response.getWriter().append(districts.toString());
		
		/*response.setContentType("application/json");
		
		List<JoinedState> states = StateDAO.getAllStates();
	
		Gson gson = new Gson();
		String json = gson.toJson(states);
		//System.out.println(json);
		
		response.getWriter().append(json);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
