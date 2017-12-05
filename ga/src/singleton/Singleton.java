package singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
	
	private static Singleton instance = new Singleton();
	
	private EntityManagerFactory emf;
	
	private Singleton() {
		emf = Persistence.createEntityManagerFactory("ga");
	}
	
	public static Singleton getInstance() {
		return instance;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}
