package experimental;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StateDAO;
import entity.User;
import singleton.Singleton;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet({ "/UpdateUser", "/updateUser" })
@ServletSecurity(
		value = @HttpConstraint(rolesAllowed = {"user", "admin"})
)
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Singleton.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		User user = StateDAO.getUser(request.getRemoteUser());
		user.setEfficiencyGapPref("true");
		user.setConsistentAdvantagePref("false");
		//System.out.println(user);
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
