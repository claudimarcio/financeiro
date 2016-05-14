package conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

	private static EntityManagerFactory emf;
 
	private PersistenceUtil() {
		super();

	}

	public static EntityManager getEntityManager() {
		if (emf == null) {

			emf = Persistence.createEntityManagerFactory("exemploPU");
		}
		return emf.createEntityManager();

	}

	public static void close(EntityManager em) {

		if (em != null) {

			em.close();
			System.out.println("fechado o entityManager");
		}
	}
	
	
	public static boolean tem(EntityManager em){
		boolean status;
		
		System.out.println(em.getProperties());
		if(em.isOpen()){
			status=false;
		}else{
			
			status = true;
		}
		return status;
	}

	public static void close() {

		if (emf != null) {
			emf.close();
			System.out.println("fechado o entityManagerFactory");
		}
		}
	}

