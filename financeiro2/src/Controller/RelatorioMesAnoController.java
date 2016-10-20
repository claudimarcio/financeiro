package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.CadastroDespesasModel;
import model.RelatorioGeralModel;
import DAO.UsuariosDAO;
import DAO.recebeMesAno;

@ManagedBean(name = "anoController")
@SessionScoped
public class RelatorioMesAnoController {
	private List<Integer> ano;
	private List <Double> ValorTotalReceitaAnoMes ;
	
	
	 public List<Double> getValorTotalReceitaAnoMes() {
		return ValorTotalReceitaAnoMes;
	}


	public void setValorTotalReceitaAnoMes(List<Double> valorTotalReceitaAnoMes) {
		ValorTotalReceitaAnoMes = valorTotalReceitaAnoMes;
	}


	public List<Integer> getValorTotalReceitaAnoMesData() {
		return ValorTotalReceitaAnoMesData;
	}


	public void setValorTotalReceitaAnoMesData(
			List<Integer> valorTotalReceitaAnoMesData) {
		ValorTotalReceitaAnoMesData = valorTotalReceitaAnoMesData;
	}
	
	
	public List<Integer> getAno() {
		return ano;
	}


	public void setAno(List<Integer> ano) {
		this.ano = ano;
	}


	private List <Integer> ValorTotalReceitaAnoMesData ;
	
	CadastroDespesasModel cadastrodespM = new CadastroDespesasModel();
	RelatorioGeralModel relatorioGeral = new RelatorioGeralModel();
	
	
	

	public void listaValor(){
		  
		  
		  FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext()
					.getSession(false);

			UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
			long usuarioId = usuario1.getId();
			ValorTotalReceitaAnoMes =  relatorioGeral.listaValorMesAnoReceita(usuarioId );
		
		 
		  
	  }
	
	
	public  void listaMesAnoData(){
		  
		  
		  FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext()
					.getSession(false);

			UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
			long usuarioId = usuario1.getId();
			ano =  relatorioGeral.listaMesAnoReceitaData(usuarioId);
			
			
		
				
	}
	
	public  List<recebeMesAno> listaMesAno(){
		
		  FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext()
					.getSession(false);
			
			UsuariosDAO usuario1 = (UsuariosDAO) session.getAttribute("usuario");
			long usuarioId = usuario1.getId();
			List<recebeMesAno>listarecebeMesAno;
			
			listarecebeMesAno = relatorioGeral.listaAgregada(usuarioId);
			
			
			return listarecebeMesAno;
		
		
	}
		   
		
  
		  
	  }


	



