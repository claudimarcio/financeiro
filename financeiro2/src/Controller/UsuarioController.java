package Controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UsuariosModel;
import DAO.UsuariosDAO;
import conexao.JPAListener;
import controleLogin.Autentication;
import controleLogin.Autentication1;

@ManagedBean
@SessionScoped
public class UsuarioController {

	private DataModel<UsuariosDAO> usuariolista;
	private UsuariosDAO usuarioDao;
    private boolean liberaLinkUsuario = false;
	UsuariosModel usuarioM = new UsuariosModel();

	public DataModel<UsuariosDAO> listaTabelausuario() {

		List<UsuariosDAO> lista = usuarioM.usuariolista();
		usuariolista = new ListDataModel<UsuariosDAO>(lista);

		return usuariolista;

	}

	public String InserirUsuario() {

		// usuarioDao = (UsuariosDAO)(usuariolista.getRowData());
		usuarioM.InsertUsuario(usuarioDao);

		return "lista.xhtml";
	}

	public void DeletarUsuario() {

		usuarioDao = (UsuariosDAO) (usuariolista.getRowData());
		usuarioM.RemoveUsuario(usuarioDao);

	}

	public String AlteraUsuario() {
		// usuarioDao = (UsuariosDAO)(usuariolista.getRowData());
		usuarioM.AlteraUsuario(usuarioDao);
		return "lista.xhtml";
	}

	public String enviarDados() {

		usuarioDao = (UsuariosDAO) (usuariolista.getRowData());

		return "gerenciadorUsuario.xhtml";

	}

	public String GerenciaInseirUsuario() {

		usuarioDao = new UsuariosDAO();

		return "novoUsuario.xhtml";
	}

	public UsuariosDAO getUsuario() {
		return usuarioDao;
	}

	public void setUsuario(UsuariosDAO usuario) {
		this.usuarioDao = usuario;
	}

	public String voltaListagem() {

		return "areaCliente/areaAdmin/lista.xhtml";

	}

	public void testeLista() {

		List<UsuariosDAO> lista = usuarioM.usuariolista();
		System.out.println(lista);
	}

	/*
	 * Metodo que checa usuario e senha e direciona para o diretoriio conforme
	 * privilégios
	 */

	public String checa() {
		String url = null;

		UsuariosDAO user = (UsuariosDAO) usuarioM.getUsuario(
				usuarioDao.getNome(), usuarioDao.getSenha());

		if (user.getNome() == null) {
			System.out.println("reprovado");
			url = telaLogin();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "erro",
							"Senha ou Usuario errado"));
		} else {
			try {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) facesContext
						.getExternalContext().getSession(false);
				session.setAttribute("usuario", user);

				// define qual diretorio de acordo com privilégios
				if (user.getAutoridade().equals("admin")) {
					url = "../areaCliente/areaAdmin/lista.xhtml";
					
					liberaLinkUsuario = true;

				} else {
					url = "../areaCliente/areaCliente.xhtml";
					liberaLinkUsuario = false;
				}

			} catch (Exception e) {
				System.out.println("erro");
			}

		}

		return url;

	}

	public String logout() {
		String url = null;

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario = (UsuariosDAO) session.getAttribute("usuario");

		if (usuario.getAutoridade().equals("admin")) {
			url = "../../index.xhtml";

		} else if (usuario.getAutoridade().equals("normal")) {
			url = "../index.xhtml";
		}
		session.invalidate();
        
    
		return url;

	}

	/*
	 * Metodo que direciona para tela de login
	 */
	public String telaLogin() {

		usuarioDao = new UsuariosDAO();
		return "login/telaLogin.xhtml";
	}

	public String usuarioLogado() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		UsuariosDAO usuario = (UsuariosDAO) session.getAttribute("usuario");

		return usuario.getNome();
	}
	
	
	public boolean liberaLinkUsuario(){
		
		
		return liberaLinkUsuario;
		
	}

}
