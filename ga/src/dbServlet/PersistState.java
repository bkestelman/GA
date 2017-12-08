package dbServlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.State;
import model.JoinedState;
import singleton.Singleton;

/**
 * Servlet implementation class PersistState
 */
@WebServlet(
		description = "Persists State Received in POST Request to Database", 
		urlPatterns = { 
				"/PersistState", 
				"/persistState"
		})
@ServletSecurity(
		@HttpConstraint(rolesAllowed = {"admin"}))
public class PersistState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersistState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name = request.getParameter("name");
		System.out.println(name);
		
		State state = new State();
		state.setName(name);
		
		Singleton singleton = Singleton.getInstance();
		EntityManager em = singleton.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		List<JoinedState> resultStates;
		Query q;
		q = em.createQuery("SELECT s FROM JoinedState s WHERE s.name=:name");
		q.setParameter("name", name);
		resultStates = q.getResultList();
		if(resultStates.size() > 1) System.err.println("WARNING: more than one state with given name retrieved");
		em.persist(state);
		em.getTransaction().commit();
		
		response.getWriter().append("The state was " + resultStates.get(0).getName());
	}

}
