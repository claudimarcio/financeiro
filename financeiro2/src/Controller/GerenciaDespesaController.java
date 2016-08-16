package Controller;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

import DAO.CadastroDespesasDAO;
import DAO.CadastroReceitasDAO;
import DAO.DataDao;
import DAO.DespesasDAO;
import DAO.UsuariosDAO;
import model.DespesasModel;
import model.GerenciaContas;

@ManagedBean(name = "gerenciaDespesaController")
@SessionScoped
public class GerenciaDespesaController {
	private boolean mudacorCampoSaldoAtual;
	private DataDao dataDao;
	private DataModel<CadastroDespesasDAO> listdespesaData;
	private DataModel<CadastroReceitasDAO> listreceitasData;
	private DespesasDAO despesaDao;
	GerenciaContas gerenciaContas = new GerenciaContas();
	DespesasModel depesaModel = new DespesasModel();
		
	public DespesasDAO getDespesaDao() {
		return despesaDao;
	}

	public void setDespesaDao(DespesasDAO despesaDao) {
		this.despesaDao = despesaDao;
	}

	public DataModel<CadastroDespesasDAO> listaDespesaPorData()
			throws ParseException {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
		long usuarioId = usuario1.getId();

		List<CadastroDespesasDAO> lista = new ArrayList<CadastroDespesasDAO>();
		lista = gerenciaContas.listaDespesaDoMes(usuarioId);

		listdespesaData = new ListDataModel<CadastroDespesasDAO>(lista);

		return listdespesaData;

	}

	public DataModel<CadastroReceitasDAO> listaReceitaPorData()
			throws ParseException {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
		long usuarioId = usuario1.getId();

		List<CadastroReceitasDAO> lista = new ArrayList<CadastroReceitasDAO>();
		lista = gerenciaContas.listaReceitaDoMes(usuarioId);

		listreceitasData = new ListDataModel<CadastroReceitasDAO>(lista);

		return listreceitasData;

	}

	public String valorTotalDespesa() {

		Double valor = null;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
		long usuarioId = usuario1.getId();

		valor = gerenciaContas.valorDespesaTotal(usuarioId);
		String valor1 = NumberFormat.getCurrencyInstance().format(valor);

		return valor1;
	}

	public String valorTotalReceitas() {

		Double valor = null;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
		long usuarioId = usuario1.getId();
		valor = gerenciaContas.ValorReceitaTotal(usuarioId);
		String valor1 = NumberFormat.getCurrencyInstance().format(valor);
		return valor1;
	}
	
	public String saldoAtual(){
		Double valor = null;
		
		valor=gerenciaContas.saldoAtualTotal();
		String valor1 = NumberFormat.getCurrencyInstance().format(valor);
		
		
		if(valor>0){
			
			mudacorCampoSaldoAtual=true;
		}
		
		return valor1;
		
	}
	
	public boolean isMudacorCampoSaldoAtual() {
		return mudacorCampoSaldoAtual;
	}

	public void setMudacorCampoSaldoAtual(boolean mudacorCampoSaldoAtual) {
		this.mudacorCampoSaldoAtual = mudacorCampoSaldoAtual;
	}

}
