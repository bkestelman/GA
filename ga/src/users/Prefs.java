package users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StateDAO;
import entity.User;

/**
 * Servlet implementation class Prefs
 */
@WebServlet({ "/Prefs", "/prefs" })
@ServletSecurity(
		value = @HttpConstraint(rolesAllowed = {"user", "admin"})
)
public class Prefs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prefs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = StateDAO.getUser(request.getRemoteUser());
		request.setAttribute("efficiencyGapPref", user.getEfficiencyGapPref());
		request.setAttribute("consistentAdvantagePref", user.getConsistentAdvantagePref());
		request.getRequestDispatcher("/userPrefsPopup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
