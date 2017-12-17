package geojson;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import constants.Constants;

/**
 * Servlet implementation class DistrictsGeojson
 */
@WebServlet({ "/DistrictsGeojson", "/districtsGeojson" })
public class DistrictsGeojson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistrictsGeojson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase mongodb = mongoClient.getDatabase("ga");
		MongoCollection<Document> geojsonCollection = mongodb.getCollection(Constants.DISTRICTS_GEOJSON_COLLECTION);
		
		int statefp = Integer.parseInt(request.getParameter("statefp"));
		Document doc = geojsonCollection.find(Filters.eq("statefp", statefp)).first();

		if(request.getAttribute("NO_WRITE") == null) {
			System.out.println("Writing response from districtsGeojson");
			response.getWriter().append(doc.toJson());
		}
		else {
			//System.out.println(doc.toJson());
			request.setAttribute("districtsGeojson", doc.toJson());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
