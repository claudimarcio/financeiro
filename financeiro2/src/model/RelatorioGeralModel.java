package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import DAO.CadastroDespesasDAO;
import DAO.CadastroReceitasDAO;
import DAO.recebeMesAno;
import conexao.PersistenceUtil;

public class RelatorioGeralModel {
	
	
	
	//select EXTRACT(YEAR_MONTH FROM cadastro_despesas_data) as data, sum(cadastro_despesas_valor) from cadastro_despesas group by EXTRACT(YEAR_MONTH FROM cadastro_despesas_data);
	//select month(cadastro_despesas_data),Year(cadastro_despesas_data), sum(cadastro_despesas_valor) from cadastro_despesas group by YEAR(cadastro_despesas_data), month(cadastro_despesas_data);
	
	
	public List<CadastroDespesasDAO> gerenciaListaDespesa(Long id,
			Date dataInicio, Date datafinal) throws ParseException {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		List<CadastroDespesasDAO> lista = null;

		// formatando a data
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
String data10= formato.format(dataInicio);
		SimpleDateFormat formato1 = new SimpleDateFormat("yyyy/MM/dd");
String data11=formato1.format(datafinal);
				
		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			Query query = em.createQuery(
					" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario"
							+ " where cd.usuario='" + id + "'"
							+ " and cd.data BETWEEN'" + data10 + "'and'" +  data11 
							+ "'" + " ORDER BY '" + data10 + "' DESC ",
					CadastroDespesasDAO.class);
			lista = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro ao gerar a lista: " + e);
		}
		// PersistenceUtil.close(em);
		// PersistenceUtil.close();
		return lista;

	}
	
	
	
	public List<CadastroReceitasDAO> gerenciaListaReceita(Long id,
			Date dataInicio, Date datafinal) throws ParseException {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		List<CadastroReceitasDAO> lista = null;

		// formatando a data
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
String data10= formato.format(dataInicio);
		SimpleDateFormat formato1 = new SimpleDateFormat("yyyy/MM/dd");
String data11=formato1.format(datafinal);
				
		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			Query query = em.createQuery(
					" from CadastroReceitasDAO cd join fetch cd.receitas  join fetch cd.usuario"
							+ " where cd.usuario='" + id + "'"
							+ " and cd.data BETWEEN'" + data10 + "'and'" +  data11 
							+ "'" + " ORDER BY '" + data10 + "' DESC ",
					CadastroReceitasDAO.class);
			lista = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro ao gerar a lista: " + e);
		}
		// PersistenceUtil.close(em);
		// PersistenceUtil.close();
		return lista;

	}
	
	
	
	
	public  Double relatorioGeralDespesaTotal(Long id,
			Date dataInicio, Date datafinal) throws ParseException {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
        
		
		Double valorTotalDespesa = null;
	      

		// formatando a data
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
String data10= formato.format(dataInicio);
		SimpleDateFormat formato1 = new SimpleDateFormat("yyyy/MM/dd");
String data11=formato1.format(datafinal);
				
		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			Query query = em.createQuery(
					"  select sum(cd.valor)from CadastroDespesasDAO cd"
							+ " where cd.usuario='" + id + "'"
							+ " and cd.data BETWEEN'" + data10 + "'and'" +  data11 
							+ "'" + " ORDER BY '" + data10 + "' DESC ",
					Double.class);
			valorTotalDespesa = (Double) query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro ao gerar a lista: " + e);
		}
		// PersistenceUtil.close(em);
		// PersistenceUtil.close();
		
		
		if(valorTotalDespesa==null){
			
			valorTotalDespesa=0.00;
		}
		
		
		return valorTotalDespesa;

	}
	
	
	
	public  Double relatorioGeralreceitaTotal(Long id,
			Date dataInicio, Date datafinal) throws ParseException {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
        
		
		Double valorTotalReceita = null;
	      

		// formatando a data
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
String data10= formato.format(dataInicio);
		SimpleDateFormat formato1 = new SimpleDateFormat("yyyy/MM/dd");
String data11=formato1.format(datafinal);
				
		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			Query query = em.createQuery(
					"  select sum(cd.valor)from CadastroReceitasDAO cd"
							+ " where cd.usuario='" + id + "'"
							+ " and cd.data BETWEEN'" + data10 + "'and'" +  data11 
							+ "'" + " ORDER BY '" + data10 + "' DESC ",
					Double.class);
			valorTotalReceita = (Double) query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro ao gerar a lista: " + e);
		}
		// PersistenceUtil.close(em);
		// PersistenceUtil.close();
		
		
		if(valorTotalReceita==null){
			
			valorTotalReceita=0.00;
		}
		
		
		return valorTotalReceita;

	}
	
	/*
	@SuppressWarnings("unchecked")
	public List<Integer>listaMesAnoReceita(Long usuarioId){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
	 List lista = null;
		
		
		
		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			
			
			 Query query= em.createQuery(
					"select EXTRACT(YEAR_MONTH FROM cd.data) from CadastroReceitasDAO cd "
							+"WHERE cd.usuario= '"+usuarioId+"'"
							+"group by EXTRACT(YEAR_MONTH FROM cd.data)", Integer.class);
					 
			  lista = query.getResultList(); 
			 
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro ao gerar a lista: " + e);
		}
		// PersistenceUtil.close(em);
		// PersistenceUtil.close();
		
		
		return lista;
	}

	*/
	
