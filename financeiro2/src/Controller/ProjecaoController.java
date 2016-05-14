package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.ProjecaoGastosModel;
import DAO.ProjecaoGastosDAO;

@ManagedBean(name = "projecaoController")
@SessionScoped
public class ProjecaoController {

	private ProjecaoGastosDAO projecaoGastosDAO = new ProjecaoGastosDAO();

	private List<ProjecaoGastosDAO> projecaoGastosList = new ArrayList<ProjecaoGastosDAO>();

	ProjecaoGastosModel projecaoM = new ProjecaoGastosModel();

	private List<ProjecaoGastosDAO> projecaoList;

	public void InserirProjecao() {
		projecaoM.InsertProjecaoGastos(projecaoGastosDAO);

	}

	public void DeletarProjecao() {
		projecaoM.RemoveProjecaoGastos(projecaoGastosDAO);
	}

	public void AlteraProjecao() {

		projecaoM.AlteraProjecaoGastos(projecaoGastosDAO);
	}

	public List<ProjecaoGastosDAO> getProjecaoList() {
		
		this.projecaoGastosList = projecaoM.Projecaolista();
		return projecaoList;
	}

	public void setProjecaoList(List<ProjecaoGastosDAO> projecaoList) {
		this.projecaoGastosList = projecaoList;
		
		
	}

	public ProjecaoGastosDAO getProjecaoGastosDAO() {
		return projecaoGastosDAO;
	}

	public void setProjecao(ProjecaoGastosDAO projecao) {
		this.projecaoGastosDAO = projecao;
	}

	
}
