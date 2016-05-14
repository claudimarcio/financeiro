package conexao;

import javax.persistence.EntityManager;




public class TesteJPA {


	public static void main(String[] args) {
		
		EntityManager em= PersistenceUtil.getEntityManager();
		
		System.out.println("Foi criada Gerenciador que fara a persistencia no banco de dados");
		PersistenceUtil.close(em);
		PersistenceUtil.close();

	}

}
