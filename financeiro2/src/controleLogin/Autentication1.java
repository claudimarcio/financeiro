package controleLogin;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UsuariosDAO;


@WebFilter(filterName="/Autentication1", urlPatterns={"/areaAdmin/*"})
public class Autentication1 implements Filter {

    /**
     * Default constructor. 
     */
    public Autentication1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    
		
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = (HttpSession) ((HttpServletRequest) request).getSession(false);
		
		UsuariosDAO usuario = (UsuariosDAO) session.getAttribute("usuario");
			
		
		if(usuario.getAutoridade()=="admin"){
			chain.doFilter(request, response);	
		}else{
		
			res.sendRedirect(req.getContextPath()+"../areaCliente.xhtml");
		}					
		
	}
	
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
