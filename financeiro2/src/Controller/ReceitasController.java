package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

import model.ReceitasModel;
import DAO.DespesasDAO;
import DAO.ReceitasDAO;
import DAO.UsuariosDAO;

@ManagedBean(name = "receitasController")
@SessionScoped
public class ReceitasController {

	private ReceitasDAO receitasDAO;
	private DataModel<ReceitasDAO> receitalista;
	ReceitasModel receitasM = new ReceitasModel();
	
	
	public DataModel<ReceitasDAO> receitaLista(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario = (UsuariosDAO) session.getAttribute("usuario");
		String usuarioNome = usuario.getNome();
		String usuarioSenha = usuario.getSenha();
		
		List<ReceitasDAO>lista = receitasM.receitasLista(usuarioNome, usuarioSenha);
		
		receitalista= new ListDataModel<ReceitasDAO>(lista);
		return receitalista;
	}
	
public String gerenciaInserirNovaReceita(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
			
		
		receitasDAO  = new ReceitasDAO();
		receitasDAO.setStatus(true);
		receitasDAO.setUsuario(usuario1);
		
		return "novaReceita.xhtml";
		
		
	}


public String alteracaoRedirecionaPagina(){
	
	
	receitasDAO = (ReceitasDAO)receitalista.getRowData();
	
	
	
	return "alteracaoReceita.xhtml";
	
}
	
	
	
	
	
	public String InserirRececeitas(){
		
		
		receitasM.InsertReceitas(receitasDAO);
		
		return "listaReceita.xhtml";
	}
	
	public String DeletaRec(){
		
		receitasDAO = (ReceitasDAO)receitalista.getRowData();
		System.out.println("este é"+ receitasDAO);
		receitasM.RemoveReceitas(receitasDAO);
	  return"listaReceita.xhtml";			
	}
	
	public String AlteraRec(){
		
		System.out.println( "Este trecho de linha é o que tem a receita dao "+receitasDAO);
		receitasM.AlteraRec(receitasDAO);
		return"listaReceita";	
	}
	
	public ReceitasDAO getReceitas(){
		return receitasDAO;
		
	}
	
	public void setReceitas(ReceitasDAO receitas){
		this.receitasDAO = receitas;
		
	}
	
	
	public  void verifica(){
		
		System.out.println( "Este trecho de linha é o que tem a receita dao "+receitasDAO);
		
	}
}
