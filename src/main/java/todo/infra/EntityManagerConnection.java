package todo.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceProperty;

public class EntityManagerConnection {
	
	private static EntityManager em;
	
	public EntityManagerConnection(){
		
	}
	
	public static EntityManager getInstance(){
		if (em == null){
			EntityManagerFactory emf = 
					Persistence.createEntityManagerFactory("SIGTodo");
			em = emf.createEntityManager();
		}
		
		return em;
	}

}
