package Testamodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.CadastroDespesasDAO;
import DAO.DespesasDAO;
import model.CadastroDespesasModel;
import conexao.PersistenceUtil;

public class testaModelCasatroDespesa {
	
	
	public static void main(String[] args) {
		
		
		 EntityManager em = PersistenceUtil.getEntityManager();
		 EntityTransaction tx = em.getTransaction();
		 
		 List <CadastroDespesasDAO> user = new ArrayList<CadastroDespesasDAO>();
		 
		 CadastroDespesasModel cadDespModel = new CadastroDespesasModel();
		 
		 user=cadDespModel.cadastroDespesaList(10,1);
		  
		  for(CadastroDespesasDAO cd:user){
			 System.out.println(cd.getDespesas().getNome());
		 
		 
		
		
	}

}
}
