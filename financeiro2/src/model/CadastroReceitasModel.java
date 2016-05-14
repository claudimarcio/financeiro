package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.CadastroReceitasDAO;
import conexao.PersistenceUtil;

public class CadastroReceitasModel {

	public CadastroReceitasModel() {
		super();
		
	}

	
	public void InsertCadastroReceitas(CadastroReceitasDAO cadastro_receitas){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
	    	em.persist(cadastro_receitas);
	        tx.commit(); 
			} catch(Exception e){
				System.out.println("Erro ao inserir cadastro de receita" + e);
				tx.rollback();
			}
		PersistenceUtil.close(em);
        PersistenceUtil.close();
	}
	
public void RemoveCadastroReceitas(long id){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		CadastroReceitasDAO cr = em.find(CadastroReceitasDAO.class, id);
		
		try{
			tx.begin();
	    	cr.setStatus(false);
	        tx.commit(); 
			} catch(Exception e){
				System.out.println("Erro ao eliminar cadastro de receita" + e);
				tx.rollback();
			}
		PersistenceUtil.close(em);
        PersistenceUtil.close();
	}
	
public void AlteraCadastroReceitas(CadastroReceitasDAO cadastro_receitas){
	
	EntityManager em = PersistenceUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	try{
		tx.begin();
    	em.merge(cadastro_receitas);
        tx.commit(); 
		} catch(Exception e){
			System.out.println("Erro ao alterar cadastro de receita" + e);
			tx.rollback();
		}
	PersistenceUtil.close(em);
    PersistenceUtil.close();
}

}
