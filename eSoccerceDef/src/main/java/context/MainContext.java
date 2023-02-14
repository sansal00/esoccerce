package context;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class MainContext implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {

		ServletContext context = sce.getServletContext(); 
		DataSource ds = null; 
		try {
			Context initCtx = new InitialContext(); 
			Context envCtx = (Context) initCtx.lookup("java:comp/env"); 
			ds = (DataSource) envCtx.lookup("jdbc/esoccerce"); 
			Connection con = null; 

			try {
				con = ds.getConnection();
				@SuppressWarnings("unused")
				DatabaseMetaData metaData = con.getMetaData(); 
			} finally {
				if (con != null)
					con.close(); 
			}

		} catch (SQLException | NamingException e) {
			System.out.println(e);
		}

		context.setAttribute("DataSource", ds); 
	}


	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext(); 
		context.removeAttribute("dataSource"); 
		System.out.println("Shutdown web application");

	}
}