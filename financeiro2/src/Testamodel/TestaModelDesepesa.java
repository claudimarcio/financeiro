package Testamodel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.DespesasModel;

import DAO.DespesasDAO;

import conexao.PersistenceUtil;

public class TestaModelDesepesa {

	
	public static void main(String[] args) {
		
		
		 EntityManager em = PersistenceUtil.getEntityManager();
		 EntityTransaction tx = em.getTransaction();
		 
		 DespesasDAO desp = em.find(DespesasDAO.class,1l);
		 DespesasModel despm = new DespesasModel();
		  desp.setStatus(true);
		 
		 
		 try{
			 
		 despm.AlteraDespesas(desp);
		 
		 } catch(Exception e ){
			 System.out.println("erro testaModelDespesa: "+e);
			  tx.rollback();
			 
		 }
		 
		 
		 


	}

}