public List<Double>listaValorMesAnoReceita(Long usarioId){
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
	 List<Double> lista = null;
		
		
		
		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			
			
			 Query query= em.createQuery(
					"select  sum(cd.valor) from CadastroReceitasDAO cd "
					 +"WHERE cd.usuario= '"+usarioId+"'"
					 +"group by EXTRACT(YEAR_MONTH FROM cd.data)", Double.class);
					 
			  lista = query.getResultList(); 
			 
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro ao gerar a lista: " + e);
		}
		// PersistenceUtil.close(em);
		// PersistenceUtil.close();
		
			
		return lista;
	}

	

public List<Integer>listaMesAnoReceitaData(Long usarioId){
	
	EntityManager em = PersistenceUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
 List<Integer> lista = null;
	
	
	
	try {
		tx.begin();
		// Query query =
		// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
		// CadastroDespesasDAO.class);

		
		
		 Query query= em.createQuery(
				"select  EXTRACT(YEAR_MONTH FROM cd.data) from CadastroReceitasDAO cd  "
				 +"WHERE cd.usuario= '"+usarioId+"'"
				 +"group by EXTRACT(YEAR_MONTH FROM cd.data)", Integer.class);
				 
		  lista = query.getResultList(); 
		 
		tx.commit();
	} catch (Exception e) {
		System.out.println("erro ao gerar a lista: " + e);
	}
	// PersistenceUtil.close(em);
	// PersistenceUtil.close();
	
		
	return lista;
}


@SuppressWarnings("unchecked")
public List <recebeMesAno>listaAgregada(Long usarioId){
	
	EntityManager em = PersistenceUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	List <Object[]> resultado= null;
	List<recebeMesAno>result = null;
	List<recebeMesAno>lista = new ArrayList<recebeMesAno>();
	
	
	
	
	try {
		tx.begin();
		// Query query =
		// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
		// CadastroDespesasDAO.class);

		
		
		final Query query= em.createQuery(
				"select  sum(cd.valor), EXTRACT(YEAR_MONTH FROM cd.data) from CadastroReceitasDAO cd  "
				 +"WHERE cd.usuario= '"+usarioId+"'"
				 +"group by EXTRACT(YEAR_MONTH FROM cd.data)");
	 resultado=(List<Object[]>)query.getResultList(); 
	for(Object[] linha : resultado){
 		   	 lista.add(new recebeMesAno(((Integer)linha[1]), ((Double)linha[0])));
	    	
	   	
	 }
	  System.out.println(lista);
	  
	  
	 tx.commit();
	   	
		    	
	} catch (Exception e) {
		System.out.println("erro ao gerar a lista: " + e);
	}
	// PersistenceUtil.close(em);
	// PersistenceUtil.close();
		
	return lista;
}




}
