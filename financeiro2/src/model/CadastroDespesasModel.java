package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import DAO.CadastroDespesasDAO;
import conexao.PersistenceUtil;

public class CadastroDespesasModel {

	public CadastroDespesasModel() {
		super();

	}

	public void InsertCadastroDespesas(CadastroDespesasDAO cadastro_despesas) {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(cadastro_despesas);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Erro ao inserir cadastro de despesas" + e);
			tx.rollback();
		}
		PersistenceUtil.close(em);
		PersistenceUtil.close();
	}

	public void RemoveCadastroDespesas(long id) {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		CadastroDespesasDAO cd = em.find(CadastroDespesasDAO.class,id); 
		
		try {
			tx.begin();
			cd.setStatus(false);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Erro ao eliminar cadastro de despesas" + e);
			tx.rollback();
		}
		PersistenceUtil.close(em);
		PersistenceUtil.close();
	}

	public void AlteraCadastroDespesas(CadastroDespesasDAO cadastro_despesas) {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(cadastro_despesas);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Erro ao alterar cadastro de despesas" + e);
			tx.rollback();
		}
		PersistenceUtil.close(em);
		PersistenceUtil.close();
	}

	public List<CadastroDespesasDAO> castroDespesasLista() throws ParseException {
		
		
		
		

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		List<CadastroDespesasDAO> lista = null;
		
		 // formatando a data
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(formato.parse("01/01/2015").getTime());
        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data1 = new java.sql.Date(formato1.parse("30/12/2015").getTime());
		try {
		tx.begin();	
		//Query query = em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario", CadastroDespesasDAO.class);
		
		Query query = em.createQuery(" from CadastroDespesasDAO cd join fetch cd.despesas  join fetch cd.usuario"+
		" where cd.usuario=1"+
		" and cd.data BETWEEN'"+data+"'and'"+data1+"'"+
		"and cd.status = false", CadastroDespesasDAO.class);
		lista = query.getResultList();
		tx.commit();
		} catch (Exception e) {
            System.out.println("erro ao gerar a lista: "+e);
		}
		PersistenceUtil.close(em);
		PersistenceUtil.close();
		return lista;

	}

}
