package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.ReceitasDAO;
import DAO.UsuariosDAO;
import conexao.PersistenceUtil;

public class ReceitasModel {

	
	public ReceitasModel() {
		super();
		
	}

	public void InsertReceitas(ReceitasDAO receitas){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
	    	em.persist(receitas);
	        tx.commit(); 
			} catch(Exception e){
				System.out.println("Erro ao inserir receita" + e);
				tx.rollback();
			}
		PersistenceUtil.close(em);
        PersistenceUtil.close();
	}
	
public void RemoveReceitas(ReceitasDAO receitas){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		//ReceitasDAO rec = em.find(ReceitasDAO.class, id);
		try{
			tx.begin();
	    	receitas.setStatus(false);
	        tx.commit(); 
			} catch(Exception e){
				System.out.println("Erro ao eliminar receita" + e);
				tx.rollback();
			}
		PersistenceUtil.close(em);
        PersistenceUtil.close();
	}
	
public void AlteraReceitas(ReceitasDAO receitas){
	
	EntityManager em = PersistenceUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	try{
		tx.begin();
    	em.merge(receitas);
        tx.commit(); 
		} catch(Exception e){
			System.out.println("Erro ao alterar receita" + e);
			tx.rollback();
		}
	PersistenceUtil.close(em);
    PersistenceUtil.close();
}

public  List<ReceitasDAO> receitaslista(){
	List<ReceitasDAO>listrec = null;
	EntityManager em = PersistenceUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	try{
	tx.begin();
	listrec = em.createQuery("from ReceitasDAO", ReceitasDAO.class).getResultList();
    tx.commit(); 
	}catch(Exception e){
		System.out.println("erro na lista"+e);
		tx.rollback();
	}
   // PersistenceUtil.close(em);
   // PersistenceUtil.close();
    return listrec;
}
	
}
