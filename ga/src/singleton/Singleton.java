package singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
	
	private static Singleton instance;
	
	private EntityManagerFactory emf;
	
	private Singleton() {
		emf = Persistence.createEntityManagerFactory("ga");
	}
	
	public static synchronized Singleton getInstance() {
		if(instance == null) 
			instance = new Singleton();
		return instance;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}
