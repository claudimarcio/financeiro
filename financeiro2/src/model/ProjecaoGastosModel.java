package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.ProjecaoGastosDAO;
import DAO.UsuariosDAO;
import conexao.PersistenceUtil;

public class ProjecaoGastosModel {

	public ProjecaoGastosModel() {
		super();
		
	}

	
	public void InsertProjecaoGastos(ProjecaoGastosDAO projecao){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
	    	em.persist(projecao);
	        tx.commit(); 
			} catch(Exception e){
				System.out.println("Erro ao inserir projecao" + e);
				tx.rollback();
			}
		PersistenceUtil.close(em);
        PersistenceUtil.close();
	}
	
public void RemoveProjecaoGastos(ProjecaoGastosDAO prog ){
		
	    
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		//ProjecaoGastosDAO pg = em.find(ProjecaoGastosDAO.class, id);
		
		try{
			tx.begin();
	    	prog.setStatus(false);
	        tx.commit(); 
			} catch(Exception e){
				System.out.println("Erro ao remover projecao" + e);
				tx.rollback();
			}
		PersistenceUtil.close(em);
        PersistenceUtil.close();
	}
	
public void AlteraProjecaoGastos(ProjecaoGastosDAO projecao){
	
	EntityManager em = PersistenceUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	try{
		tx.begin();
    	em.merge(projecao);
        tx.commit(); 
		} catch(Exception e){
			System.out.println("Erro ao alterar projecao" + e);
			tx.rollback();
		}
	PersistenceUtil.close(em);
    PersistenceUtil.close();
}


public  List<ProjecaoGastosDAO> Projecaolista(){
	List<ProjecaoGastosDAO>listgasto = null;
	EntityManager em = PersistenceUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	try{
	tx.begin();
	listgasto = em.createQuery("from ProjecaoGastosDAO", ProjecaoGastosDAO.class).getResultList();
    tx.commit(); 
	}catch(Exception e){
		System.out.println("erro na lista"+e);
		tx.rollback();
	}
   // PersistenceUtil.close(em);
   // PersistenceUtil.close();
    return listgasto;
}



}
