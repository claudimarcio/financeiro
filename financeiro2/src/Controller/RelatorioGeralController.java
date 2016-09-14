package Controller;

import java.text.NumberFormat;
import java.text.ParseException;
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
import model.RelatorioGeralModel;
import DAO.CadastroDespesasDAO;
import DAO.CadastroReceitasDAO;
import DAO.DataDao;
import DAO.DespesasDAO;
import DAO.UsuariosDAO;

@ManagedBean(name = "relatorioGeralController")
@SessionScoped
public class RelatorioGeralController {

	private Date dataInicio, dataFinal;
	private boolean mudacorCampoSaldoAtual;
	private DataDao dataDao;
	private DataModel<Double> ValorTotalReceitaAnoMes;
	private DataModel<CadastroDespesasDAO> listdespesaData;
	private DataModel<CadastroReceitasDAO> listreceitaData;
	private DataModel<CadastroReceitasDAO> listreceitasData;
	private DespesasDAO despesaDao;
	private CadastroDespesasDAO cadastroDespeDAO;
	private String valorTotalDespesaStr;
	private String valorTotalReceitaStr;
	private Double valorTotalDespesaDoub;
	private Double valorTotalReceitaDoub;
	private String diferencaDespesaReceitastr;
	CadastroDespesasModel cadastrodespM = new CadastroDespesasModel();
	RelatorioGeralModel relatorioGeral = new RelatorioGeralModel();

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public DataModel<CadastroReceitasDAO> getListreceitaData() {
		return listreceitaData;
	}

	public void setListreceitaData(
			DataModel<CadastroReceitasDAO> listreceitaData) {
		this.listreceitaData = listreceitaData;
	}

	public DataModel<CadastroDespesasDAO> getListdespesaData() {
		return listdespesaData;
	}

	public void setListdespesaData(
			DataModel<CadastroDespesasDAO> listdespesaData) {
		this.listdespesaData = listdespesaData;
	}
	public String getValorTotalDespesaStr() {
		return valorTotalDespesaStr;
	}

	public void setValorTotalDespesaStr(String valorTotalDespesaStr) {
		this.valorTotalDespesaStr = valorTotalDespesaStr;
	}
	
	
	public String getValorTotalReceitaStr() {
		return valorTotalReceitaStr;
	}

	public void setValorTotalReceitaStr(String valorTotalReceitaStr) {
		this.valorTotalReceitaStr = valorTotalReceitaStr;
	}
	
	
	public Double getValorTotalDespesaDoub() {
		return valorTotalDespesaDoub;
	}

	public void setValorTotalDespesaDoub(Double valorTotalDespesaDoub) {
		this.valorTotalDespesaDoub = valorTotalDespesaDoub;
	}
	
	public String getDiferencaDespesaReceitastr() {
		return diferencaDespesaReceitastr;
	}

	public void setDiferencaDespesaReceitastr(String diferencaDespesaReceitastr) {
		this.diferencaDespesaReceitastr = diferencaDespesaReceitastr;
	}


	
	

	public void listaDespesaDataInicioFinal() throws ParseException {

		
		
		

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
		long usuarioId = usuario1.getId();

		List<CadastroDespesasDAO> lista = new ArrayList<CadastroDespesasDAO>();
		lista = relatorioGeral.gerenciaListaDespesa(usuarioId, dataInicio,
				dataFinal);

		listdespesaData = new ListDataModel<CadastroDespesasDAO>(lista);

	

	}

	public void listaReceitaDataInicioFinal() throws ParseException {

	

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
		long usuarioId = usuario1.getId();

		List<CadastroReceitasDAO> lista = new ArrayList<CadastroReceitasDAO>();
		lista= relatorioGeral.gerenciaListaReceita(usuarioId, dataInicio,
				dataFinal);

		listreceitaData = new ListDataModel<CadastroReceitasDAO>(lista);

		
	}
	
	public void valorTotalDespesas() throws ParseException {

		

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
		long usuarioId = usuario1.getId();

		
		valorTotalDespesaDoub= relatorioGeral.relatorioGeralDespesaTotal(usuarioId, dataInicio,
				dataFinal);

		 setValorTotalDespesaStr(NumberFormat.getCurrencyInstance().format(valorTotalDespesaDoub));
		
        
	}
	
public void valorTotalReceitas() throws ParseException {

		

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
		long usuarioId = usuario1.getId();

		
		valorTotalReceitaDoub= relatorioGeral.relatorioGeralreceitaTotal(usuarioId, dataInicio,
				dataFinal);

		 setValorTotalReceitaStr(NumberFormat.getCurrencyInstance().format(valorTotalReceitaDoub));
		
        
	}


  public void diferencaDespesaReceita(){
	  
	  double valorDiferenca = valorTotalReceitaDoub-valorTotalDespesaDoub;
	  
	//  diferencaDespesaReceitastr = NumberFormat.getCurrencyInstance().format(valorDiferenca);
	 
	  setDiferencaDespesaReceitastr(NumberFormat.getCurrencyInstance().format(valorDiferenca));
	  
  }
  
  
    
	
	
	
	public void ChamaMetodoDespesaEReceita() throws ParseException{
		
      listaDespesaDataInicioFinal();
      listaReceitaDataInicioFinal();
      valorTotalDespesas();
      valorTotalReceitas();
      diferencaDespesaReceita();
		
	}

	public void reset() {
		dataInicio = null;
		dataFinal = null;
	}

	
	
	
	
	
	

}
