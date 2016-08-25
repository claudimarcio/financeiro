package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import DAO.CadastroDespesasDAO;
import DAO.CadastroReceitasDAO;
import conexao.PersistenceUtil;

public class GerenciaContas {
	
	
	private Double saldoReceita, saldoDespesa, saldoAtual;

	public List<CadastroDespesasDAO> gerenciaListaDespesa(Long id,
			String dataInicio, String datafinal) throws ParseException {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		List<CadastroDespesasDAO> lista = null;

		// formatando a data
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = new java.sql.Date(formato.parse(dataInicio)
				.getTime());
		SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data1 = new java.sql.Date(formato1.parse(datafinal)
				.getTime());
		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			Query query = em.createQuery(
					" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario"
							+ " where cd.usuario='" + id + "'"
							+ " and cd.data BETWEEN'" + data + "'and'" + data1
							+ "'" + " ORDER BY '" + data + "' DESC ",
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

	public List<CadastroDespesasDAO> listaDespesaDoMes(long usuarioId) {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		List<CadastroDespesasDAO> lista = null;

		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			Query query = em
					.createQuery(
							"FROM CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario "
									+ "WHERE YEAR(cd.data) = YEAR(CURRENT_DATE) AND MONTH(cd.data) = MONTH(CURRENT_DATE) AND cd.usuario='"
									+ usuarioId + "'  ORDER BY  cd.data  ASC",
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

	public Double valorDespesaTotal(long usuarioId) {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		CadastroDespesasDAO valor = null;
		Double valor1 = null;
		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			TypedQuery<Double> query = em
					.createQuery(
							" SELECT SUM(cd.valor)FROM CadastroDespesasDAO cd "
									+ "WHERE YEAR(cd.data) = YEAR(CURRENT_DATE) AND MONTH(cd.data) = MONTH(CURRENT_DATE) AND cd.usuario='"
									+ usuarioId + "'", Double.class);
			valor1 = query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro ao gerar a lista: " + e);
		}
		// PersistenceUtil.close(em);
		// PersistenceUtil.close();
		 if(valor1==0){
		    valor1=0;	
		 }
		 
		saldoDespesa = valor1;

		return valor1;

	}

	public List<CadastroReceitasDAO> listaReceitaDoMes(long usuarioId) {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		List<CadastroReceitasDAO> lista = null;

		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			Query query = em
					.createQuery(
							"FROM CadastroReceitasDAO cd join fetch cd.receitas  join fetch cd.usuario "
									+ "WHERE YEAR(cd.data) = YEAR(CURRENT_DATE) AND MONTH(cd.data) = MONTH(CURRENT_DATE) AND cd.usuario='"
									+ usuarioId + "'  ORDER BY  cd.data  ASC",
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

	public Double ValorReceitaTotal(long usuarioId) {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		Double valor1 = null;
		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			TypedQuery<Double> query = em
					.createQuery(
							" SELECT SUM(cd.valor)FROM CadastroReceitasDAO cd "
									+ "WHERE YEAR(cd.data) = YEAR(CURRENT_DATE) AND MONTH(cd.data) = MONTH(CURRENT_DATE) AND cd.usuario='"
									+ usuarioId + "'", Double.class);
			valor1 = query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro ao gerar a lista: " + e);
		}
		// PersistenceUtil.close(em);
		// PersistenceUtil.close();
                  if(valor1==0){
		    valor1=0;	
		 }
		 saldoReceita = valor1;
		return valor1;

	}
	
	
	public Double saldoAtualTotal(){
		
		
		saldoAtual = saldoReceita-saldoDespesa;
		
		
		
		return saldoAtual;
	}
	
	
	
	public Double valorDespesaTotalDescontaPago(long usuarioId) {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		CadastroDespesasDAO valor = null;
		Double valor1 = null;
		try {
			tx.begin();
			// Query query =
			// em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario",
			// CadastroDespesasDAO.class);

			TypedQuery<Double> query = em
					.createQuery(
							" SELECT SUM(cd.valor)FROM CadastroDespesasDAO cd "
									+ "WHERE YEAR(cd.data) = YEAR(CURRENT_DATE) AND MONTH(cd.data) = MONTH(CURRENT_DATE) AND cd.usuario='"
									+ usuarioId + "' and cd.status=false", Double.class);
			valor1 = query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro ao gerar a lista: " + e);
		}
		// PersistenceUtil.close(em);
		// PersistenceUtil.close();
		
		saldoDespesa = valor1;

		return valor1;

	}
	
}
