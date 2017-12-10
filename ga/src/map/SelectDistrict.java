package map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.StateDAO;
import model.District;

/**
 * Servlet implementation class SelectDistrict
 */
@WebServlet({ "/SelectDistrict", "/selectDistrict", "/district" })
public class SelectDistrict extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectDistrict() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cd115fp = request.getParameter("cd115fp");
		String statefp = request.getParameter("statefp");
		System.out.println("District code in request: " + cd115fp);
		System.out.println("State code in request: " + statefp);

		List<District> districtResults = null;
		try {
			districtResults = StateDAO.getDistrictResults(statefp, cd115fp); // returns a result for each party
		} catch (Exception e) {
			System.err.println("Exception in StateDAO.getDistrictResults");
			e.printStackTrace();
		}

		if (districtResults != null) {
			System.out.println("District results: ");
			System.out.println(districtResults);

			Gson gson = new Gson();
			String json = gson.toJson(districtResults);
			System.out.println("json: ");
			System.out.println(json);

			response.getWriter().append(json);
		} else {
			System.out.println("Null districtResults");
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
