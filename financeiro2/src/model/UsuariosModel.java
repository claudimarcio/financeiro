package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import conexao.PersistenceUtil;
import DAO.UsuariosDAO;

public class UsuariosModel {

	public UsuariosModel() {
		super();
	}

	public List<UsuariosDAO> usuariolista() {
		List<UsuariosDAO> listuser = null;
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			listuser = em.createQuery("from UsuariosDAO", UsuariosDAO.class)
					.getResultList();
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro na lista" + e);
			tx.rollback();
		}
		 PersistenceUtil.close(em);
		// PersistenceUtil.close();
		return listuser;
	}

	public UsuariosDAO usuarioId(long id) {

		UsuariosDAO usuario = null;

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			usuario = em.find(UsuariosDAO.class, 1l);
			tx.commit();
		} catch (Exception e) {
			System.out.println("erro");
			tx.rollback();
		}
		 PersistenceUtil.close(em);
		// PersistenceUtil.close();

		return usuario;
	}

	public void InsertUsuario(UsuariosDAO usuario) { //

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(usuario);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Erro ao inserir usuario" + e);
			tx.rollback();
		}
		 PersistenceUtil.close(em);
		// PersistenceUtil.close();
	}

	public void RemoveUsuario(UsuariosDAO usuario) {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {

			tx.begin();
			UsuariosDAO usuario1 = em.find(UsuariosDAO.class, usuario.getId());
			em.remove(usuario1);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Erro ao eliminar usuario" + e);
			tx.rollback();
		}
		 PersistenceUtil.close(em);
		// PersistenceUtil.close();
	}

	public void AlteraUsuario(UsuariosDAO usuario) { //

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {

			tx.begin();
			em.merge(usuario);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Erro ao alterar usuario" + e);
			tx.rollback();
		}
		 PersistenceUtil.close(em);
		// PersistenceUtil.close();
	}

	/*
	 * Método utilizado para fazer o login do usuario no sistema.
	 */

	public UsuariosDAO getUsuario(String nome, String senha) {

		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		UsuariosDAO usuario = new UsuariosDAO();

		try {
			tx.begin();
			Query query = em
					.createQuery("SELECT u from UsuariosDAO u where u.nome = '"
							+ nome + "' and u.senha = '" + senha + "'");

			@SuppressWarnings("unchecked")
			List<UsuariosDAO> log = query.getResultList();

			tx.commit();

			for (UsuariosDAO emp : log) {

				if ((emp.getNome().equals(nome))
						&& (emp.getSenha().equals(senha))) {
					usuario.setAutoridade(emp.getAutoridade());
					usuario.setNome(emp.getNome());
					usuario.setSenha(emp.getSenha());

				}
			}
			PersistenceUtil.close(em);
			return usuario;

		} catch (Exception e) {
			System.out.println("Erro ao comparar usuario" + e);
			tx.rollback();

			return null;
		}

	}

}