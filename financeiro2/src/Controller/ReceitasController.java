package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.ReceitasModel;

import DAO.ReceitasDAO;
import DAO.UsuariosDAO;

@ManagedBean(name = "receitasController")
@SessionScoped
public class ReceitasController {

	private ReceitasDAO receitasDAO = new ReceitasDAO();
	
	private List<ReceitasDAO> receitasList = new ArrayList<ReceitasDAO>();
	
	ReceitasModel receitasM = new ReceitasModel();
	
	public void InserirRececeitas(){
		receitasM.InsertReceitas(receitasDAO);
	}
	
	public void DeletaReceitas(){
		receitasM.RemoveReceitas(receitasDAO);
				
	}
	
	public void AlteraReceitas(){
		receitasM.AlteraReceitas(receitasDAO);
		
	}
	
	public List<ReceitasDAO> getReceitasList(){
		this.receitasList = receitasM.receitaslista();
		return receitasList;
		
	}
	
	public void setReceitaList(List<ReceitasDAO> receitaList){
		this.receitasList = receitaList;
		
	}
	
	public ReceitasDAO getReceitas(){
		return receitasDAO;
		
	}
	
	public void setReceitas(ReceitasDAO receitas){
		this.receitasDAO = receitas;
		
	}
}
