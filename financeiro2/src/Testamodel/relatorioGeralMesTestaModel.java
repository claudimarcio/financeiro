package Testamodel;

import java.util.List;

import model.RelatorioGeralModel;

public class relatorioGeralMesTestaModel {
	public static void main(String[] args) {
		
	
		 
		Long idUsuario = (long) 10;
		 
		 RelatorioGeralModel rel = new RelatorioGeralModel();
		 
		List<Integer> relatorio= rel.listaMesAnoReceita(idUsuario);
		
		List<Double> valorDoMes = rel.listaValorMesAnoReceita(idUsuario); 
		 
	for(Integer mes: relatorio){
		
		System.out.println(mes);
	}
	
	
for(Double mes: valorDoMes){
		
		System.out.println(mes);
	}

}
}
