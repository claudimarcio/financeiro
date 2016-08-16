package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import DAO.CadastroDespesasDAO;
import DAO.DespesasDAO;
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
		//PersistenceUtil.close(em);
		//PersistenceUtil.close();
	}

	public void RemoveCadastroDespesas(long id) {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		CadastroDespesasDAO cd = em.find(CadastroDespesasDAO.class, id);

		try {
			tx.begin();
			//cd.setStatus(false);
			em.remove(cd);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Erro ao eliminar cadastro de despesas" + e);
			tx.rollback();
		}
		//PersistenceUtil.close(em);
		//PersistenceUtil.close();
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
		//PersistenceUtil.close(em);
		//PersistenceUtil.close();
	}

	

	public List<CadastroDespesasDAO> cadastroDespesaList(long usuarioid,
			int cadastroGastoStatus) {
		List<CadastroDespesasDAO> listcadastroDesp = null;
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			listcadastroDesp = em.createQuery(
					" from  CadastroDespesasDAO cd"
			+ " where cd.usuario='"+usuarioid +"' and cd.status='"+cadastroGastoStatus+"'",
					CadastroDespesasDAO.class).getResultList();
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro na lista" + e);
			tx.rollback();
		}
		// PersistenceUtil.close(em);
		// PersistenceUtil.close();
		return listcadastroDesp;
	}
	
	



}
