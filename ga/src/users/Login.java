package users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.StateDAO;
import entity.User;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/Login", "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Please do not use GET for user login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("j_username");
		String password = request.getParameter("j_password");
		System.out.println(username);
		System.out.println(password);

		// request.logout();
		try {
			request.login(username, password);
		} catch (ServletException e) {
			response.getWriter().append("{\"success\": \"false\"}");
		}

		/*
		 * User user = StateDAO.login(username, password); Gson gson = new Gson();
		 * String json = gson.toJson(user); System.out.println(json);
		 */

		response.addCookie(new Cookie("username", username));
		response.getWriter().append("{\"success\": \"true\"}");

	}

}
