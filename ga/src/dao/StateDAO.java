package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.User;
import entity.UserRole;
import model.District;
import model.JoinedState;
import singleton.Singleton;

public class StateDAO {
	
	//private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ga");
	
	public static List<JoinedState> getAllStates() {
		EntityManagerFactory emf = Singleton.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query q;
		List<JoinedState> results;
		q = em.createQuery("SELECT s FROM JoinedState s");
		results = q.getResultList();
		return results;
	}

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
	
	public static List<District> getDistricts(String statefp) {
		EntityManagerFactory emf = Singleton.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query q;
		List<District> results;
		q = em.createQuery("SELECT d FROM District d WHERE d.statefp=:statefp");
		q.setParameter("statefp", statefp);
		results = q.getResultList();
		//em.getTransaction().commit();
		//if(results.size() > 1) System.err.println("WARNING: more than one state with given name retrieved");
		return results;
	}
	
	public static List<District> getDistrictResults(String statefp, String cd115fp) {
		EntityManagerFactory emf = Singleton.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query q;
		List<District> results;
		q = em.createQuery("SELECT d FROM District d WHERE d.cd115fp=:cd115fp AND d.statefp=:statefp");
		q.setParameter("cd115fp", Integer.toString(Integer.parseInt(cd115fp)));
		q.setParameter("statefp", statefp);
		results = q.getResultList();
		//em.getTransaction().commit();
		//if(results.size() > 1) System.err.println("WARNING: more than one state with given name retrieved");
		return results;
	}
	
	public static void savePrefs(Map<String, String> prefs, User user) {
		EntityManagerFactory emf = Singleton.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		user.setEfficiencyGapPref(prefs.get("efficiencyGap"));
		user.setConsistentAdvantagePref(prefs.get("consistentAdvantage"));
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
	}
	
	public static User getUser(String username) {
		EntityManagerFactory emf = Singleton.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query q;
		q = em.createQuery("SELECT u FROM User u WHERE u.username=:username");
		q.setParameter("username", username);
		List<User> users = q.getResultList();
		if(users.size() > 1) System.err.println("WARNING: more than one user matched");
		else if(users.size() == 0) return null;
		return users.get(0);
	}
	
	public static User login(String username, String password) {
		EntityManagerFactory emf = Singleton.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query q;
		q = em.createQuery("SELECT u FROM User u WHERE u.username=:username AND u.password=:password");
		q.setParameter("username", username);
		q.setParameter("password", password);
		List<User> users = q.getResultList();
		if(users.size() > 1) System.err.println("WARNING: more than one user matched");
		else if(users.size() == 0) return null;
		return users.get(0);
	}
	
	public static void register(String username, String password) {
		EntityManagerFactory emf = Singleton.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		em.getTransaction().begin();
		em.persist(user);
		UserRole role = new UserRole();
		role.setRole("user");
		role.setUsername(username);
		em.persist(role);
		em.getTransaction().commit();
	}
	
	/*
	public static Object queryTable(String table, HashMap params) {
		EntityManagerFactory emf = Singleton.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query q;
		String qStr = "SELECT o FROM " + table + " o WHERE o.username=:username AND
		q = em.createQuery()
	}*/
}
