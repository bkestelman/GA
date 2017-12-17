package map;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

import dao.StateDAO;
import model.District;

/**
 * Servlet implementation class DistrictsInfo
 */
@WebServlet({ "/DistrictsInfo", "/districtsInfo" })
public class DistrictsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DistrictsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String statefp = request.getParameter("statefp");

		List<District> districts = null;
		try {
			districts = StateDAO.getDistricts(statefp); // returns a result for each party
		} catch (Exception e) {
			System.err.println("Exception in StateDAO.getDistricts");
			e.printStackTrace();
		}

		if (districts != null) {
			Gson gson = new Gson();
			String json = gson.toJson(districts);
			if (request.getAttribute("NO_WRITE") == null) {
				System.out.println("/districtsInfo WRITE enabled");
				response.getWriter().append(json);
			} else {
				//System.out.println(json);
				request.setAttribute("districtsInfo", json);
			}
		} else {
			System.out.println("Null districts");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
