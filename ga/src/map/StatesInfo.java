package map;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.StateDAO;
import model.JoinedState;

/**
 * Servlet implementation class StatesInfo
 */
@WebServlet(description = "Returns info (JoinedState object) for all states", urlPatterns = { "/StatesInfo",
		"/statesInfo" })
public class StatesInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StatesInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");

		List<JoinedState> states = StateDAO.getAllStates();

		Gson gson = new Gson();
		String json = gson.toJson(states);
		// System.out.println(json);

		if(request.getAttribute("NO_WRITE") == null) {
			response.getWriter().append(json);
		}
		else {
			request.setAttribute("statesInfo", json);
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
