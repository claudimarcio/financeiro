package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.CadastroDespesasDAO;
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
		//PersistenceUtil.close(em);
        //PersistenceUtil.close();
	}
	
public void RemoveCadastroReceitas(long id){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		CadastroReceitasDAO cr = em.find(CadastroReceitasDAO.class, id);
		
		try{
			tx.begin();
			em.remove(cr);
	    	//cr.setStatus(false);
	        tx.commit(); 
			} catch(Exception e){
				System.out.println("Erro ao eliminar cadastro de receita" + e);
				tx.rollback();
			}
		//PersistenceUtil.close(em);
        //PersistenceUtil.close();
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
	//PersistenceUtil.close(em);
    //PersistenceUtil.close();
}


public List<CadastroReceitasDAO> cadastroReceitaList(long usuarioid,
		int cadastroGastoStatus) {
	List<CadastroReceitasDAO> listcadastroRec = null;
	EntityManager em = PersistenceUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	try {
		tx.begin();
		listcadastroRec = em.createQuery(
				" from  CadastroReceitasDAO cd"
		+ " where cd.usuario='"+usuarioid +"' and cd.status='"+cadastroGastoStatus+"'",
				CadastroReceitasDAO.class).getResultList();
		tx.commit();
	} catch (Exception e) {
		System.out.println("erro na lista" + e);
		tx.rollback();
	}
	System.out.println("retornando lista: "+ listcadastroRec);
	
	// PersistenceUtil.close(em);
	// PersistenceUtil.close();
	return listcadastroRec;
}



}
