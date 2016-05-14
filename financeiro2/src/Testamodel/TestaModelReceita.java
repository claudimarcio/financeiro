package Testamodel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.ReceitasModel;

import DAO.ReceitasDAO;

import conexao.PersistenceUtil;

public class TestaModelReceita {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 EntityManager em = PersistenceUtil.getEntityManager();
		 EntityTransaction tx = em.getTransaction();
		 
		 ReceitasDAO re = em.find(ReceitasDAO.class,1l);
		 re.setStatus(true);
		 
		 ReceitasModel reM = new ReceitasModel();
		 
		 try{
			 
			 reM.AlteraReceitas(re);
			 
		 }catch(Exception e){
			 
			System.out.println("erro receita model: "+e); 
			tx.rollback();
		 }
	}

}
