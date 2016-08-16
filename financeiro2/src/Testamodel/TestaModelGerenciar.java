package Testamodel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import conexao.PersistenceUtil;
import model.GerenciaContas;
import DAO.CadastroDespesasDAO;
import DAO.CadastroReceitasDAO;
import DAO.DataDao;

public class TestaModelGerenciar {
	
	public static void main(String[] args) throws ParseException {
		
		 EntityManager em = PersistenceUtil.getEntityManager();
		 EntityTransaction tx = em.getTransaction();
		
		DataDao data = new DataDao();
		GerenciaContas gerencia = new GerenciaContas();
		
		
		List<CadastroReceitasDAO> user = new ArrayList<CadastroReceitasDAO>();
		
		long usuarioId=9;
		 Double valorTotal= null;
		user = gerencia.listaReceitaDoMes(usuarioId);
		
		for(CadastroReceitasDAO cad:user){
		
			
			System.out.println(cad.getReceitas().getNome());

		}	
		
		
	}

}
