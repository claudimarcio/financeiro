package Construtor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.UsuariosModel;

import DAO.CadastroDespesasDAO;
import DAO.CadastroReceitasDAO;
import DAO.DespesasDAO;
import DAO.ReceitasDAO;
import DAO.UsuariosDAO;
import DAO.ProjecaoGastosDAO;

import conexao.PersistenceUtil;

public class Construtor {

	
	private static UsuariosDAO user;

	public static void main(String[] args) throws ParseException {
		EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
 
        //CadastroReceitas cadastro_receitas = new CadastroReceitas();
        
       // UsuariosDAO user = em.find(UsuariosDAO.class,1l);
      //  UsuariosDAO user1 = em.find(UsuariosDAO.class,2l); 
        //Receita receitas =  em.find(Receita.class,3l);
        //Receita receitas = new Receita();
      //  user.setAutoridade("normal");
     //   user1.setAutoridade("Admin");
       
       
        //cadastro_receitas.setValor(1800.00);
        //cadastro_receitas.setUsuario(user);
        // formatando a data
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //java.sql.Date data = new java.sql.Date(formato.parse("15/01/2016").getTime());
        //cadastro_receitas.setData(data);
        //cadastro_receitas.setReceitas(receitas);
        
      //  try{
       // 	tx.begin();
       // 	em.merge(user);
        //	em.merge(user1);
       // 	tx.commit();
       // 	System.out.println("Tabela criada com sucesso!");
       // } catch(Exception e){
        	//para desfazer a transação caso haja erro
        //	System.out.println("Erro na criação");
        //	tx.rollback();
      //  }
       // PersistenceUtil.close(em);
      //  PersistenceUtil.close();
        
        
        
        UsuariosModel model = new UsuariosModel();
        
        try {
        	
        	user = model.getUsuario("quinholi", "5555");
        	
        	System.out.println(user);
			
		} catch (Exception e) {
			 System.out.println("erro ao chamar o usuario");
		}
        
	}

	}
