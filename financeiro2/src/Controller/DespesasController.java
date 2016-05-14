package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.DespesasModel;

import DAO.DespesasDAO;

@ManagedBean(name = "despesasController")
@SessionScoped
public class DespesasController {
	private DespesasDAO despesasDAO = new DespesasDAO();
	
	private List<DespesasDAO> despesasList = new ArrayList<DespesasDAO>();
	
	DespesasModel despesasM = new DespesasModel();
	
	public void InserirDespesas(){
		despesasM.InsertDespesas(despesasDAO);
		
	}
	
	public void DeletaDespesas(){
		despesasM.RemoveDespesas(despesasDAO);
				
	}
	
	public void AlteraDespesas(){
		despesasM.AlteraDespesas(despesasDAO);
		
	}
	
	public List<DespesasDAO> getDespesasList(){
		this.despesasList = despesasM.despesaslista();
		return despesasList;
		
	}
	
	public void setDespesasList(List<DespesasDAO> despesasList){
		this.despesasList = despesasList;
	}
	
	public DespesasDAO getDespesas(){
		return despesasDAO;
		
	}
	
	public void setDespesas(DespesasDAO despesas){
		this.despesasDAO = despesas;
		
	}

}
