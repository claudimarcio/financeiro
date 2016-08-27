package Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

import model.CadastroReceitasModel;
import model.ReceitasModel;
import DAO.CadastroDespesasDAO;
import DAO.CadastroReceitasDAO;
import DAO.DespesasDAO;
import DAO.ReceitasDAO;
import DAO.UsuariosDAO;

@ManagedBean(name="cadastroReceitaController")
@SessionScoped
public class CadastroReceitaController {

	Date date;
	ReceitasModel receitaM = new ReceitasModel();
	private DataModel<CadastroReceitasDAO> cadastroReceitaplista;
	private CadastroReceitasDAO cadastroRecDAO;
	CadastroReceitasModel cadastrorecM = new CadastroReceitasModel();
	private int status = 1;

	public CadastroReceitasDAO getCadastroRecDAO() {
		return cadastroRecDAO;
	}

	public void setCadastroRecDAO(CadastroReceitasDAO cadastroRecDAO) {
		this.cadastroRecDAO = cadastroRecDAO;
	}

	public DataModel<CadastroReceitasDAO> listaTabelaCastroRec() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario = (UsuariosDAO) session.getAttribute("usuario");
		long usuarioId = usuario.getId();

		List<CadastroReceitasDAO> lista = new ArrayList<CadastroReceitasDAO>();

		lista = cadastrorecM.cadastroReceitaList(usuarioId, status);
		cadastroReceitaplista = new ListDataModel<CadastroReceitasDAO>(lista);

		return cadastroReceitaplista;

	}
	
	
	public String gerenciaInserirCadastroReceita() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");

		cadastroRecDAO = new CadastroReceitasDAO();

		cadastroRecDAO.setUsuario(usuario1);
		cadastroRecDAO.setStatus(false);
		return "novoCadastroReceita.xhtml";

	}
	
	
	public List<ReceitasDAO> listaNormal() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario = (UsuariosDAO) session.getAttribute("usuario");
		String usuarioNome = usuario.getNome();
		String usuarioSenha = usuario.getSenha();

		List<ReceitasDAO> lista = receitaM.receitasLista(usuarioNome,
				usuarioSenha);

		return lista;

	}
	
	
	public String InserirCadastroReceita() {

		cadastrorecM.InsertCadastroReceitas(cadastroRecDAO);
		return "listaCadastroReceita.xhtml";

	}
	
	public String remover(){
		 
		 cadastroRecDAO = (CadastroReceitasDAO) cadastroReceitaplista.getRowData();
		 
		cadastrorecM.RemoveCadastroReceitas(cadastroRecDAO.getId());
		 
		 return "listaCadastroReceitas.xhtml";
		 
	 }
	
	 public String alteracaoCadastroReceitaPagina(){
		 
		 
			cadastroRecDAO = (CadastroReceitasDAO) (cadastroReceitaplista.getRowData());
			 
			 return "alteracaoCadastroReceita.xhtml";
		 }
	 
	 
 public String alteraCadastroReceita(){
		 
		 cadastroRecDAO.setStatus(false);
		 cadastrorecM.AlteraCadastroReceitas(cadastroRecDAO);;
		 
		 return "listaCadastroReceita.xhtml";
		 
	 }

}
