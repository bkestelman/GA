package geojson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import constants.Constants;

/**
 * Servlet implementation class StatesGeojson
 */
@WebServlet({ "/StatesGeojson", "/statesGeojson" })
public class StatesGeojson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatesGeojson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase mongodb = mongoClient.getDatabase("ga");
		MongoCollection<Document> geojsonCollection = mongodb.getCollection("states");
		
		//Document doc = null;
		//JSONObject states = new JSONObject();
		
		Document doc = geojsonCollection.find().first();
		//System.out.println(doc.toJson());
		
		
		/*JSONObject states = new JSONObject(doc.toJson());
		JSONArray features = states.getJSONArray("features");
		for(int i = 0; i < states.length(); i++) {
			features.getJSONObject(i).getJSONObject("properties").put("statefp", Integer.toString(i));
		}*/
		
		/* THIS IS GOOD CODE (reads states with all districts)
		MongoCursor<Document> cursor = geojsonCollection.find().iterator();
		try {
		    while (cursor.hasNext()) {
		    	doc = cursor.next();
		    	JSONObject state = new JSONObject(doc.toJson());
				states.put(Integer.toString(doc.getInteger("statefp")), state);
		        //System.out.println(cursor.next().toJson());
		    }
		} finally {
		    cursor.close();
		}*/
		
		response.getWriter().append(doc.toJson());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
