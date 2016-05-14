package conexao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JPAListener implements ServletContextListener {

	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		 PersistenceUtil.getEntityManager();
		 System.out.println("context initialized");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 System.out.println("context finalizade");
		PersistenceUtil.close();
	}

	

}
