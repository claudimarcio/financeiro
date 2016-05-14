package Controller;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class LoginControler {
	
	
	
	
	public String telaInicial(){
		
		String url = "../index.xhml";
		
		return  url;
	}
	
	
	public String telaCadastro(){
		
		return "telaCadastro.xhtml";
		
	}

}
