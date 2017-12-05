package dbServlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.State;
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
		doGet(request, response);
		
		System.out.println(request.getParameter("name"));
		
		State state = new State();
		state.setName(request.getParameter("name"));
		
		Singleton singleton = Singleton.getInstance();
		EntityManager em = singleton.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(state);
		em.getTransaction().commit();
	}

}
