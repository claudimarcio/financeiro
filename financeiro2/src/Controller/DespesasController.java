package Controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import model.DespesasModel;
import DAO.DespesasDAO;
import DAO.UsuariosDAO;

@ManagedBean(name = "despesasController")
@SessionScoped
public class DespesasController {

	private DataModel<DespesasDAO> despesaslista;
	private DespesasDAO despesasDAO;
	DespesasModel despesasM = new DespesasModel();

	// private DespesasDAO despesasDAO = new DespesasDAO();

	// private List<DespesasDAO> despesasList = new ArrayList<DespesasDAO>();

	// DespesasModel despesasM = new DespesasModel();

	public String InserirDespesas() {
		despesasM.InsertDespesas(despesasDAO);
		return "listaDespesas.xhtml";

	}

	public void DeletaDespesas() {
		
		despesasDAO = (DespesasDAO) (despesaslista.getRowData());
		despesasM.RemoveDespesas(despesasDAO);

	}

	public String AlteraDespesas() {
		despesasM.AlteraDespesas(despesasDAO);
		
		return "listaDespesas.xhtml";

	}

	public DataModel<DespesasDAO> listaTabelaDespesa() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario = (UsuariosDAO) session.getAttribute("usuario");
		String usuarioNome = usuario.getNome();
		String usuarioSenha = usuario.getSenha();

	
		
		List<DespesasDAO> lista = despesasM.despesaslista(usuarioNome,
				usuarioSenha);
		despesaslista = new ListDataModel<DespesasDAO>(lista);

		return despesaslista;

	}

	public DespesasDAO getDespesas() {
		return despesasDAO;

	}

	public void setDespesas(DespesasDAO despesas) {
		this.despesasDAO = despesas;

	}
	
	/*
	 * Metodo que cria uma nona despesa e direciona
	 * para a pagina inserir nova Despesa.xhtml
	 */
	
	public String gerenciaInserirNovaDespesa(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
			
		
		despesasDAO  = new DespesasDAO();
		despesasDAO.setStatus(true);
		despesasDAO.setUsuario(usuario1);
		return "novaDespesa.xhtml";
		
		
	}
	
	// metodo para direcionar a pagina usuario normal para pagina listadespesas
	
	
	public String direcionaPaginaListaDespesa(){
		
		
		return "listaDespesas.xhtml";
	}
	
	
	/**
	 *Metodo para enviar para a pagina onde sera feita as atualização
	 * ou seja as modificações na despesa.
	 * 
	 */
	
	 public String alteracaoDespesapagina(){
		 
		 
		despesasDAO = (DespesasDAO) (despesaslista.getRowData());
		 
		 return "alteracaoDespesa.xhtml";
	 }
	 
	 
	 /*
	  *Este metodo retorna o nome das despesas cadastradas para serem utilizado
	  * para preencher o list da pagina novoCadastroDespesa.xhtml 
	  */
	 
	 
	 public List<DespesasDAO> listaNormal(){
		 
		 FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext()
					.getSession(false);

			UsuariosDAO usuario = (UsuariosDAO) session.getAttribute("usuario");
			String usuarioNome = usuario.getNome();
			String usuarioSenha = usuario.getSenha();

		
			
			List<DespesasDAO> lista = despesasM.despesaslista(usuarioNome,
					usuarioSenha);
			
			return lista; 
		 
		 
	 }

}
