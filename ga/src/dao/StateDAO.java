package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.JoinedState;
import singleton.Singleton;

public class StateDAO {

	public static JoinedState getState(String name) {
		EntityManagerFactory emf = Singleton.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		//em.getTransaction().begin();
		Query q;
		List<JoinedState> results;
		q = em.createQuery("SELECT s FROM JoinedState s WHERE s.name=:name");
		q.setParameter("name", name);
		results = q.getResultList();
		//em.getTransaction().commit();
		if(results.size() > 1) System.err.println("WARNING: more than one state with given name retrieved");
		return results.get(0);
	}
}
