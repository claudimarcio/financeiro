package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.DespesasDAO;
import DAO.UsuariosDAO;
import conexao.PersistenceUtil;

public class DespesasModel {

	public DespesasModel() {
		super();
		
	}

	
	public void InsertDespesas(DespesasDAO despesas){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
	    	em.persist(despesas);
	        tx.commit(); 
			} catch(Exception e){
				System.out.println("Erro ao inserir despesas" + e);
				tx.rollback();
			}
		PersistenceUtil.close(em);
        PersistenceUtil.close();
	}
	
public void RemoveDespesas(DespesasDAO despesa){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		//DespesasDAO desp = em.find(DespesasDAO.class, id);
		
		try{
			tx.begin();
	    	despesa.setStatus(false);
	        tx.commit(); 
			} catch(Exception e){
				System.out.println("Erro ao eliminar despesas" + e);
				tx.rollback();
			}
		PersistenceUtil.close(em);
        PersistenceUtil.close();
	}

public void AlteraDespesas(DespesasDAO despesas){
	
	EntityManager em = PersistenceUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	try{
		tx.begin();
    	em.merge(despesas);
        tx.commit(); 
		} catch(Exception e){
			System.out.println("Erro ao laterar despesas" + e);
			tx.rollback();
		}
	PersistenceUtil.close(em);
    PersistenceUtil.close();
}


public  List<DespesasDAO> despesaslista(){
	List<DespesasDAO>listdesp = null;
	EntityManager em = PersistenceUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	try{
	tx.begin();
	listdesp = em.createQuery("from DespesasDAO", DespesasDAO.class).getResultList();
    tx.commit(); 
	}catch(Exception e){
		System.out.println("erro na lista"+e);
		tx.rollback();
	}
   // PersistenceUtil.close(em);
   // PersistenceUtil.close();
    return listdesp;
}
}
