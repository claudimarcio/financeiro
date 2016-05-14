package Testamodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import conexao.PersistenceUtil;

import DAO.CadastroDespesasDAO;
import DAO.DespesasDAO;
import DAO.UsuariosDAO;

import model.CadastroDespesasModel;
import model.DespesasModel;
import model.UsuariosModel;

public class testeModel {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		
		List <UsuariosDAO> user = new ArrayList<UsuariosDAO>();
		UsuariosModel un = new UsuariosModel();
		  user=un.usuariolista();
		  
		  for(UsuariosDAO cd:user){
			 System.out.println(cd);
		  }

		
		 // System.out.println("valor : "+cd.getValor()+"\n"+
		//" Data : "+cd.getData()+"\n"+" Nome da Despesa : "+
		// cd.getDespesas().getNome()); }
		 

		
		// EntityManager em = PersistenceUtil.getEntityManager();
		// EntityTransaction tx = em.getTransaction();
		 
		//  CadastroDespesasDAO cd = em.find(CadastroDespesasDAO.class,1l);
		//  CadastroDespesasModel cdM = new CadastroDespesasModel();
		 // DespesasDAO dep = em.find( DespesasDAO.class, 1l); 
		 // UsuariosDAO user = em.find( UsuariosDAO.class, 2l);
		  
		  
		 
		// try{ // formatando a data SimpleDateFormat formato = new
		//// SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// java.sql.Date data = new java.sql.Date(formato.parse("08/11/2015").getTime());
		// cd.setValor(150.00);
		// cd.setDespesas(dep);
		// cd.setUsuario(user);
		// cd.setStatus(true);
		// cd.setData(data);
		// cd.setId(12);
		 
		// cdM.RemoveCadastroDespesas(1);
		 
		  
		 
		// } catch(Exception e){ //para desfazer a transação caso haja erro
		// System.out.println("Erro na criação"); tx.rollback(); }
		

		/*EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		CadastroDespesasModel cdM = new CadastroDespesasModel();
		
	

		try {
			
			cdM.RemoveCadastroDespesas(1);
			

		} catch (Exception e) {
			
			System.out.println("Erro na criação"+e); tx.rollback();
			
		}*/

		}
	}


