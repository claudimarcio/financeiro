package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.DespesasDAO;
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
		//PersistenceUtil.close(em);
       // PersistenceUtil.close();
	}
	
public void RemoveReceitas(ReceitasDAO receitas){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		//ReceitasDAO rec = em.find(ReceitasDAO.class, id);
		try{
			ReceitasDAO despesa1 = em.find(ReceitasDAO.class, receitas.getId());
			System.out.println("Ate aqui chegou antes do remove");
			tx.begin();
			em.remove(despesa1);
			tx.commit();
	        
			} catch(Exception e){
				
				tx.rollback();
				System.out.println("Erro ao eliminar receita" + e);
			}
		//PersistenceUtil.close(em);
        //PersistenceUtil.close();
	}
	
public void AlteraRec(ReceitasDAO receitas){
	
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
	//PersistenceUtil.close(em);
    //PersistenceUtil.close();
}

public  List<ReceitasDAO> receitasLista(String usuario, String senha){
	List<ReceitasDAO>recdesp = null;
	EntityManager em = PersistenceUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	try{
	tx.begin();
	recdesp = em.createQuery("from ReceitasDAO where usuario.nome =  '"+ usuario +"' and usuario.senha = '"+ senha +"' and status = true" , ReceitasDAO.class).getResultList();
    tx.commit(); 
	}catch(Exception e){
		System.out.println("erro na lista"+e);
		tx.rollback();
	}
   // PersistenceUtil.close(em);
   // PersistenceUtil.close();
    return recdesp;
}
	
}
