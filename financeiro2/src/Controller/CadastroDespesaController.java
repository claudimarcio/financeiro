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

import model.CadastroDespesasModel;
import model.DespesasModel;
import model.ProjecaoGastosModel;
import DAO.CadastroDespesasDAO;
import DAO.DespesasDAO;
import DAO.ProjecaoGastosDAO;
import DAO.UsuariosDAO;

@ManagedBean(name = "cadastroDespesaControle")
@SessionScoped
public class CadastroDespesaController {

	Date date;
	DespesasModel despesasM = new DespesasModel();
	private DataModel<CadastroDespesasDAO> cadastroDesplista;
	private CadastroDespesasDAO cadastroDespeDAO;
	CadastroDespesasModel cadastrodespM = new CadastroDespesasModel();
	private int status = 1;

	/*
	 * getters e setters para poder popular o objeto cadastroDespDao da tela
	 * novo cadastro cadastro despesa
	 */

	public CadastroDespesasDAO getCadastroDespeDAO() {
		return cadastroDespeDAO;
	}

	public void setCadastroDespeDAO(CadastroDespesasDAO cadastroDespeDAO) {
		this.cadastroDespeDAO = cadastroDespeDAO;
	}

	public DataModel<CadastroDespesasDAO> listaTabelaCastroDesp() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario = (UsuariosDAO) session.getAttribute("usuario");
		long usuarioId = usuario.getId();

		List<CadastroDespesasDAO> lista = new ArrayList<CadastroDespesasDAO>();

		lista = cadastrodespM.cadastroDespesaList(usuarioId, status);
		cadastroDesplista = new ListDataModel<CadastroDespesasDAO>(lista);

		return cadastroDesplista;

	}

	public String gerenciaInserirCadastroDespesa() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");

		cadastroDespeDAO = new CadastroDespesasDAO();

		cadastroDespeDAO.setUsuario(usuario1);
		cadastroDespeDAO.setStatus(true);
		return "novoCadastroDespesa.xhtml";

	}

	public List<DespesasDAO> listaNormal() {

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

	public String InserirCadastroDespesas() {

		cadastrodespM.InsertCadastroDespesas(cadastroDespeDAO);
		return "listaCadastroDespesa.xhtml";

	}
	
	
	
	 public String alteracaoCadastroDespesapagina(){
		 
		 
			cadastroDespeDAO = (CadastroDespesasDAO) (cadastroDesplista.getRowData());
			 
			 return "alteracaoCadastroDespesas.xhtml";
		 }
	 
	 public String alteraCadastroDespesa(){
		 
		 cadastroDespeDAO.setStatus(true);
		 cadastrodespM.AlteraCadastroDespesas(cadastroDespeDAO);
		 
		 return "listaCadastroDespesa.xhtml";
		 
	 }
	 
	 public String remover(){
		 
		 cadastroDespeDAO = (CadastroDespesasDAO) cadastroDesplista.getRowData();
		 
		 cadastrodespM.RemoveCadastroDespesas(cadastroDespeDAO.getId());
		 
		 return "listaCadastroDespesa.xhtml";
		 
	 }

}
