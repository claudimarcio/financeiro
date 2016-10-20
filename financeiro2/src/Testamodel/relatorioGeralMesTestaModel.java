package Testamodel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.recebeMesAno;
import conexao.PersistenceUtil;
import model.RelatorioGeralModel;

public class relatorioGeralMesTestaModel {
	public static void main(String[] args) {
		

		List<recebeMesAno> recebe=null;
		RelatorioGeralModel relatorio = new RelatorioGeralModel();
		long numero = 9;
		recebe = relatorio.listaAgregada(numero);
		
		
	
	} 
	
	
	

}
