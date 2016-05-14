package Testamodel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.CadastroDespesasModel;
import model.CadastroReceitasModel;

import DAO.CadastroDespesasDAO;
import DAO.CadastroReceitasDAO;

import conexao.PersistenceUtil;

public class TestaModelCadastroReceita {

	
	public static void main(String[] args) {
		
		 EntityManager em = PersistenceUtil.getEntityManager();
		 EntityTransaction tx = em.getTransaction();
		 
		 CadastroReceitasDAO cr = em.find(CadastroReceitasDAO.class, 1l);
		 CadastroReceitasModel crM= new CadastroReceitasModel();
		 
		 try{
			 cr.setStatus(true);
			 crM.AlteraCadastroReceitas(cr);
			 
		 }catch(Exception e){
			 System.out.println("erro receitaModel; "+e);
		 }
		 
		 
		 
		 
		
	}

}
